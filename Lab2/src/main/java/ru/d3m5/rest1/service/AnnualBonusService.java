package ru.d3m5.rest1.service;

import org.springframework.stereotype.Service;
import ru.d3m5.rest1.model.Positions;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}
