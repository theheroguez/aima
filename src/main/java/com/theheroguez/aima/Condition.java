package com.theheroguez.aima;

/**
 * The Condition interface represents a condition that can be evaluated against a given state.
 * Conditions are used to determine if a certain rule should be applied or not.
 */
public interface Condition {
    boolean evaluate(State s);
}
