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
public class Semantica3b {

    public void conv(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2012));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv()");
        int numPila = semantica2Contadores.size() - 1;
        boolean bandP1 = true;
        boolean bandP2 = true;
        semantica2Contadores.get(numPila).setTopeLinea("INT/CHAR[]");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                semantica2Contadores.add(new Contador2(2002));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Conv_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP1 = false;
                                semantica2Contadores.add(new Contador2(2002));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(0).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Conv_p1()", "E", "E");
                                cte.agregarError(655, "Metodo conv_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        semantica2Contadores.add(new Contador2(2002));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Conv_p1()", "E", "E");
                        cte.agregarError(655, "Metodo conv_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(numPila).setValorReal("null");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP1 = false;
                        semantica2Contadores.add(new Contador2(2002));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Conv_p1()", "E", "E");
                        cte.agregarError(655, "Metodo conv_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -105:
                semantica2Contadores.add(new Contador2(2002));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Conv_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                bandP1 = false;
                semantica2Contadores.add(new Contador2(2002));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(0).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(0).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Conv_p1()", "E", "E");
                cte.agregarError(655, "Metodo conv_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(1).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                switch (pilaMetodo.get(2).getLexema().trim()) {
                                    case "2":
                                    case "4":
                                    case "8":
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "A");
                                        break;
                                    case "16":
                                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(numPila).setEdo("Error");
                                        bandP2 = false;
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "A");
                                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                        break;
                                    default:
                                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(numPila).setEdo("Error");
                                        bandP2 = false;
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                        break;
                                }
                                break;
                            case -109:
                                switch (pilaMetodo.get(2).getLexema().trim()) {
                                    case "2":
                                    case "4":
                                    case "8":
                                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(numPila).setEdo("Error");
                                        bandP2 = false;
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                        break;
                                    case "16":
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "A");
                                        break;
                                    default:
                                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(numPila).setEdo("Error");
                                        bandP2 = false;
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                        break;
                                }
                                break;
                            default:
                                switch (pilaMetodo.get(2).getLexema().trim()) {
                                    case "2":
                                    case "4":
                                    case "8":
                                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(numPila).setEdo("Error");
                                        bandP2 = false;
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                        break;
                                    case "16":
                                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(numPila).setEdo("Error");
                                        bandP2 = false;
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                        break;
                                    default:
                                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(numPila).setEdo("Error");
                                        bandP2 = false;
                                        semantica2Contadores.add(new Contador2(2003));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT/CHAR[]");
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                        break;
                                }
                                break;
                        }
                        break;
                    }
                    if (!sql.obtenerClaseVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerClaseVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (pilaMetodo.get(2).getLexema().trim()) {
                            case "2":
                            case "4":
                            case "8":
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP2 = false;
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                            case "16":
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP2 = false;
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP2 = false;
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                        break;
                    }
                    if (j == 0) {
                        switch (pilaMetodo.get(2).getLexema().trim()) {
                            case "2":
                            case "4":
                            case "8":
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP2 = false;
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                            case "16":
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP2 = false;
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                            default:
                                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(numPila).setEdo("Error");
                                bandP2 = false;
                                semantica2Contadores.add(new Contador2(2003));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                                cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                break;
                        }
                    }
                }
                break;
            case -105:
                switch (pilaMetodo.get(2).getLexema().trim()) {
                    case "2":
                    case "4":
                    case "8":
                        semantica2Contadores.get(numPila).setValorReal("INT");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                        break;
                    case "16":
                        semantica2Contadores.get(numPila).setValorReal("INT");
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    default:
                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                        break;
                }
                break;
            case -109:
                switch (pilaMetodo.get(2).getLexema().trim()) {
                    case "2":
                    case "4":
                    case "8":
                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    case "16":
                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                        Tabla(semantica3Contadores, "Conv_p2()", "E", "A");
                        break;
                    default:
                        semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                        semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(numPila).setEdo("Error");
                        Tabla(semantica3Contadores, "Conv()", "E", "E");
                        bandP2 = false;
                        semantica2Contadores.add(new Contador2(2003));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                        cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                bandP2 = false;
                semantica2Contadores.add(new Contador2(2003));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p2");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT/CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(1).getLexema().trim(), ambito.get(ambito.size() - 1)));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Conv_p2()", "E", "E");
                cte.agregarError(655, "Metodo conv_p2()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
        switch (pilaMetodo.get(2).getToken()) {
            case -100:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                Tabla(semantica3Contadores, "Conv()", "S", "E");
                ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -777, pilaMetodo.get(2).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2004));
                cte.agregarError(655, "Metodo conv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Conv_p3()", "E", "E");
                cte.agregarError(655, "Metodo conv_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
            case -105:
                if (!bandP1 || !bandP2) {
                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Error");
                    ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -777, pilaMetodo.get(2).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2004));
                    Tabla(semantica3Contadores, "Conv()", "E", "E");
                    cte.agregarError(655, "Metodo conv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                    Tabla(semantica3Contadores, "Conv_p3()", "E", "E");
                    cte.agregarError(655, "Metodo conv_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                } else {
                    switch (pilaMetodo.get(2).getLexema().trim()) {
                        case "2":
                        case "4":
                        case "8":
                            semantica2Contadores.get(numPila).setValorReal("INT");
                            semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(numPila).setEdo("Acepta");
                            ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -105, pilaMetodo.get(2).getLexema().trim() + ""));
                            semantica2Contadores.add(new Contador2(2004));
                            Tabla(semantica3Contadores, "Conv()", "S", "A");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                            Tabla(semantica3Contadores, "Conv_p3()", "E", "A");
                            break;
                        case "16":
                            semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                            semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(numPila).setEdo("Error");
                            ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -108, pilaMetodo.get(2).getLexema().trim() + ""));
                            semantica2Contadores.add(new Contador2(2004));
                            cte.agregarError(655, "Metodo conv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                            Tabla(semantica3Contadores, "Conv()", "S", "E");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                            Tabla(semantica3Contadores, "Conv_p3()", "E", "E");
                            cte.agregarError(655, "Metodo conv_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                            break;
                        default:
                            semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                            semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(numPila).setEdo("Error");
                            ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -777, pilaMetodo.get(2).getLexema().trim() + ""));
                            semantica2Contadores.add(new Contador2(2004));
                            cte.agregarError(655, "Metodo conv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                            Tabla(semantica3Contadores, "Conv()", "S", "E");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                            Tabla(semantica3Contadores, "Conv_p3()", "E", "E");
                            cte.agregarError(655, "Metodo conv_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                            break;
                    }
                }
                break;
            case -109:
                if (!bandP1 || !bandP2) {
                    semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                    semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                    semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(numPila).setEdo("Error");
                    ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -105, pilaMetodo.get(2).getLexema().trim() + ""));
                    semantica2Contadores.add(new Contador2(2004));
                    cte.agregarError(655, "Metodo conv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    Tabla(semantica3Contadores, "Conv_()", "S", "E");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                    Tabla(semantica3Contadores, "Conv_p3()", "E", "E");
                    cte.agregarError(655, "Metodo conv_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                } else {
                    switch (pilaMetodo.get(2).getLexema().trim()) {
                        case "2":
                        case "4":
                        case "8":
                            semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                            semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(numPila).setEdo("Error");
                            ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -105, pilaMetodo.get(2).getLexema().trim() + ""));
                            semantica2Contadores.add(new Contador2(2004));
                            Tabla(semantica3Contadores, "Conv()", "S", "E");
                            cte.agregarError(655, "Metodo conv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                            Tabla(semantica3Contadores, "Conv_p3()", "E", "E");
                            cte.agregarError(655, "Metodo conv_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                            break;
                        case "16":
                            semantica2Contadores.get(numPila).setValorReal("INT");
                            semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(numPila).setEdo("Acepta");
                            ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -109, pilaMetodo.get(2).getLexema().trim() + ""));
                            semantica2Contadores.add(new Contador2(2004));
                            Tabla(semantica3Contadores, "Conv()", "S", "A");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                            Tabla(semantica3Contadores, "Conv_p3()", "E", "A");
                            break;
                        default:
                            semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                            semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(numPila).setEdo("Error");
                            ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -777, pilaMetodo.get(2).getLexema().trim() + ""));
                            semantica2Contadores.add(new Contador2(2004));
                            cte.agregarError(655, "Metodo conv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                            Tabla(semantica3Contadores, "Conv()", "S", "E");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                            Tabla(semantica3Contadores, "Conv_p3()", "E", "E");
                            cte.agregarError(655, "Metodo conv_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                            break;
                    }
                }
                break;
            default:
                semantica2Contadores.get(numPila).setValorReal(pilaMetodo.get(2).getLexema().trim());
                semantica2Contadores.get(numPila).setLinea(pilaMetodo.get(2).getLinea());
                semantica2Contadores.get(numPila).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(numPila).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(2).getLinea(), -777, pilaMetodo.get(2).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2004));
                Tabla(semantica3Contadores, "Conv()", "S", "E");
                cte.agregarError(655, "Metodo conv()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("conv_p3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(2).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(2).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Conv_p3()", "E", "E");
                cte.agregarError(655, "Metodo conv_p3()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void up(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2013));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)))) {
                            case -108:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -108, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2005));
                                Tabla(semantica3Contadores, "Up()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Up_p1()", "E", "A");
                                break;
                            case -109:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -109, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2005));
                                Tabla(semantica3Contadores, "Up()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Up_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2005));
                                Tabla(semantica3Contadores, "Up()", "S", "E");
                                cte.agregarError(656, "Metodo up()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Up_p1()", "E", "E");
                                cte.agregarError(656, "Metodo up_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        Tabla(semantica3Contadores, "Up()", "S", "E");
                        semantica2Contadores.add(new Contador2(2005));
                        cte.agregarError(656, "Metodo up()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Up_p1()", "E", "E");
                        cte.agregarError(656, "Metodo up_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2005));
                        Tabla(semantica3Contadores, "Up()", "S", "E");
                        cte.agregarError(656, "Metodo up()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Up_p1()", "E", "E");
                        cte.agregarError(656, "Metodo up_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -108:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR/CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -108, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2005));
                Tabla(semantica3Contadores, "Up()", "S", "S");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Up_p1()", "E", "A");
                break;
            case -109:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR/CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -109, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2005));
                Tabla(semantica3Contadores, "Up()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Up_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2005));
                Tabla(semantica3Contadores, "Up()", "S", "E");
                cte.agregarError(656, "Metodo up()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("up_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Up_p1()", "E", "E");
                cte.agregarError(656, "Metodo up_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void low(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2013));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)))) {
                            case -108:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -108, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2005));
                                Tabla(semantica3Contadores, "Low()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Low_p1()", "E", "A");
                                break;
                            case -109:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -109, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2005));
                                Tabla(semantica3Contadores, "Low()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Low_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2005));
                                Tabla(semantica3Contadores, "Low()", "S", "A");
                                cte.agregarError(657, "Metodo low()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Low_p1()", "E", "A");
                                cte.agregarError(657, "Metodo low_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        semantica2Contadores.add(new Contador2(2005));
                        Tabla(semantica3Contadores, "Low()", "S", "E");
                        cte.agregarError(657, "Metodo low()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Low_p1()", "E", "E");
                        cte.agregarError(657, "Metodo low_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2005));
                        Tabla(semantica3Contadores, "Low()", "S", "E");
                        cte.agregarError(657, "Metodo low()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Low_p1()", "E", "E");
                        cte.agregarError(657, "Metodo low_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -108:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR/CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -108, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2005));
                Tabla(semantica3Contadores, "Low()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Low_p1()", "E", "A");
                break;
            case -109:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR/CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -109, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2005));
                Tabla(semantica3Contadores, "Low()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Low_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2005));
                Tabla(semantica3Contadores, "Low()", "S", "E");
                cte.agregarError(657, "Metodo low()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("low_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Low_p1()", "E", "E");
                cte.agregarError(657, "Metodo low_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void len(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2014));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("len()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)))) {
                            case -109:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -105, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2006));
                                Tabla(semantica3Contadores, "Len()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("len_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Len_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2006));
                                Tabla(semantica3Contadores, "Len()", "S", "E");
                                cte.agregarError(658, "Metodo len()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("len_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Len_p1()", "E", "E");
                                cte.agregarError(658, "Metodo len_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        semantica2Contadores.add(new Contador2(2006));
                        Tabla(semantica3Contadores, "Len()", "S", "E");
                        cte.agregarError(658, "Metodo len()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("len_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Len_p1()", "E", "E");
                        cte.agregarError(658, "Metodo len_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2006));
                        Tabla(semantica3Contadores, "Len()", "S", "E");
                        cte.agregarError(658, "Metodo len()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("len_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Len_p1()", "E", "E");
                        cte.agregarError(658, "Metodo len_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -109:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -105, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2006));
                Tabla(semantica3Contadores, "Len()", "S", "E");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("len_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Len_p1()", "E", "E");
                break;
            default:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2006));
                Tabla(semantica3Contadores, "Len()", "S", "E");
                cte.agregarError(658, "Metodo len()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("len_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR/CHAR[]");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Len_p1()", "E", "E");
                cte.agregarError(658, "Metodo len_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void val(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2014));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("val()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)))) {
                            case -108:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -105, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2007));
                                Tabla(semantica3Contadores, "Val()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("val_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Val_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2007));
                                Tabla(semantica3Contadores, "Val()", "S", "E");
                                cte.agregarError(659, "Metodo val()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("val_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Val_p1()", "E", "E");
                                cte.agregarError(659, "Metodo val_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        semantica2Contadores.add(new Contador2(2007));
                        Tabla(semantica3Contadores, "Val()", "S", "E");
                        cte.agregarError(659, "Metodo val()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("val_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Val_p1()", "E", "E");
                        cte.agregarError(659, "Metodo val_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2007));
                        Tabla(semantica3Contadores, "Val()", "S", "E");
                        cte.agregarError(659, "Metodo val_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("val_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Val_p1()", "E", "E");
                        cte.agregarError(659, "Metodo val()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -108:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -105, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2007));
                Tabla(semantica3Contadores, "Val()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("val_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Val_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2006));
                Tabla(semantica3Contadores, "Val()", "S", "E");
                cte.agregarError(659, "Metodo val()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("val_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("CHAR");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Val_p1()", "E", "E");
                cte.agregarError(659, "Metodo val_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                break;
        }
    }

    public void asc(ArrayList<Contador2> semantica2Contadores, ArrayList<Integer> ambito, Stack<NodoToken> pilaMetodo, ArrayList<NodoToken> ecuacion, MySql sql, ArrayList<Contador3> semantica3Contadores, ListaError cte) {
        semantica2Contadores.add(new Contador2(2015));
        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("asc()");
        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
        switch (pilaMetodo.get(0).getToken()) {
            case -100:
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("-")
                            && !sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)).equals("")) {
                        switch (traducirToken(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)))) {
                            case -105:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("CHAR");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -108, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2007));
                                Tabla(semantica3Contadores, "Asc()", "S", "A");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("asc_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                Tabla(semantica3Contadores, "Asc_p1()", "E", "A");
                                break;
                            default:
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                                semantica2Contadores.add(new Contador2(2007));
                                Tabla(semantica3Contadores, "Asc()", "S", "E");
                                cte.agregarError(660, "Metodo asc()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("asc_p1");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(sql.obtenerTipoVariable(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim(), ambito.get(j)));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                Tabla(semantica3Contadores, "Asc_p1()", "E", "E");
                                cte.agregarError(660, "Metodo asc_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
                        semantica2Contadores.add(new Contador2(2007));
                        Tabla(semantica3Contadores, "Asc()", "S", "E");
                        cte.agregarError(660, "Metodo asc()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("asc_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Asc_p1()", "E", "E");
                        cte.agregarError(660, "Metodo asc_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        break;
                    }
                    if (j == 0) {
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                        semantica2Contadores.add(new Contador2(2007));
                        Tabla(semantica3Contadores, "Asc()", "S", "E");
                        cte.agregarError(660, "Metodo asc()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("asc_p1");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("null");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        Tabla(semantica3Contadores, "Asc_p1()", "E", "E");
                        cte.agregarError(660, "Metodo asc_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                    }
                }
                break;
            case -105:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -108, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2007));
                Tabla(semantica3Contadores, "Asc()", "S", "A");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("asc_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                Tabla(semantica3Contadores, "Asc_p1()", "E", "A");
                break;
            default:
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                ecuacion.add(new NodoToken(pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), -777, pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim() + ""));
                semantica2Contadores.add(new Contador2(2006));
                Tabla(semantica3Contadores, "Asc()", "S", "E");
                cte.agregarError(660, "Metodo asc()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setFuncion("asc_p1");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("INT");
                semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(pilaMetodo.get(pilaMetodo.size() - 1).getLexema().trim());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(pilaMetodo.get(pilaMetodo.size() - 1).getLinea());
                semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                Tabla(semantica3Contadores, "Asc_p1()", "E", "E");
                cte.agregarError(660, "Metodo asc_p1()", "Error", pilaMetodo.get(pilaMetodo.size() - 1).getLinea(), "Semantica3");
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
