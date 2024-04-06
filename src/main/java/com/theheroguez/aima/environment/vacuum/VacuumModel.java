package com.theheroguez.aima.environment.vacuum;

import com.theheroguez.aima.Model;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VacuumModel implements Model {
    private VacuumState A;
    private VacuumState B;

    @Override
    public String toString() {
        return "VacuumModel{" +
                "A=" + A +
                ", B=" + B +
                '}';
    }
}
