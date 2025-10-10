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

    public Action act(Perception perception) {
        if (perception.isDirty) {
            return new Action("Aspirar");
        } else if (perception.location == 'A') {
            return new Action("Direita");
        } else {
            return new Action("Esquerda");
        }
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

            Action action = agent.act(perception);
            System.out.println("➡️ " + action + "\n");

            enviroment.executeAction(action);
        }
    }
}
public class Main {
    public static void main(String[] args) {
        World world = new World(new Agent());
        world.run(6);
    }
}
