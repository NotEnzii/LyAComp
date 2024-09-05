/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambito;

import Errores.ListaError;
import Externo.MySql;
import Semantica2.Contador2;
import Sintaxis.ListaToken;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Ambito {

    private boolean zonaEjecucion = false;
    private int ambitoActual = 0;
    private int ambitoDisponible = 1;
    private int varibleLinea = 0;
    private final Stack<Integer> pilaAmbito;
    private String nombreVariable;
    private String nombreUltimoRegistro;
    private String tipoVariable;
    private Stack<String> tipoVariableFunSem2;
    private Stack<String> lexemaVariableFunSem2;
    private Stack<Boolean> bandFunSen2;
    private Stack<Boolean> bandFunSen22;
    private boolean duplicadaVariable = false;
    private boolean regNoDeclarado = false;
    private boolean varNoDeclarado = false;
    private boolean arrayVariable = false;
    private final MySql sql;
    private String query = "";
    private int contadorRegitro = 0;
    private int contadorFuncion = 0;
    private ArrayList<String> valoresTipoArr;
    private ArrayList<nodoContadores> contador;
    private ArrayList<Integer> padreHijoAmbito;

    public Ambito(MySql sql) {
        contador = new ArrayList<>();
        valoresTipoArr = new ArrayList<>();
        padreHijoAmbito = new ArrayList<>();
        pilaAmbito = new Stack<>();
        pilaAmbito.push(0);
        padreHijoAmbito.add(0);
        this.sql = sql;
        contador.add(new nodoContadores());
        tipoVariableFunSem2 = new Stack<>();
        lexemaVariableFunSem2 = new Stack<>();
        bandFunSen2 = new Stack<>();
        bandFunSen22 = new Stack<>();
    }

    public Stack<Integer> pila(Stack<Integer> pila, ListaToken oper, ArrayList<Contador2> semantica2Contadores, ListaError cte) {
        tipoVariable(pila.peek());
        switch (pila.peek()) {
            case -100:
                varNoDeclarado = false;
                nombreVariable = oper.obtenerPrimero().getLexema();
                varibleLinea = oper.obtenerPrimero().getLinea();
                break;
            case 300:
                zonaEjecucion = true;
                while (pila.peek() == 300) {
                    pila.pop();
                }
                break;
            case 301:
                zonaEjecucion = false;
                while (pila.peek() == 301) {
                    pila.pop();
                }
                break;
            case 302:
                aumentarAmbito();
                arrayVariable = false;
                valoresTipoArr = new ArrayList<>();
                contador.add(new nodoContadores());
                while (pila.peek() == 302) {
                    pila.pop();
                }
                break;
            case 303:
                if (!bandFunSen2.isEmpty() && !tipoVariableFunSem2.isEmpty() && !lexemaVariableFunSem2.isEmpty()) {
                    if (!bandFunSen22.isEmpty()) {
                        if (tipoVariableFunSem2.peek().equals("VOID")) {
////                        System.out.println(lexemaVariableFunSem2 + "  +  " + tipoVariableFunSem2 + "  +  " + bandFunSen22);
                            cte.agregarError(636, "Regla 1150", "Error", oper.obtenerPrimero().getLinea(), "Semantica2");
                            semantica2Contadores.add(new Contador2(1150));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(lexemaVariableFunSem2.peek());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(oper.obtenerPrimero().getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambitoActual);
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        } else {
                            semantica2Contadores.add(new Contador2(1140));
//                        System.out.println(lexemaVariableFunSem2 + "  +  " + tipoVariableFunSem2 + "  +  " + bandFunSen22);
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(lexemaVariableFunSem2.peek());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(oper.obtenerPrimero().getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambitoActual);
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                        }
                        bandFunSen2.pop();
                        bandFunSen22.pop();
                        tipoVariableFunSem2.pop();
                        lexemaVariableFunSem2.pop();
                    } else {
                        if (tipoVariableFunSem2.peek().equals("VOID")) {
//                        System.out.println(lexemaVariableFunSem2 + "  +  " + tipoVariableFunSem2 + "  +  " + bandFunSen22);
                            semantica2Contadores.add(new Contador2(1150));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(lexemaVariableFunSem2.peek());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(oper.obtenerPrimero().getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambitoActual);
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        } else {
//                        System.out.println(lexemaVariableFunSem2 + "  +  " + tipoVariableFunSem2 + "  +  " + bandFunSen22);
                            cte.agregarError(636, "Regla 1140", "Error", oper.obtenerPrimero().getLinea(), "Semantica2");
                            semantica2Contadores.add(new Contador2(1140));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(lexemaVariableFunSem2.peek());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(oper.obtenerPrimero().getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambitoActual);
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                        }
                        bandFunSen2.pop();
                        tipoVariableFunSem2.pop();
                        lexemaVariableFunSem2.pop();
                    }
                }
                if (padreHijoAmbito.get(padreHijoAmbito.size() - 1) == ambitoActual) {
                    padreHijoAmbito.remove(padreHijoAmbito.size() - 1);
                }
                reducirAmbito();
                arrayVariable = false;
                valoresTipoArr = new ArrayList<>();
                while (pila.peek() == 303) {
                    pila.pop();
                }
                break;
            case 304:
                if (!sql.comprobarVariableDuplicada(nombreVariable.trim(), ambitoActual + "")) {
                    query = "INSERT INTO tablasimbolos (id,tipo,clase,ambito,tarr,dimArr,noPar,tParr) VALUES ('" + nombreVariable.trim() + "', '" + tipoVariable.trim() + "', 'const','" + ambitoActual + "','-','-','0','-');";
                    sql.ejecutarQuery(query);
                    contador.get(ambitoActual).aumentarContador(tipoVariable.trim());
                } else {
                    duplicadaVariable = true;
                }
                while (pila.peek() == 304) {
                    pila.pop();
                }
                break;
            case 305:
                if (!sql.comprobarVariableDuplicada(nombreVariable.trim(), ambitoActual + "")) {
                    query = "INSERT INTO tablasimbolos (id,tipo,clase,ambito,tarr,dimArr,noPar,tParr) VALUES ('" + nombreVariable.trim() + "', '" + tipoVariable.trim() + "', 'var','" + ambitoActual + "','-','-','0','-');";
                    sql.ejecutarQuery(query);
                    contador.get(ambitoActual).aumentarContador(tipoVariable.trim());
                    if (arrayVariable) {
                        String dimArr = "";
                        for (int i = 0; i < valoresTipoArr.size(); i++) {
                            dimArr += valoresTipoArr.get(i);
                            if ((i + 1) != valoresTipoArr.size()) {
                                dimArr += ",";
                            }
                        }
                        query = "UPDATE tablasimbolos SET tarr='" + valoresTipoArr.size() + "' WHERE id='" + nombreVariable + "' and ambito='" + ambitoActual + "';";
                        sql.ejecutarQuery(query);
                        query = "UPDATE tablasimbolos SET dimArr='" + dimArr + "' WHERE id='" + nombreVariable + "' and ambito='" + ambitoActual + "';";
                        sql.ejecutarQuery(query);
                    }
                } else {
                    duplicadaVariable = true;
                }
                while (pila.peek() == 305) {
                    pila.pop();
                }
                break;
            case 306:
                if (!sql.comprobarVariableDuplicada(nombreVariable.trim(), ambitoActual + "")) {
                    contadorRegitro = 0;
                    nombreUltimoRegistro = nombreVariable;
                    query = "INSERT INTO tablasimbolos (id,tipo,clase,ambito,tarr,dimArr,noPar,tParr) VALUES ('" + nombreVariable.trim() + "', '-', 'reg','" + ambitoActual + "', '-', '-', '0', '1');";
                    sql.ejecutarQuery(query);
                    padreHijoAmbito.add(ambitoActual + 1);
                    contador.get(ambitoActual).aumentarContador("REG");
                } else {
                    duplicadaVariable = true;
                }
                while (pila.peek() == 306) {
                    pila.pop();
                }
                break;
            case 307:
                if (!sql.comprobarVariableDuplicada(nombreVariable.trim(), ambitoActual + "")) {
                    if (tipoVariable.equals("REG")) {
                        query = "INSERT INTO tablasimbolos (id,tipo,clase,ambito,tarr,dimArr,noPar,tParr) VALUES ('" + nombreVariable.trim() + "', 'dato', '" + tipoVariable + "','" + ambitoActual + "', '-', '-', '" + (contadorRegitro + 1) + "', 'datos');";
                    } else {
                        query = "INSERT INTO tablasimbolos (id,tipo,clase,ambito,tarr,dimArr,noPar,tParr) VALUES ('" + nombreVariable.trim() + "', '" + tipoVariable + "', 'item','" + ambitoActual + "', '-', '-', '" + (contadorRegitro + 1) + "', 'datos');";
                    }
                    contadorRegitro++;
                    contador.get(ambitoActual).aumentarContador(tipoVariable.trim());
                    sql.ejecutarQuery(query);
                    if (arrayVariable) {
                        String dimArr = "";
                        for (int i = 0; i < valoresTipoArr.size(); i++) {
                            dimArr += valoresTipoArr.get(i);
                            if ((i + 1) != valoresTipoArr.size()) {
                                dimArr += ",";
                            }
                        }
                        query = "UPDATE tablasimbolos SET tarr='" + valoresTipoArr.size() + "' WHERE id='" + nombreVariable + "' and ambito='" + ambitoActual + "';";
                        sql.ejecutarQuery(query);
                        query = "UPDATE tablasimbolos SET dimArr='" + dimArr + "' WHERE id='" + nombreVariable + "' and ambito='" + ambitoActual + "';";
                        sql.ejecutarQuery(query);
                        arrayVariable = false;
                        valoresTipoArr = new ArrayList<>();
                    }
                } else {
                    duplicadaVariable = true;
                }
                while (pila.peek() == 307) {
                    pila.pop();
                }
                break;
            case 308:
                query = "UPDATE tablasimbolos SET noPar='" + contadorRegitro + "' WHERE id='" + nombreUltimoRegistro + "';";
                sql.ejecutarQuery(query);
                while (pila.peek() == 308) {
                    pila.pop();
                }
                break;
            case 309:
                while (pila.peek() == 309) {
                    pila.pop();
                }
                valoresTipoArr.add(oper.obtenerPrimero().getLexema());
                arrayVariable = true;
                break;
            case 310:
                if (!sql.comprobarVariableDuplicada(nombreVariable.trim(), 0 + "") || sql.comprobarVariableDuplicada(nombreVariable.trim(), ambitoActual - 1 + "")) {
                    regNoDeclarado = true;
                }
                while (pila.peek() == 310) {
                    pila.pop();
                }
                break;
            case 311:
                if (!sql.comprobarVariableDuplicada(nombreVariable.trim(), ambitoActual + "")) {
                    contadorFuncion = 0;
                    bandFunSen2.add(true);
                    nombreUltimoRegistro = nombreVariable;
                    query = "INSERT INTO tablasimbolos (id,tipo,clase,ambito,tarr,dimArr,noPar,tParr) VALUES ('" + nombreVariable.trim() + "','" + tipoVariable + "', 'fun','" + ambitoActual + "', '-', '-', '0', '1');";
                    if (tipoVariable.equals("VOID")) {
                        semantica2Contadores.add(new Contador2(1110));
                        tipoVariableFunSem2.add("VOID");
                        lexemaVariableFunSem2.add(nombreVariable);
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("VOID");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(nombreVariable.trim());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(oper.obtenerPrimero().getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambitoActual);
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                    } else {
                        semantica2Contadores.add(new Contador2(1120));
                        tipoVariableFunSem2.add(tipoVariable);
                        lexemaVariableFunSem2.add(nombreVariable);
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tipoVariable);
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(nombreVariable.trim());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(oper.obtenerPrimero().getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambitoActual);
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                    }
                    sql.ejecutarQuery(query);
                    if (arrayVariable) {
                        String dimArr = "";
                        for (int i = 0; i < valoresTipoArr.size(); i++) {
                            dimArr += valoresTipoArr.get(i);
                            if ((i + 1) != valoresTipoArr.size()) {
                                dimArr += ",";
                            }
                        }
                        query = "UPDATE tablasimbolos SET tarr='" + valoresTipoArr.size() + "' WHERE id='BINARY" + nombreVariable + "' and ambito='" + ambitoActual + "';";
                        sql.ejecutarQuery(query);
                        query = "UPDATE tablasimbolos SET dimArr='" + dimArr + "' WHERE id='BINARY" + nombreVariable + "' and ambito='" + ambitoActual + "';";
                        sql.ejecutarQuery(query);
                        arrayVariable = false;
                        valoresTipoArr = new ArrayList<>();
                    }
                } else {
                    duplicadaVariable = true;
                }
                arrayVariable = false;
                valoresTipoArr = new ArrayList<>();
                while (pila.peek() == 311) {
                    pila.pop();
                }
                break;
            case 312:
                if (!sql.comprobarVariableDuplicada(nombreVariable.trim(), ambitoActual + "")) {
                    query = "INSERT INTO tablasimbolos (id,tipo,clase,ambito,tarr,dimArr,noPar,tParr) VALUES ('" + nombreVariable.trim() + "', '" + tipoVariable + "', 'par','" + aumentarAmbitoFAKE() + "', '-', '-', '" + (1 + contadorFuncion++) + "', 'f');";
                    sql.ejecutarQuery(query);
                    contador.get(ambitoActual).aumentarContador(tipoVariable.trim());
                    if (arrayVariable) {
                        String dimArr = "";
                        for (int i = 0; i < valoresTipoArr.size(); i++) {
                            dimArr += valoresTipoArr.get(i);
                            if ((i + 1) != valoresTipoArr.size()) {
                                dimArr += ",";
                            }
                        }
                        query = "UPDATE tablasimbolos SET tarr='" + valoresTipoArr.size() + "' WHERE id='" + nombreVariable + "' and ambito='" + ambitoActual + "';";
                        sql.ejecutarQuery(query);
                        query = "UPDATE tablasimbolos SET dimArr='" + dimArr + "' WHERE id='" + nombreVariable + "' and ambito='" + ambitoActual + "';";
                        sql.ejecutarQuery(query);
                    }
                } else {
                    duplicadaVariable = true;
                }
                while (pila.peek() == 312) {
                    pila.pop();
                }
                break;
            case 313:
                while (pila.peek() == 313) {
                    pila.pop();
                }
                arrayVariable = false;
                valoresTipoArr = new ArrayList<>();
                break;
            case 314:
                while (pila.peek() == 314) {
                    pila.pop();
                }
                aumentarAmbito();
                padreHijoAmbito.add(ambitoActual);
                arrayVariable = false;
                valoresTipoArr = new ArrayList<>();
                contador.add(new nodoContadores());
                query = "UPDATE tablasimbolos SET noPar='" + contadorFuncion + "' WHERE id='" + nombreUltimoRegistro + "';";
                sql.ejecutarQuery(query);
                break;
            case 315:
                for (int i = padreHijoAmbito.size() - 1; i >= 0; i--) {
                    if (!sql.comprobarVariableDuplicada(nombreVariable.trim(), padreHijoAmbito.get(i) + "")) {
                        varNoDeclarado = true;
                    } else {
                        varNoDeclarado = false;
                        break;
                    }
                }
                while (pila.peek() == 315) {
                    pila.pop();
                }
                break;
            case -227:
                if (!bandFunSen2.isEmpty()) {
                    bandFunSen22.add(true);
                }
                break;
        }
        return pila;
    }

    private void tipoVariable(int peek) {
        switch (peek) {
            case -105:
                tipoVariable = "int";
                break;
            case -106:
                tipoVariable = "real";
                break;
            case -107:
                tipoVariable = "exp";
                break;
            case -108:
                tipoVariable = "char";
                break;
            case -109:
                tipoVariable = "char[]";
                break;
            case -213:
                tipoVariable = "bool";
                break;
            case -214:
                tipoVariable = "bool";
                break;
            case -217:
                tipoVariable = "CHAR";
                break;
            case -208:
                tipoVariable = "INT";
                break;
            case -211:
                tipoVariable = "REAL";
                break;
            case -212:
                tipoVariable = "BOOL";
                break;
            case -218:
                tipoVariable = "EXP";
                break;
            case -243:
                tipoVariable = "REG";
                break;
            case -219:
                tipoVariable = "VOID";
                break;
            case -220:
                tipoVariable = "FILE";
                break;
        }
    }

    private void aumentarAmbito() {
        pilaAmbito.push(ambitoDisponible++);
        ambitoActual = pilaAmbito.peek();
    }

    private int aumentarAmbitoFAKE() {
        int x = ambitoDisponible;
        return x;
    }

    private void reducirAmbito() {
        pilaAmbito.pop();
        ambitoActual = pilaAmbito.peek();
    }

    public boolean comprobarAmbitobase() {
        return ambitoActual == 0;
    }

    public boolean comprobarVariableDuplicada() {
        return duplicadaVariable;
    }

    public int getAmbitoActual() {
        return ambitoActual;
    }

    public void setDuplicadaVariable(boolean duplicadaVariable) {
        this.duplicadaVariable = duplicadaVariable;
    }

    public String getNombreVariable() {
        return nombreVariable;
    }

    public String getTipoVariable() {
        return tipoVariable;
    }

    public int getVaribleLinea() {
        return varibleLinea;
    }

    public ArrayList<nodoContadores> getContador() {
        return contador;
    }

    public boolean comprobarRegNoDeclarado() {
        return regNoDeclarado;
    }

    public void setRegNoDeclarado(boolean regNoDeclarado) {
        this.regNoDeclarado = regNoDeclarado;
    }

    public boolean isVarNoDeclarado() {
        return varNoDeclarado;
    }

    public void setVarNoDeclarado(boolean varNoDeclarado) {
        this.varNoDeclarado = varNoDeclarado;
    }

    public ArrayList<Integer> getPadreHijoAmbito() {
        return padreHijoAmbito;
    }
}
