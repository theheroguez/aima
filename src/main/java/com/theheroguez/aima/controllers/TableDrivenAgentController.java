package com.theheroguez.aima.controllers;

import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.environment.vacuum.VacuumTableDrivenAgent;
import com.theheroguez.aima.Percept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The TableDrivenAgentController class is a REST Controller that handles requests to process a list
 * of percepts using a TableDrivenAgent and return a list of actions performed by the agent.
 */
@RestController
@RequestMapping("/table-driven-agent")
public class TableDrivenAgentController {

    private final VacuumTableDrivenAgent agent;

    public TableDrivenAgentController(VacuumTableDrivenAgent agent) {
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
