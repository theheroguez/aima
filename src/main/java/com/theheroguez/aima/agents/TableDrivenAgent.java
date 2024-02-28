package com.theheroguez.aima.agents;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * TableDrivenAgent is an implementation of the Agent interface that uses a table
 * to determine the appropriate action based on the given percept.
 */
public class TableDrivenAgent<P, A> implements Agent<P, A> {
    private final List<P> percepts;
    private final Map<List<P>, A> table;

    public TableDrivenAgent(Map<List<P>, A> table) {
        this.table = table;
        this.percepts = new ArrayList<>();
    }

    /**
     * Adds the given percept to the list of percepts and retrieves the associated action from the lookup table.
     *
     * @param percept the percept to be applied
     * @return an Optional object containing the action associated with the percept, or an empty Optional if no action is found
     */
    @Override
    public Optional<A> apply(P percept) {
        percepts.add(percept);
        return lookUp();
    }

    /**
     * Retrieves and returns the action associated with the list of percepts.
     *
     * @return an Optional object containing the action associated with the list of percepts
     */
    public Optional<A> lookUp() {
        return Optional.ofNullable(table.get(percepts));
    }
}
