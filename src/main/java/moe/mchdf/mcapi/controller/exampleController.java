package moe.mchdf.mcapi.controller;

import moe.mchdf.mcapi.service.exampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class exampleController {

    private static final Logger LOGGER = LoggerFactory.getLogger(exampleController.class);

    private final exampleService exampleService;

    public exampleController(exampleService exampleService) {
        this.exampleService = exampleService;
    }
    @GetMapping("/ex")
    public Map<String, Object> exampleController() {
        LOGGER.info("예시 API 호출됨.");
        return exampleService.getExData();
    }

}
