public class Transicao {
    Estado estadoDestino;
    int custo;

    public Transicao(Estado estadoDestino, int custo) {
        this.estadoDestino = estadoDestino;
        this.custo = custo;
    }
}
