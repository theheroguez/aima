package com.theheroguez.aima.controllers;

import com.theheroguez.aima.Percept;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.environment.vacuum.VacuumModelBasedReflexAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/model-based-reflex-agent")
public class ModelBasedReflexAgentController {
    private final VacuumModelBasedReflexAgent agent;

    public ModelBasedReflexAgentController(VacuumModelBasedReflexAgent agent) {
        this.agent = agent;
    }

    @GetMapping("/process")
    public List<String> process() {
        List<Percept<Location, Status>> percepts = new ArrayList<>();
        percepts.add(new Percept<>(Location.A, Status.DIRTY));
        percepts.add(new Percept<>(Location.B, Status.DIRTY));
        percepts.add(new Percept<>(Location.A, Status.CLEAN));
        percepts.add(new Percept<>(Location.B, Status.CLEAN));
        percepts.add(new Percept<>(Location.B, Status.DIRTY));

        return percepts
                .stream()
                .map(percept -> "Action: " + agent.apply(percept))
                .toList();
    }
}
