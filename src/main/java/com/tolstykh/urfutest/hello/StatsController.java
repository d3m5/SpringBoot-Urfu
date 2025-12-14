package com.tolstykh.urfutest.hello;

import org.springframework.web.bind.annotation.*;

@RestController
public class StatsController {

    // Ссылки на контроллеры (если они в одном приложении)
    private ArrayListController arrayListController;
    private HashMapController hashMapController;

    // Если контроллеры в разных классах, можно использовать @Autowired
    public StatsController(ArrayListController arrayListController, HashMapController hashMapController) {
        this.arrayListController = arrayListController;
        this.hashMapController = hashMapController;
    }

    @GetMapping("/show-all-length")
    public String showAllLength() {
        // Получаем размеры из контроллеров
        int arrayListSize = getArrayListSize();
        int hashMapSize = getHashMapSize();

        return String.format(
                "Количество элементов в ArrayList: %d%n" +
                        "Количество элементов в HashMap: %d%n" +
                        "Общее количество элементов: %d",
                arrayListSize, hashMapSize, arrayListSize + hashMapSize
        );
    }

    private int getArrayListSize() {
        // Если у вас есть метод для получения размера в ArrayListController
        // return arrayListController.getArrayListSize();

        // Если нет, используем статическое поле или другой способ
        return 0; // Замените на реальную логику
    }

    private int getHashMapSize() {
        // Аналогично для HashMapController
        return 0; // Замените на реальную логику
    }
}