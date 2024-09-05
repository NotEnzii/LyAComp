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
public class Semantica3c {

    public void openFile(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2016));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$()");
        int numPila = semantica2Contadores.size() - 1;
        boolean bandP1 = true;
        boolean bandP2 = true;
        semantica2Contadores.get(numPila).setTopeLinea("FILE/CHAR[]/CHAR[]");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)))) {
                            case -220:
                                semantica2Contadores.add(new Contador2(2008));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "$_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP1 = false;
                                semantica2Contadores.add(new Contador2(2008));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "$_p1()", "E", "E");
                                cte.agregarError(661, "$_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2008));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "$_p1()", "E", "E");
                        cte.agregarError(661, "$_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2008));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "$_p1()", "E", "E");
                        cte.agregarError(661, "$_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                bandP1 = false;
                semantica2Contadores.add(new Contador2(2008));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "$_p1()", "E", "E");
                cte.agregarError(661, "$_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(2).getToken()) {
            case -109:
                switch (pilaMetodo.get(2).getLexema().trim()) {
                    case "\"w\"":
                    case "\"W\"":
                    case "\"r\"":
                    case "\"R\"":
                    case "\"w+\"":
                    case "\"W+\"":
                    case "\"r+\"":
                    case "\"R+\"":
                        semantica2Contadores.add(new Contador2(2009));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                        Tabla(semantica3Contadores, "$_p2()", "E", "A");
                        break;
                    default:
                        semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2009));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "$_p2()", "E", "E");
                        cte.agregarError(661, "$_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(ambito.size() - 1)));
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                bandP2 = false;
                semantica2Contadores.add(new Contador2(2009));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p2");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(2).getLexema().trim(), ambito.get(ambito.size() - 1)));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "$_p2()", "E", "E");
                cte.agregarError(661, "$_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(3).getToken()) {
            case -109:
                if (!bandP1 || !bandP2) {
                    semantica2Contadores.get(numPila).setValorReal("FILE");
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(3).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Error");
                    ecuacion.add(new NodoToken(pilaMetodo.get(3).getLinea(), -777, pilaMetodo.get(3).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2006));
                    Tabla(semantica3Contadores, "$()", "S", "E");
                    cte.agregarError(661, "$()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(3).getLexema().trim());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(3).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                    Tabla(semantica3Contadores, "$_p3()", "E", "E");
                    cte.agregarError(661, "$_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                } else {
                    semantica2Contadores.get(numPila).setValorReal("FILE");
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(3).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Acepta");
                    ecuacion.add(new NodoToken(pilaMetodo.get(3).getLinea(), -212, pilaMetodo.get(2).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2006));
                    Tabla(semantica3Contadores, "$()", "S", "A");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(3).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                    Tabla(semantica3Contadores, "$_p3()", "E", "A");
                    break;
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(3).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(3).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(3).getLinea(), -777, pilaMetodo.get(3).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2004));
                Tabla(semantica3Contadores, "$()", "S", "E");
                cte.agregarError(661, "$()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("$_p3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(3).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(3).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "$_p3()", "E", "E");
                cte.agregarError(661, "$_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void closeFile(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2016));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("~()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)))) {
                            case -220:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -212, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2008));
                                Tabla(semantica3Contadores, "~()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("~_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "~_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2008));
                                Tabla(semantica3Contadores, "~()", "S", "E");
                                cte.agregarError(662, "~()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("~_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "~_p1()", "E", "E");
                                cte.agregarError(662, "~_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        semantica2Contadores.add(new Contador2(2008));
                        Tabla(semantica3Contadores, "~()", "S", "E");
                        cte.agregarError(662, "~()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("~_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "~_p1()", "E", "E");
                        cte.agregarError(662, "~_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2008));
                        Tabla(semantica3Contadores, "~()", "S", "E");
                        cte.agregarError(662, "~()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("~_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "~_p1()", "E", "E");
                        cte.agregarError(662, "~_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            default:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2008));
                Tabla(semantica3Contadores, "~()", "S", "E");
                cte.agregarError(662, "~()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("~_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "~_p1()", "E", "A");
                cte.agregarError(662, "~_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void leerFile(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2016));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+()");
        int numPila = semantica2Contadores.size() - 1;
        boolean bandP1 = true;
        semantica2Contadores.get(numPila).setTopeLinea("CHAR[]/FILE");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)))) {
                            case -108:
                            case -109:
                                semantica2Contadores.add(new Contador2(2006));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "<+_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP1 = false;
                                semantica2Contadores.add(new Contador2(2006));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "<+_p1()", "E", "E");
                                cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2006));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "<+_p1()", "E", "E");
                        cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2006));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "<+_p1()", "E", "E");
                        cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -109:
                semantica2Contadores.add(new Contador2(2006));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "<+_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                bandP1 = false;
                semantica2Contadores.add(new Contador2(2006));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "<+_p1()", "E", "E");
                cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(1).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)))) {
                            case -220:
                                if (!bandP1) {
                                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Error");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2008));
                                    Tabla(semantica3Contadores, "<+()", "S", "E");
                                    cte.agregarError(663, "<+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p2");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    Tabla(semantica3Contadores, "<+_p2()", "E", "E");
                                    cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                } else {
                                    semantica2Contadores.get(numPila).setValorReal("FILE");
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Acepta");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -212, pilaMetodo.get(1).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2008));
                                    Tabla(semantica3Contadores, "<+()", "S", "A");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p2");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("FILE");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                    Tabla(semantica3Contadores, "<+_p2()", "E", "A");
                                    break;
                                }
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2008));
                                Tabla(semantica3Contadores, "<+()", "S", "E");
                                cte.agregarError(663, "<+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "<+_p2()", "E", "E");
                                cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        semantica2Contadores.add(new Contador2(2008));
                        Tabla(semantica3Contadores, "<+()", "S", "E");
                        cte.agregarError(663, "<+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "<+_p2()", "E", "E");
                        cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2008));
                        Tabla(semantica3Contadores, "<+()", "S", "E");
                        cte.agregarError(663, "<+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "<+_p2()", "E", "E");
                        cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2008));
                Tabla(semantica3Contadores, "<+()", "S", "E");
                cte.agregarError(663, "<+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("<+_p2");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "<+_p2()", "E", "E");
                cte.agregarError(663, "<+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void escrbirFile(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2017));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+()");
        int numPila = semantica2Contadores.size() - 1;
        boolean bandP1 = true;
        semantica2Contadores.get(numPila).setTopeLinea("CHAR[]/FILE");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)))) {
                            case -108:
                            case -109:
                                semantica2Contadores.add(new Contador2(2006));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, ">+_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP1 = false;
                                semantica2Contadores.add(new Contador2(2006));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, ">+_p1()", "E", "E");
                                cte.agregarError(665, ">+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2006));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, ">+_p1()", "E", "E");
                        cte.agregarError(665, ">+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2006));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, ">+_p1()", "E", "E");
                        cte.agregarError(665, ">+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -109:
                semantica2Contadores.add(new Contador2(2006));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, ">+_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                bandP1 = false;
                semantica2Contadores.add(new Contador2(2006));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, ">+_p1()", "E", "E");
                cte.agregarError(665, ">+_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(1).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)))) {
                            case -220:
                                if (!bandP1) {
                                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Error");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2008));
                                    Tabla(semantica3Contadores, ">+()", "S", "E");
                                    cte.agregarError(665, ">+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p2");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                    Tabla(semantica3Contadores, ">+_p2()", "E", "E");
                                    cte.agregarError(665, ">+_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                } else {
                                    semantica2Contadores.get(numPila).setValorReal("VOID");
                                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(numPila).setEdo("Acepta");
                                    ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                    semantica2Contadores.add(new Contador2(2008));
                                    Tabla(semantica3Contadores, ">+()", "S", "A");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p2");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("FILE");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                    Tabla(semantica3Contadores, ">+_p2()", "E", "A");
                                    break;
                                }
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2008));
                                Tabla(semantica3Contadores, ">+()", "S", "E");
                                cte.agregarError(665, ">+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, ">+_p2()", "E", "E");
                                cte.agregarError(665, ">+_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        semantica2Contadores.add(new Contador2(2008));
                        Tabla(semantica3Contadores, ">+()", "S", "E");
                        cte.agregarError(665, ">+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, ">+_p2()", "E", "E");
                        cte.agregarError(665, ">+_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2008));
                        Tabla(semantica3Contadores, ">+()", "S", "E");
                        cte.agregarError(665, ">+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, ">+_p2()", "E", "E");
                        cte.agregarError(665, ">+_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(1).getLinea(), -777, pilaMetodo.get(1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2008));
                Tabla(semantica3Contadores, ">+()", "S", "E");
                cte.agregarError(665, ">+()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion(">+_p2");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("FILE");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, ">+_p2()", "E", "E");
                cte.agregarError(665, ">+_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
