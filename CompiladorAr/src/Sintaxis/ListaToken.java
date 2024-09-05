package Sintaxis;

import Sintaxis.NodoToken;


public class ListaToken {
    int tam=0;
    NodoToken prim = null;
    NodoToken ult = null;
    boolean r = false;
    
    public boolean insertarUltimo(int linea, int token, String lexema){
        NodoToken nuevo=new NodoToken(linea, token, lexema);
        if(prim==null){
            prim=nuevo;
            ult=nuevo;
            r=true;
        }
          else{
            ult.sig=nuevo;
            ult=nuevo;
            r=true;
           }
        tam++;
        return r;
    }
    public String mostrarLexemaPrimero(){
        return prim.getLexema();
    }
    
    public int mostrarLineaPrimero(){      
        return prim.getLinea();
    }
    
    public int mostrarTokenPrimero(){
        return prim.getToken();
    }
    
    public NodoToken obtenerPrimero(){
        return prim;
    }

    public boolean insertarInicio(int linea, int token, String lexema) {
        tam++;
        NodoToken nuevo = new NodoToken(linea, token, lexema);
        if (prim == null) {
            prim = nuevo;
            ult = nuevo;
            r = true;
        } else {
            nuevo.sig = prim;
            prim = nuevo;
            r = true;
        }
        return r;
    }

    public void mostrarDatos() {
        NodoToken aux = prim;
        if (prim == null) {
        } else {
            while (aux != null) {
                aux = aux.sig;

            }
        }
    }

    public boolean listaVacia() {
        if (prim == null) {
            return true;
        } else {
            return false;
        }
    }
    public int mostrarPrimero(){
        return prim.getToken();
    }

    public boolean eliminarInicio() {
        NodoToken aux = prim;
        if (prim == ult) {
            prim = null;
            ult = null;
            r = true;
        }
        if (prim != null) {
            prim = prim.sig;
            aux.sig = null;
            r = true;
        }
        return r;
    }

    public NodoToken getUlt() {
        return ult;
    }

    public void setUlt(NodoToken ult) {
        this.ult = ult;
    }
    
    
}
