package com.this0.headline.controller;

import com.this0.headline.pojo.Type;
import com.this0.headline.service.TypeService;
import com.this0.headline.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/portal")
@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/findAllTypes")
    public Result findAllTypes(){
        Result result = typeService.findAllTypes();
        return result;
    }


}
