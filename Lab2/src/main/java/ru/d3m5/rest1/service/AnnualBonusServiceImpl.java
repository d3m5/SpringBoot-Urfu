package ru.d3m5.rest1.service;

import org.springframework.stereotype.Service;
import ru.d3m5.rest1.model.Positions;

@Service
public class AnnualBonusServiceImpl implements AnnualBonusService{

    @Override
    public double calculate(Positions positions, double salary, double bonus, int workDays) {
        return salary * bonus * 365 * positions.getPositionCoefficient() / workDays;
    }
}
