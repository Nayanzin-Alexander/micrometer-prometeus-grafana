package com.nayanzin.micrometerprometeusgrafana.config.swagger;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller

public class SwaggerController {

    private static final String REDIRECT_SWAGGER_UI_HTML = "redirect:swagger-ui.html";

    @RequestMapping("/")
    public String index() {
        return REDIRECT_SWAGGER_UI_HTML;
    }
}
