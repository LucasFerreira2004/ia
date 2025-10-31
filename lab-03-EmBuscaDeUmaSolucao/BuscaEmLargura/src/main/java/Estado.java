import java.util.ArrayList;
import java.util.List;

public class Estado {
    String nome;
    List<Transicao> transicoes;

    public Estado(String nome) {
        this.nome = nome;
        this.transicoes = new ArrayList<>();
    }
    @Override
    public String toString(){
        return nome;
    }
}
