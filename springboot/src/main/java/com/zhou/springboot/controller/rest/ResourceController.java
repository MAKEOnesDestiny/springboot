package com.zhou.springboot.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceManager resourceManager;

    @RequestMapping("/list")
    public List<WebResource> getAllResource(){
        return resourceManager.getAllWebResource();
    }

}
