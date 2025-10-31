public class No {
    Estado  estado;
    No pai;
    int custo;
    Transicao transicao;

    public No(Estado estado, No pai, int custo) {
        this.estado = estado;
        this.pai = pai;
        this.custo = custo;
        this.transicao = transicao;
    }

    @Override
    public String toString(){
        if (pai == null)
            return estado.toString() + " pai: null" + " custo: " + custo;
        return estado.toString() + " pai: " + pai.estado + " custo: " + custo;
    }
}
