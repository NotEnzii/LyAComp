/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantica1;

/**
 *
 * @author Usuario
 */
public class Contador {

    private final int linea;
    private int tint;
    private int treal;
    private int texp;
    private int tchar;
    private int tcharll;
    private int tbool;
    private int treg;
    private int tvoid;
    private int tfile;
    private int tvariant;
    private int total;
    private String asignacion;

    public Contador(int linea) {
        this.linea = linea;
        this.tint = 0;
        this.treal = 0;
        this.texp = 0;
        this.tchar = 0;
        this.tcharll = 0;
        this.tbool = 0;
        this.treg = 0;
        this.tvoid = 0;
        this.tfile = 0;
        this.tvariant = 0;
        this.total = 0;
        this.asignacion="";
    }

    public int getLinea() {
        return linea;
    }

    public void setTint() {
        this.tint++;
    }

    public void setTreal() {
        this.treal++;
    }

    public void setTexp() {
        this.texp++;
    }

    public void setTchar() {
        this.tchar++;
    }

    public void setTcharll() {
        this.tcharll++;
    }

    public void setTbool() {
        this.tbool++;
    }

    public void setTreg() {
        this.treg++;
    }

    public void setTvoid() {
        this.tvoid++;
    }

    public void setTfile() {
        this.tfile++;
    }

    public void setTvariant() {
        this.tvariant++;
    }

    public void setTotal() {
        this.total++;
    }
    
    public String todo(){
        return linea+" - "+tint+" - "+treal+" - "+texp+" - "+tchar+" - "+tcharll+" - "+tbool+" - "+treg+" - "+tvoid+" - "+tfile+" - "+tvariant+" - "+total;
    }

    public int getTint() {
        return tint;
    }

    public int getTreal() {
        return treal;
    }

    public int getTexp() {
        return texp;
    }

    public int getTchar() {
        return tchar;
    }

    public int getTcharll() {
        return tcharll;
    }

    public int getTbool() {
        return tbool;
    }

    public int getTreg() {
        return treg;
    }

    public int getTvoid() {
        return tvoid;
    }

    public int getTfile() {
        return tfile;
    }

    public int getTvariant() {
        return tvariant;
    }

    public int getTotal() {
        return total;
    }

    public String getAsignacion() {
        return asignacion;
    }

    public void setAsignacion(String asignacion) {
        this.asignacion = asignacion;
    }
}