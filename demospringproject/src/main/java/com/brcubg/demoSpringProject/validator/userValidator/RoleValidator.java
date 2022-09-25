package com.brcubg.demoSpringProject.validator.userValidator;

import com.brcubg.demoSpringProject.dao.RoleDao.RoleDao;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RoleValidator {

    private final RoleDao roleDao;

    public RoleValidator(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<String> validate(Long id){
        List<String> errors = new ArrayList<>();
        if(id == null){
            errors.add("Role Id Not Found!");
            return errors;
        }
        if(Boolean.FALSE.equals(roleDao.isExistId(id))){
            errors.add("Not Found Role!");
        }
        return errors;
    }
}
