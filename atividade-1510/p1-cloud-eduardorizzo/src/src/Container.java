
import java.util.Objects;

public class Container {

    private String id;
    private double ramNecessaria;

    public Container(String identificador, double memoria) {
        this.id = identificador;
        this.ramNecessaria = memoria;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getRamNecessaria() {
        return ramNecessaria;
    }

    public void setRamNecessaria(double ramNecessaria) {
        this.ramNecessaria = ramNecessaria;
    }

    // Compara os containers pelo identificador
    @Override
    public boolean equals(Object objeto) {

        if (objeto == this) {
            return true;
        }

        if (!(objeto instanceof Container)) {
            return false;
        }

        Container outro = (Container) objeto;

        return Objects.equals(id, outro.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
