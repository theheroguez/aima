package com.theheroguez.aima.environment.vacuum;

import com.theheroguez.aima.*;
import com.theheroguez.aima.agents.ModelBasedReflexAgent;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacuumModelBasedReflexAgent extends ModelBasedReflexAgent<Percept<Location, Status>, Action> {
    protected VacuumModelBasedReflexAgent(VacuumModel model, List<Rule<Action>> rules) {
        super(model, rules);
    }

    @Override
    protected State updateState(State state, Action action, Percept<Location, Status> percept, Model model) {
        VacuumModel vacuumModel = (VacuumModel) model;

        VacuumState currentState;
        if (percept.getFirst().equals(Location.A)) {
            currentState = new VacuumState(Location.A, percept.getSecond());
            vacuumModel.setA(currentState);
        } else {
            currentState = new VacuumState(Location.B, percept.getSecond());
            vacuumModel.setB(currentState);
        }

        System.out.println(vacuumModel);
        return currentState;
    }
}
