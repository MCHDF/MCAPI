package moe.mchdf.mcapi.impl;

import moe.mchdf.mcapi.service.exampleService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class exampleServiceImpl implements exampleService {
    @Override
    public Map<String, Object> getExData() {

        Map<String, Object> exData = new HashMap<>();

        exData.put("label1", "data1");
        exData.put("label2", "data2");
        exData.put("label3", "data3");

        return exData;
    }
}
