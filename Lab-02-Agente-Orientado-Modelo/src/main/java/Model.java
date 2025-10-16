import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    static List<State> states = new ArrayList<>();
    Model(){
        generateModel();
    }
    public static void generateModel(){
        states.clear();
        State s0 = new State("S0",'A', true, true);
        State s1 = new State("S1",'A', false, true);
        State s2 = new State("S2",'B', false, true);
        State s3 = new State("S3",'B', false, false);
        State s4 = new State("S4",'A', false, false);
        State s5 = new State("S5",'B', true, true);
        State s6 = new State("S6",'B', true, false);
        State s7 = new State("S7",'A', true, false);
        states.add(s0);
        states.add(s1);
        states.add(s2);
        states.add(s3);
        states.add(s4);
        states.add(s5);
        states.add(s6);
        states.add(s7);

        s0.neighbors.put(Action.ASPIRAR, s1); // limpa A
        s0.neighbors.put(Action.DIREITA, s5); // vai pra B
        s0.neighbors.put(Action.ESQUERDA, s0); // permanece (sem sala à esquerda)

        s1.neighbors.put(Action.ASPIRAR, s1); // já limpa
        s1.neighbors.put(Action.DIREITA, s2); // vai pra B
        s1.neighbors.put(Action.ESQUERDA, s1); // permanece

        s2.neighbors.put(Action.ASPIRAR, s3); // limpa B
        s2.neighbors.put(Action.ESQUERDA, s1); // volta pra A
        s2.neighbors.put(Action.DIREITA, s2); // permanece (sem sala à direita)

        s3.neighbors.put(Action.ASPIRAR, s3); // já limpo
        s3.neighbors.put(Action.ESQUERDA, s4); // vai pra A
        s3.neighbors.put(Action.DIREITA, s3); // permanece

        s4.neighbors.put(Action.ASPIRAR, s4); // já limpo
        s4.neighbors.put(Action.DIREITA, s3); // vai pra B
        s4.neighbors.put(Action.ESQUERDA, s4); // permanece

        s5.neighbors.put(Action.ASPIRAR, s6); // limpa B
        s5.neighbors.put(Action.ESQUERDA, s0); // volta pra A
        s5.neighbors.put(Action.DIREITA, s5); // permanece

        s6.neighbors.put(Action.ASPIRAR, s6); // já limpo
        s6.neighbors.put(Action.ESQUERDA, s7); // volta pra A
        s6.neighbors.put(Action.DIREITA, s6); // permanece

        s7.neighbors.put(Action.ASPIRAR, s4); // limpa A
        s7.neighbors.put(Action.DIREITA, s6); // vai pra B
        s7.neighbors.put(Action.ESQUERDA, s7); // permanece
    }
    public void printModel(){
        System.out.println(states);
    }
}

