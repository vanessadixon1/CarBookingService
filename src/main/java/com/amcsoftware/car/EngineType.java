package com.amcsoftware.car;

public enum EngineType {
    Electric("Electric"),
    Hybrid("Hybrid"),
    Diesel("Diesel"),
    Petrol("Petrol"),
    Gas("Gas");

    String engineType;

    EngineType(String engineType) {
        this.engineType = engineType;
    }

}
