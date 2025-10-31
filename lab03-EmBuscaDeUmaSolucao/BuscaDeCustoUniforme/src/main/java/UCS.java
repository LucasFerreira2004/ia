import java.util.*;

public class UCS {

    public UCS() {
    }

    public static List<No> execute(Estado origem, Estado obejtivo) {
        PriorityQueue<No> borda = new PriorityQueue<>(Comparator.comparingInt(no -> no.custo));
        List<Estado> explorados = new ArrayList<>();

        No o = new No(origem, null, 0);
        if (o.estado.equals(obejtivo)) {
            return getSolution(o);
        }
        borda.add(o);
        while (!borda.isEmpty()) {
            No u = borda.poll();
            if (u.estado.equals(obejtivo)) {
                System.out.println("custo: " + u.custo);
                return getSolution(u);
            }
            explorados.add(u.estado);

            for (Transicao t : u.estado.transicoes) {
                No filho = new No(t.estadoDestino, u, u.custo + t.custo);
                Optional<No> existente = borda.stream()
                        .filter(n -> n.estado.equals(t.estadoDestino))
                        .findFirst();

                if(!explorados.contains(filho.estado) && !borda.contains(filho)) {
                    borda.add(filho);
                }
                else if (existente.isPresent() && filho.custo < existente.get().custo) {
                    borda.remove(existente.get());
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
