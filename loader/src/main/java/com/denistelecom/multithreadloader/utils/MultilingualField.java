package com.denistelecom.multithreadloader.utils;

import lombok.experimental.Accessors;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Accessors(chain = true)
public class MultilingualField extends EnumMap<LanguageEnum, String> {
    public MultilingualField() {
        super(LanguageEnum.class);
    }
 }
