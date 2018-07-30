package com.example.swaggertrial.controller;

import com.example.swaggertrial.model.IndexModel;
import io.swagger.annotations.*;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "index class", description = "default Controller")
@RestController
public class IndexController {

    @ApiResponse(code = 1, message = "indexModel")
    @ApiOperation(value = "查找用户", notes = "查找用户", httpMethod = "GET", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @GetMapping("/index")
    public IndexModel index() {
        return new IndexModel(1L, "MengHui", 25L);
    }

}
