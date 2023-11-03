package moe.mchdf.mcapi.controller;

import moe.mchdf.mcapi.service.exampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class exampleController {

    private final exampleService exampleService;

    public exampleController(exampleService exampleService) {
        this.exampleService = exampleService;
    }
    @GetMapping("/ex")
    public Map<String, Object> exampleController() {
        return exampleService.getExData();
    }

}
