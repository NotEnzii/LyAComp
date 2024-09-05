package Errores;
public class NodoError {

    private String descripcion;
    private String lexema;
    private String tipo;
    private int linea;
    private int error;

    public NodoError(int linea, int error, String descripcion, String lexema, String tipo) {
        this.linea = linea;
        this.error = error;
        this.descripcion = descripcion;
        this.lexema = lexema;
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }
}
