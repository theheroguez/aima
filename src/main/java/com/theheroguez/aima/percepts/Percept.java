package com.theheroguez.aima.percepts;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
public class Percept<T, U> {
    private T first;
    private U second;

    public Percept(T first, U second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Percept<?, ?> percept = (Percept<?, ?>) o;
        return Objects.equals(first, percept.first) && Objects.equals(second, percept.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }
}
