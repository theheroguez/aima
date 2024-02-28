package com.theheroguez.aima;

import lombok.Getter;

/**
 * The Rule class represents a rule that can be evaluated against a given state and perform an action if the condition is met.
 *
 * @param <A> the type of the action to be performed
 */
@Getter
public class Rule<A> {
    private final A action;
    private final Condition condition;

    public Rule(A action, Condition condition) {
        this.action = action;
        this.condition = condition;
    }

    /**
     * Evaluates the condition of a rule against a given state.
     *
     * @param s the state to evaluate the condition against
     * @return true if the condition evaluates to true, false otherwise
     */
    public boolean evaluate(State s) {
        return condition.evaluate(s);
    }
}
