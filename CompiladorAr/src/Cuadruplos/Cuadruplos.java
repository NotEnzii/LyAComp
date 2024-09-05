/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Cuadruplos;

import Sintaxis.NodoToken;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JTable;

/**
 *
 * @author Usuario
 */
public class Cuadruplos {

    private int TE = 1;
    private int TR = 1;
    private int TS = 1;
    private int TCH = 1;
    private int TEX = 1;
    private int TB = 1;
    private int TRX = 1;
    private int TF = 1;
    private int Ife = 1;
    private int Fore = 1;
    private int While = 1;
    private int Switche = 1;
    private int contadorCuad = 0;
    private ArrayList<ContadorT1> cuadT1 = new ArrayList<>();
    private ArrayList<NodoToken> variablesArgumento = new ArrayList<>();
    private ArrayList<NodoToken> variablesAumento = new ArrayList<>();
    private ArrayList<ContadorT2> cuadnT2 = new ArrayList<>();
    private Stack<NodoToken> endEstatutos = new Stack<>();
    private int variablesArgumentoBand = 0;
    private int variablesAumentoBand = 0;
    private boolean ifEtiqueta = false;
    private boolean ifUsado = false;
    private boolean ifPendiente = false;
    private boolean elseUsad = false;
    private boolean forEtiqueta = false;
    private boolean forPendiente = false;
    private boolean whileEtiqueta = false;
    private boolean whilePendiente = false;
    private boolean asignacion = false;
    private boolean Aper = false;
    private int AperC = 0;
    private int AperT = 0;
    private int asignacionTipo = 1;
    private int SwitchNum = 1;
    private NodoToken switcCond;

    public void cuadruplos(Stack<NodoToken> cuadruplo, JTable TCuad, JTable TCuad2) {
        cuadnT2 = new ArrayList<>();
        cuadnT2.add(new ContadorT2(0));
        for (int i = 0; i < cuadruplo.size(); i++) {
            switch (cuadruplo.get(i).getToken()) {
                case -200:
                    endEstatutos.add(cuadruplo.get(i));
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad++).setEtiqueta("");
                    ifEtiqueta = true;
                    ifPendiente = true;
                    break;
                case -202:
                    endEstatutos.add(cuadruplo.get(i));
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad++).setEtiqueta("");
                    whileEtiqueta = true;
                    whilePendiente = true;
                    break;
                case -204:
                    endEstatutos.add(cuadruplo.get(i));
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad++).setEtiqueta("");
                    forPendiente = true;
                    forEtiqueta = true;
                    break;
                case -207:
                        for (int j = 0; j < cuadnT2.size(); j++) {
                            if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                                cuadnT2.get(j).setSWE();
                                break;
                            }
                            if ((j + 1) == cuadnT2.size()) {
                                cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                                cuadnT2.get(cuadnT2.size() - 1).setSWE();
                                break;
                            }
                        }
                    endEstatutos.add(cuadruplo.get(i));
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad++).setEtiqueta("");
                    break;
                case -221:
                    endEstatutos.add(cuadruplo.get(i));
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad).setEtiqueta("");
                    break;
                case -224:
                        for (int j = 0; j < cuadnT2.size(); j++) {
                            if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                                cuadnT2.get(j).setSWE();
                                break;
                            }
                            if ((j + 1) == cuadnT2.size()) {
                                cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                                cuadnT2.get(cuadnT2.size() - 1).setSWE();
                                break;
                            }
                        }
                    endEstatutos.add(cuadruplo.get(i));
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad++).setEtiqueta("case");
                    break;
                case -501:
                    endEstatutos.add(cuadruplo.get(i));
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad).setEtiqueta("Def");
                    cuadT1.get(contadorCuad++).setAccion(cuadruplo.get(i).getLexema().trim());
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i + 1).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setDEF();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i + 1).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setDEF();
                            break;
                        }
                    }
                    break;
                case -502:
                    endEstatutos.add(cuadruplo.get(i));
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad).setEtiqueta("PPAL");
                    cuadT1.get(contadorCuad++).setAccion("Main");
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setPPAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setPPAL();
                            break;
                        }
                    }
                    break;
            }
            if (!endEstatutos.isEmpty()) {
//                System.out.println(endEstatutos.peek().getToken() + " +-+ " + endEstatutos.peek().getLexema().trim());
                switch (endEstatutos.peek().getToken()) {
                    case -200:
                        inIf(cuadruplo, i);
                        break;
                    case -202:
                        inWhile(cuadruplo, i);
                        break;
                    case -204:
                        inFor(cuadruplo, i);
                        break;
                    case -207:
                        inSwt(cuadruplo, i);
                        break;
                    case -221:
                        inElse(cuadruplo, i);
                        break;
                    case -224:
                        break;
                    case -501:
                        inDef(cuadruplo, i);
                        break;
                    case -502:
                        inDef(cuadruplo, i);
                        break;
                }
            }
        }

        Object[][] cua = new Object[cuadT1.size()][5];
        for (int j = 0; j < cuadT1.size(); j++) {
            cua[j][0] = cuadT1.get(j).getEtiqueta() + "";
            cua[j][1] = cuadT1.get(j).getAccion() + "";
            cua[j][2] = cuadT1.get(j).getArg1() + "";
            cua[j][3] = cuadT1.get(j).getArg2() + "";
            cua[j][4] = cuadT1.get(j).getResultado() + "";
        }
        TCuad.setModel(new javax.swing.table.DefaultTableModel(cua, new String[]{"Etiqueta", "Accion", "Arg1", "Arg2", "Resultado"}));

        Object[][] cua2 = new Object[cuadnT2.size()][25];
        for (int j = 0; j < cuadnT2.size(); j++) {
            cua2[j][0] = cuadnT2.get(j).getAmbito();
            cua2[j][1] = cuadnT2.get(j).getTE();
            cua2[j][2] = cuadnT2.get(j).getTR();
            cua2[j][3] = cuadnT2.get(j).getTS();
            cua2[j][4] = cuadnT2.get(j).getTCH();
            cua2[j][5] = cuadnT2.get(j).getTEX();
            cua2[j][6] = cuadnT2.get(j).getTB();
            cua2[j][7] = cuadnT2.get(j).getTRX();
            cua2[j][8] = cuadnT2.get(j).getTF();
            cua2[j][9] = cuadnT2.get(j).getARR();
            cua2[j][10] = cuadnT2.get(j).getCALL();
            cua2[j][11] = cuadnT2.get(j).getIGUAL();
            cua2[j][12] = cuadnT2.get(j).getOPREL();
            cua2[j][13] = cuadnT2.get(j).getOPLOG();
            cua2[j][14] = cuadnT2.get(j).getOPARI();
            cua2[j][15] = cuadnT2.get(j).getOPUN();
            cua2[j][16] = cuadnT2.get(j).getJF();
            cua2[j][17] = cuadnT2.get(j).getJMP();
            cua2[j][18] = cuadnT2.get(j).getVALOR();
            cua2[j][19] = cuadnT2.get(j).getIFE();
            cua2[j][20] = cuadnT2.get(j).getSWE();
            cua2[j][21] = cuadnT2.get(j).getFORE();
            cua2[j][22] = cuadnT2.get(j).getWHIE();
            cua2[j][23] = cuadnT2.get(j).getDEF();
            cua2[j][24] = cuadnT2.get(j).getPPAL();
        }
        TCuad2.setModel(new javax.swing.table.DefaultTableModel(cua2, new String[]{"Ambitos", "TE", "TR", "TS", "TCH", "TEX", "TB", "TRX", "TF", "Arr", "call", "=", "Op-Rel", "Ope-Log", "Oper-Arit", "Op-Un", "JF", "JMP", "valor", "if-E", "SW-E", "For-E", "Whi-E", "DEF", "PPAL"}));
    }

    private void inSwt(Stack<NodoToken> cuadruplo, int i) {
//        Variables-------------------------
        switch (cuadruplo.get(i).getToken()) {
            case -100:
            case -105:
            case -106:
            case -107:
            case -108:
            case -109:
                SwitchNum = Switche;
                switcCond = cuadruplo.get(i);
                break;
            case -148:
                endSw(cuadruplo, i);
                endEstatutos.pop();
                break;
            default:
                if ((cuadruplo.get(i).getToken() <= -228 && cuadruplo.get(i).getToken() >= -244)
                        || cuadruplo.get(i).getToken() == -151 || cuadruplo.get(i).getToken() == -152
                        || cuadruplo.get(i).getToken() == -129 || cuadruplo.get(i).getToken() == -133
                        || cuadruplo.get(i).getToken() == -131 || cuadruplo.get(i).getToken() == -135) {
                    if (variablesArgumentoBand == 2) {
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                    }
                }
                break;
        }
    }

    private void inDef(Stack<NodoToken> cuadruplo, int i) {
//        Variables-------------------------
        switch (cuadruplo.get(i).getToken()) {
            case -100:
                if (variablesArgumentoBand == 0) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            //Asignacion------------------------
            case -103:
            case -112:
            case -115:
            case -118:
            case -136:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = true;
                break;
            //Comparacion------------------------
            case -128:
            case -122:
            case -130:
            case -132:
            case -134:
            case -138:
            case -139:
            case -137:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = false;
                break;
            //Constantes-------------------------
            case -105:
            case -106:
            case -107:
            case -108:
            case -109:
                switch (variablesArgumentoBand) {
                    case 0:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                    case 1:
                        variablesArgumento = new ArrayList<>();
                        variablesArgumento.add(cuadruplo.get(i));
                        break;
                    case 2:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            case -110:
                break;
            case -111:
            case -117:
            case -114:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPUN();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPUN();
                        break;
                    }
                }
                variablesAumento.add(cuadruplo.get(i));
                variablesAumentoBand++;
                break;
            case -148:
                enDEF(cuadruplo, i);
                endEstatutos.pop();
                break;
            default:
                if ((cuadruplo.get(i).getToken() <= -228 && cuadruplo.get(i).getToken() >= -244)
                        || cuadruplo.get(i).getToken() == -151 || cuadruplo.get(i).getToken() == -152
                        || cuadruplo.get(i).getToken() == -129 || cuadruplo.get(i).getToken() == -133
                        || cuadruplo.get(i).getToken() == -131 || cuadruplo.get(i).getToken() == -135) {
                    if (variablesArgumentoBand == 2) {
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                    }
                }
                break;
        }
        if (variablesArgumentoBand == 3) {
            cuadT1.add(new ContadorT1());
            if (variablesArgumento.get(2).getToken() <= -228 && variablesArgumento.get(2).getToken() >= -244) {
                cuadT1.get(contadorCuad - 1).setAccion("call");
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setCALL();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setCALL();
                        break;
                    }
                }
                cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(2).getLexema().trim());
                String tipo = tipoMetodo(variablesArgumento.get(2).getToken(), i, cuadruplo);
                cuadT1.get(contadorCuad - 1).setResultado(tipo);
                variablesArgumento.get(2).setLexema(tipo);
                cuadT1.add(new ContadorT1());
                contadorCuad++;
            }
            cuadT1.get(contadorCuad - 1).setAccion(variablesArgumento.get(1).getLexema().trim());
            cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(0).getLexema().trim());
            if (asignacion) {
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setIGUAL();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                        break;
                    }
                }
                cuadT1.get(contadorCuad - 1).setResultado(variablesArgumento.get(2).getLexema().trim());
            }
            asignacion = false;
            variablesArgumento = new ArrayList<>();
            variablesArgumentoBand = 0;
        }
        if (variablesAumentoBand == 2) {
            cuadT1.add(new ContadorT1());
            cuadT1.get(contadorCuad).setAccion(variablesAumento.get(0).getLexema().trim());
            cuadT1.get(contadorCuad).setArg1(variablesAumento.get(1).getLexema().trim());
            cuadT1.get(contadorCuad++).setResultado(variablesAumento.get(1).getLexema().trim());
            variablesAumento = new ArrayList<>();
            variablesAumentoBand = 0;
        }
    }

    private void inIf(Stack<NodoToken> cuadruplo, int i) {
//        Variables-------------------------
        switch (cuadruplo.get(i).getToken()) {
            case -100:
                if (variablesArgumentoBand == 0) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            case -123:
                Aper = true;
                AperT = 2;
                break;
            case -124:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                Aper = true;
                AperT = 0;
                break;
            case -125:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                Aper = true;
                AperT = 3;
                break;
            case -126:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                Aper = true;
                AperT = 1;
                break;
            //Asignacion------------------------
            case -103:
            case -112:
            case -115:
            case -118:
            case -136:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = true;
                break;
            //Comparacion------------------------
            case -128:
            case -122:
            case -130:
            case -132:
            case -134:
            case -138:
            case -139:
            case -137:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = false;
                break;
            //Constantes-------------------------
            case -105:
            case -106:
            case -107:
            case -108:
            case -109:
                switch (variablesArgumentoBand) {
                    case 0:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                    case 1:
                        variablesArgumento = new ArrayList<>();
                        variablesArgumento.add(cuadruplo.get(i));
                        break;
                    case 2:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            case -110:
                break;
            case -111:
            case -117:
            case -114:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPUN();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPUN();
                        break;
                    }
                }
                variablesAumento.add(cuadruplo.get(i));
                variablesAumentoBand++;
                break;
            case -148:
                endIf(cuadruplo, i);
                endEstatutos.pop();
                break;
            default:
                if ((cuadruplo.get(i).getToken() <= -228 && cuadruplo.get(i).getToken() >= -244)
                        || cuadruplo.get(i).getToken() == -151 || cuadruplo.get(i).getToken() == -152
                        || cuadruplo.get(i).getToken() == -129 || cuadruplo.get(i).getToken() == -133
                        || cuadruplo.get(i).getToken() == -131 || cuadruplo.get(i).getToken() == -135) {
                    if (variablesArgumentoBand == 2) {
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                    }
                }
                break;
        }
        if (variablesArgumentoBand == 3) {
            if (!ifEtiqueta) {
                cuadT1.add(new ContadorT1());
                cuadT1.get(contadorCuad).setAccion(variablesArgumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad).setArg1(variablesArgumento.get(0).getLexema().trim());
                if (asignacion) {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setIGUAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad++).setResultado(variablesArgumento.get(2).getLexema().trim());
                } else {
                    cuadT1.get(contadorCuad).setArg2(variablesArgumento.get(2).getLexema().trim());
                    cuadT1.get(contadorCuad++).setResultado("TB" + TB++);
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setTB();
                            cuadnT2.get(j).setOPREL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setTB();
                            cuadnT2.get(cuadnT2.size() - 1).setOPREL();
                            break;
                        }
                    }
                    if (Aper) {
                        if (AperC == 0) {
                            AperC++;
                        } else {
                            cuadT1.add(new ContadorT1());
                            switch (AperT) {
                                case 0:
                                    cuadT1.get(contadorCuad).setAccion("&&");
                                    break;
                                case 1:
                                    cuadT1.get(contadorCuad).setAccion("||");
                                    break;
                                case 2:
                                    cuadT1.get(contadorCuad).setAccion("&");
                                    break;
                                case 3:
                                    cuadT1.get(contadorCuad).setAccion("|");
                                    break;
                            }
                            for (int j = 0; j < cuadnT2.size(); j++) {
                                if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                                    cuadnT2.get(j).setOPLOG();
                                    break;
                                }
                                if ((j + 1) == cuadnT2.size()) {
                                    cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                                    cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                                    break;
                                }
                            }
                            cuadT1.get(contadorCuad).setArg1("TB" + (TB - 2));
                            cuadT1.get(contadorCuad).setArg2("TB" + (TB - 1));
                            cuadT1.get(contadorCuad).setResultado("TB" + TB);
                            ContadorT1 aux = cuadT1.get(contadorCuad);
                            ContadorT1 aux2 = cuadT1.get(contadorCuad - 1);
                            ContadorT1 aux3 = cuadT1.get(contadorCuad - 2);
                            cuadT1.set(contadorCuad, aux3);
                            cuadT1.set(contadorCuad - 2, aux2);
                            cuadT1.set(contadorCuad - 1, aux);
                            for (int j = 0; j < cuadnT2.size(); j++) {
                                if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                                    cuadnT2.get(j).setTB();
                                    break;
                                }
                                if ((j + 1) == cuadnT2.size()) {
                                    cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                                    cuadnT2.get(cuadnT2.size() - 1).setTB();
                                    break;
                                }
                            }
                            cuadT1.get(contadorCuad).setArg1("TB" + (TB++));
                            contadorCuad++;
                            Aper = false;
                            AperC = 0;
                        }
                    }
                }
                asignacion = false;
            } else {
                if (variablesArgumento.get(2).getToken() <= -228 && variablesArgumento.get(2).getToken() >= -244) {
                    cuadT1.get(contadorCuad - 1).setAccion("call");
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setCALL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setCALL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(2).getLexema().trim());
                    String tipo = tipoMetodo(variablesArgumento.get(2).getToken(), i, cuadruplo);
                    cuadT1.get(contadorCuad - 1).setResultado(tipo);
                    variablesArgumento.get(2).setLexema(tipo);
                    cuadT1.add(new ContadorT1());
                    contadorCuad++;
                }
                ifEtiqueta = false;
                cuadT1.get(contadorCuad - 1).setAccion(variablesArgumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(0).getLexema().trim());
                if (asignacion) {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setIGUAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setResultado(variablesArgumento.get(2).getLexema().trim());
                } else {
                    cuadT1.get(contadorCuad - 1).setArg2(variablesArgumento.get(2).getLexema().trim());
                    cuadT1.get(contadorCuad - 1).setResultado("TB" + TB);
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad).setAccion("JF");
                    cuadT1.get(contadorCuad).setArg1("TB" + TB++);
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setTB();
                            cuadnT2.get(j).setJF();
                            cuadnT2.get(j).setIFE();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setTB();
                            cuadnT2.get(cuadnT2.size() - 1).setJF();
                            cuadnT2.get(cuadnT2.size() - 1).setIFE();
                            break;
                        }
                    }
                    AperC++;
                    if (ifPendiente) {
                        cuadT1.get(contadorCuad++).setResultado("if-" + Ife);
                    } else {
                        cuadT1.get(contadorCuad++).setResultado("if-" + ++Ife);
                    }
                }
                asignacion = false;
            }
            variablesArgumento = new ArrayList<>();
            variablesArgumentoBand = 0;
        }
        if (variablesAumentoBand == 2) {
            if (!ifEtiqueta) {
                cuadT1.add(new ContadorT1());
                cuadT1.get(contadorCuad).setAccion(variablesAumento.get(0).getLexema().trim());
                cuadT1.get(contadorCuad).setArg1(variablesAumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad++).setResultado(variablesAumento.get(1).getLexema().trim());
            } else {
                ifEtiqueta = false;
                cuadT1.get(contadorCuad - 1).setAccion(variablesAumento.get(0).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setArg1(variablesAumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setResultado(variablesAumento.get(1).getLexema().trim());
            }
            variablesAumento = new ArrayList<>();
            variablesAumentoBand = 0;
        }
    }

    private void inCase(Stack<NodoToken> cuadruplo, int i) {
//        Variables-------------------------
        switch (cuadruplo.get(i).getToken()) {
            case -100:
                if (variablesArgumentoBand == 0) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            case -123:
                Aper = true;
                AperT = 2;
                break;
            case -124:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                Aper = true;
                AperT = 0;
                break;
            case -125:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                Aper = true;
                AperT = 3;
                break;
            case -126:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                Aper = true;
                AperT = 1;
                break;
            //Asignacion------------------------
            case -103:
            case -112:
            case -115:
            case -118:
            case -136:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = true;
                break;
            //Comparacion------------------------
            case -128:
            case -122:
            case -130:
            case -132:
            case -134:
            case -138:
            case -139:
            case -137:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = false;
                break;
            //Constantes-------------------------
            case -105:
            case -106:
            case -107:
            case -108:
            case -109:
                switch (variablesArgumentoBand) {
                    case 0:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                    case 1:
                        variablesArgumento = new ArrayList<>();
                        variablesArgumento.add(cuadruplo.get(i));
                        break;
                    case 2:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            case -110:
                break;
            case -111:
            case -117:
            case -114:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPUN();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPUN();
                        break;
                    }
                }
                variablesAumento.add(cuadruplo.get(i));
                variablesAumentoBand++;
                break;
            case -148:
                endEstatutos.pop();
                break;
            default:
                if ((cuadruplo.get(i).getToken() <= -228 && cuadruplo.get(i).getToken() >= -244)
                        || cuadruplo.get(i).getToken() == -151 || cuadruplo.get(i).getToken() == -152
                        || cuadruplo.get(i).getToken() == -129 || cuadruplo.get(i).getToken() == -133
                        || cuadruplo.get(i).getToken() == -131 || cuadruplo.get(i).getToken() == -135) {
                    if (variablesArgumentoBand == 2) {
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                    }
                }
                break;
        }
        if (variablesArgumentoBand == 3) {
            if (!ifEtiqueta) {
                cuadT1.add(new ContadorT1());
                cuadT1.get(contadorCuad).setAccion(variablesArgumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad).setArg1(variablesArgumento.get(0).getLexema().trim());
                if (asignacion) {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setIGUAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad++).setResultado(variablesArgumento.get(2).getLexema().trim());
                } else {
                    cuadT1.get(contadorCuad).setArg2(variablesArgumento.get(2).getLexema().trim());
                    cuadT1.get(contadorCuad++).setResultado("TB" + TB++);
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setTB();
                            cuadnT2.get(j).setOPREL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setTB();
                            cuadnT2.get(cuadnT2.size() - 1).setOPREL();
                            break;
                        }
                    }
                    if (Aper) {
                        if (AperC == 0) {
                            AperC++;
                        } else {
                            cuadT1.add(new ContadorT1());
                            switch (AperT) {
                                case 0:
                                    cuadT1.get(contadorCuad).setAccion("&&");
                                    break;
                                case 1:
                                    cuadT1.get(contadorCuad).setAccion("||");
                                    break;
                                case 2:
                                    cuadT1.get(contadorCuad).setAccion("&");
                                    break;
                                case 3:
                                    cuadT1.get(contadorCuad).setAccion("|");
                                    break;
                            }
                            for (int j = 0; j < cuadnT2.size(); j++) {
                                if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                                    cuadnT2.get(j).setOPLOG();
                                    break;
                                }
                                if ((j + 1) == cuadnT2.size()) {
                                    cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                                    cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                                    break;
                                }
                            }
                            cuadT1.get(contadorCuad).setArg1("TB" + (TB - 2));
                            cuadT1.get(contadorCuad).setArg2("TB" + (TB - 1));
                            cuadT1.get(contadorCuad).setResultado("TB" + TB);
                            ContadorT1 aux = cuadT1.get(contadorCuad);
                            ContadorT1 aux2 = cuadT1.get(contadorCuad - 1);
                            ContadorT1 aux3 = cuadT1.get(contadorCuad - 2);
                            cuadT1.set(contadorCuad, aux3);
                            cuadT1.set(contadorCuad - 2, aux2);
                            cuadT1.set(contadorCuad - 1, aux);
                            for (int j = 0; j < cuadnT2.size(); j++) {
                                if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                                    cuadnT2.get(j).setTB();
                                    break;
                                }
                                if ((j + 1) == cuadnT2.size()) {
                                    cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                                    cuadnT2.get(cuadnT2.size() - 1).setTB();
                                    break;
                                }
                            }
                            cuadT1.get(contadorCuad).setArg1("TB" + (TB++));
                            contadorCuad++;
                            Aper = false;
                            AperC = 0;
                        }
                    }
                }
                asignacion = false;
            } else {
                if (variablesArgumento.get(2).getToken() <= -228 && variablesArgumento.get(2).getToken() >= -244) {
                    cuadT1.get(contadorCuad - 1).setAccion("call");
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setCALL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setCALL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(2).getLexema().trim());
                    String tipo = tipoMetodo(variablesArgumento.get(2).getToken(), i, cuadruplo);
                    cuadT1.get(contadorCuad - 1).setResultado(tipo);
                    variablesArgumento.get(2).setLexema(tipo);
                    cuadT1.add(new ContadorT1());
                    contadorCuad++;
                }
                ifEtiqueta = false;
                cuadT1.get(contadorCuad - 1).setAccion(variablesArgumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(0).getLexema().trim());
                if (asignacion) {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setIGUAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setResultado(variablesArgumento.get(2).getLexema().trim());
                } else {
                    cuadT1.get(contadorCuad - 1).setArg2(variablesArgumento.get(2).getLexema().trim());
                    cuadT1.get(contadorCuad - 1).setResultado("TB" + TB);
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad).setAccion("JF");
                    cuadT1.get(contadorCuad).setArg1("TB" + TB++);
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setTB();
                            cuadnT2.get(j).setJF();
                            cuadnT2.get(j).setSWE();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setTB();
                            cuadnT2.get(cuadnT2.size() - 1).setJF();
                            cuadnT2.get(cuadnT2.size() - 1).setSWE();
                            break;
                        }
                    }
                    AperC++;
                    if (ifPendiente) {
                        cuadT1.get(contadorCuad++).setResultado("Sw-" + Switche);
                    } else {
                        cuadT1.get(contadorCuad++).setResultado("Sw-" + Switche);
                    }
                }
                asignacion = false;
            }
            variablesArgumento = new ArrayList<>();
            variablesArgumentoBand = 0;
        }
        if (variablesAumentoBand == 2) {
            if (!ifEtiqueta) {
                cuadT1.add(new ContadorT1());
                cuadT1.get(contadorCuad).setAccion(variablesAumento.get(0).getLexema().trim());
                cuadT1.get(contadorCuad).setArg1(variablesAumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad++).setResultado(variablesAumento.get(1).getLexema().trim());
            } else {
                ifEtiqueta = false;
                cuadT1.get(contadorCuad - 1).setAccion(variablesAumento.get(0).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setArg1(variablesAumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setResultado(variablesAumento.get(1).getLexema().trim());
            }
            variablesAumento = new ArrayList<>();
            variablesAumentoBand = 0;
        }
    }

    private void inElse(Stack<NodoToken> cuadruplo, int i) {
//        Variables-------------------------
        switch (cuadruplo.get(i).getToken()) {
            case -100:
                if (variablesArgumentoBand == 0) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            //Asignacion------------------------
            case -103:
            case -112:
            case -115:
            case -118:
            case -136:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = true;
                break;
            //Comparacion------------------------
            case -128:
            case -122:
            case -130:
            case -132:
            case -134:
            case -138:
            case -139:
            case -137:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = false;
                break;
            //Constantes-------------------------
            case -105:
            case -106:
            case -107:
            case -108:
            case -109:
                switch (variablesArgumentoBand) {
                    case 0:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                    case 1:
                        variablesArgumento = new ArrayList<>();
                        variablesArgumento.add(cuadruplo.get(i));
                        break;
                    case 2:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            case -111:
            case -117:
            case -114:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPUN();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPUN();
                        break;
                    }
                }
                variablesAumento.add(cuadruplo.get(i));
                variablesAumentoBand++;
                break;
            case -148:
                endElse(cuadruplo, i);
                endEstatutos.pop();
                break;
            default:
                if ((cuadruplo.get(i).getToken() <= -228 && cuadruplo.get(i).getToken() >= -244)
                        || cuadruplo.get(i).getToken() == -151 || cuadruplo.get(i).getToken() == -152
                        || cuadruplo.get(i).getToken() == -129 || cuadruplo.get(i).getToken() == -133
                        || cuadruplo.get(i).getToken() == -131 || cuadruplo.get(i).getToken() == -135) {
                    if (variablesArgumentoBand == 2) {
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                    }
                }
                break;
        }
        if (variablesArgumentoBand == 3) {
            if (ifUsado) {
                contadorCuad--;
                ifUsado = false;
            } else {
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setIFE();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setIFE();
                        break;
                    }
                }
                cuadT1.get(contadorCuad).setEtiqueta("if-" + Ife);
            }
            cuadT1.get(contadorCuad).setAccion(variablesArgumento.get(0).getLexema().trim());
            cuadT1.get(contadorCuad).setArg1(variablesArgumento.get(1).getLexema().trim());
            cuadT1.get(contadorCuad++).setResultado(variablesArgumento.get(2).getLexema().trim());
            cuadT1.add(new ContadorT1());
            switch (variablesArgumento.get(2).getToken()) {
                case -105:
                    break;
                case -106:
                    break;
                case -107:
                    break;
                case -108:
                    break;
                case -109:
                    break;
            }
            ifEtiqueta = false;
            asignacion = false;
            variablesArgumento = new ArrayList<>();
            variablesArgumentoBand = 0;
        }
        if (variablesAumentoBand == 2) {
            ifEtiqueta = false;
            cuadT1.get(contadorCuad).setAccion(variablesAumento.get(0).getLexema().trim());
            cuadT1.get(contadorCuad).setArg1(variablesAumento.get(1).getLexema().trim());
            cuadT1.get(contadorCuad++).setResultado(variablesAumento.get(1).getLexema().trim());
            variablesAumento = new ArrayList<>();
            variablesAumentoBand = 0;
        }
    }

    private void endIf(Stack<NodoToken> cuadruplo, int i) {
        cuadT1.add(new ContadorT1());
        for (int j = 0; j < cuadnT2.size(); j++) {
            if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                cuadnT2.get(j).setJMP();
                cuadnT2.get(j).setIFE();
                break;
            }
            if ((j + 1) == cuadnT2.size()) {
                cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                cuadnT2.get(cuadnT2.size() - 1).setJMP();
                cuadnT2.get(cuadnT2.size() - 1).setIFE();
                break;
            }
        }
        cuadT1.get(contadorCuad).setAccion("JMP");
        if (elseUsad) {
            cuadT1.get(contadorCuad++).setResultado("if-" + Ife);
        } else {
            cuadT1.get(contadorCuad++).setResultado("if-" + (Ife + 1));
        }
        cuadT1.add(new ContadorT1());
        cuadT1.get(contadorCuad++).setEtiqueta("if-" + Ife++);
    }

    private void endSw(Stack<NodoToken> cuadruplo, int i) {
        cuadT1.add(new ContadorT1());
        for (int j = 0; j < cuadnT2.size(); j++) {
            if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                cuadnT2.get(j).setJMP();
                cuadnT2.get(j).setSWE();
                break;
            }
            if ((j + 1) == cuadnT2.size()) {
                cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                cuadnT2.get(cuadnT2.size() - 1).setJMP();
                cuadnT2.get(cuadnT2.size() - 1).setSWE();
                break;
            }
        }
        cuadT1.get(contadorCuad).setAccion("JMP");
        cuadT1.get(contadorCuad++).setResultado("Sw-" + Switche++);
        cuadT1.add(new ContadorT1());
        cuadT1.get(contadorCuad++).setEtiqueta("Sw-" + SwitchNum);
    }

    private void enDEF(Stack<NodoToken> cuadruplo, int i) {
        cuadT1.add(new ContadorT1());
        cuadT1.get(contadorCuad++).setEtiqueta("endDef");
    }

    private void endElse(Stack<NodoToken> cuadruplo, int i) {
        cuadT1.add(new ContadorT1());
        for (int j = 0; j < cuadnT2.size(); j++) {
            if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                cuadnT2.get(j).setIFE();
                break;
            }
            if ((j + 1) == cuadnT2.size()) {
                cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                cuadnT2.get(cuadnT2.size() - 1).setIFE();
                break;
            }
        }
        cuadT1.get(contadorCuad++).setEtiqueta("if-" + Ife++);
        elseUsad = true;
    }

    private void inFor(Stack<NodoToken> cuadruplo, int i) {
//        Variables-------------------------
        switch (cuadruplo.get(i).getToken()) {
            case -100:
                if (variablesArgumentoBand == 0) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            //Asignacion------------------------
            case -103:
            case -112:
            case -115:
            case -118:
            case -136:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = true;
                break;
            //Comparacion------------------------
            case -128:
            case -122:
            case -130:
            case -132:
            case -134:
            case -138:
            case -139:
            case -137:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = false;
                break;
            //Constantes-------------------------
            case -105:
            case -106:
            case -107:
            case -108:
            case -109:
                switch (variablesArgumentoBand) {
                    case 0:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                    case 1:
                        variablesArgumento = new ArrayList<>();
                        variablesArgumento.add(cuadruplo.get(i));
                        break;
                    case 2:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            case -111:
            case -117:
            case -114:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPUN();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPUN();
                        break;
                    }
                }
                variablesAumento.add(cuadruplo.get(i));
                variablesAumentoBand++;
                break;
            case -148:
                endFor(cuadruplo, i);
                endEstatutos.pop();
                break;
            default:
                if ((cuadruplo.get(i).getToken() <= -228 && cuadruplo.get(i).getToken() >= -244)
                        || cuadruplo.get(i).getToken() == -151 || cuadruplo.get(i).getToken() == -152
                        || cuadruplo.get(i).getToken() == -129 || cuadruplo.get(i).getToken() == -133
                        || cuadruplo.get(i).getToken() == -131 || cuadruplo.get(i).getToken() == -135) {
                    if (variablesArgumentoBand == 2) {
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                    }
                }
                break;
        }
        if (variablesArgumentoBand == 3) {
            if (!forEtiqueta) {
                if (variablesArgumento.get(2).getToken() <= -228 && variablesArgumento.get(2).getToken() >= -244) {
                    cuadT1.get(contadorCuad - 1).setAccion("call");
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setCALL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setCALL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(2).getLexema().trim());
                    String tipo = tipoMetodo(variablesArgumento.get(2).getToken(), i, cuadruplo);
                    cuadT1.get(contadorCuad - 1).setResultado(tipo);
                    variablesArgumento.get(2).setLexema(tipo);
                    cuadT1.add(new ContadorT1());
                    contadorCuad++;
                }
                cuadT1.add(new ContadorT1());
                cuadT1.get(contadorCuad).setAccion(variablesArgumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad).setArg1(variablesArgumento.get(0).getLexema().trim());
                if (asignacion) {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setIGUAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad++).setResultado(variablesArgumento.get(2).getLexema().trim());
                } else {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setTB();
                            cuadnT2.get(j).setJF();
                            cuadnT2.get(j).setFORE();
                            cuadnT2.get(j).setOPREL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setTB();
                            cuadnT2.get(cuadnT2.size() - 1).setJF();
                            cuadnT2.get(cuadnT2.size() - 1).setFORE();
                            cuadnT2.get(cuadnT2.size() - 1).setOPREL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad).setEtiqueta("for-" + Fore++);
                    cuadT1.get(contadorCuad).setArg2(variablesArgumento.get(2).getLexema().trim());
                    cuadT1.get(contadorCuad++).setResultado("TB" + TB++);
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad).setAccion("JF");
                    cuadT1.get(contadorCuad).setArg1("TB" + (TB - 1));
                    cuadT1.get(contadorCuad++).setResultado("for-" + Fore);
                }
                asignacion = false;
            } else {
                if (variablesArgumento.get(2).getToken() <= -228 && variablesArgumento.get(2).getToken() >= -244) {
                    cuadT1.get(contadorCuad - 1).setAccion("call");
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setCALL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setCALL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(2).getLexema().trim());
                    String tipo = tipoMetodo(variablesArgumento.get(2).getToken(), i, cuadruplo);
                    cuadT1.get(contadorCuad - 1).setResultado(tipo);
                    variablesArgumento.get(2).setLexema(tipo);
                    cuadT1.add(new ContadorT1());
                    contadorCuad++;
                }
                forEtiqueta = false;
                cuadT1.get(contadorCuad - 1).setAccion(variablesArgumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(0).getLexema().trim());
                if (asignacion) {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setIGUAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setResultado(variablesArgumento.get(2).getLexema().trim());
                } else {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setTB();
                            cuadnT2.get(j).setOPREL();
                            cuadnT2.get(j).setJF();
                            cuadnT2.get(j).setFORE();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setTB();
                            cuadnT2.get(cuadnT2.size() - 1).setOPREL();
                            cuadnT2.get(cuadnT2.size() - 1).setJF();
                            cuadnT2.get(cuadnT2.size() - 1).setFORE();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setArg2(variablesArgumento.get(2).getLexema().trim());
                    cuadT1.get(contadorCuad - 1).setResultado("TB" + TB);
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad).setAccion("JF");
                    cuadT1.get(contadorCuad).setArg1("TB" + TB++);
                    cuadT1.get(contadorCuad++).setResultado("for-" + Fore);
                    forPendiente = false;
                }
                asignacion = false;
            }
            switch (variablesArgumento.get(2).getToken()) {
                case -105:
                    break;
                case -106:
                    break;
                case -107:
                    break;
                case -108:
                    break;
                case -109:
                    break;
            }
            variablesArgumento = new ArrayList<>();
            variablesArgumentoBand = 0;
        }
        if (variablesAumentoBand == 2) {
            if (!forEtiqueta) {
                cuadT1.add(new ContadorT1());
                cuadT1.get(contadorCuad).setAccion(variablesAumento.get(0).getLexema().trim());
                cuadT1.get(contadorCuad).setArg1(variablesAumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad++).setResultado(variablesAumento.get(1).getLexema().trim());
            } else {
                forEtiqueta = false;
                cuadT1.get(contadorCuad - 1).setAccion(variablesAumento.get(0).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setArg1(variablesAumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setResultado(variablesAumento.get(1).getLexema().trim());
            }
            variablesAumento = new ArrayList<>();
            variablesAumentoBand = 0;
        }
    }

    private void endFor(Stack<NodoToken> cuadruplo, int i) {
        cuadT1.add(new ContadorT1());
        cuadT1.get(contadorCuad).setAccion("JMP");
        for (int j = 0; j < cuadnT2.size(); j++) {
            if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                cuadnT2.get(j).setJMP();
                cuadnT2.get(j).setFORE();
                break;
            }
            if ((j + 1) == cuadnT2.size()) {
                cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                cuadnT2.get(cuadnT2.size() - 1).setJMP();
                cuadnT2.get(cuadnT2.size() - 1).setFORE();
                break;
            }
        }
        if (Fore - 2 <= 0) {
            cuadT1.get(contadorCuad++).setResultado("for-" + (Fore - 1));
        } else {
            cuadT1.get(contadorCuad++).setResultado("for-" + (Fore - 2));
        }
        cuadT1.add(new ContadorT1());
        cuadT1.get(contadorCuad++).setEtiqueta("for-" + Fore++);
    }

    private void inWhile(Stack<NodoToken> cuadruplo, int i) {
//        Variables-------------------------
        switch (cuadruplo.get(i).getToken()) {
            case -100:
                if (variablesArgumentoBand == 0) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            //Asignacion------------------------
            case -103:
            case -112:
            case -115:
            case -118:
            case -136:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = true;
                break;
            //Comparacion------------------------
            case -128:
            case -122:
            case -130:
            case -132:
            case -134:
            case -138:
            case -139:
            case -137:
                if (variablesArgumentoBand == 1) {
                    variablesArgumento.add(cuadruplo.get(i));
                    variablesArgumentoBand++;
                }
                asignacion = false;
                break;
            //Constantes-------------------------
            case -105:
            case -106:
            case -107:
            case -108:
            case -109:
                switch (variablesArgumentoBand) {
                    case 0:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                    case 1:
                        variablesArgumento = new ArrayList<>();
                        variablesArgumento.add(cuadruplo.get(i));
                        break;
                    case 2:
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                        break;
                }
                if (variablesAumentoBand == 1) {
                    variablesAumento.add(cuadruplo.get(i));
                    variablesAumentoBand++;
                }
                break;
            case -123:
                Aper = true;
                AperT = 2;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                break;
            case -124:
                Aper = true;
                AperT = 0;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                break;
            case -125:
                Aper = true;
                AperT = 3;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                break;
            case -126:
                Aper = true;
                AperT = 1;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPLOG();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPLOG();
                        break;
                    }
                }
                break;
            case -111:
            case -117:
            case -114:
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setOPUN();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setOPUN();
                        break;
                    }
                }
                variablesAumento.add(cuadruplo.get(i));
                variablesAumentoBand++;
                break;
            case -148:
                endWhile(cuadruplo, i);
                endEstatutos.pop();
                break;
            default:
                if ((cuadruplo.get(i).getToken() <= -228 && cuadruplo.get(i).getToken() >= -244)
                        || cuadruplo.get(i).getToken() == -151 || cuadruplo.get(i).getToken() == -152
                        || cuadruplo.get(i).getToken() == -129 || cuadruplo.get(i).getToken() == -133
                        || cuadruplo.get(i).getToken() == -131 || cuadruplo.get(i).getToken() == -135) {
                    if (variablesArgumentoBand == 2) {
                        variablesArgumento.add(cuadruplo.get(i));
                        variablesArgumentoBand++;
                    }
                }
                break;
        }
        if (variablesArgumentoBand == 3) {
            if (!whileEtiqueta) {
                if (variablesArgumento.get(2).getToken() <= -228 && variablesArgumento.get(2).getToken() >= -244) {
                    cuadT1.get(contadorCuad - 1).setAccion("call");
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setCALL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setCALL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(2).getLexema().trim());
                    String tipo = tipoMetodo(variablesArgumento.get(2).getToken(), i, cuadruplo);
                    cuadT1.get(contadorCuad - 1).setResultado(tipo);
                    variablesArgumento.get(2).setLexema(tipo);
                    cuadT1.add(new ContadorT1());
                    contadorCuad++;
                }
                cuadT1.add(new ContadorT1());
                cuadT1.get(contadorCuad).setAccion(variablesArgumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad).setArg1(variablesArgumento.get(0).getLexema().trim());
                if (asignacion) {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setIGUAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad++).setResultado(variablesArgumento.get(2).getLexema().trim());
                } else {
                    cuadT1.get(contadorCuad).setArg2(variablesArgumento.get(2).getLexema().trim());
                    cuadT1.get(contadorCuad++).setResultado("TB" + TB++);
                    if (Aper) {
                        if (AperC == 0) {
                            AperC++;
                        } else {
                            cuadT1.add(new ContadorT1());
                            switch (AperT) {
                                case 0:
                                    cuadT1.get(contadorCuad).setAccion("&&");
                                    break;
                                case 1:
                                    cuadT1.get(contadorCuad).setAccion("||");
                                    break;
                                case 2:
                                    cuadT1.get(contadorCuad).setAccion("&");
                                    break;
                                case 3:
                                    cuadT1.get(contadorCuad).setAccion("|");
                                    break;
                            }
                            for (int j = 0; j < cuadnT2.size(); j++) {
                                if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                                    cuadnT2.get(j).setOPUN();
                                    cuadnT2.get(j).setTB();
                                    break;
                                }
                                if ((j + 1) == cuadnT2.size()) {
                                    cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                                    cuadnT2.get(cuadnT2.size() - 1).setOPUN();
                                    cuadnT2.get(cuadnT2.size() - 1).setTB();
                                    break;
                                }
                            }
                            cuadT1.get(contadorCuad).setArg1("TB" + (TB - 2));
                            cuadT1.get(contadorCuad).setArg2("TB" + (TB - 1));
                            cuadT1.get(contadorCuad).setResultado("TB" + TB);
                            ContadorT1 aux = cuadT1.get(contadorCuad);
                            ContadorT1 aux2 = cuadT1.get(contadorCuad - 1);
                            ContadorT1 aux3 = cuadT1.get(contadorCuad - 2);
                            cuadT1.set(contadorCuad, aux3);
                            cuadT1.set(contadorCuad - 2, aux2);
                            cuadT1.set(contadorCuad - 1, aux);
                            cuadT1.get(contadorCuad).setArg1("TB" + (TB++));
                            contadorCuad++;
                            Aper = false;
                            AperC = 0;
                        }
                    }
                }
                asignacion = false;
            } else {
                if (variablesArgumento.get(2).getToken() <= -228 && variablesArgumento.get(2).getToken() >= -244) {
                    cuadT1.get(contadorCuad - 1).setAccion("call");
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setCALL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setCALL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(2).getLexema().trim());
                    String tipo = tipoMetodo(variablesArgumento.get(2).getToken(), i, cuadruplo);
                    cuadT1.get(contadorCuad - 1).setResultado(tipo);
                    variablesArgumento.get(2).setLexema(tipo);
                    cuadT1.add(new ContadorT1());
                    contadorCuad++;
                }
                whileEtiqueta = false;
                cuadT1.get(contadorCuad - 1).setAccion(variablesArgumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(0).getLexema().trim());
                if (asignacion) {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setIGUAL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setIGUAL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setResultado(variablesArgumento.get(2).getLexema().trim());
                } else {
                    for (int j = 0; j < cuadnT2.size(); j++) {
                        if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                            cuadnT2.get(j).setWHIE();
                            cuadnT2.get(j).setJF();
                            cuadnT2.get(j).setTB();
                            cuadnT2.get(j).setOPREL();
                            break;
                        }
                        if ((j + 1) == cuadnT2.size()) {
                            cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                            cuadnT2.get(cuadnT2.size() - 1).setWHIE();
                            cuadnT2.get(cuadnT2.size() - 1).setJF();
                            cuadnT2.get(cuadnT2.size() - 1).setTB();
                            cuadnT2.get(cuadnT2.size() - 1).setOPREL();
                            break;
                        }
                    }
                    cuadT1.get(contadorCuad - 1).setEtiqueta("while-" + While);
                    cuadT1.get(contadorCuad - 1).setArg2(variablesArgumento.get(2).getLexema().trim());
                    cuadT1.get(contadorCuad - 1).setResultado("TB" + TB);
                    cuadT1.add(new ContadorT1());
                    cuadT1.get(contadorCuad).setAccion("JF");
                    cuadT1.get(contadorCuad).setArg1("TB" + TB++);
                    cuadT1.get(contadorCuad++).setResultado("while-" + ++While);
                }
                asignacion = false;
            }
            switch (variablesArgumento.get(2).getToken()) {
                case -105:
                    break;
                case -106:
                    break;
                case -107:
                    break;
                case -108:
                    break;
                case -109:
                    break;
            }
            variablesArgumento = new ArrayList<>();
            variablesArgumentoBand = 0;
        }
        if (variablesAumentoBand == 2) {
            if (!whileEtiqueta) {
                cuadT1.add(new ContadorT1());
                cuadT1.get(contadorCuad).setAccion(variablesAumento.get(0).getLexema().trim());
                cuadT1.get(contadorCuad).setArg1(variablesAumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad++).setResultado(variablesAumento.get(1).getLexema().trim());
            } else {
                whileEtiqueta = false;
                cuadT1.get(contadorCuad - 1).setAccion(variablesAumento.get(0).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setArg1(variablesAumento.get(1).getLexema().trim());
                cuadT1.get(contadorCuad - 1).setResultado(variablesAumento.get(1).getLexema().trim());
            }
            variablesAumento = new ArrayList<>();
            variablesAumentoBand = 0;
        }
    }

    private void endWhile(Stack<NodoToken> cuadruplo, int i) {
        cuadT1.add(new ContadorT1());
        cuadT1.get(contadorCuad).setAccion("JMP");
        for (int j = 0; j < cuadnT2.size(); j++) {
            if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                cuadnT2.get(j).setJMP();
                cuadnT2.get(j).setWHIE();
                break;
            }
            if ((j + 1) == cuadnT2.size()) {
                cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                cuadnT2.get(cuadnT2.size() - 1).setJMP();
                cuadnT2.get(cuadnT2.size() - 1).setWHIE();
                break;
            }
        }
        if (While - 2 >= 1) {
            cuadT1.get(contadorCuad++).setResultado("while-" + (While - 2));
        } else {
            cuadT1.get(contadorCuad++).setResultado("while-" + (While - 1));
        }
        cuadT1.add(new ContadorT1());
        cuadT1.get(contadorCuad++).setEtiqueta("while-" + While++);
    }

    private String tipoTvariable(int token) {
        String Tv = "df";
        switch (token) {
            case -105:
                Tv = "TE" + TE++;
                break;
            case -106:
                Tv = "TR" + TR++;
                break;
            case -107:
                Tv = "TEX" + TEX++;
                break;
            case -108:
                Tv = "TCH" + TCH++;
                break;
            case -109:
                Tv = "TS" + TS++;
                break;
            default:
                break;
        }
        return Tv;
    }

    private String tipoMetodo(int token, int i, Stack<NodoToken> cuadruplo) {
        String Tv = "TE" + TE;
        switch (token) {
            case -236:
            case -238:
                Tv = "TE" + TE++;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setTE();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setTE();
                        break;
                    }
                }
                break;
            case -228:
            case -229:
            case -230:
            case -231:
                Tv = "TEX" + TEX++;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setTEX();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setTEX();
                        break;
                    }
                }
                break;
            case -237:
                Tv = "TCH" + TCH++;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setTCH();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setTCH();
                        break;
                    }
                }
                break;
            case -232:
            case -233:
            case -234:
            case -235:
                Tv = "TS" + TS++;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setTS();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setTS();
                        break;
                    }
                }
                break;
            case -131:
            case -150:
            case -151:
                Tv = "TB" + TB++;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setTB();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setTB();
                        break;
                    }
                }
                break;
            case -135:
                Tv = "TF" + TF++;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setTF();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setTF();
                        break;
                    }
                }
                break;
            default:
                Tv = "TE" + TE++;
                for (int j = 0; j < cuadnT2.size(); j++) {
                    if (cuadruplo.get(i).getLinea() == cuadnT2.get(j).getAmbito()) {
                        cuadnT2.get(j).setTE();
                        break;
                    }
                    if ((j + 1) == cuadnT2.size()) {
                        cuadnT2.add(new ContadorT2(cuadruplo.get(i).getLinea()));
                        cuadnT2.get(cuadnT2.size() - 1).setTE();
                        break;
                    }
                }
                break;
        }
        return Tv;
    }

    private void respaldo() {

//                //Variables-------------------------
//                case -100:
//                    if (variablesArgumentoBand == 0) {
//                        variablesArgumento.add(cuadruplo.get(i));
//                        variablesArgumentoBand++;
//                    }
//                    if (variablesAumentoBand == 1) {
//                        variablesAumento.add(cuadruplo.get(i));
//                        variablesAumentoBand++;
//                    }
//                    break;
//                //Asignacion------------------------
//                case -103:
//                case -112:
//                case -115:
//                case -118:
//                case -136:
//                    if (variablesArgumentoBand == 1) {
//                        variablesArgumento.add(cuadruplo.get(i));
//                        variablesArgumentoBand++;
//                    }
//                    asignacion = true;
//                    break;
//                //Comparacion------------------------
//                case -128:
//                case -122:
//                case -130:
//                case -132:
//                case -134:
//                case -138:
//                case -139:
//                case -137:
//                    if (variablesArgumentoBand == 1) {
//                        variablesArgumento.add(cuadruplo.get(i));
//                        variablesArgumentoBand++;
//                    }
//                    asignacion = false;
//                    break;
//                //Constantes-------------------------
//                case -105:
//                case -106:
//                case -107:
//                case -108:
//                case -109:
//                    switch (variablesArgumentoBand) {
//                        case 0:
//                            variablesArgumento.add(cuadruplo.get(i));
//                            variablesArgumentoBand++;
//                            break;
//                        case 1:
//                            variablesArgumento = new ArrayList<>();
//                            variablesArgumento.add(cuadruplo.get(i));
//                            break;
//                        case 2:
//                            variablesArgumento.add(cuadruplo.get(i));
//                            variablesArgumentoBand++;
//                            break;
//                    }
//                    if (variablesAumentoBand == 1) {
//                        variablesAumento.add(cuadruplo.get(i));
//                        variablesAumentoBand++;
//                    }
//                    break;
//                case -111:
//                case -117:
//                case -114:
//                    variablesAumento.add(cuadruplo.get(i));
//                    variablesAumentoBand++;
//                    break;
//                case -148:
//                    if (!endEstatutos.isEmpty()) {
//                        switch (endEstatutos.get(endEstatutos.size() - 1).getToken()) {
//                            case -200:
//                                cuadT1.add(new ContadorT1());
//                                cuadT1.get(contadorCuad++).setEtiqueta("end-If");
//                                break;
//                            case -202:
//                                cuadT1.add(new ContadorT1());
//                                cuadT1.get(contadorCuad++).setEtiqueta("end-while");
//                                break;
//                        }
//                        endEstatutos.pop();
//                    }
//                    break;
//                case -200:
//                    endEstatutos.add(cuadruplo.get(i));
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad++).setEtiqueta("if");
//                    ifEtiqueta = true;
//                    break;
//                case -202:
//                    endEstatutos.add(cuadruplo.get(i));
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad++).setEtiqueta("while");
//                    ifEtiqueta = true;
//                    break;
//                case -204:
//                    endEstatutos.add(cuadruplo.get(i));
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad++).setEtiqueta("for");
//                    break;
//                case -207:
//                    endEstatutos.add(cuadruplo.get(i));
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad++).setEtiqueta("switch");
//                    break;
//                case -221:
//                    endEstatutos.add(cuadruplo.get(i));
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad++).setEtiqueta("jf");
//                    break;
//                case -224:
//                    endEstatutos.add(cuadruplo.get(i));
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad++).setEtiqueta("case");
//                    break;
//                case -501:
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad).setEtiqueta("Def");
//                    cuadT1.get(contadorCuad++).setAccion(cuadruplo.get(i).getLexema().trim());
//                    break;
//                case -502:
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad).setEtiqueta("PPAL");
//                    cuadT1.get(contadorCuad++).setAccion("Main");
//                    break;
//                default:
//                    if (cuadruplo.get(i).getToken() <= -228 && cuadruplo.get(i).getToken() >= -244) {
//                        if (variablesArgumentoBand == 2) {
//                            variablesArgumento.add(cuadruplo.get(i));
//                            variablesArgumentoBand++;
//                        }
//                    }
//                    break;
//            }
//            if (variablesArgumentoBand == 3) {
//                if (!ifEtiqueta) {
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad).setAccion(variablesArgumento.get(1).getLexema().trim());
//                    cuadT1.get(contadorCuad).setArg1(variablesArgumento.get(0).getLexema().trim());
//                    if (asignacion) {
//                        cuadT1.get(contadorCuad++).setResultado(variablesArgumento.get(2).getLexema().trim());
//                    } else {
//                        cuadT1.get(contadorCuad).setArg2(variablesArgumento.get(2).getLexema().trim());
//                        cuadT1.get(contadorCuad++).setResultado("TB" + TB++);
//                    }
//                    asignacion = false;
//                } else {
//                    ifEtiqueta = false;
//                    cuadT1.get(contadorCuad - 1).setAccion(variablesArgumento.get(1).getLexema().trim());
//                    cuadT1.get(contadorCuad - 1).setArg1(variablesArgumento.get(0).getLexema().trim());
//                    if (asignacion) {
//                        cuadT1.get(contadorCuad - 1).setResultado(variablesArgumento.get(2).getLexema().trim());
//                    } else {
//                        cuadT1.get(contadorCuad - 1).setArg2(variablesArgumento.get(2).getLexema().trim());
//                        cuadT1.get(contadorCuad-1).setResultado("TB" + TB++);
//                    }
//                    asignacion = false;
//                }
//                switch (variablesArgumento.get(2).getToken()) {
//                    case -105:
//                        break;
//                    case -106:
//                        break;
//                    case -107:
//                        break;
//                    case -108:
//                        break;
//                    case -109:
//                        break;
//                }
//                variablesArgumento = new ArrayList<>();
//                variablesArgumentoBand = 0;
//            }
//            if (variablesAumentoBand == 2) {
//                if (!ifEtiqueta) {
//                    cuadT1.add(new ContadorT1());
//                    cuadT1.get(contadorCuad).setAccion(variablesAumento.get(0).getLexema().trim());
//                    cuadT1.get(contadorCuad).setArg1(variablesAumento.get(1).getLexema().trim());
//                    cuadT1.get(contadorCuad++).setResultado(variablesAumento.get(1).getLexema().trim());
//                } else {
//                    ifEtiqueta = false;
//                    cuadT1.get(contadorCuad - 1).setAccion(variablesAumento.get(0).getLexema().trim());
//                    cuadT1.get(contadorCuad - 1).setArg1(variablesAumento.get(1).getLexema().trim());
//                    cuadT1.get(contadorCuad - 1).setResultado(variablesAumento.get(1).getLexema().trim());
//                }
//                variablesAumento = new ArrayList<>();
//                variablesAumentoBand = 0;
//            }
    }
}
