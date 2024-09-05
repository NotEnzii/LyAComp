/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantica1;

import Errores.ListaError;
import Externo.MySql;
import Semantica2.Contador2;
import Semantica3.Contador3;
import Semantica3.Semantica3;
import Semantica3.Semantica3b;
import Semantica3.Semantica3c;
import Sintaxis.ListaToken;
import Sintaxis.NodoToken;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Semantica1 {

    private NodoToken id;
    private NodoToken idS2;
    private int lastToken;
    private int lastLinea;
    private int lastAmbito;
    private String lastLexema;
    private ArrayList<NodoToken> ecuacion;
    private boolean agregarEcuacion;
    private boolean agregarEcuacionMetodo;
    private final ArregloTablas tablas;
    private Stack<NodoToken> pilaVariables;
    private Stack<NodoToken> pilaOperadores;
    private Stack<NodoToken> pilaMetodo;
    private Semantica3 semantica3;
    private Semantica3b semantica3b;
    private Semantica3c semantica3c;
    private final MySql sql;

    public Semantica1(MySql sql, ArregloTablas tablas) {
        this.sql = sql;
        ecuacion = new ArrayList<>();
        agregarEcuacion = false;
        agregarEcuacionMetodo = false;
        this.lastToken = 0;
        this.tablas = tablas;
        semantica3 = new Semantica3();
        semantica3b = new Semantica3b();
        semantica3c = new Semantica3c();
    }

    public Stack<Integer> pila(Stack<Integer> pila, ListaToken oper, ArrayList<Integer> ambito, ArrayList<Contador2> semantica2Contadores, ListaError cte, ArrayList<Contador3> semantica3Contadores) {
        switch (pila.peek()) {
            case -100:
                if (!agregarEcuacion && !agregarEcuacionMetodo) {
                    ecuacion = new ArrayList<>();
                    id = oper.obtenerPrimero();
                }
                break;
            case 315:
                if (!agregarEcuacion && !agregarEcuacionMetodo) {
                    ecuacion.add(id);
                }
                break;
            case 320:
                while (pila.peek() == 320) {
                    pila.pop();
                }
                agregarEcuacion = true;
                break;
            case 321:
                while (pila.peek() == 321) {
                    pila.pop();
                }
                if (ecuacion.size() > 0) {
                    pilaVariables = new Stack<>();
                    pilaOperadores = new Stack<>();
//                    System.out.print("Semantica 1: Ecuacion: ");
//                    for (int i = 0; i < ecuacion.size(); i++) {
//                        System.out.print(ecuacion.get(i).getLexema().trim());
//                    }
//                    System.out.println("");
                    for (int i = 0; i < ecuacion.size(); i++) {
                        incertarPilas(i, ambito, semantica2Contadores, cte);
                    }
                    while (!pilaOperadores.isEmpty()) {
                        NodoToken auxV1, auxV2, auxO;
                        auxV1 = pilaVariables.peek();
                        pilaVariables.pop();
                        auxV2 = pilaVariables.peek();
                        lastLexema = auxV2.getLexema();
                        pilaVariables.pop();
                        auxO = pilaOperadores.peek();
                        pilaOperadores.pop();
                        switch (auxO.getToken() + "") {
                            case "-101":
                                pilaVariables.add(tablas.division(auxV1, auxV2));
                                break;
                            case "-110":
                                pilaVariables.add(tablas.suma(auxV1, auxV2));
                                break;
                            case "-113":
                                pilaVariables.add(tablas.mulplicacion(auxV1, auxV2));
                                break;
                            case "-116":
                                pilaVariables.add(tablas.resta(auxV1, auxV2));
                                break;
                            case "-136":
                                for (int j = ambito.size() - 1; j >= 0; j--) {
//                                    System.out.println(sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)));
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1020, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-137":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-112":
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1021, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-118":
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-103":
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-115":
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-128":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-134":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-139":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-130":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-138":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-122":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-132":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-119":
                                pilaVariables.add(tablas.residuo(auxV1, auxV2));
                                break;
                            case "-123":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-124":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-125":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-126":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-127":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                        }
                    }
                    agregarEcuacion = false;
                    lastToken = pilaVariables.peek().getToken();
                    lastLinea = pilaVariables.peek().getLinea();
                    lastAmbito = ambito.get(ambito.size() - 1);
//                    System.out.println("Semantica 1: Resultado: " + pilaVariables.peek().getToken());
                    ecuacion = new ArrayList<>();
                }
                break;
            case 333:
                while (pila.peek() == 333) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 334:
                while (pila.peek() == 334) {
                    pila.pop();
                }
                agregarEcuacion = true;
                break;
            case -140:
            case -148:
                agregarEcuacion = false;
                if (ecuacion.size() > 0) {
                    pilaVariables = new Stack<>();
                    pilaOperadores = new Stack<>();
//                    System.out.print("Semantica 1: Ecuacion: ");
                    for (int i = 0; i < ecuacion.size(); i++) {
//                        System.out.print(ecuacion.get(i).getLexema().trim());
                    }
//                    System.out.println("");
                    for (int i = 0; i < ecuacion.size(); i++) {
                        incertarPilas(i, ambito, semantica2Contadores, cte);
                    }
                    while (!pilaOperadores.isEmpty()) {
                        NodoToken auxV1, auxV2, auxO;
                        auxV1 = pilaVariables.peek();
                        pilaVariables.pop();
                        auxV2 = pilaVariables.peek();
                        lastLexema = auxV2.getLexema();
                        pilaVariables.pop();
                        auxO = pilaOperadores.peek();
                        pilaOperadores.pop();
//                        System.out.println("-----------" + pilaOperadores.size());
                        switch (auxO.getToken() + "") {
                            case "-101":
                                pilaVariables.add(tablas.division(auxV1, auxV2));
                                break;
                            case "-110":
                                pilaVariables.add(tablas.suma(auxV1, auxV2));
                                break;
                            case "-113":
                                pilaVariables.add(tablas.mulplicacion(auxV1, auxV2));
                                break;
                            case "-116":
                                pilaVariables.add(tablas.resta(auxV1, auxV2));
                                break;
                            case "-136":
                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1020, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                break;
                            case "-137":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-112":
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1021, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                break;
                            case "-118":
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                break;
                            case "-103":
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                break;
                            case "-115":
                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-128":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-134":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-139":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-130":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-138":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-122":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-132":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-119":
                                pilaVariables.add(tablas.residuo(auxV1, auxV2));
                                break;
                            case "-123":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-124":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-125":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-126":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-127":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                        }
                    }
                    agregarEcuacion = false;
                    lastToken = pilaVariables.peek().getToken();
                    lastLinea = pilaVariables.peek().getLinea();
                    lastAmbito = ambito.get(ambito.size() - 1);
//                    System.out.println("Semantica 1: Resultado: " + pilaVariables.peek().getToken());
                    ecuacion = new ArrayList<>();
                }
                break;
            case 338:
                while (pila.peek() == 338) {
                    pila.pop();
                }
                agregarEcuacion = false;
                if (ecuacion.size() > 0) {
                    pilaVariables = new Stack<>();
                    pilaOperadores = new Stack<>();
//                    System.out.print("Semantica 1: Ecuacion: ");
                    for (int i = 0; i < ecuacion.size(); i++) {
//                        System.out.print(ecuacion.get(i).getLexema().trim());
                    }
//                    System.out.println("");
                    for (int i = 0; i < ecuacion.size(); i++) {
                        incertarPilas(i, ambito, semantica2Contadores, cte);
                    }
                    while (!pilaOperadores.isEmpty()) {
                        NodoToken auxV1, auxV2, auxO;
                        auxV1 = pilaVariables.peek();
                        pilaVariables.pop();
                        auxV2 = pilaVariables.peek();
                        lastLexema = auxV2.getLexema();
                        pilaVariables.pop();
                        auxO = pilaOperadores.peek();
                        pilaOperadores.pop();
//                        System.out.println("-----------" + pilaOperadores.size());
                        switch (auxO.getToken() + "") {
                            case "-101":
                                pilaVariables.add(tablas.division(auxV1, auxV2));
                                break;
                            case "-110":
                                pilaVariables.add(tablas.suma(auxV1, auxV2));
                                break;
                            case "-113":
                                pilaVariables.add(tablas.mulplicacion(auxV1, auxV2));
                                break;
                            case "-116":
                                pilaVariables.add(tablas.resta(auxV1, auxV2));
                                break;
                            case "-136":
                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1020, semantica2Contadores, ambito.get(ambito.size() - 1)));

                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                break;
                            case "-137":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-112":

                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1021, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-118":

                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-103":

                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-115":

                                for (int j = ambito.size() - 1; j >= 0; j--) {
                                    if (sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par")) {
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        break;
                                    }
                                    if (!sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("var")
                                            && !sql.obtenerClaseVariable(auxV2.getLexema().trim(), ambito.get(j)).equals("par") && j == 0) {
//                                        System.out.println("--------" + auxV2.getLexema().trim() + " - " + auxV2.getLinea());
                                        semantica2Contadores.add(new Contador2(1090));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(tablas.agregarAsignacion(auxV2));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(auxV2.getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    }
                                }
                                pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                                break;
                            case "-128":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-134":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-139":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-130":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-138":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-122":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-132":
                                pilaVariables.add(tablas.relacional(auxV1, auxV2));
                                break;
                            case "-119":
                                pilaVariables.add(tablas.residuo(auxV1, auxV2));
                                break;
                            case "-123":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-124":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-125":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-126":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                            case "-127":
                                pilaVariables.add(tablas.logico(auxV1, auxV2));
                                break;
                        }
                    }
                    agregarEcuacion = false;
                    lastToken = pilaVariables.peek().getToken();
                    lastLinea = pilaVariables.peek().getLinea();
                    lastAmbito = ambito.get(ambito.size() - 1);
//                    System.out.println("Semantica 1: Resultado: " + pilaVariables.peek().getToken());
                    ecuacion = new ArrayList<>();
                }
                break;
            case 350:
                while (pila.peek() == 350) {
                    pila.pop();
                }
                pilaMetodo = new Stack<>();
                agregarEcuacionMetodo = true;
                break;
            case 351:
                while (pila.peek() == 351) {
                    pila.pop();
                }
                agregarEcuacionMetodo = false;
                break;
            case 352:
                while (pila.peek() == 352) {
                    pila.pop();
                }
                semantica3.clean(semantica2Contadores, oper.obtenerPrimero().getLinea(), ambito, semantica3Contadores);
                agregarEcuacion = false;
                ecuacion.add(new NodoToken(lastLinea, -777, "clean()"));
                break;
            case 353:
                while (pila.peek() == 353) {
                    pila.pop();
                }
                agregarEcuacion = true;
                break;
            case 354:
                while (pila.peek() == 354) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 355:
                while (pila.peek() == 355) {
                    pila.pop();
                }
                semantica3.sqrt(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 356:
                while (pila.peek() == 356) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 357:
                while (pila.peek() == 357) {
                    pila.pop();
                }
                semantica3.sqr(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 358:
                while (pila.peek() == 358) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 359:
                while (pila.peek() == 359) {
                    pila.pop();
                }
                semantica3.pow(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 360:
                while (pila.peek() == 360) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 361:
                while (pila.peek() == 361) {
                    pila.pop();
                }
                semantica3.sqrtv(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 362:
                while (pila.peek() == 362) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 363:
                while (pila.peek() == 363) {
                    pila.pop();
                }
                semantica3.ins(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 364:
                while (pila.peek() == 364) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 365:
                while (pila.peek() == 365) {
                    pila.pop();
                }
                semantica3b.conv(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 366:
                while (pila.peek() == 366) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 367:
                while (pila.peek() == 367) {
                    pila.pop();
                }
                semantica3b.up(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 368:
                while (pila.peek() == 368) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 369:
                while (pila.peek() == 369) {
                    pila.pop();
                }
                semantica3b.low(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 370:
                while (pila.peek() == 370) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 371:
                while (pila.peek() == 371) {
                    pila.pop();
                }
                semantica3b.len(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
            case 372:
                while (pila.peek() == 372) {
                    pila.pop();
                }
                pilaMetodo = new Stack<>();
                agregarEcuacionMetodo = true;
                agregarEcuacion = false;
                break;
            case 373:
                agregarEcuacionMetodo = false;
                while (pila.peek() == 373) {
                    pila.pop();
                }
                semantica3b.val(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 374:
                while (pila.peek() == 374) {
                    pila.pop();
                }
                pilaMetodo = new Stack<>();
                agregarEcuacionMetodo = true;
                agregarEcuacion = false;
                break;
            case 375:
                agregarEcuacionMetodo = false;
                while (pila.peek() == 375) {
                    pila.pop();
                }
                semantica3b.asc(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 376:
                while (pila.peek() == 376) {
                    pila.pop();
                }
                pilaMetodo = new Stack<>();
                agregarEcuacionMetodo = true;
                agregarEcuacion = false;
                break;
            case 377:
                agregarEcuacionMetodo = false;
                while (pila.peek() == 377) {
                    pila.pop();
                }
                semantica3c.openFile(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 378:
                while (pila.peek() == 378) {
                    pila.pop();
                }
                pilaMetodo = new Stack<>();
                agregarEcuacionMetodo = true;
                agregarEcuacion = false;
                break;
            case 379:
                agregarEcuacionMetodo = false;
                while (pila.peek() == 379) {
                    pila.pop();
                }
                semantica3c.closeFile(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 380:
                while (pila.peek() == 380) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 381:
                while (pila.peek() == 381) {
                    pila.pop();
                }
                semantica3c.leerFile(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
            case 382:
                while (pila.peek() == 382) {
                    pila.pop();
                }
                agregarEcuacion = false;
                break;
            case 383:
                while (pila.peek() == 383) {
                    pila.pop();
                }
                semantica3c.escrbirFile(semantica2Contadores, ambito, pilaMetodo, ecuacion, sql, semantica3Contadores, cte);
                agregarEcuacion = true;
                break;
        }
        if (agregarEcuacion && pila.peek() < 0 && pila.peek() != -143 && pila.peek() != -144 && !agregarEcuacionMetodo) {
            if (oper.obtenerPrimero().getToken() == -100) {
                idS2 = oper.obtenerPrimero();
            }
            ecuacion.add(oper.obtenerPrimero());
        }
        if (agregarEcuacionMetodo && pila.peek() < 0 && pila.peek() != -141 && pila.peek() != -143 && pila.peek() != -144) {
            pilaMetodo.add(oper.obtenerPrimero());
        }
        return pila;
    }

    private void incertarPilas(int i, ArrayList<Integer> ambito, ArrayList<Contador2> semantica2Contadores, ListaError cte) {
        switch (ecuacion.get(i).getToken() + "") {
            case "-100":
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(ecuacion.get(i).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(ecuacion.get(i).getLexema().trim(), ambito.get(j)).equals("")) {
                        ecuacion.get(i).setToken(traducirToken(sql.obtenerTipoVariable(ecuacion.get(i).getLexema(), ambito.get(j))));
                        incertarPilas(i, ambito, semantica2Contadores, cte);
//                        System.out.println(sql.obtenerTipoVariable(ecuacion.get(i).getLexema(), ambito.get(j)) + "//---2");
                        break;
                    }
                    if (!sql.obtenerClaseVariable(ecuacion.get(i).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(ecuacion.get(i).getLexema().trim(), ambito.get(j)).equals("")) {
                        ecuacion.get(i).setToken(traducirToken(sql.obtenerClaseVariable(ecuacion.get(i).getLexema(), ambito.get(j))));
                        incertarPilas(i, ambito, semantica2Contadores, cte);
//                        System.out.println(sql.obtenerClaseVariable(ecuacion.get(i).getLexema(), ambito.get(j)) + "//---3");
                        break;
                    }
                    if (j == 0) {
                        ecuacion.get(i).setToken(-777);
//                        System.out.println("---------------4");
                        incertarPilas(i, ambito, semantica2Contadores, cte);
                    }
                }
                break;

            case "-101":
                if (pilaOperadores.isEmpty()) {
                    pilaOperadores.add(ecuacion.get(i));
                } else if (operandoPrioridad(ecuacion.get(i))) {
                    pilaOperadores.add(ecuacion.get(i));
                } else {
                    multipliacionOdivicion(ambito, semantica2Contadores);
                }
                break;
            case "-103":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-105":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-106":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-107":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-108":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-109":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-110":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-112":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-113":
                if (pilaOperadores.isEmpty()) {
                    pilaOperadores.add(ecuacion.get(i));
                } else if (operandoPrioridad(ecuacion.get(i))) {
                    pilaOperadores.add(ecuacion.get(i));
                } else {
                    multipliacionOdivicion(ambito, semantica2Contadores);
                }
                break;
            case "-115":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-116":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-118":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-119":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-128":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-134":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-139":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-130":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-138":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-122":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-132":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-136":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-137":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-212":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-213":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-214":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-216":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-219":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-220":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-243":
                pilaVariables.add(ecuacion.get(i));
                break;
            case "-123":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-124":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-125":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-126":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-127":
                pilaOperadores.add(ecuacion.get(i));
                break;
            case "-777":
                pilaVariables.add(ecuacion.get(i));
                break;
        }
    }

    private void multipliacionOdivicion(ArrayList<Integer> ambito, ArrayList<Contador2> semantica2Contadores) {
        while (pilaVariables.isEmpty() || operandoPrioridad(pilaOperadores.peek())) {
            NodoToken auxV1, auxV2, auxO;
            auxV1 = pilaVariables.peek();
            pilaVariables.pop();
            auxV2 = pilaVariables.peek();
            lastLexema = auxV2.getLexema();
            pilaVariables.pop();
            auxO = pilaOperadores.peek();
            pilaOperadores.pop();
            switch (auxO.getToken() + "") {
                case "-101":
                    pilaVariables.add(tablas.division(auxV1, auxV2));
                    break;
                case "-110":
                    pilaVariables.add(tablas.suma(auxV1, auxV2));
                    break;
                case "-113":
                    pilaVariables.add(tablas.mulplicacion(auxV1, auxV2));
                    break;
                case "-116":
                    pilaVariables.add(tablas.resta(auxV1, auxV2));
                    break;
                case "-136":
                    pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1020, semantica2Contadores, ambito.get(ambito.size() - 1)));
                    break;
                case "-137":
                    pilaVariables.add(tablas.relacional(auxV1, auxV2));
                    break;
                case "-112":
                    pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1021, semantica2Contadores, ambito.get(ambito.size() - 1)));
                    break;
                case "-118":
                    pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                    break;
                case "-103":
                    pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                    break;
                case "-115":
                    pilaVariables.add(tablas.asignacion(auxV1, auxV2, 1022, semantica2Contadores, ambito.get(ambito.size() - 1)));
                    break;
                case "-128":
                    pilaVariables.add(tablas.relacional(auxV1, auxV2));
                    break;
                case "-134":
                    pilaVariables.add(tablas.relacional(auxV1, auxV2));
                    break;
                case "-139":
                    pilaVariables.add(tablas.relacional(auxV1, auxV2));
                    break;
                case "-130":
                    pilaVariables.add(tablas.relacional(auxV1, auxV2));
                    break;
                case "-138":
                    pilaVariables.add(tablas.relacional(auxV1, auxV2));
                    break;
                case "-122":
                    pilaVariables.add(tablas.relacional(auxV1, auxV2));
                    break;
                case "-132":
                    pilaVariables.add(tablas.relacional(auxV1, auxV2));
                    break;
                case "-119":
                    pilaVariables.add(tablas.residuo(auxV1, auxV2));
                    break;
                case "-123":
                    pilaVariables.add(tablas.logico(auxV1, auxV2));
                    break;
                case "-124":
                    pilaVariables.add(tablas.logico(auxV1, auxV2));
                    break;
                case "-125":
                    pilaVariables.add(tablas.logico(auxV1, auxV2));
                    break;
                case "-126":
                    pilaVariables.add(tablas.logico(auxV1, auxV2));
                    break;
                case "-127":
                    pilaVariables.add(tablas.logico(auxV1, auxV2));
                    break;
            }
        }
    }

    private boolean operandoPrioridad(NodoToken x) {
        switch (x.getToken()) {
            case -136:
                return true;
            case -137:
                return true;
            case -113:
                return true;
            case -101:
                return true;
            case -112:
                return true;
            case -118:
                return true;
            case -103:
                return true;
            case -115:
                return true;
            case -128:
                return true;
            case -134:
                return true;
            case -139:
                return true;
            case -130:
                return true;
            case -138:
                return true;
            case -122:
                return true;
            case -132:
                return true;
            case -119:
                return true;
            case -123:
                return true;
            case -124:
                return true;
            case -125:
                return true;
            case -126:
                return true;
            case -127:
                return true;
        }
        return false;
    }

    private int traducirToken(String token) {
        switch (token) {
            case "int":
                return -105;
            case "INT":
                return -105;
            case "real":
                return -106;
            case "REAL":
                return -106;
            case "exp":
                return -107;
            case "EXP":
                return -107;
            case "char":
                return -108;
            case "CHAR":
                return -108;
            case "char[]":
                return -109;
            case "CHAR[]":
                return -109;
            case "bool":
                return -212;
            case "BOOL":
                return -212;
            case "reg":
                return -216;
            case "REG":
                return -243;
            case "VOID":
                return -219;
            case "FILE":
                return -220;
        }
        return -777;
    }

    public int getLastToken() {
        return lastToken;
    }

    public void setLastToken(int lastToken) {
        this.lastToken = lastToken;
    }

    public int getLastLinea() {
        return lastLinea;
    }

    public void setLastLinea(int lastLinea) {
        this.lastLinea = lastLinea;
    }

    public int getLastAmbito() {
        return lastAmbito;
    }

    public void setLastAmbito(int lastAmbito) {
        this.lastAmbito = lastAmbito;
    }

    public String getLastLexema() {
        return lastLexema;
    }

    public void setLastLexema(String lastLexema) {
        this.lastLexema = lastLexema;
    }

    public NodoToken getId() {
        return idS2;
    }

    public void setId(NodoToken id) {
        this.idS2 = id;
    }
}
