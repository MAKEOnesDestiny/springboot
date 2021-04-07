package com.zhou.springboot.controller.rest;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import javax.servlet.ServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceManager resourceManager;

    @RequestMapping("/list")
    @ResponseBody
    public List<WebResource> getAllResource() {
        return resourceManager.getAllWebResource();
    }

    @RequestMapping("/ui")
    public void ui(ServletResponse response) throws IOException, TemplateException {
        response.setContentType("text/html; charset=utf-8");

        Configuration cfg = new Configuration(Configuration.getVersion());
        Resource resource = new ClassPathResource("/templates/");
        String path = Objects.requireNonNull(resource.getFile()).getPath();
        cfg.setDirectoryForTemplateLoading(new File(path));

        Template template = cfg.getTemplate("webResource.ftl", StandardCharsets.UTF_8.toString());
        template.process(new HashMap<String, List<WebResource>>() {{
            put("wss", resourceManager.getAllWebResource());
        }}, response.getWriter());
        return;
    }

}
