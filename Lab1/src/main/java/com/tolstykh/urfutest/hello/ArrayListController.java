package com.tolstykh.urfutest.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController

public class ArrayListController {
    private List<String> stringList = null;

    @GetMapping("/update-array")
    public String updateArrayList(@RequestParam String s) {
        // Если это первый вызов метода, создаем пустой ArrayList
        if (stringList == null) {
            stringList = new ArrayList<>();
        }
        // Добавляем значение в список
        stringList.add(s);

        return "Добавлено: '" + s + "'. Всего элементов: " + stringList.size();
    }

    // Метод для просмотра содержимого списка
    @GetMapping("/show-array")
    public List<String> showArrayList() {
        if (stringList == null) {
            return new ArrayList<>();
        }
        return stringList;
    }
    public Integer getArrayListSize(){
        return stringList.size();
    }
}
