package com.tolstykh.urfutest.hello;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class HashMapController {

    private Map<Integer, String> stringMap = null;
    private int currentKey = 1; // Счетчик для ключей

    @GetMapping("/update-map")
    public String updateHashMap(@RequestParam String s) {
        // Если это первый вызов метода, создаем пустой HashMap
        if (stringMap == null) {
            stringMap = new HashMap<>();
        }


        // Добавляем значение в Map
        stringMap.put(currentKey, s);
        String result = "Добавлено: Ключ=" + currentKey + ", Значение='" + s + "'";
        currentKey++; // Увеличиваем ключ для следующего вызова

        return result + ". Всего элементов: " + stringMap.size();
    }

    // метод для просмотра содержимого Map
    @GetMapping("/show-map")
    public Map<Integer, String> viewHashMap() {
        if (stringMap == null) {
            return new HashMap<>();
        }
        return new HashMap<>(stringMap);
    }
    public Integer getHashMapSize(){
        return stringMap == null ? 0 : stringMap.size();
    }
}