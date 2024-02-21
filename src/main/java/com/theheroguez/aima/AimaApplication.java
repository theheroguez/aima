package com.theheroguez.aima;

import com.theheroguez.aima.enums.Action;
import com.theheroguez.aima.agents.Agent;
import com.theheroguez.aima.agents.TableDrivenAgent;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.percepts.Percept;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class AimaApplication {

    /**
     * The main method is the entry point of the application.
     * It creates a table mapping percepts to actions, creates a list of percepts,
     * and uses a TableDrivenAgent to process each percept and determine the corresponding action.
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(AimaApplication.class, args);

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

        List<Percept<Location, Status>> percepts = new ArrayList<>();
        percepts.add(new Percept<>(Location.A, Status.CLEAN));
        percepts.add(new Percept<>(Location.B, Status.DIRTY));
        percepts.add(new Percept<>(Location.A, Status.CLEAN));

        Agent agent = new TableDrivenAgent(table);

        for (Percept<Location, Status> percept : percepts) {
            Action action = agent.process(percept);
            System.out.println("Action: " + action);
        }
    }

}
