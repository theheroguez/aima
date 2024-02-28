package com.theheroguez.aima.environment.vacuum;

import com.theheroguez.aima.Action;
import com.theheroguez.aima.Percept;
import com.theheroguez.aima.Rule;
import com.theheroguez.aima.State;
import com.theheroguez.aima.agents.SimpleReflexAgent;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VacuumSimpleReflexAgent extends SimpleReflexAgent<Percept<Location, Status>, Action> {
    public VacuumSimpleReflexAgent(List<Rule<Action>> rules) {
        super(rules);
    }

    @Override
    public State interpretInput(Percept<Location, Status> percept) {
        return new VacuumState(percept.getFirst(), percept.getSecond());
    }
}
