package com.theheroguez.aima.controllers;

import com.theheroguez.aima.agents.SimpleReflexAgent;
import com.theheroguez.aima.services.Processor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The SimpleReflexAgentController class is a REST Controller that handles requests to process a list
 * of percepts using a SimpleReflexAgent and return a list of actions performed by the agent.
 */
@RestController
@RequestMapping("/simple-reflex-agent")
public class SimpleReflexAgentController {
    private final Processor processor;

    public SimpleReflexAgentController(SimpleReflexAgent agent) {
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
