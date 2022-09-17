package com.brcubg.demoSpringProject.validator.userValidator;

import com.brcubg.demoSpringProject.dao.RoleDao.RoleDao;
import com.brcubg.demoSpringProject.dao.UserDao.UserDao;
import com.brcubg.demoSpringProject.request.UserRequest.UserCreateRequest;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserValidator {

    final private UserDao userDao;

    final private RoleDao roleDao;

    public UserValidator(UserDao userDao, RoleDao roleDao) {
        this.userDao = userDao;
        this.roleDao = roleDao;
    }

    public List<String> validate(Long id){
        List<String> errors = new ArrayList<>();
        if(id == null){
            errors.add("Id Not Found!");
            return errors;
        }
        if(Boolean.FALSE.equals(userDao.isExistId(id))){
            errors.add("Not Found User!");
        }
        return errors;
    }

    public List<String> validateUserName(String userName){
        List<String> errors = new ArrayList<>();
        if(!Strings.isEmpty(userName) && !Pattern.compile("^[a-zA-Z0-9][a-z0-9A-Z]*$").matcher(userName).matches()){
            errors.add("Not found user by with " + userName + " username!!") ;
        }
        return errors;
    }

    public List<String> createUserValidate(UserCreateRequest request){
        List<String> errors = new ArrayList<>();
        if(!Strings.isEmpty(request.getUserName()) && !Pattern.compile("^[a-zA-Z0-9][a-z0-9A-Z]*$").matcher(request.getUserName()).matches()){
            errors.add("Not valid " + request.getUserName() + " username!!") ;
        }

        if(!Strings.isEmpty(request.getPassword()) && !Pattern.compile("^\\w{5,}$").matcher(request.getPassword()).matches()){
            errors.add("Password length must not be shorter than 5!") ;
        }

        if(Boolean.FALSE.equals(roleDao.isExistId(request.getRole()))){
            errors.add("Not Found Role!");
        }

        return errors;
    }
}
