package com.theheroguez.aima.environment.vacuum;

import com.theheroguez.aima.State;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import lombok.Getter;

@Getter
public class VacuumState implements State {
    private final Location currentLocation;
    private final Status currentState;

    public VacuumState(Location currentLocation, Status currentState) {
        this.currentLocation = currentLocation;
        this.currentState = currentState;
    }
}
