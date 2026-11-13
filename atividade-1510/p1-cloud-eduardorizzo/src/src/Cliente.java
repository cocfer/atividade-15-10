
import java.util.Objects;

public class Cliente {

    private String cpf;
    private String nome;

    public Cliente(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
    }

    // Métodos de acesso
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // Verifica se os clientes possuem o mesmo CPF
    @Override
    public boolean equals(Object objeto) {
        if (objeto == this) {
            return true;
        }

        if (!(objeto instanceof Cliente)) {
            return false;
        }

        Cliente cliente = (Cliente) objeto;

        return Objects.equals(this.cpf, cliente.cpf);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(cpf);
    }
}
