package com.theheroguez.aima.services;

import com.theheroguez.aima.agents.Agent;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.percepts.Percept;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class Processor {
    private final Agent agent;

    public Processor(Agent agent) {
        this.agent = agent;
    }

    public List<String> process() {
        List<Percept<Location, Status>> percepts = new ArrayList<>();
        percepts.add(new Percept<>(Location.A, Status.CLEAN));
        percepts.add(new Percept<>(Location.B, Status.DIRTY));
        percepts.add(new Percept<>(Location.A, Status.CLEAN));

        return percepts
                .stream()
                .map(percept -> "Action: " + agent.process(percept))
                .toList();
    }
}
