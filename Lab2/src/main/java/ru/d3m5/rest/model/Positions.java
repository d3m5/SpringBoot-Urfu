package ru.d3m5.rest.model;

import lombok.Getter;
    @Getter
    public enum Positions {
        DEV(2.2),
        HR(2.2),
        TL( 2.2);

        private final Double positionCoefficient;

        Positions(Double positionCoefficient) {
            this.positionCoefficient = positionCoefficient;
        }
    }
