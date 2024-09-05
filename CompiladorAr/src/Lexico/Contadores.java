package Lexico;
public class Contadores {
    private int errores;
    private int id;
    private int coment;
    private int pr;
    private int cedec;
    private int ctext;
    private int cdeci;
    private int ccar;
    private int cexp;
    private int arit;
    private int mono;
    private int logico;
    private int rel;
    private int bit;
    private int punt;
    private int agrup;
    private int asig;
    private int linea;

    public Contadores(int errores, int id, int coment, int pr, int cedec, int ctext, int cdeci, int ccar, int cexp, int arit, int mono, int logico, int rel, int bit, int punt, int agrup, int asig, int linea) {
        this.errores = errores;
        this.id = id;
        this.coment = coment;
        this.pr = pr;
        this.cedec = cedec;
        this.ctext = ctext;
        this.cdeci = cdeci;
        this.ccar = ccar;
        this.cexp = cexp;
        this.arit = arit;
        this.mono = mono;
        this.logico = logico;
        this.rel = rel;
        this.bit = bit;
        this.punt = punt;
        this.agrup = agrup;
        this.asig = asig;
        this.linea = linea;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores(int errores) {
        this.errores = errores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getComent() {
        return coment;
    }

    public void setComent(int coment) {
        this.coment = coment;
    }

    public int getPr() {
        return pr;
    }

    public void setPr(int pr) {
        this.pr = pr;
    }

    public int getCedec() {
        return cedec;
    }

    public void setCedec(int cedec) {
        this.cedec = cedec;
    }

    public int getCtext() {
        return ctext;
    }

    public void setCtext(int ctext) {
        this.ctext = ctext;
    }

    public int getCdeci() {
        return cdeci;
    }

    public void setCdeci(int cdeci) {
        this.cdeci = cdeci;
    }

    public int getCcar() {
        return ccar;
    }

    public void setCcar(int ccar) {
        this.ccar = ccar;
    }

    public int getCexp() {
        return cexp;
    }

    public void setCexp(int cexp) {
        this.cexp = cexp;
    }

    public int getArit() {
        return arit;
    }

    public void setArit(int arit) {
        this.arit = arit;
    }

    public int getMono() {
        return mono;
    }

    public void setMono(int mono) {
        this.mono = mono;
    }

    public int getLogico() {
        return logico;
    }

    public void setLogico(int logico) {
        this.logico = logico;
    }

    public int getRel() {
        return rel;
    }

    public void setRel(int rel) {
        this.rel = rel;
    }

    public int getBit() {
        return bit;
    }

    public void setBit(int bit) {
        this.bit = bit;
    }

    public int getPunt() {
        return punt;
    }

    public void setPunt(int punt) {
        this.punt = punt;
    }

    public int getAgrup() {
        return agrup;
    }

    public void setAgrup(int agrup) {
        this.agrup = agrup;
    }

    public int getAsig() {
        return asig;
    }

    public void setAsig(int asig) {
        this.asig = asig;
    }

    public int getLinea() {
        return linea;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }
}