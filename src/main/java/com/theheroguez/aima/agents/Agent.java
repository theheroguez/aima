package com.theheroguez.aima.agents;

import com.theheroguez.aima.enums.Action;
import com.theheroguez.aima.percepts.Percept;

import java.util.List;
import java.util.Map;

public interface Agent {
    public Action process(Percept<?, ?> percept);

    public Action lookUp(List<Percept<?, ?>> percepts, Map<List<Percept<?, ?>>, Action> table);
}
