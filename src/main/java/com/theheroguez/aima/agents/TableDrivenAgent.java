package com.theheroguez.aima.agents;

import com.theheroguez.aima.enums.Action;
import com.theheroguez.aima.percepts.Percept;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * TableDrivenAgent is an implementation of the Agent interface that uses a table
 * to determine the appropriate action based on the given percept.
 */
@Component
public class TableDrivenAgent implements Agent {
    private final Map<List<Percept<?, ?>>, Action> table;
    private final List<Percept<?, ?>> percepts;

    public TableDrivenAgent(Map<List<Percept<?, ?>>, Action> table) {
        this.table = table;
        this.percepts = new ArrayList<>();
    }

    /**
     * Adds the given percept to the list of percepts and returns the corresponding action.
     *
     * @param percept the percept to be added to the list
     * @return the action associated with the list of percepts
     */
    @Override
    public Action process(Percept<?, ?> percept) {
        percepts.add(percept);
        return lookUp(percepts, table);
    }

    /**
     * Looks up the appropriate action in the given table based on the list of percepts.
     *
     * @param percepts the list of percepts
     * @param table the table mapping lists of percepts to actions
     * @return the action associated with the list of percepts, or null if no action is found
     */
    @Override
    public Action lookUp(List<Percept<?, ?>> percepts, Map<List<Percept<?, ?>>, Action> table) {
        return table.get(percepts);
    }
}
