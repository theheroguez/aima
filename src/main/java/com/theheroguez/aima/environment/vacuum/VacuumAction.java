package com.theheroguez.aima.environment.vacuum;

import com.theheroguez.aima.Action;
import lombok.Getter;

@Getter
public class VacuumAction implements Action {
    private String action;

    public VacuumAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return action;
    }
}
