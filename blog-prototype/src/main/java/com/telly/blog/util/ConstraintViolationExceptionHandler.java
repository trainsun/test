package com.telly.blog.util;


import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * ConstraintViolationException 处理器.
 * Create By Telly On 2019/8/11 10:38
 */
public class ConstraintViolationExceptionHandler {

    public static String getMessage(ConstraintViolationException e){

        List<String> msgList = new ArrayList<>();
        for(ConstraintViolation<?> constraintViolation:e.getConstraintViolations()){
            msgList.add(constraintViolation.getMessage());
        }
        String messages = StringUtils.join(msgList.toArray(), ';');
        return messages;
    }
}
