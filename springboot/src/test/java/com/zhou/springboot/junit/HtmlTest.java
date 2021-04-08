package com.zhou.springboot.junit;

import com.zhou.springboot.controller.rest.ResourceManager;
import com.zhou.springboot.controller.rest.WebResource;
import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.File;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HtmlTest {

    @Autowired
    private ResourceManager resourceManager;

    @Test
    public void testTemplate() throws Exception {
        Configuration cfg = new Configuration(Configuration.getVersion());
        Resource resource = new ClassPathResource("/templates/");
        String path = Objects.requireNonNull(resource.getFile()).getPath();
        cfg.setDirectoryForTemplateLoading(new File(path));

        Writer writer = new PrintWriter(System.out);
        Template template = cfg.getTemplate("webResource.ftl", StandardCharsets.UTF_8.toString());
        template.process(new HashMap<String, Object>() {{
            put("wss", resourceManager.getAllWebResource());
        }}, writer);
    }

    public WebResource mockResource() {
        WebResource resource = new WebResource("test/url", null, null, null,
                                               null, null, new ArrayList<>());
        return resource;
    }

}
