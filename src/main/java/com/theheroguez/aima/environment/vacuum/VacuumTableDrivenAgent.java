package com.theheroguez.aima.environment.vacuum;

import com.theheroguez.aima.Action;
import com.theheroguez.aima.agents.TableDrivenAgent;
import com.theheroguez.aima.enums.Location;
import com.theheroguez.aima.enums.Status;
import com.theheroguez.aima.Percept;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class VacuumTableDrivenAgent extends TableDrivenAgent<Percept<Location, Status>, Action> {
    public static Action MOVE_RIGHT = new VacuumAction("MOVE RIGHT");
    public static Action MOVE_LEFT = new VacuumAction("MOVE LEFT");
    public static Action SUCK = new VacuumAction("SUCK");

    public VacuumTableDrivenAgent(Map<List<Percept<Location, Status>>, Action> table) {
        super(table);
    }
}
