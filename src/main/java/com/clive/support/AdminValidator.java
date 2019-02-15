package com.clive.support;

import com.clive.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

@Component
public class AdminValidator {

    @Autowired
    private AdminRepository adminRepository;

    public void validateUserId(BindingResult bindingResult, String userId) {
        if (adminRepository.getUserDataByUsername(userId) != null) {
            bindingResult.addError(new FieldError("userData", "userId", "user id already exists"));
        }
    }
}
