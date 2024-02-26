package com.theheroguez.aima.agents;

import com.theheroguez.aima.enums.Action;
import com.theheroguez.aima.percepts.Percept;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * The SimpleReflexAgent class represents a simple reflex agent that uses a set of rules to determine the appropriate action based on a given percept.
 */
@Component
public class SimpleReflexAgent implements Agent {

    private final Map<Percept<?, ?>, Action> rules;

    public SimpleReflexAgent(Map<Percept<?, ?>, Action> rules) {
        this.rules = rules;
    }

    /**
     * Returns the action determined by the set of rules based on the given percept.
     *
     * @param percept the percept used to determine the action
     * @return the action determined by the rules
     */
    @Override
    public Action process(Percept<?, ?> percept) {
        return rules.get(percept);
    }

    @Override
    public Action lookUp(List<Percept<?, ?>> percepts, Map<List<Percept<?, ?>>, Action> table) {
        return null;
    }
}
