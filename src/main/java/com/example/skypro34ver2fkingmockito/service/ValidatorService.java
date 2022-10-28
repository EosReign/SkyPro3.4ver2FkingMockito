package com.example.skypro34ver2fkingmockito.service;

import org.apache.commons.lang3.StringUtils;
import com.example.skypro34ver2fkingmockito.exception.IncorrectParamException;
import org.springframework.stereotype.Service;

@Service
public class ValidatorService {
    public String validate(String str) {
        String[] strs = str.split("-");
        for (int i = 0; i < strs.length; i++) {
            if (!StringUtils.isAlpha(strs[i])) {
                throw new IncorrectParamException();
            }
            strs[i] = StringUtils.capitalize(strs[i].toLowerCase());
        }
        return String.join("-",strs);
    }
}
