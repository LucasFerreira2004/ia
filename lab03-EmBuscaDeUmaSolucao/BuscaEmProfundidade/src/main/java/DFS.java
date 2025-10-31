import java.util.*;

public class DFS {

    public DFS() {
    }

    public static List<No> execute(Estado origem, Estado obejtivo) {
        Stack<No> borda = new Stack<>();
        List<Estado> explorados = new ArrayList<>();

        No o = new No(origem, null, 0);
        if (o.estado.equals(obejtivo)) {
            return getSolution(o);
        }
        borda.add(o);
        while (!borda.isEmpty()) {
            No u = borda.pop();
            explorados.add(u.estado);

            for (Transicao t : u.estado.transicoes){
                No filho = new No(t.estadoDestino, u, u.custo + t.custo);
                if (!explorados.contains(filho.estado) && !borda.contains(filho)) {
                    if (filho.estado.equals(obejtivo)) {
                        System.out.println("custo " + filho.custo);
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
