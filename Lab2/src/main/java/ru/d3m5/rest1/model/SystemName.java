package ru.d3m5.rest1.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum SystemName {
    ERP("Enterprise Resource Planning"),
    CRM("Customer Relationship "),
    WMS("Warehouse Management System"),
    Service1("Service - 1");

    private final String name;

    SystemName(String name) {
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
