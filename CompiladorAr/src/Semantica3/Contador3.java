/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantica3;

/**
 *
 * @author Usuario
 */
public class Contador3 {

    private final String funcion; 
    private int entrada;
    private int salida;
    private int aceptados;
    private int errores;
    
    public Contador3(String funcion) {
        this.funcion = funcion;
        this.entrada=0;
        this.salida=0;
        this.aceptados=0;
        this.errores=0;
    }

    public String getFuncion() {
        return funcion;
    }
    
    public int getEntrada() {
        return entrada;
    }

    public void setEntrada() {
        this.entrada++;
    }

    public int getSalida() {
        return salida;
    }

    public void setSalida() {
        this.salida++;
    }

    public int getAceptados() {
        return aceptados;
    }

    public void setAceptados() {
        this.aceptados++;
    }

    public int getErrores() {
        return errores;
    }

    public void setErrores() {
        this.errores++;
    }
}