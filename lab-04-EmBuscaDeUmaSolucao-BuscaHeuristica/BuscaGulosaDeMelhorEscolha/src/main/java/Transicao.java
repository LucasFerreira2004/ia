public class Transicao {
    Estado estadoDestino;
    int custo;

    public Transicao(Estado estadoDestino, int custo) {
        this.estadoDestino = estadoDestino;
        this.custo = custo;
    }

    @Override
    public String toString() {
        if (estadoDestino == null)
            return "null |";
        return "ir para -> " + estadoDestino.nome + "|";
    }
}
