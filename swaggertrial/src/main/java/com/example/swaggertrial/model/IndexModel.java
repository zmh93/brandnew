package com.example.swaggertrial.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("首页默认类")
public class IndexModel {


    @ApiModelProperty("首页默认类id")
    private Long   id;
    @ApiModelProperty("首页默认类name")
    private String name;
    @ApiModelProperty("首页默认类age")
    private Long   age;

}
