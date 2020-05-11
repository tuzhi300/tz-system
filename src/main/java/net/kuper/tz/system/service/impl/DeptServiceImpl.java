package net.kuper.tz.system.service.impl;

import net.kuper.tz.core.controller.exception.ApiException;
import net.kuper.tz.core.utils.RegexUtils;
import net.kuper.tz.system.dao.DeptDao;
import net.kuper.tz.system.entity.DeptEntity;
import net.kuper.tz.system.entity.DeptQueryEntity;
import net.kuper.tz.system.entity.DeptUpdateEntity;
import net.kuper.tz.system.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.List;

/**
 * 部门Service实现类
 *
 * @author kuper
 * @email shengongwen@163.com
 * @date 2020-03-03 09:47:33
 */
@Service("deptService")
public class DeptServiceImpl implements DeptService {

    private String deptCodePrefix = "TZ";

    @Autowired
    private DeptDao deptDao;

    @Override
    public List<DeptEntity> queryList(DeptQueryEntity deptQueryEntity) {
        List<DeptEntity> deptList = deptDao.queryList(deptQueryEntity);
        return deptList;
    }

    @Override
    public DeptEntity queryObject(String id) {
        return deptDao.queryObject(id);
    }

    /**
     * 验证无限循环
     *
     * @param deptUpdateEntity
     */
    private void verifyCycleParentId(DeptUpdateEntity deptUpdateEntity) {
        List<String> ids = deptDao.queryChildrenId(deptUpdateEntity.getId(), null);
        boolean has = false;
        if (ids != null && !ids.isEmpty()) {
            has = ids.contains(deptUpdateEntity.getParentId());
        }
        if (has) {
            throw new ApiException("不能选择子部门为当前菜单的上级部门");
        }
    }

    /**
     * 验证无限循环
     *
     * @param deptUpdateEntity
     */
    private void verifyDeptCode(DeptUpdateEntity deptUpdateEntity) {
        if (!deptUpdateEntity.getCode().startsWith(deptCodePrefix)) {
            throw new ApiException("部门编号前缀错误");
        }
        DeptEntity parent = deptDao.queryObject(deptUpdateEntity.getParentId());
        if (parent == null && deptUpdateEntity.getId() != null && !deptUpdateEntity.getId().startsWith("init00000")) {
            throw new ApiException("上级部门不存在");
        }

        if (parent != null && !deptUpdateEntity.getCode().startsWith(parent.getCode())) {
            throw new ApiException("部门编号不匹配");
        }
        String index = deptUpdateEntity.getCode().replace(parent.getCode(), "");
        if (index.length() != 2) {
            throw new ApiException("部门编号长度不正确");
        }
        if (!RegexUtils.isMatch("[0-9][1-9]", index)) {
            throw new ApiException("部门编号后两位非数字");
        }
    }

    @Override
    public List<DeptEntity> queryListByParentId(String parentId) {
        return deptDao.queryListByParentId(parentId, 1);
    }

    @Override
    public String autoBuildCode(String parentId) {
        String code = null;
        DeptEntity parent = deptDao.queryObject(parentId);
        DeptQueryEntity deptQueryEntity = new DeptQueryEntity();
        deptQueryEntity.setParentId(parentId);
        List<DeptEntity> children = deptDao.queryList(deptQueryEntity);
        if (parent == null) {
            throw new ApiException("部门不存在");
        }
        if (children == null || children.isEmpty()) {
            code = parent.getCode() + "01";
        } else {
            Integer index = 0;
            for (DeptEntity child : children) {
                String strIndex = child.getCode().substring(child.getCode().length() - 2);
                Integer tmpIndex = Integer.valueOf(strIndex);
                if (tmpIndex > index) {
                    index = tmpIndex;
                }
            }
            DecimalFormat numberFormat = (DecimalFormat) NumberFormat.getInstance();
            numberFormat.applyPattern("00");
            code = parent.getCode() + numberFormat.format(index + 1);
        }
        return code;
    }

    @Override
    public DeptEntity save(DeptUpdateEntity deptUpdateEntity) {
        verifyDeptCode(deptUpdateEntity);
        deptDao.save(deptUpdateEntity);
        return deptDao.queryObject(deptUpdateEntity.getId());
    }

    @Override
    public void update(DeptUpdateEntity deptUpdateEntity) {
        verifyDeptCode(deptUpdateEntity);
        verifyCycleParentId(deptUpdateEntity);
        deptDao.update(deptUpdateEntity);
    }

    @Override
    public void delete(String id) {
        List<String> ids = deptDao.queryChildrenId(id, null);
        if (ids != null && ids.size() > 0) {
            throw new ApiException("还有子部门，无法删除");
        }
        deptDao.delete(id);
    }

    @Override
    public void deleteBatch(String[] ids) {
    }
}
