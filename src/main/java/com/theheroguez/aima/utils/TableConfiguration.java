package com.theheroguez.aima.utils;

import com.theheroguez.aima.enums.Action;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.percepts.Percept;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

/**
 * The TableConfiguration class is a configuration class that provides a bean for tabulating a table for TDA (Table-Driven Agent).
 * It contains a method to create and populate the table with a mapping of percept combinations to actions.
 */
@Configuration
public class TableConfiguration {

    @Bean
    public Map<List<Percept<?, ?>>, Action> tabulateTableForTDA() {
        Map<List<Percept<?, ?>>, Action> table = new HashMap<>();
        table.put(Collections.singletonList(new Percept<>(Location.A, Status.CLEAN)), Action.RIGHT);
        table.put(Collections.singletonList(new Percept<>(Location.A, Status.DIRTY)), Action.CLEAN);
        table.put(Collections.singletonList(new Percept<>(Location.B, Status.CLEAN)), Action.LEFT);
        table.put(Collections.singletonList(new Percept<>(Location.B, Status.DIRTY)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.CLEAN), new Percept<>(Location.A, Status.CLEAN)), Action.RIGHT);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.CLEAN), new Percept<>(Location.A, Status.DIRTY)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.DIRTY), new Percept<>(Location.A, Status.CLEAN)), Action.RIGHT);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.DIRTY), new Percept<>(Location.A, Status.DIRTY)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.CLEAN), new Percept<>(Location.B, Status.CLEAN)), Action.RIGHT);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.CLEAN), new Percept<>(Location.B, Status.DIRTY)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.DIRTY), new Percept<>(Location.B, Status.CLEAN)), Action.LEFT);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.DIRTY), new Percept<>(Location.B, Status.DIRTY)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.CLEAN), new Percept<>(Location.A, Status.CLEAN)), Action.LEFT);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.CLEAN), new Percept<>(Location.A, Status.DIRTY)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.DIRTY), new Percept<>(Location.A, Status.CLEAN)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.DIRTY), new Percept<>(Location.A, Status.DIRTY)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.CLEAN), new Percept<>(Location.B, Status.CLEAN)), Action.LEFT);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.CLEAN), new Percept<>(Location.B, Status.DIRTY)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.DIRTY), new Percept<>(Location.B, Status.CLEAN)), Action.CLEAN);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.DIRTY), new Percept<>(Location.B, Status.DIRTY)), Action.CLEAN);

        return table;
    }
}
