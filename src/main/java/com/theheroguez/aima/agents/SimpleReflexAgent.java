package com.theheroguez.aima.agents;

import com.theheroguez.aima.enums.Action;
import com.theheroguez.aima.percepts.Percept;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class SimpleReflexAgent implements Agent {

    private final Map<Percept<?, ?>, Action> rules;

    public SimpleReflexAgent(Map<Percept<?, ?>, Action> rules) {
        this.rules = rules;
    }

    @Override
    public Action process(Percept<?, ?> percept) {
        return rules.get(percept);
    }

    @Override
    public Action lookUp(List<Percept<?, ?>> percepts, Map<List<Percept<?, ?>>, Action> table) {
        return null;
    }
}
