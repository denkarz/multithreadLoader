package com.denistelecom.multithreadloader.utils;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LanguageEnum {

    RUS(1), ENG(2);

    private final int id;

    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
