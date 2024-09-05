/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantica2;

/**
 *
 * @author Usuario
 */
public class Contador2 {

    private final int Regla;
    private String funcion;
    private String topeLinea;
    private String valorReal;
    private int linea;
    private String edo;
    private int ambito;

    public Contador2(int Regla) {
        this.Regla = Regla;
        funcion = "";
        topeLinea = "";
        valorReal = "";
        linea = 0;
        edo = "";
        ambito = 0;
    }

    public int getRegla() {
        return Regla;
    }

    public String getTopeLinea() {
        return topeLinea;
    }

    public String getValorReal() {
        return valorReal;
    }

    public int getLinea() {
        return linea;
    }

    public String getEdo() {
        return edo;
    }

    public int getAmbito() {
        return ambito;
    }

    public void setTopeLinea(String topeLinea) {
        this.topeLinea = topeLinea;
    }

    public void setValorReal(String valorReal) {
        this.valorReal = valorReal;
    }

    public void setLinea(int linea) {
        this.linea = linea;
    }

    public void setEdo(String edo) {
        this.edo = edo;
    }

    public void setAmbito(int ambito) {
        this.ambito = ambito;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
    
    
}