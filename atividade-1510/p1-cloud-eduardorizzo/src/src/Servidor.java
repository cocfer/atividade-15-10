
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Servidor {

    private String ip;
    private double ramTotal;
    private double precoPorHora;
    private boolean statusLigado;

    private List<Container> containers = new ArrayList<>();

    public Servidor(String ip, double memoria, double preco) {
        this.ip = ip;
        this.ramTotal = memoria;
        this.precoPorHora = preco;
        this.statusLigado = false;
    }

    // Getters e setters
    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public double getRamTotal() {
        return ramTotal;
    }

    public void setRamTotal(double ramTotal) {
        this.ramTotal = ramTotal;
    }

    public double getPrecoPorHora() {
        return precoPorHora;
    }

    public void setPrecoPorHora(double precoPorHora) {
        this.precoPorHora = precoPorHora;
    }

    public boolean isStatusLigado() {
        return statusLigado;
    }

    public List<Container> getContainers() {
        return containers;
    }

    // Controle de funcionamento
    public void ligar() {
        statusLigado = true;
    }

    public void desligar() {
        statusLigado = false;
    }

    // Realiza a alocação respeitando as regras do servidor
    public void alocarContainer(Container container)
            throws CapacidadeExcedidaException {

        if (!statusLigado) {
            throw new ServidorOfflineException(
                "Erro: Não é possível alocar containers em um servidor desligado."
            );
        }

        double memoriaAtual = calcularRamEmUso();
        double memoriaNova = container.getRamNecessaria();

        if (memoriaAtual + memoriaNova > ramTotal) {
            throw new CapacidadeExcedidaException(
                "Falha Crítica: Memória RAM insuficiente no servidor " + ip + "."
            );
        }

        containers.add(container);
    }

    // Calcula a memória utilizada através de Streams
    public double calcularRamEmUso() {
        return containers.stream()
                .mapToDouble(container -> container.getRamNecessaria())
                .sum();
    }

    // Compara servidores pelo endereço IP
    @Override
    public boolean equals(Object objeto) {

        if (objeto == this) {
            return true;
        }

        if (!(objeto instanceof Servidor)) {
            return false;
        }

        Servidor outro = (Servidor) objeto;

        return Objects.equals(ip, outro.ip);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(ip);
    }
}
