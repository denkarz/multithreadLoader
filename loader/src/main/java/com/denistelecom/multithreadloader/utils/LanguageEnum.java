package com.denistelecom.multithreadloader.utils;

public enum LanguageEnum {
    RUS, ENG;


    @Override
    public String toString() {
        return name().toLowerCase();
    }
}
