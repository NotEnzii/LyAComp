/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Errores;

import Sintaxis.NodoToken;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Usuario
 */
public class ListaError {
    JTable tablaTokens;
    JTable tablaErrores;
    NodoToken tokens[];
    NodoError errores[];

    public ListaError(JTable tablaTokens, JTable tablaErrores) {
        this.tablaTokens = tablaTokens;
        this.tablaErrores = tablaErrores;
        inicializarVariables();
    }
    
    public NodoToken[] obtenerArregloTokens(){
        return this.tokens;
    }
    
    public NodoError[] obtenerArregloErrores(){
        return this.errores;
    }
    
    private void inicializarVariables(){
        tokens = new NodoToken[1];
        errores = new NodoError[1];
    }
    
    public void agregarToken(int estado, String lexema, int linea){
        tokens[tokens.length - 1] = new NodoToken(linea, estado, lexema);
        aumentarArregloToken();
    }
    
    public void agregarError(int estado, String descripcion, String lexema, 
            int linea, String etapa){
        errores[errores.length - 1] = new NodoError(linea, estado,descripcion,lexema,etapa);
        aumentarArregloError();
    }
    
    public void actualizarTablas(){
        DefaultTableModel modeloTabla = new DefaultTableModel(0,0);
        tablaTokens.setModel(modeloTabla);
        tablaTokens.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Lexema");
        modeloTabla.addColumn("Linea");
        for (int i = 0; i < tokens.length - 1; i++) {
            modeloTabla.addRow(new Object[]{
                tokens[i].getToken(),
                tokens[i].getLexema(),
                tokens[i].getLinea()});
        }
        modeloTabla = new DefaultTableModel(0,0);
        tablaErrores.setModel(modeloTabla);
        tablaErrores.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        modeloTabla.addColumn("Estado");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Lexema");
        modeloTabla.addColumn("Linea");
        modeloTabla.addColumn("Tipo");
        for (int i = 0; i < errores.length - 1; i++) {
            modeloTabla.addRow(new Object[]{
                errores[i].getError(),
                errores[i].getDescripcion(),
                errores[i].getLexema(),
                errores[i].getLinea(),
                errores[i].getTipo()});
        }
    }
    
    private void aumentarArregloToken() {
        NodoToken aux[] = tokens;
        tokens = new NodoToken[tokens.length + 1];
        for (int i = 0; i < aux.length; i++) {
            tokens[i] = aux[i];
        }
    }
    
    private void aumentarArregloError() {
        NodoError aux[] = errores;
        errores = new NodoError[errores.length + 1];
        for (int i = 0; i < aux.length; i++) {
            errores[i] = aux[i];
        }
    }

    public int getErrores() {
        return errores.length;
    }
    
    
}