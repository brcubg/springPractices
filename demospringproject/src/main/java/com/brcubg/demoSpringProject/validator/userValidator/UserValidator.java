package com.brcubg.demoSpringProject.validator.userValidator;

import com.brcubg.demoSpringProject.dao.UserDao.UserDao;
import org.apache.logging.log4j.util.Strings;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

@Service
public class UserValidator {

    final private UserDao userDao;

    public UserValidator(UserDao userDao) {
        this.userDao = userDao;
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
}
