import java.time.Year;

public class Auto {
    private String marca;
    private int anio;

    public Auto(String marca, int anio) {
        this.marca = marca;
        this.anio = anio;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int calcularPago() {
        int anioActual = Year.now().getValue();
        int antiguedad = anioActual - anio;
        if (antiguedad < 0) antiguedad = 0;
        return antiguedad * 50;
    }

    @Override
    public String toString() {
        return "\n---Auto---\n" +
                "Marca: " + marca +
                "\t Año: " + anio;
    }
}


