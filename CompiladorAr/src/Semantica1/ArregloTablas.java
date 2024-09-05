/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semantica1;

import Errores.ListaError;
import Semantica2.Contador2;
import Sintaxis.NodoToken;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class ArregloTablas {

    private final ArrayList<Contador> semantica1Contadores;
    private final ListaError cte;

    public ArregloTablas(ArrayList<Contador> semantica1Contadores, ListaError cte) {
        this.semantica1Contadores = semantica1Contadores;
        this.cte = cte;
    }

    private String[][] suma = {
        {"INT", "REAL", "EXP", "INT", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR", "INT"},
        {"REAL", "REAL", "EXP", "REAL", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR", "REAL"},
        {"EXP", "EXP", "EXP", "EXP", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR", "EXP"},
        {"INT", "REAL", "EXP", "INT", "CHAR[]", "ERROR", "REG", "ERROR", "ERROR", "CHAR"},
        {"CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "CHAR[]", "REG", "ERROR", "ERROR", "CHAR[]"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "BOOL"},
        {"REG", "REG", "REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR", "REG"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "VOID"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "FILE"},
        {"INT", "REAL", "EXP", "CHAR", "CHAR[]", "BOOL", "REG", "VOID", "FILE", "ERROR"}};

    private String[][] residuo = {
        {"INT", "ERROR", "ERROR", "INT", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "INT"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "REAL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "EXP"},
        {"INT", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "CHAR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "CHAR[]"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "BOOL"},
        {"REG", "REG", "REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR", "REG"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "VOID"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "FILE"},
        {"INT", "REAL", "EXP", "CHAR", "CHAR[]", "BOOL", "REG", "VOID", "FILE", "ERROR"}};

    private String[][] resta = {
        {"INT", "REAL", "EXP", "INT", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "INT"},
        {"REAL", "REAL", "EXP", "REAL", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "REAL"},
        {"EXP", "EXP", "EXP", "EXP", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "EXP"},
        {"INT", "REAL", "EXP", "INT", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "CHAR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "CHAR[]", "REG", "ERROR", "ERROR", "CHAR[]"},
        {"ERROR", "ERROR", "ERROR", "CHAR[]", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "BOOL"},
        {"REG", "REG", "REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR", "REG"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "VOID"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "FILE"},
        {"INT", "REAL", "EXP", "CHAR", "CHAR[]", "BOOL", "REG", "VOID", "FILE", "ERROR"}};

    private String[][] multiplicacion = {
        {"INT", "REAL", "EXP", "INT", "REG", "ERROR", "ERROR", "INT"},
        {"REAL", "REAL", "EXP", "REAL", "REG", "ERROR", "ERROR", "REAL"},
        {"EXP", "EXP", "EXP", "EXP", "REG", "ERROR", "ERROR", "EXP"},
        {"INT", "REAL", "EXP", "INT", "REG", "ERROR", "ERROR", "CHAR"},
        {"REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR", "REG"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "VOID"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "FILE"},
        {"INT", "REAL", "EXP", "CHAR", "REG", "VOID", "FILE", "ERROR"}};

    private String[][] division = {
        {"INT", "REAL", "EXP", "ERROR", "REG", "ERROR", "ERROR", "INT"},
        {"REAL", "REAL", "EXP", "ERROR", "REG", "ERROR", "ERROR", "REAL"},
        {"EXP", "EXP", "EXP", "ERROR", "REG", "ERROR", "ERROR", "EXP"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "CHAR"},
        {"REG", "REG", "REG", "REG", "REG", "ERROR", "ERROR", "REG"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "VOID"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "FILE"},
        {"INT", "REAL", "EXP", "CHAR", "REG", "VOID", "FILE", "ERROR"}};

    private String[][] relacionales = {
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR"}};

    private String[][] logico = {
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "BOOL", "BOOL"}};

    private String[][] asignacion = {
        {"INT", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "INT"},
        {"ERROR", "REAL", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REAL"},
        {"ERROR", "ERROR", "EXP", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "EXP"},
        {"ERROR", "ERROR", "ERROR", "CHAR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "CHAR"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "CHAR[]", "ERROR", "ERROR", "ERROR", "ERROR", "CHAR[]"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "BOOL", "ERROR", "ERROR", "ERROR", "BOOL"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "REG", "ERROR", "ERROR", "REG"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "VOID", "ERROR", "VOID"},
        {"ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "ERROR", "FILE", "FILE"},
        {"INT", "REAL", "EXP", "CHAR", "CHAR[]", "BOOL", "REG", "VOID", "FILE", "ERROR"}};

    public NodoToken suma(NodoToken x, NodoToken y) {
        int token = traducirToken(suma[sumaTraduccion(x)][sumaTraduccion(y)]);
        String lexema = suma[sumaTraduccion(x)][sumaTraduccion(y)];
        if (token == -777 || sumaTraduccion(x) == 9 || sumaTraduccion(y) == 9) {
            cte.agregarError(620, "Error en suma", agregarAsignacion(x) + "+" + agregarAsignacion(y), x.getLinea(), "Semantica1");
        }
        if (semantica1Contadores.isEmpty()) {
            semantica1Contadores.add(new Contador(x.getLinea()));
            aumentarContadores(lexema, 0);
        } else {
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                if (semantica1Contadores.get(i).getLinea() == x.getLinea()) {
                    aumentarContadores(lexema, i);
                } else if ((i + 1) == semantica1Contadores.size()) {
                    semantica1Contadores.add(new Contador(x.getLinea()));
                    aumentarContadores(lexema, i + 1);
                }
            }
        }
        return new NodoToken(x.getLinea(), token, lexema);
    }

    private int sumaTraduccion(NodoToken x) {
//        System.out.println(x.getToken() + " - " + x.getLexema().trim());
        switch (x.getToken() + "") {
            case "-105":
                return 0;
            case "-106":
                return 1;
            case "-107":
                return 2;
            case "-108":
                return 3;
            case "-109":
                return 4;
            case "-212":
                return 5;
            case "-213":
                return 5;
            case "-214":
                return 5;
            case "-216":
                return 6;
            case "-243":
                return 6;
            case "-219":
                return 7;
            case "-220":
                return 8;
            case "-777":
                return 9;
        }
        return 9;
    }

    public NodoToken residuo(NodoToken x, NodoToken y) {
        int token = traducirToken(residuo[residuoTraduccion(x)][residuoTraduccion(y)]);
        String lexema = residuo[residuoTraduccion(x)][residuoTraduccion(y)];
        if (token == -777 || sumaTraduccion(x) == 9 || sumaTraduccion(y) == 9) {
            cte.agregarError(621, "Error en residuo", agregarAsignacion(x) + "%" + agregarAsignacion(y), x.getLinea(), "Semantica1");
        }
        if (semantica1Contadores.isEmpty()) {
            semantica1Contadores.add(new Contador(x.getLinea()));
            aumentarContadores(lexema, 0);
        } else {
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                if (semantica1Contadores.get(i).getLinea() == x.getLinea()) {
                    aumentarContadores(lexema, i);
                } else if ((i + 1) == semantica1Contadores.size()) {
                    semantica1Contadores.add(new Contador(x.getLinea()));
                    aumentarContadores(lexema, i + 1);
                }
            }
        }
        return new NodoToken(x.getLinea(), token, lexema);
    }

    private int residuoTraduccion(NodoToken x) {
//        System.out.println(x.getToken() + " - " + x.getLexema().trim());
        switch (x.getToken() + "") {
            case "-105":
                return 0;
            case "-106":
                return 1;
            case "-107":
                return 2;
            case "-108":
                return 3;
            case "-109":
                return 4;
            case "-212":
                return 5;
            case "-213":
                return 5;
            case "-214":
                return 5;
            case "-216":
                return 6;
            case "-243":
                return 6;
            case "-219":
                return 7;
            case "-220":
                return 8;
            case "-777":
                return 9;
        }
        return 9;
    }

    public NodoToken resta(NodoToken x, NodoToken y) {
        int token = traducirToken(resta[restaTraduccion(x)][restaTraduccion(y)]);
        String lexema = resta[restaTraduccion(x)][restaTraduccion(y)];
        if (token == -777 || sumaTraduccion(x) == 9 || sumaTraduccion(y) == 9) {
            cte.agregarError(622, "Error en resta", agregarAsignacion(x) + "-" + agregarAsignacion(y), x.getLinea(), "Semantica1");
        }
        if (semantica1Contadores.isEmpty()) {
            semantica1Contadores.add(new Contador(x.getLinea()));
            aumentarContadores(lexema, 0);
        } else {
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                if (semantica1Contadores.get(i).getLinea() == x.getLinea()) {
                    aumentarContadores(lexema, i);
                } else if ((i + 1) == semantica1Contadores.size()) {
                    semantica1Contadores.add(new Contador(x.getLinea()));
                    aumentarContadores(lexema, i + 1);
                }
            }
        }
        return new NodoToken(x.getLinea(), token, lexema);
    }

    private int restaTraduccion(NodoToken x) {
//        System.out.println(x.getToken() + " - " + x.getLexema().trim());
        switch (x.getToken() + "") {
            case "-105":
                return 0;
            case "-106":
                return 1;
            case "-107":
                return 2;
            case "-108":
                return 3;
            case "-109":
                return 4;
            case "-212":
                return 5;
            case "-213":
                return 5;
            case "-214":
                return 5;
            case "-216":
                return 6;
            case "-243":
                return 6;
            case "-219":
                return 7;
            case "-220":
                return 8;
            case "-777":
                return 9;
        }
        return 9;
    }

    public NodoToken mulplicacion(NodoToken x, NodoToken y) {
        int token = traducirToken(multiplicacion[mulplicacionTraduccion(x)][mulplicacionTraduccion(y)]);
        String lexema = multiplicacion[mulplicacionTraduccion(x)][mulplicacionTraduccion(y)];
        if (token == -777 || sumaTraduccion(x) == 7 || sumaTraduccion(y) == 7) {
            cte.agregarError(623, "Error en multiplicacion", agregarAsignacion(x) + "x" + agregarAsignacion(y), x.getLinea(), "Semantica1");
        }
        if (semantica1Contadores.isEmpty()) {
            semantica1Contadores.add(new Contador(x.getLinea()));
            aumentarContadores(lexema, 0);
        } else {
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                if (semantica1Contadores.get(i).getLinea() == x.getLinea()) {
                    aumentarContadores(lexema, i);
                } else if ((i + 1) == semantica1Contadores.size()) {
                    semantica1Contadores.add(new Contador(x.getLinea()));
                    aumentarContadores(lexema, i + 1);
                }
            }
        }
        return new NodoToken(x.getLinea(), token, lexema);
    }

    private int mulplicacionTraduccion(NodoToken x) {
//        System.out.println(x.getToken() + " - " + x.getLexema().trim());
        switch (x.getToken() + "") {
            case "-105":
                return 0;
            case "-106":
                return 1;
            case "-107":
                return 2;
            case "-108":
                return 3;
            case "-216":
                return 4;
            case "-243":
                return 4;
            case "-219":
                return 5;
            case "-220":
                return 6;
            case "-777":
                return 7;
        }
        return 7;
    }

    public NodoToken division(NodoToken x, NodoToken y) {
        int token = traducirToken(division[divisionTraduccion(x)][divisionTraduccion(y)]);
        String lexema = division[divisionTraduccion(x)][divisionTraduccion(y)];
        if (token == -777 || sumaTraduccion(x) == 7 || sumaTraduccion(y) == 7) {
            cte.agregarError(624, "Error en division", agregarAsignacion(x) + "/" + agregarAsignacion(y), x.getLinea(), "Semantica1");
        }
        if (semantica1Contadores.isEmpty()) {
            semantica1Contadores.add(new Contador(x.getLinea()));
            aumentarContadores(lexema, 0);
        } else {
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                if (semantica1Contadores.get(i).getLinea() == x.getLinea()) {
                    aumentarContadores(lexema, i);
                } else if ((i + 1) == semantica1Contadores.size()) {
                    semantica1Contadores.add(new Contador(x.getLinea()));
                    aumentarContadores(lexema, i + 1);
                }
            }
        }
        return new NodoToken(x.getLinea(), token, lexema);
    }

    private int divisionTraduccion(NodoToken x) {
        switch (x.getToken() + "") {
            case "-105":
                return 0;
            case "-106":
                return 1;
            case "-107":
                return 2;
            case "-108":
                return 3;
            case "-216":
                return 4;
            case "-243":
                return 4;
            case "-219":
                return 5;
            case "-220":
                return 6;
            case "-777":
                return 7;
        }
        return 7;
    }

    public NodoToken relacional(NodoToken x, NodoToken y) {
        int token = traducirToken(relacionales[relacionalTraduccion(x)][relacionalTraduccion(y)]);
        String lexema = relacionales[relacionalTraduccion(x)][relacionalTraduccion(y)];
//        System.out.println(x.getToken() + " - " + y.getToken() + " = " + token);
        if (token == -777 || relacionalTraduccion(x) == 9 || relacionalTraduccion(y) == 9) {
//            cte.agregarError(625, "Error en relacional", agregarAsignacion(x) + "  " + agregarAsignacion(y), x.getLinea(), "Semantica1");
        }
        if (semantica1Contadores.isEmpty()) {
            semantica1Contadores.add(new Contador(x.getLinea()));
            aumentarContadores(lexema, 0);
        } else {
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                if (semantica1Contadores.get(i).getLinea() == x.getLinea()) {
                    aumentarContadores(lexema, i);
                } else if ((i + 1) == semantica1Contadores.size()) {
                    semantica1Contadores.add(new Contador(x.getLinea()));
                    aumentarContadores(lexema, i + 1);
                }
            }
        }
        return new NodoToken(x.getLinea(), token, lexema);
    }

    private int relacionalTraduccion(NodoToken x) {
//        System.out.println(x.getToken() + " - " + x.getLexema().trim());
        switch (x.getToken() + "") {
            case "-105":
                return 0;
            case "-106":
                return 1;
            case "-107":
                return 2;
            case "-108":
                return 3;
            case "-109":
                return 4;
            case "-212":
                return 5;
            case "-213":
                return 5;
            case "-214":
                return 5;
            case "-216":
                return 6;
            case "-243":
                return 6;
            case "-219":
                return 7;
            case "-220":
                return 8;
            case "-777":
                return 9;
        }
        return 9;
    }

    public NodoToken logico(NodoToken x, NodoToken y) {
        int token = traducirToken(logico[asignacionTraduccion(x)][asignacionTraduccion(y)]);
        String lexema = logico[asignacionTraduccion(x)][asignacionTraduccion(y)];
        if (token == -777 || sumaTraduccion(x) == 9 || sumaTraduccion(y) == 9) {
//            cte.agregarError(626, "Error en logico", agregarAsignacion(x) + "  " + agregarAsignacion(y), x.getLinea(), "Semantica1");
        }
        if (semantica1Contadores.isEmpty()) {
            semantica1Contadores.add(new Contador(x.getLinea()));
            aumentarContadores(lexema, 0);
        } else {
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                if (semantica1Contadores.get(i).getLinea() == x.getLinea()) {
                    aumentarContadores(lexema, i);
                } else if ((i + 1) == semantica1Contadores.size()) {
                    semantica1Contadores.add(new Contador(x.getLinea()));
                    aumentarContadores(lexema, i + 1);
                }
            }
        }
        return new NodoToken(x.getLinea(), token, lexema);
    }

    public NodoToken asignacion(NodoToken x, NodoToken y, int regla, ArrayList<Contador2> semantica2Contadores, int ambito) {
        int token = traducirToken(asignacion[asignacionTraduccion(x)][asignacionTraduccion(y)]);
        String lexema = asignacion[asignacionTraduccion(x)][asignacionTraduccion(y)];
        if (token == -777 || sumaTraduccion(x) == 9 || sumaTraduccion(y) == 9) {
//            cte.agregarError(627, "Error en asignacion", agregarAsignacion(x) + "  " + agregarAsignacion(y), x.getLinea(), "Semantica1");
        }
        if (asignacionTraduccion(x) != asignacionTraduccion(y)) {
//            cte.agregarError(631, "Regla " + regla, "Error", y.getLinea(), "Semantica2");
            semantica2Contadores.add(new Contador2(regla));
            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(y.getLexema());
            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(y.getLinea());
            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito);
            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
        } else {
            semantica2Contadores.add(new Contador2(regla));
            semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
            semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(y.getLexema());
            semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(y.getLinea());
            semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(ambito);
            semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Acepta");
        }
        if (semantica1Contadores.isEmpty()) {
            semantica1Contadores.add(new Contador(x.getLinea()));
            aumentarContadores(lexema, 0);
            semantica1Contadores.get(0).setAsignacion(y.getLexema() + "->" + agregarAsignacion(x));
        } else {
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                if (semantica1Contadores.get(i).getLinea() == x.getLinea()) {
                    aumentarContadores(lexema, i);
                    semantica1Contadores.get(i).setAsignacion(y.getLexema() + "->" + agregarAsignacion(x));
                } else if ((i + 1) == semantica1Contadores.size()) {
                    semantica1Contadores.add(new Contador(x.getLinea()));
                    aumentarContadores(lexema, i + 1);
                    semantica1Contadores.get(i).setAsignacion(y.getLexema() + "->" + agregarAsignacion(x));
                }
            }
        }
        return new NodoToken(x.getLinea(), token, lexema);
    }

    private int asignacionTraduccion(NodoToken x) {
//        System.out.println(x.getToken() + " - " + x.getLexema().trim());
        switch (x.getToken() + "") {
            case "-105":
                return 0;
            case "-106":
                return 1;
            case "-107":
                return 2;
            case "-108":
                return 3;
            case "-109":
                return 4;
            case "-212":
                return 5;
            case "-213":
                return 5;
            case "-214":
                return 5;
            case "-216":
                return 6;
            case "-243":
                return 6;
            case "-219":
                return 7;
            case "-220":
                return 8;
            case "-777":
                return 9;
        }
        return 9;
    }

    public String agregarAsignacion(NodoToken x) {
        switch (x.getToken() + "") {
            case "-105":
                return "TInt";
            case "-106":
                return "TReal";
            case "-107":
                return "TExp";
            case "-108":
                return "TChar";
            case "-109":
                return "TChar[]";
            case "-212":
                return "TBool";
            case "-213":
                return "TBool";
            case "-214":
                return "TBool";
            case "-216":
                return "TReg";
            case "-243":
                return "TReg";
            case "-219":
                return "TVoid";
            case "-220":
                return "TFile";
            case "-777":
                return "TVariant";
        }
        return "TVariant";
    }

    private int traducirToken(String token) {
        switch (token) {
            case "INT":
                return -105;
            case "REAL":
                return -106;
            case "EXP":
                return -107;
            case "CHAR":
                return -108;
            case "CHAR[]":
                return -109;
            case "BOOL":
                return -212;
            case "REG":
                return -243;
            case "VOID":
                return -219;
            case "FILE":
                return -220;
        }
        return -777;
    }

    private void aumentarContadores(String lexema, int i) {
        switch (lexema) {
            case "INT":
                semantica1Contadores.get(i).setTint();
                semantica1Contadores.get(i).setTotal();
                break;
            case "REAL":
                semantica1Contadores.get(i).setTreal();
                semantica1Contadores.get(i).setTotal();
                break;
            case "EXP":
                semantica1Contadores.get(i).setTexp();
                semantica1Contadores.get(i).setTotal();
                break;
            case "CHAR":
                semantica1Contadores.get(i).setTchar();
                semantica1Contadores.get(i).setTotal();
                break;
            case "CHAR[]":
                semantica1Contadores.get(i).setTcharll();
                semantica1Contadores.get(i).setTotal();
                break;
            case "BOOL":
                semantica1Contadores.get(i).setTbool();
                semantica1Contadores.get(i).setTotal();
                break;
            case "REG":
                semantica1Contadores.get(i).setTreg();
                semantica1Contadores.get(i).setTotal();
                break;
            case "VOID":
                semantica1Contadores.get(i).setTvoid();
                semantica1Contadores.get(i).setTotal();
                break;
            case "FILE":
                semantica1Contadores.get(i).setTvoid();
                semantica1Contadores.get(i).setTotal();
                break;
            default:
                semantica1Contadores.get(i).setTvariant();
                semantica1Contadores.get(i).setTotal();
                break;
        }
    }

    public ArrayList<Contador> getSemantica1Contadores() {
        return semantica1Contadores;
    }
}
