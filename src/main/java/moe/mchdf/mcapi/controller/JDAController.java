package moe.mchdf.mcapi.controller;

import lombok.RequiredArgsConstructor;
import moe.mchdf.mcapi.ERROR;
import moe.mchdf.mcapi.EnvData;
import moe.mchdf.mcapi.service.JDAService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class JDAController {

    private final JDAService jdaService;

    @GetMapping("/api/discord/user")
    public Map<String, Object> getDSUserData(String id, String key) {
        Map<String, Object> error = new HashMap<>();
        if (id == null) {
            error.put("error", ERROR.NO_PARAMETER);
            return error;
        } else if (key == null || !key.equals(EnvData.KEY)) {
            error.put("error", ERROR.NO_KEY);
            return error;
        }
        return jdaService.getDSUserData(id);
    }

}
