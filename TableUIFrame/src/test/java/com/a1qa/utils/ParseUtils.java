package com.a1qa.utils;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class ParseUtils {
    public static <T> T parseFromJson(String path, Class<T> classToParse) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(new File(path), classToParse);

    }
}
