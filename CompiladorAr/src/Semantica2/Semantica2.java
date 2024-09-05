/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantica2;

import Errores.ListaError;
import Externo.MySql;
import Semantica1.Semantica1;
import Sintaxis.ListaToken;
import Sintaxis.NodoToken;
import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author Usuario
 */
public class Semantica2 {

    private boolean arregloSalvar = false;
    private boolean forRegla = false;
    private boolean arrPan = false;
    private ArrayList<NodoToken> arrSalvar = new ArrayList<>();
    private ArrayList<NodoToken> arrFor = new ArrayList<>();
    private int dimencion = 0;
    private int arrCant = 0;
    private int arrCantP = 0;
    private NodoToken idFun;

    public Stack<Integer> pila(Stack<Integer> pila, ListaToken oper, ArrayList<Integer> ambito, Semantica1 semantica1, ArrayList<Contador2> semantica2Contadores, ListaError cte, MySql sql) {
        switch (pila.peek()) {
            case 330:
                while (pila.peek() == 330) {
                    pila.pop();
                }
                if (semantica1.getLastToken() != -212) {
                    cte.agregarError(630, "Regla 1010", "Error", semantica1.getLastLinea(), "Semantica2");
                    semantica2Contadores.add(new Contador2(1010));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getLastLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getLastLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                } else {
                    semantica2Contadores.add(new Contador2(1010));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getLastLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getLastLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                }
                break;
            case 331:
                while (pila.peek() == 331) {
                    pila.pop();
                }
                if (semantica1.getLastToken() != -212 && semantica1.getLastToken() != -777) {
                    cte.agregarError(630, "Regla 1011", "Error", semantica1.getLastLinea(), "Semantica2");
                    semantica2Contadores.add(new Contador2(1011));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getLastLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getLastLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                } else {
                    semantica2Contadores.add(new Contador2(1011));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getLastLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getLastLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                }
                break;
            case 332:
                while (pila.peek() == 332) {
                    pila.pop();
                }
                if (semantica1.getLastToken() != -212) {
                    cte.agregarError(630, "Regla 1012", "Error", semantica1.getLastLinea(), "Semantica2");
                    semantica2Contadores.add(new Contador2(1012));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getLastLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getLastLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                } else {
                    semantica2Contadores.add(new Contador2(1012));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getLastLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getLastLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                }
                break;
            case 333:
                while (pila.peek() == 333) {
                    pila.pop();
                }
                arregloSalvar = true;
                break;
            case 334:
                while (pila.peek() == 334) {
                    pila.pop();
                }
                arregloSalvar = false;
//                System.out.print("Semantica 2: Arreglo: ");
                for (int i = 0; i < arrSalvar.size(); i++) {
//                    System.out.print(arrSalvar.get(i).getLexema().trim());
                    if (arrSalvar.get(i).getToken() == -145) {
                        dimencion++;
                    }
                }
//                System.out.println("");
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerTamañoArreglo(semantica1.getId().getLexema() + "", ambito.get(j)).equals("-")
                            && !sql.obtenerTamañoArreglo(semantica1.getId().getLexema() + "", ambito.get(j)).equals("")) {
                        if (dimencion != Integer.parseInt(sql.obtenerTamañoArreglo(semantica1.getId().getLexema() + "", ambito.get(j)))) {
                            cte.agregarError(632, "Regla 1030", "Error", semantica1.getId().getLinea(), "Semantica2");
                            semantica2Contadores.add(new Contador2(1030));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        } else {
                            semantica2Contadores.add(new Contador2(1030));
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                        }
                        break;
                    }
                    if (j == ambito.size() - 1) {
                        cte.agregarError(632, "Regla 1030", "Error", semantica1.getId().getLinea(), "Semantica2");
                        semantica2Contadores.add(new Contador2(1030));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                    }
                }
                for (int i = 0; i < arrSalvar.size(); i++) {
                    if (arrSalvar.get(i).getToken() == -105) {
                        dimencion--;
                    }
                }
                if (dimencion > 0) {
                    cte.agregarError(632, "Regla 1031", "Error", semantica1.getId().getLinea(), "Semantica2");
                    semantica2Contadores.add(new Contador2(1031));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                } else {
                    semantica2Contadores.add(new Contador2(1031));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                }
                ArrayList<Integer> dimeciones = new ArrayList<>();
                ArrayList<Integer> dimeciones2 = new ArrayList<>();
                for (int i = 0; i < arrSalvar.size(); i++) {
                    if (arrSalvar.get(i).getToken() == -105) {
                        dimeciones.add(Integer.parseInt(arrSalvar.get(i).getLexema()));
                    }
                }
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerDimecionesArreglo(semantica1.getId().getLexema() + "", ambito.get(j)).equals("-")
                            && !sql.obtenerDimecionesArreglo(semantica1.getId().getLexema() + "", ambito.get(j)).equals("")) {
                        String dim = sql.obtenerDimecionesArreglo(semantica1.getId().getLexema() + "", ambito.get(j));
                        for (int i = 0; i < dim.length(); i++) {
                            if (dim.charAt(i) != ',') {
                                dimeciones2.add(Integer.parseInt(dim.charAt(i) + ""));
                            }
                        }
                    }
                }
                if (dimeciones.size() != dimeciones2.size()) {
                    cte.agregarError(632, "Regla 1032", "Error", semantica1.getId().getLinea(), "Semantica2");
                    semantica2Contadores.add(new Contador2(1031));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                } else {
                    semantica2Contadores.add(new Contador2(1031));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                }
                for (int i = 0; i < dimeciones.size() - 1; i++) {
                    if (dimeciones.get(i) > dimeciones2.get(i)) {
                        cte.agregarError(632, "Regla 1032", "Error", semantica1.getId().getLinea(), "Semantica2");
                        semantica2Contadores.add(new Contador2(1031));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        break;
                    } else if (i == dimeciones.size() - 1) {
                        semantica2Contadores.add(new Contador2(1031));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("AR");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getId().getLexema());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getId().getLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                    }
                }
                break;
            case 335:
                while (pila.peek() == 335) {
                    pila.pop();
                }
                forRegla = true;
                break;
            case 336:
                while (pila.peek() == 336) {
                    pila.pop();
                }
                forRegla = false;
                arrFor.add(new NodoToken(arrFor.get(arrFor.size() - 1).getLinea(), -778, arrFor.get(arrFor.size() - 1).getLexema()));
//                System.out.print("Semantica 2: For: ");
                for (int i = 0; i < arrFor.size(); i++) {
//                    System.out.print(arrFor.get(i).getLexema().trim());
                }
//                System.out.println("");
                NodoToken id = new NodoToken(arrFor.get(0).getLinea(), arrFor.get(0).getToken(), arrFor.get(0).getLexema());
                boolean primid = false;
                boolean[] forB = {false, false};
                boolean[] band1 = {false, false, false};
                boolean[] band2 = {false, false, false};
                boolean[] band3 = {false, false};
                for (int i = 0; i < arrFor.size(); i++) {
                    if (!forB[0] && !forB[1]) {
                        switch (arrFor.get(i).getToken()) {
                            case -100:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                }
                                band1[0] = true;
                                break;
                            case -777:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                }
                                band1[0] = true;
                                break;
                            case -136:
                                band1[1] = true;
                                break;
                            case -105:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                    band1[0] = true;
                                }
                                if (!primid) {
                                    band1[2] = true;
                                }
                                break;
                            case -140:
                                if (band1[0] && band1[1] && band1[2]) {
                                    semantica2Contadores.add(new Contador2(1080));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else if (!band1[0] && !band1[1] && !band1[2]) {
                                    semantica2Contadores.add(new Contador2(1083));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else {
                                    semantica2Contadores.add(new Contador2(1080));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                }
                                band1[0] = false;
                                band1[1] = false;
                                band1[2] = false;
                                forB[0] = true;
                                primid = true;
                                break;
                            case -141:
                                if (band1[0] && band1[1] && band1[2]) {
                                    semantica2Contadores.add(new Contador2(1080));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else if (!band1[0] && !band1[1] && !band1[2]) {
                                    semantica2Contadores.add(new Contador2(1083));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else {
                                    cte.agregarError(633, "Regla 1080", "Error", id.getLinea(), "Semantica2");
                                    semantica2Contadores.add(new Contador2(1080));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                }
                                band1[0] = false;
                                band1[1] = false;
                                band1[2] = false;
                                primid = true;
                                break;
                        }
                    } else if (forB[0] && !forB[1]) {
                        switch (arrFor.get(i).getToken()) {
                            case -100:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                }
                                band2[0] = true;
                                break;
                            case -777:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                }
                                band2[0] = true;
                                break;
                            case -128:
                                band2[1] = true;
                                break;
                            case -134:
                                band2[1] = true;
                                break;
                            case -139:
                                band2[1] = true;
                                break;
                            case -130:
                                band2[1] = true;
                                break;
                            case -138:
                                band2[1] = true;
                                break;
                            case -122:
                                band2[1] = true;
                                break;
                            case -137:
                                band2[1] = true;
                                break;
                            case -132:
                                band2[1] = true;
                                break;
                            case -105:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                    band2[0] = true;
                                }
                                if (!primid) {
                                    band2[2] = true;
                                }
                                break;
                            case -140:
                                if (band2[0] && band2[1] && band2[2]) {
                                    semantica2Contadores.add(new Contador2(1081));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else if (!band2[0] && !band2[1] && !band2[2]) {
                                    semantica2Contadores.add(new Contador2(1083));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else {
                                    cte.agregarError(633, "Regla 1081", "Error", id.getLinea(), "Semantica2");
                                    semantica2Contadores.add(new Contador2(1081));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                }
                                band2[0] = false;
                                band2[1] = false;
                                band2[2] = false;
                                forB[1] = true;
                                primid = true;
                                break;
                        }
                    } else if (forB[0] && forB[1]) {
//                        System.out.println(arrFor.get(i).getToken());
                        switch (arrFor.get(i).getToken()) {
                            case -100:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                }
                                band3[1] = true;
                                break;
                            case -777:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                }
                                band3[1] = true;
                                break;
                            case -105:
                                if (primid) {
                                    id = arrFor.get(i);
                                    primid = false;
                                    band3[1] = true;
                                }
                                if (!primid) {
                                    band3[1] = false;
                                }
                                break;
                            case -111:
                                band3[0] = true;
                                break;
                            case -117:
                                band3[0] = true;
                                break;
                            case -778:
                                for (int f = 0; f < 2; f++) {
//                                    System.out.println(band3[f]);
                                }
                                if (band3[0] && band3[1]) {
                                    semantica2Contadores.add(new Contador2(1082));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else if (!band3[0] && !band3[1]) {
                                    semantica2Contadores.add(new Contador2(1083));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else {
                                    cte.agregarError(633, "Regla 1082", "Error", id.getLinea(), "Semantica2");
                                    semantica2Contadores.add(new Contador2(1082));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                }
                                band3[0] = false;
                                band3[1] = false;
                                primid = true;
                                arrFor = new ArrayList<>();
                                break;
                            case -141:
                                for (int f = 0; f < 2; f++) {
//                                    System.out.println(band3[f]);
                                }
                                if (band3[0] && band3[1]) {
                                    semantica2Contadores.add(new Contador2(1082));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else if (!band3[0] && !band3[1]) {
                                    semantica2Contadores.add(new Contador2(1083));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                                } else {
                                    cte.agregarError(633, "Regla 1082", "Error", id.getLinea(), "Semantica2");
                                    semantica2Contadores.add(new Contador2(1082));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(id.getLexema());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(id.getLinea());
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                                }
                                band3[0] = false;
                                band3[1] = false;
                                primid = true;
                                break;
                        }
                    }
                }
                break;
            case 338:
                while (pila.peek() == 338) {
                    pila.pop();
                }
                idFun = new NodoToken(semantica1.getId().getLinea(), semantica1.getId().getToken(), semantica1.getId().getLexema());
                for (int j = ambito.size() - 1; j >= 0; j--) {
                    if (!sql.obtenerNumeroParamtro(idFun.getLexema() + "", ambito.get(j)).equals("-")
                            && !sql.obtenerNumeroParamtro(idFun.getLexema() + "", ambito.get(j)).equals("")) {
                        arrCantP = Integer.parseInt(sql.obtenerNumeroParamtro(idFun.getLexema() + "", ambito.get(j)));
                    }
                }
                arrCant = 0;
                arrPan = true;
                break;
            case 337:
                while (pila.peek() == 337) {
                    pila.pop();
                }
                if ((arrCant+1) == arrCantP) {
                    semantica2Contadores.add(new Contador2(1100));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("Fun");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(idFun.getLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(idFun.getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
                } else {
                    cte.agregarError(634, "Regla 1100", "Error", idFun.getLinea(), "Semantica2");
                    semantica2Contadores.add(new Contador2(1100));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("Fun");
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(idFun.getLexema());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(idFun.getLinea());
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito.get(ambito.size() - 1));
                    semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                }
                arrPan = false;
                arrCant = 0;
                arrCantP = 0;
                break;
        }
        if (arregloSalvar && pila.peek() < 0) {
            arrSalvar.add(oper.obtenerPrimero());
        }
        if (arrPan && pila.peek() == -141) {
            arrCant++;
        }
        if (forRegla && pila.peek() < 0) {
            arrFor.add(oper.obtenerPrimero());
        }
        return pila;
    }

}
