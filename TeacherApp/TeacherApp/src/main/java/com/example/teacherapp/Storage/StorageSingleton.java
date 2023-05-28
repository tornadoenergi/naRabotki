package com.example.teacherapp.Storage;

public class StorageSingleton {
    private static Storage instance = null;

    private StorageSingleton() {}

    public static synchronized Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }
}