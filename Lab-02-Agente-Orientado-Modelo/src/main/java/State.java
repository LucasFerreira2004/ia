import java.util.Map;

public class State {
    public String name;
    public char agentLocation;
    public boolean isDirtyA;
    public boolean isDirtyB;
    Map<Action, State> neighbors;

    State(String name, char agentLocation, boolean isDirtyA, boolean isDirtyB){
        this.name = name;
        this.isDirtyA = isDirtyA;
        this.isDirtyB = isDirtyB;
        this.agentLocation = agentLocation;
    }

    @Override
    public String toString(){
        return "name " + name + "agenteLocation: " + agentLocation+ " roomA: " + isDirtyA + " roomB: " + isDirtyB ;
    }

}
