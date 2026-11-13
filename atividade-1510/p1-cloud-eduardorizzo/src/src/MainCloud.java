
public class MainCloud {

    public static void main(String[] args) {

        CloudManager sistema = new CloudManager();

        // Criando o cliente
        Cliente cliente = new Cliente("111.222.333-44", "Wayne Enterprises");

        // Criando o servidor
        Servidor servidor = new Servidor("192.168.0.1", 16.0, 5.50);

        // Cadastrando cliente e servidor
        sistema.registrarCliente(cliente);
        sistema.adicionarServidor(cliente, servidor);

        // Criando os containers
        Container primeiro = new Container("C-01", 10.0);
        Container segundo = new Container("C-02", 8.0);

        // Teste de servidor desligado (exceção unchecked)
        // Descomente para testar e depois comente novamente.
        // servidor.alocarContainer(primeiro);

        // Ativando o servidor
        servidor.ligar();

        // Primeira alocação
        try {
            servidor.alocarContainer(primeiro);
            System.out.println("Primeiro container adicionado!");
        } catch (CapacidadeExcedidaException erro) {
            System.out.println(erro.getMessage());
        }

        // Segunda alocação: ultrapassa a memória disponível
        try {
            servidor.alocarContainer(segundo);
            System.out.println("Segundo container adicionado!");
        } catch (CapacidadeExcedidaException erro) {
            System.out.println("Erro na alocação: " + erro.getMessage());
        }

        // Consultando o faturamento
        double valor = sistema.calcularFaturaAtiva(cliente);

        System.out.println("Valor da fatura ativa: R$ " + valor);
    }
}
