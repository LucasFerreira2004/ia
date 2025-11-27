public class No {
    Estado  estado;
    No pai;
    int custo;

    public No(Estado estado, No pai, int custo) {
        this.estado = estado;
        this.pai = pai;
        this.custo = custo;
    }

    @Override
    public String toString(){
        if (pai == null)
            return estado.toString() + " pai: null" + " custo: " + custo;
        return estado.toString() + " pai: " + pai.estado + " custo: " + custo;
    }
}
