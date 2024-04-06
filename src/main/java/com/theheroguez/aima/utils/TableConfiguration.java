package com.theheroguez.aima.utils;

import com.theheroguez.aima.*;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.environment.vacuum.VacuumModel;
import com.theheroguez.aima.environment.vacuum.VacuumState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.*;

import static com.theheroguez.aima.environment.vacuum.VacuumTableDrivenAgent.*;

/**
 * The TableConfiguration class is a configuration class that provides a bean for tabulating a table for TDA (Table-Driven Agent).
 * It contains a method to create and populate the table with a mapping of percept combinations to actions.
 */
@Configuration
public class TableConfiguration {
    @Bean
    public Map<List<Percept<Location, Status>>, Action> tabulateTableForTDA() {
        Map<List<Percept<Location, Status>>, Action> table = new HashMap<>();
        table.put(Collections.singletonList(new Percept<>(Location.A, Status.CLEAN)), MOVE_RIGHT);
        table.put(Collections.singletonList(new Percept<>(Location.A, Status.DIRTY)), SUCK);
        table.put(Collections.singletonList(new Percept<>(Location.B, Status.CLEAN)), MOVE_LEFT);
        table.put(Collections.singletonList(new Percept<>(Location.B, Status.DIRTY)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.CLEAN), new Percept<>(Location.A, Status.CLEAN)), MOVE_RIGHT);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.CLEAN), new Percept<>(Location.A, Status.DIRTY)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.DIRTY), new Percept<>(Location.A, Status.CLEAN)), MOVE_RIGHT);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.DIRTY), new Percept<>(Location.A, Status.DIRTY)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.CLEAN), new Percept<>(Location.B, Status.CLEAN)), MOVE_RIGHT);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.CLEAN), new Percept<>(Location.B, Status.DIRTY)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.DIRTY), new Percept<>(Location.B, Status.CLEAN)), MOVE_LEFT);
        table.put(Arrays.asList(new Percept<>(Location.A, Status.DIRTY), new Percept<>(Location.B, Status.DIRTY)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.CLEAN), new Percept<>(Location.A, Status.CLEAN)), MOVE_LEFT);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.CLEAN), new Percept<>(Location.A, Status.DIRTY)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.DIRTY), new Percept<>(Location.A, Status.CLEAN)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.DIRTY), new Percept<>(Location.A, Status.DIRTY)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.CLEAN), new Percept<>(Location.B, Status.CLEAN)), MOVE_LEFT);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.CLEAN), new Percept<>(Location.B, Status.DIRTY)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.DIRTY), new Percept<>(Location.B, Status.CLEAN)), SUCK);
        table.put(Arrays.asList(new Percept<>(Location.B, Status.DIRTY), new Percept<>(Location.B, Status.DIRTY)), SUCK);

        return table;
    }

    @Bean
    public List<Rule<Action>> simpleReflexRules() {
        List<Rule<Action>> rules = new ArrayList<>();
        rules.add(new Rule<>(SUCK, state -> ((VacuumState) state).getCurrentState().equals(Status.DIRTY)));
        rules.add(new Rule<>(MOVE_RIGHT, state -> ((VacuumState) state).getCurrentState().equals(Status.CLEAN) && ((VacuumState) state).getCurrentLocation().equals(Location.A)));
        rules.add(new Rule<>(MOVE_LEFT, state -> ((VacuumState) state).getCurrentState().equals(Status.CLEAN) && ((VacuumState) state).getCurrentLocation().equals(Location.B)));

        return rules;
    }

    @Bean
    public VacuumModel vacuumModelFactory() {
        return new VacuumModel();
    }
}
