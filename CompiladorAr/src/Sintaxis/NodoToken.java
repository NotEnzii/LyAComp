package Sintaxis;
public class NodoToken {
    private String lexema;
    private int token;
    private int linea;
    NodoToken sig;

    public NodoToken(int linea, int token, String lexema){
        this.linea=linea;
        this.token=token;
        this.lexema=lexema;
    }
    public String getLexema() {
        return lexema;
    }

    public void setLexema(String lexema) {
        this.lexema = lexema;
    }

    public int getToken() {
        return token;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public NodoToken getSig() {
        return sig;
    }

    public void setSig(NodoToken sig) {
        this.sig = sig;
    }
}
