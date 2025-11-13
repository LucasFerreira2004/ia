import java.util.*;

public class AStar {
    public AStar(Map<Estado, Integer> heuristicas) {
    }

    public static List<No> execute(Estado origem, Estado objetivo, Map<Estado, Integer> heuristicas) {
        PriorityQueue<No> borda = new PriorityQueue<>(Comparator.comparingInt(no -> heuristicas.get(no.estado) +  no.custo));
        List<Estado> explorados = new ArrayList<>();

        No o = new No(origem, null, 0, null);
        if (o.estado.equals(objetivo)) {
            System.out.println("custo: " + o.custo);
            System.out.println(getCaminho(o));
            return getSolution(o);
        }
        borda.add(o);
        while (!borda.isEmpty()) {
            No u = borda.poll();
            if (u.estado.equals(objetivo)) {
                System.out.println("custo: " + u.custo);
                System.out.println(getCaminho(u));
                return getSolution(u);
            }
            explorados.add(u.estado);

            for (Transicao t : u.estado.transicoes) {
                No filho = new No(t.estadoDestino, u, u.custo + t.custo, t);
                Optional<No> existente = borda.stream()
                        .filter(n -> n.estado.equals(t.estadoDestino))
                        .findFirst();

                if(!explorados.contains(filho.estado) && !borda.contains(filho)) {
                    borda.add(filho);
                }
                else if (existente.isPresent() && (heuristicas.get(filho.estado) + filho.custo) < (heuristicas.get(existente.get().estado) + existente.get().custo)) {
                    borda.remove(existente.get());
                    borda.add(filho);
                }
            }
        }
        return null;
    }
    public static String getCaminho(No no){
        StringBuilder caminho = new StringBuilder();
        caminho.append(no.transicao);
        while(no.pai != null){
            caminho.append(no.pai.transicao);
            no = no.pai;
        }
        return caminho.toString();
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
