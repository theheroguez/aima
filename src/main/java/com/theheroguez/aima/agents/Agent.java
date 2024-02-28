package com.theheroguez.aima.agents;

import java.util.Optional;
import java.util.function.Function;

/**
 * The Agent interface represents an agent that processes percepts and produces actions based on those percepts.
 *
 * @param <P> the type of percepts the agent receives
 * @param <A> the type of actions the agent produces
 */
public interface Agent<P, A> extends Function<P, Optional<A>> {
    Optional<A> apply(P percept);
}
