import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class State{
    public boolean isDirtyA;
    public boolean isDirtyB;
    public char agentLocation;

    State(char agentLocation, boolean isDirtyA, boolean isDirtyB){
        this.isDirtyA = isDirtyA;
        this.isDirtyB = isDirtyB;
        this.agentLocation = agentLocation;
    }
    @Override
    public String toString(){
        return "loc: " + agentLocation+ " roomA: " + isDirtyA + " roomB: " + isDirtyB;
    }
    public State next(String action) {
        boolean a = isDirtyA;
        boolean b = isDirtyB;
        char loc = agentLocation;

        switch (action) {
            case "Aspirar":
                if (loc == 'A') a = false;
                else b = false;
                break;
            case "Direita":
                loc = 'B';
                break;
            case "Esquerda":
                loc = 'A';
                break;
        }
        return new State(loc, a, b);
    }
}


class Model{
    static Map<State, Map<String, State>> adjacency = new HashMap<>();
    Model(){
        generateModel();
    }
    public static void generateModel(){
        List<State> states = new ArrayList<>();

        char[] agenteLocations = {'A', 'B'};
        for (char loc : agenteLocations) {
            for (boolean a : new boolean[]{true, false}) {
                for (boolean b : new boolean[]{true, false}) {
                    State state = new State(loc, a, b);
                    states.add(state);
                }
            }
        }

        List<String> actions = new ArrayList<>();
        actions.add("direta");
        actions.add("esquerda");
        actions.add("aspirar");
        
        for (State state : states){
            Map<String, State> neighbors = new HashMap<>();
            for (String act : actions){
                neighbors.put(act, state.next(act));
            }
            adjacency.put(state, neighbors);
        }
    }

    public void printModel(){
        System.out.println(adjacency);
    }
}


class Enviroment {
    public char agentLocation;
    public boolean isDurtyA;
    public boolean isDurtyB;

    public Enviroment(char agentLocation, boolean isDurtyA, boolean isDurtyB) {
        this.agentLocation = agentLocation;
        this.isDurtyA = isDurtyA;
        this.isDurtyB = isDurtyB;
    }
    public Enviroment() {
        this.agentLocation = 'A';
        this.isDurtyA = true;
        this.isDurtyB = true;
    }

    public Perception getPerception() {
        if (this.agentLocation == 'A') {
            return new Perception('A', isDurtyA);
        }
        return new Perception('B', isDurtyB);
    }

    public void executeAction(Action action){
        String act = action.action;
        switch (act) {
            case "Aspirar":
                if (agentLocation == 'A') {
                    isDurtyA = false;
                } else {
                    isDurtyB = false;
                }
                break;
            case "Direita":
                agentLocation = 'B';
                break;
            case "Esquerda":
                agentLocation = 'A';
                break;
        }
    }
    @Override
    public String toString() {
        String aRoom = isDurtyA ? ".*.*."  : "  ";
        String bRoom = isDurtyB ? ".*.*."  : "  ";
        String enviroment = "";
        if (agentLocation == 'A') {
            enviroment = "[(º-º) " + aRoom +"] [" + bRoom + "]";
        }else if (agentLocation == 'B') {
            enviroment = "[" + aRoom +"] [(º-º)" + bRoom + "]";
        }
        return enviroment;
    }
}

class Agent {
    public Perception perceive(Enviroment environment) {
        return environment.getPerception();
    }


}
class Action {
    public String action;
    public Action(String action) {
        this.action = action;
    }
    @Override
    public String toString() {
        return "ação: " + action;
    }
}

class Perception {
    public char location;
    public boolean isDirty;

    public Perception(char location, boolean isDirty) {
        this.location = location;
        this.isDirty = isDirty;
    }

    @Override
    public String toString() {
        String estado = isDirty ? "true" : "false";
        return "Percepção: " + location + ", " + estado;
    }

}

class World {
    Enviroment enviroment;
    Agent agent;

    World(Agent agent){
        this.enviroment = new Enviroment();
        this.agent = agent;
    }

    public void run(int steps) {
        System.out.println("\n " + "agente" + " \n");
        for (int step = 0; step < steps; step++) {
            System.out.println("Passo " + (step + 1));
            System.out.println(enviroment);

            Perception perception = agent.perceive(enviroment);
            System.out.println(perception);

            //Action action = agent.act(perception);
            //System.out.println("➡️ " + action + "\n");

           // enviroment.executeAction(action);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Model model = new Model();
        model.printModel();
    }
}
