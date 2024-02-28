package com.theheroguez.aima.controllers;

import com.theheroguez.aima.Percept;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.environment.vacuum.VacuumSimpleReflexAgent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The SimpleReflexAgentController class is a REST Controller that handles requests to process a list
 * of percepts using a SimpleReflexAgent and return a list of actions performed by the agent.
 */
@RestController
@RequestMapping("/simple-reflex-agent")
public class SimpleReflexAgentController {
    private final VacuumSimpleReflexAgent agent;

    public SimpleReflexAgentController(VacuumSimpleReflexAgent agent) {
        this.agent = agent;
    }

    /**
     * Returns a list of strings representing the actions associated with each percept.
     *
     * @return a list of strings representing the actions
     */
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
