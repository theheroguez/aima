package com.theheroguez.aima.controllers;

import com.theheroguez.aima.agents.TableDrivenAgent;
import com.theheroguez.aima.services.Processor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The TableDrivenAgentController class is a REST Controller that handles requests to process a list
 * of percepts using a TableDrivenAgent and return a list of actions performed by the agent.
 */
@RestController
@RequestMapping("/tdd-agent")
public class TableDrivenAgentController {

    private final Processor processor;

    public TableDrivenAgentController(TableDrivenAgent agent) {
        this.processor = new Processor(agent);
    }

    /**
     * Returns a list of strings representing the actions associated with each percept.
     *
     * @return a list of strings representing the actions
     */
    @GetMapping("/process")
    public List<String> process() {
        return processor.process();
    }
}
