/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantica3;

import Errores.ListaError;
import Externo.MySql;
import Semantica2.Contador2;
import Sintaxis.NodoToken;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Semantica3 {

    public void clean(ArrayList<Contador2> semantica2Contadores, int lastLinea, ArrayList<Integer> ambito, ArrayList<Contador3> semantica3Contadores) {
        Tabla(semantica3Contadores, "Clean()", "", "A");
        semantica2Contadores.add(new Contador2(2000));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("Clean()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("Clean()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(lastLinea);
        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
    }

    public void sqrt(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2010));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("EXP");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                Tabla(semantica3Contadores, "Sqrt()", "S", "A");
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "A");
                                break;
                            case -106:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqrt()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("REAL");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "A");
                                break;
                            case -107:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqrt()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "A");
                                break;
                            case -108:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqrt()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqrt()", "S", "E");
                                cte.agregarError(650, "Meotdo sqrt()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                cte.agregarError(650, "Meotdo sqrt_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "E");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        semantica2Contadores.add(new Contador2(2001));
                        Tabla(semantica3Contadores, "Sqrt()", "S", "E");
                        cte.agregarError(650, "Meotdo sqrt()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqrt_p1()", "E", "E");
                        cte.agregarError(650, "Meotdo sqrt_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2001));
                        Tabla(semantica3Contadores, "Sqrt()", "S", "E");
                        cte.agregarError(650, "Meotdo sqrt()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        cte.agregarError(650, "Meotdo sqrt_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        Tabla(semantica3Contadores, "Sqrt_p1()", "E", "E");
                    }
                }
                break;
            case -105:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqrt()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "A");
                break;
            case -106:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqrt()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("REAL");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "A");
                break;
            case -107:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqrt()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "A");
                break;
            case -108:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqrt()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqrt()", "S", "E");
                cte.agregarError(650, "Meotdo sqrt()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Sqrt_p1()", "E", "E");
                cte.agregarError(650, "Meotdo sqrt_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void sqr(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2010));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("EXP");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqr()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqr_p1()", "E", "A");
                                break;
                            case -106:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqr()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrt_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("REAL");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqr_p1()", "E", "A");
                                break;
                            case -107:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqr()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqr_p1()", "E", "A");
                                break;
                            case -108:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqr()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqr_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2001));
                                Tabla(semantica3Contadores, "Sqr()", "S", "E");
                                cte.agregarError(651, "Metodo sqr()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Sqr_p1()", "E", "E");
                                cte.agregarError(651, "Metodo sqr_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        semantica2Contadores.add(new Contador2(2001));
                        Tabla(semantica3Contadores, "Sqr()", "S", "E");
                        cte.agregarError(651, "Metodo sqr()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqr_p1()", "E", "E");
                        cte.agregarError(651, "Metodo sqr_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2001));
                        Tabla(semantica3Contadores, "Sqr()", "S", "E");
                        cte.agregarError(651, "Metodo sqr()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqr_p1()", "E", "E");
                        cte.agregarError(651, "Metodo sqr_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -105:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqr()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqr_p1()", "E", "A");
                break;
            case -106:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqr()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("REAL");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqr_p1()", "E", "A");
                break;
            case -107:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqr()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqr_p1()", "E", "A");
                break;
            case -108:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -107, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqr()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqr_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2001));
                Tabla(semantica3Contadores, "Sqr()", "S", "E");
                cte.agregarError(651, "Metodo sqr()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqr_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Sqr_p1()", "E", "E");
                cte.agregarError(651, "Metodo sqr_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void pow(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2010));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow()");
        int numPila = semantica2Contadores.size() - 1;
        boolean bandP1 = true;
        semantica2Contadores.get(numPila).setTopeLinea("EXP");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Pow_p1()", "E", "A");
                                break;
                            case -106:
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("REAL");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Pow_p1()", "E", "A");
                                break;
                            case -107:
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Pow_p1()", "E", "A");
                                break;
                            case -108:
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Pow_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                Tabla(semantica3Contadores, "Pow()", "S", "E");
                                bandP1 = false;
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Pow_p1()", "E", "E");
                                cte.agregarError(652, "Metodo pow_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Pow()", "S", "E");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2001));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Pow_p1()", "E", "E");
                        cte.agregarError(652, "Metodo pow_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Pow()", "S", "E");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2001));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Pow_p1()", "E", "E");
                        cte.agregarError(652, "Metodo pow_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -105:
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Pow_p1()", "E", "A");
                break;
            case -106:
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("REAL");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Pow_p1()", "E", "A");
                break;
            case -107:
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Pow_p1()", "E", "A");
                break;
            case -108:
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Pow_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                Tabla(semantica3Contadores, "Pow()", "S", "E");
                bandP1 = false;
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Pow_p1()", "E", "E");
                cte.agregarError(652, "Metodo pow_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(1).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                if (!bandP1) {
                                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Error");
                                    Tabla(semantica3Contadores, "Pow()", "S", "E");
                                    cte.agregarError(652, "Metodo pow()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2002));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p2");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    Tabla(semantica3Contadores, "Pow_p2()", "E", "E");
                                    cte.agregarError(652, "Metodo pow_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                } else {
                                    semantica2Contadores.get(numPila).setValorReal("EXP");
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Acepta");
                                    Tabla(semantica3Contadores, "Pow()", "S", "A");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -107, pilaMetodo.get(1).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2002));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p2");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                    Tabla(semantica3Contadores, "Pow_p2()", "E", "A");
                                    break;
                                }
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                Tabla(semantica3Contadores, "Pow()", "S", "E");
                                ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2002));
                                cte.agregarError(652, "Metodo pow()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Pow_p2()", "E", "E");
                                cte.agregarError(652, "Metodo pow_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Pow()", "S", "E");
                        semantica2Contadores.add(new Contador2(2002));
                        cte.agregarError(652, "Metodo pow()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Pow_p2()", "E", "E");
                        cte.agregarError(652, "Metodo pow_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2002));
                        Tabla(semantica3Contadores, "Pow", "S", "E");
                        cte.agregarError(652, "Metodo pow()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Pow_p2()", "E", "E");
                        cte.agregarError(652, "Metodo pow_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -105:
                if (!bandP1) {
                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Error");
                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2002));
                    Tabla(semantica3Contadores, "Pow()", "S", "E");
                    cte.agregarError(652, "Metodo pow()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p2");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                    Tabla(semantica3Contadores, "Pow_p2()", "E", "E");
                    cte.agregarError(652, "Metodo pow_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                } else {
                    semantica2Contadores.get(numPila).setValorReal("EXP");
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Acepta");
                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -107, pilaMetodo.get(1).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2002));
                    Tabla(semantica3Contadores, "Pow()", "S", "A");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p2");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                    Tabla(semantica3Contadores, "Pow_p2()", "E", "A");
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                Tabla(semantica3Contadores, "Pow()", "S", "E");
                ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2002));
                cte.agregarError(652, "Metodo pow()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("pow_p2");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Pow_p2()", "E", "E");
                cte.agregarError(652, "Metodo pow_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void sqrtv(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2010));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv()");
        int numPila = semantica2Contadores.size() - 1;
        boolean bandP1 = true;
        semantica2Contadores.get(numPila).setTopeLinea("EXP");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "A");
                                break;
                            case -106:
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("REAL");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "A");
                                break;
                            case -107:
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "A");
                                break;
                            case -108:
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                                bandP1 = false;
                                semantica2Contadores.add(new Contador2(2001));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "E");
                                cte.agregarError(653, "Metodo sqrtv_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2001));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "E");
                        cte.agregarError(653, "Metodo sqrtv_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2001));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "E");
                        cte.agregarError(653, "Metodo sqrtv_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -105:
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "A");
                break;
            case -106:
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("REAL");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "A");
                break;
            case -107:
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("EXP");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "A");
                break;
            case -108:
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                bandP1 = false;
                semantica2Contadores.add(new Contador2(2001));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("numerico");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Sqrtv_p1()", "E", "E");
                cte.agregarError(653, "Metodo sqrtv_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(1).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                if (!bandP1) {
                                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Error");
                                    Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2002));
                                    cte.agregarError(653, "Metodo sqrtv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p2");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    Tabla(semantica3Contadores, "Sqrtv_p2()", "E", "E");
                                    cte.agregarError(653, "Metodo sqrtv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                } else {
                                    semantica2Contadores.get(numPila).setValorReal("EXP");
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Acepta");
                                    Tabla(semantica3Contadores, "Sqrtv()", "S", "A");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -107, pilaMetodo.get(1).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2002));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p2");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                    Tabla(semantica3Contadores, "Sqrtv_p2()", "E", "A");
                                    break;
                                }
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2002));
                                Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                                cte.agregarError(653, "Metodo sqrtv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                cte.agregarError(653, "Metodo sqrtv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                Tabla(semantica3Contadores, "Sqrtv_p2()", "E", "E");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        semantica2Contadores.add(new Contador2(2002));
                        cte.agregarError(653, "Metodo sqrtv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqrtv_p2()", "E", "E");
                        cte.agregarError(653, "Metodo sqrtv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2002));
                        cte.agregarError(653, "Metodo sqrtv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Sqrtv_p2()", "E", "E");
                        cte.agregarError(653, "Metodo sqrtv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -105:
                if (!bandP1) {
                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Error");
                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2002));
                    cte.agregarError(653, "Metodo sqrtv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p2");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                    Tabla(semantica3Contadores, "Sqrtv_p2()", "E", "E");
                    cte.agregarError(653, "Metodo sqrtv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                } else {
                    semantica2Contadores.get(numPila).setValorReal("EXP");
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Acepta");
                    Tabla(semantica3Contadores, "Sqrtv()", "S", "A");
                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -107, pilaMetodo.get(1).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2002));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p2");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                    Tabla(semantica3Contadores, "Sqrtv_p2()", "E", "A");
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2002));
                Tabla(semantica3Contadores, "Sqrtv()", "S", "E");
                cte.agregarError(653, "Metodo sqrtv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("sqrtv_p2");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("int");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Sqrtv_p2()", "E", "E");
                cte.agregarError(653, "Metodo sqrtv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void ins(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2011));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins()");
        int numPila = semantica2Contadores.size() - 1;
        boolean bandP1 = true;
        boolean bandP2 = true;
        semantica2Contadores.get(numPila).setTopeLinea("CHAR[]");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)))) {
                            case -109:
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Ins_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                Tabla(semantica3Contadores, "Ins()", "S", "E");
                                bandP1 = false;
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Ins_p1()", "E", "E");
                                cte.agregarError(654, "Metodo ins_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins()", "S", "E");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins_p1()", "E", "E");
                        cte.agregarError(654, "Metodo ins_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins()", "S", "E");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins_p1()", "E", "E");
                        cte.agregarError(654, "Metodo ins_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -109:
                semantica2Contadores.add(new Contador2(2003));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Ins_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                Tabla(semantica3Contadores, "Ins", "S", "E");
                bandP1 = false;
                semantica2Contadores.add(new Contador2(2003));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Ins_p1()", "E", "E");
                cte.agregarError(654, "Metodo ins_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(1).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)))) {
                            case -109:
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Ins_p2()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                Tabla(semantica3Contadores, "Ins()", "S", "E");
                                bandP2 = false;
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Ins_p2()", "E", "E");
                                cte.agregarError(654, "Metodo ins_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins()", "S", "E");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins_p2()", "E", "E");
                        cte.agregarError(654, "Metodo ins_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins()", "S", "E");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins_p2()", "E", "E");
                        cte.agregarError(654, "Metodo ins_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -109:
                semantica2Contadores.add(new Contador2(2003));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p2");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Ins_p2()", "E", "A");
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                Tabla(semantica3Contadores, "Ins()", "S", "E");
                bandP2 = false;
                semantica2Contadores.add(new Contador2(2003));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p2");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Ins_p2()", "E", "E");
                cte.agregarError(654, "Metodo ins_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(2).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                if (!bandP1 || !bandP2) {
                                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Error");
                                    Tabla(semantica3Contadores, "Ins()", "S", "E");
                                    cte.agregarError(654, "Metodo ins()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -777, pilaMetodo.get(2).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2002));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p3");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    Tabla(semantica3Contadores, "Ins_p3()", "E", "E");
                                    cte.agregarError(654, "Metodo ins_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                    break;
                                } else {
                                    semantica2Contadores.get(numPila).setValorReal("CHAR[]");
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Acepta");
                                    Tabla(semantica3Contadores, "Ins()", "S", "A");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -109, pilaMetodo.get(2).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2002));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p3");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                    Tabla(semantica3Contadores, "Ins_p3()", "E", "A");
                                    break;
                                }
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                Tabla(semantica3Contadores, "Ins()", "S", "E");
                                semantica2Contadores.add(new Contador2(2002));
                                cte.agregarError(654, "Metodo ins()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Ins_p3()", "E", "E");
                                cte.agregarError(654, "Metodo ins_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(j)).equals("")) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins()", "S", "E");
                        semantica2Contadores.add(new Contador2(2003));
                        cte.agregarError(654, "Metodo ins()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins_p3()", "E", "E");
                        cte.agregarError(654, "Metodo ins_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins()", "S", "E");
                        cte.agregarError(654, "Metodo ins()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Ins_p3()", "E", "E");
                        cte.agregarError(654, "Metodo ins_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -105:
                if (!bandP1 || !bandP2) {
                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Error");
                    Tabla(semantica3Contadores, "Ins()", "E", "E");
                    ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -777, pilaMetodo.get(2).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2002));
                    cte.agregarError(654, "Metodo ins()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                    cte.agregarError(654, "Metodo ins_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    Tabla(semantica3Contadores, "Ins_p3()", "E", "E");
                } else {
                    semantica2Contadores.get(numPila).setValorReal("CHAR[]");
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Acepta");
                    Tabla(semantica3Contadores, "Ins()", "S", "A");
                    ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -109, pilaMetodo.get(2).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2002));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                    Tabla(semantica3Contadores, "Ins_p3()", "E", "A");
                    break;
                }
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                Tabla(semantica3Contadores, "Ins()", "S", "E");
                semantica2Contadores.add(new Contador2(2003));
                cte.agregarError(654, "Metodo ins()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("ins_p3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Ins_p3()", "E", "E");
                cte.agregarError(654, "Metodo ins_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    private void Tabla(ArrayList<Contador3> semantica3Contadores, String Metodo, String EoS, String AoE) {
        for (int i = 0; i < semantica3Contadores.size(); i++) {
            if (semantica3Contadores.get(i).getFuncion().equals(Metodo)) {
                switch (EoS) {
                    case "E":
                        semantica3Contadores.get(i).setEntrada();
                        break;
                    case "S":
                        semantica3Contadores.get(i).setSalida();
                        break;
                }
                switch (AoE) {
                    case "A":
                        semantica3Contadores.get(i).setAceptados();
                        break;
                    case "E":
                        semantica3Contadores.get(i).setErrores();
                        break;
                }
                break;
            }
        }
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
}
