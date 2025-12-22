package ru.d3m5.rest.service;

import org.springframework.stereotype.Service;
import ru.d3m5.rest.model.Positions;

@Service
public interface AnnualBonusService {
    double calculate(Positions positions, double salary, double bonus, int workDays);
}
