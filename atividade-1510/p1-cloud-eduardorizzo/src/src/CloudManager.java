
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloudManager {

    private Map<Cliente, Set<Servidor>> bancoDeDados = new HashMap<>();

    // Cadastra um novo cliente
    public void registrarCliente(Cliente cliente) {
        bancoDeDados.putIfAbsent(cliente, new HashSet<>());
    }

    // Vincula um servidor ao cliente
    public void adicionarServidor(Cliente cliente, Servidor servidor) {
        bancoDeDados.computeIfAbsent(cliente, c -> new HashSet<>())
                    .add(servidor);
    }

    // Calcula o valor dos servidores que estão ativos
    public double calcularFaturaAtiva(Cliente cliente) {

        return bancoDeDados
                .getOrDefault(cliente, Set.of())
                .stream()
                .filter(servidor -> servidor.isStatusLigado())
                .mapToDouble(servidor -> servidor.getPrecoPorHora())
                .sum();
    }
}
