package com.theheroguez.aima.repositories;

import com.theheroguez.aima.agents.TableDrivenAgent;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.percepts.Percept;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * The TableDrivenAgentController class implements a REST API endpoint for processing a list of percepts and
 * returning a list of actions associated with each percept. It uses an instance of the TableDrivenAgent class
 * to perform the processing.
 */
@RestController
public class TableDrivenAgentController {

    private final TableDrivenAgent agent;

    public TableDrivenAgentController(TableDrivenAgent agent) {
        this.agent = agent;
    }

    /**
     * This method processes a list of percepts and returns a list of actions associated with each percept.
     *
     * @return a list of actions associated with each percept
     */
    @GetMapping("/tdd-agent")
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
