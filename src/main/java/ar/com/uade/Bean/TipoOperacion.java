package ar.com.uade.Bean;

public enum TipoOperacion {
    COMPRA (1),
    VENTA (2);

    private final int tipoOperacionCodigo;

    TipoOperacion(int tipoOperacionCodigo) {
        this.tipoOperacionCodigo = tipoOperacionCodigo;
    }

    public String toString() {
        return values()[tipoOperacionCodigo].name();
    }
}