public class Enviroment {
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
        switch (action) {
            case ASPIRAR:
                if (agentLocation == 'A') {
                    isDurtyA = false;
                } else {
                    isDurtyB = false;
                }
                break;
            case DIREITA:
                agentLocation = 'B';
                break;
            case ESQUERDA:
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
