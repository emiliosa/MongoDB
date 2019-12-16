package ar.com.uade.Bean;

public enum Moneda {
    PESO_ARGENTINO (1),
    DOLAR_USA (2);

    private final int monedaCodigo;

    Moneda(int monedaCodigo) {
        this.monedaCodigo = monedaCodigo;
    }

    public String toString() {
        return values()[monedaCodigo].name();
    }
}