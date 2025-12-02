package com.example.windows.collection_Lambda_2025;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Method;


@RequestMapping("collection/api/")
@RestController
public class MastetrControllerForCollection {

    // end point url
    // localhost:9082/collection/api/mehtodName
    @Autowired(required = true)
    CollectionDemoVsCollectionss objReff;

    @Autowired(required = true)
    LambdaExperssion lambdaExperssion;

    @Autowired(required = true)
    CompartorVsComparableinterface compartorVsComparableinterface;

        @GetMapping("{methodName}")
        public Object invokeAnyMethod(
                @PathVariable String methodName,
                @RequestParam(required = false) String[] params) {

            try {
                System.out.println("Inside master method...");

                // If no params, call no-arg method
                if (params == null || params.length == 0) {
                    Method method = lambdaExperssion.getClass().getDeclaredMethod(methodName);
                    return method.invoke(lambdaExperssion);
                }

                // Build parameter types (All are Strings because coming from request)
                Class<?>[] paramTypes = new Class<?>[params.length];
                for (int i = 0; i < params.length; i++) {
                    paramTypes[i] = String.class;
                }

                // Find method with parameters
                Method method = lambdaExperssion.getClass().getDeclaredMethod(methodName, paramTypes);
                return method.invoke(lambdaExperssion, (Object[]) params);

            } catch (Exception e) {
                return "Error: " + e.getMessage();
            }
        }
    }


    /*@GetMapping("{methodName}?")
    public String masterControllerForCollection(@PathVariable String methodName) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        try {
            System.out.println(": inside master reflection method ");
            Method method = lambdaExperssion.getClass().getDeclaredMethod(methodName,);
            return (String) method.invoke(lambdaExperssion);
        } catch (Exception e) {
            return e.getMessage();
        }
    }*/

