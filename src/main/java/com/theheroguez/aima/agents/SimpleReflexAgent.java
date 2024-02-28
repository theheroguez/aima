package com.theheroguez.aima.agents;

import com.theheroguez.aima.Rule;
import com.theheroguez.aima.State;

import java.util.List;
import java.util.Optional;

/**
 * The SimpleReflexAgent class represents a simple reflex agent that uses a set of rules to determine the appropriate action based on a given percept.
 */

public abstract class SimpleReflexAgent<P, A> implements Agent<P, A> {
    protected final List<Rule<A>> rules;

    public SimpleReflexAgent(List<Rule<A>> rules) {
        this.rules = rules;
    }

    /**
     * Returns the action determined by the set of rules based on the given percept.
     *
     * @param percept the percept used to determine the action
     * @return the action determined by the rules
     */
    @Override
    public Optional<A> apply(P percept) {
        State state = interpretInput(percept);
        Rule<A> rule = ruleMatch(state);
        return Optional.ofNullable(rule.getAction());
    }

    protected abstract State interpretInput(P percept);

    private Rule<A> ruleMatch(State state) {
        return rules.stream().filter(r -> r.evaluate(state)).findFirst().orElse(null);
    }
}
