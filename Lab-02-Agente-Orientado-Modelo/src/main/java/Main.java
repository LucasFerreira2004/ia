import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
