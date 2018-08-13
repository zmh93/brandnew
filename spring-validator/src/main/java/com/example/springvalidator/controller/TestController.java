package com.example.springvalidator.controller;

import com.example.springvalidator.exception.ParameterException;
import com.example.springvalidator.vo.ValidatorVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.midi.Soundbank;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class TestController {

    @PostMapping("/test")
    public Object testValidator(@RequestBody @Validated ValidatorVo vo, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            String errorMessage = "error";
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.info(fieldError.toString());
                errorMessage = fieldError.getDefaultMessage() + fieldError.getField() + ":" + fieldError.getRejectedValue();
            }
            throw new ParameterException("666", errorMessage);
        }
        return vo;
    }

}
