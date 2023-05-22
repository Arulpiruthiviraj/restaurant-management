package com.arul.restaurantmanagement.utils;

import java.lang.reflect.Field;

public class RestaurantUtils {
    public static <T> void updateFields(T objectToUpdate, T updatedObject) {
        Class<?> clazz = objectToUpdate.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object updatedValue = field.get(updatedObject);
                if (updatedValue != null) {
                    field.set(objectToUpdate, updatedValue);
                }
            } catch (IllegalAccessException e) {
                // Handle exception if needed
                e.printStackTrace();
            }
        }
    }
}
