package com.example.springvalidator.vo;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
public class ValidatorVo {
    @NotBlank(message = "ValidatorVo`s field name不能为空")
    private String name;
    @Min(value = 18,message = "不能未成年")
    @Max(value = 35,message = "赶紧退休")
    private int    age;
    @NotBlank(message = "ValidatorVo`s field info不能为空")
    private String info;
}
