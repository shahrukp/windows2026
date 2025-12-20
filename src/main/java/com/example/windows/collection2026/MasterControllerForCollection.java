package com.example.windows.collection2026;


import com.example.windows.code.task.FailFasts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sound.sampled.AudioFileFormat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

@RestController
@RequestMapping("/collection/api/codex")
public class MasterControllerForCollection {


    // url -> http:localhost:8084/collection/api/codex/methodname
    @Autowired
    SetInterface setInterface;

    @Autowired
    CallComparble_ComparbleInterfce callComparble_ComparbleInterfce;

    @Autowired
    FailSafeVsFailFast failSafeVsFailFast;

    @Autowired
    FailFasts failFasts;

    @Autowired
    ListInterface listInterface;


    @Autowired
    MapConcurrentMapConcurrentHashMap mapConcurrentMapConcurrentHashMap;
    @GetMapping("/{methodname}")
    public Object masterController(@PathVariable String methodname) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
        try {
            Method method = mapConcurrentMapConcurrentHashMap.getClass().getDeclaredMethod(methodname);
            System.out.println("Completed @! ");
            return method.invoke(mapConcurrentMapConcurrentHashMap);
        } catch (Exception e) {
            System.out.println("Error  ");
            return "Error -> " + e.getMessage();
        }

    }
}
