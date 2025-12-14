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

        return String.format("Количество элементов в ArrayList: %d%n" + "Количество элементов в HashMap: %d%n" + "Общее количество элементов: %d", arrayListSize, hashMapSize, arrayListSize + hashMapSize);
    }

    private Integer getArrayListSize() {
        return arrayListController.getArrayListSize();
    }

    private int getHashMapSize() {
        // Аналогично для HashMapController
        return hashMapController.getHashMapSize();
    }
}