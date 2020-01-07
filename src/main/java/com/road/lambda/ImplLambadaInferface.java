package com.road.lambda;

import java.util.HashMap;
import java.util.Map;

public class ImplLambadaInferface implements LambdaInterface {
    @Override
    public String messageCheck(String name) {
        return null;
    }

    /**
     * 使用Stream
     * 
     * @param args
     */
    public static void main(String[] args) {
        // Stream.of(userMenuList, allList).flatMap(Collection::stream).distinct().collect(Collectors.toList());
        StringBuilder errorNumbers = new StringBuilder();
        StringBuilder successNumbers = new StringBuilder();
        Map<String, Object> objectMap = new HashMap<>();
        errorNumbers.append("10000008369").append(",");
        objectMap.put("errorNumbers",
            (errorNumbers.length() > 0 ? errorNumbers.substring(0, errorNumbers.length() - 1) : null));
        objectMap.put("successNumbers",
            (successNumbers.length() > 0 ? successNumbers.substring(0, successNumbers.length() - 1) : null));
        System.out.println(objectMap.toString());
    }
}
