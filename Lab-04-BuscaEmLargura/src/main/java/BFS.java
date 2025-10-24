import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public BFS() {
    }

    public static List<No> execute(Estado origem, Estado obejtivo) {
        Queue<No> borda = new LinkedList<>();
        List<Estado> explorados = new ArrayList<>();

        No o = new No(origem, null, 0);
        if (o.estado == obejtivo) {
            return getSolution(o);
        }
        borda.add(o);
        while (!borda.isEmpty()) {
            No u = borda.remove();
            explorados.add(u.estado);

            for (Transicao t : u.estado.transicoes) {
                No filho = new No(t.estadoDestino, u, u.custo + t.custo);
                if(!explorados.contains(filho.estado) && !borda.contains(filho)) {
                    if(filho.estado == obejtivo) {
                        return getSolution(filho);
                    }
                    borda.add(filho);
                }
            }
        }
        return null;
    }

    public static List<No> getSolution (No no){
        List<No> res = new ArrayList<>();
        res.add(no);

        while (no.pai != null) {
            no  = no.pai;
            res.add(no);
        }
        return res;
    }
}
