package Sintaxis;

import Cuadruplos.Cuadruplos;
import Ambito.Ambito;
import Errores.ListaError;
import Externo.Excels;
import Externo.MySql;
import Semantica1.ArregloTablas;
import Semantica1.Contador;
import Semantica1.Semantica1;
import Semantica2.Contador2;
import Semantica2.Semantica2;
import Semantica3.Contador3;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Sintaxis {

    Excels excel;
    ListaToken oper;
    Ambito ambito;
    Semantica1 semantica1;
    Semantica2 semantica2;
    Cuadruplos cuadruplos;
    private Stack<NodoToken> cuadruplo;
    int[][] matrizSintaxis;
    int[][] producciones = ArregloProducciones.producciones;
    Stack<Integer> pilaSintaxis = new Stack<>();
    ListaError cte;
    String ant = "";
    boolean bandCuad;
    MySql sql;
    JTable TAmbito;
    JTable TCuad;
    JTable TCuadT2;
    ArregloTablas tablas;
    ArrayList<Contador2> semantica2Contadores;
    ArrayList<Contador3> semantica3Contadores;

    public Sintaxis(ListaToken oper, ListaError cte, MySql sql, JTable TAmbito, ArrayList<Contador> semantica1Contadores, ArrayList<Contador2> semantica2Contadores, ArrayList<Contador3> semantica3Contadores, JTable TCuad, JTable TCuadT2) {
        this.excel = new Excels();
        this.sql = sql;
        this.TAmbito = TAmbito;
        this.TCuad = TCuad;
        this.TCuadT2 = TCuadT2;
        this.tablas = new ArregloTablas(semantica1Contadores, cte);
        this.ambito = new Ambito(this.sql);
        this.semantica1 = new Semantica1(this.sql, tablas);
        this.semantica2 = new Semantica2();
        this.cuadruplos = new Cuadruplos();
        this.matrizSintaxis = excel.cargarExcelSintaxis();
        this.oper = oper;
        this.semantica2Contadores = semantica2Contadores;
        this.semantica3Contadores = semantica3Contadores;
        this.cte = cte;
    }

    public void iniciarSintaxis() {
        cicloSintaxis();
    }

    private void cicloSintaxis() {
        pilaSintaxis.push(-1000);
        pilaSintaxis.push(0);
        oper.insertarUltimo(oper.getUlt().getLinea(), -1000, "א");
        int fila = 0;
        int columna = 0;
        bandCuad = true;
        boolean banderCua = false;
        boolean banderPilaCua = false;
        boolean banderMainCua = false;
        int ultimaLinea = oper.getUlt().getLinea();
        while (pilaSintaxis.empty() == false && oper.listaVacia() == false) {
            switch (pilaSintaxis.peek()) {
                case 300:
                    if (!banderPilaCua) {
                        cuadruplo = new Stack<>();
                        banderPilaCua = true;
                        banderMainCua = true;
                    }
                    if (banderMainCua) {
                        cuadruplo.add(new NodoToken(ambito.getAmbitoActual(), -502, "main"));
                    }
                    banderCua = true;
                    break;
                case 301:
                    banderCua = false;
                    break;
                case 303:
                    banderMainCua = true;
                    break;
                case 311:
                    if (!banderPilaCua) {
                        cuadruplo = new Stack<>();
                        banderPilaCua = true;
                    }
                    banderMainCua = false;
                    banderCua = true;
                    break;
                case 313:
                    banderCua = false;
                    break;
                case 314:
                    banderCua = false;
                    break;
                case 350:
                    banderCua = false;
                    break;
                case 351:
                    banderCua = true;
                    break;
                case -376:
                case -145:
                    if (banderPilaCua) {
                        banderCua = false;
                    }
                    break;
                case -377:
                case -146:
                    if (banderPilaCua) {
                        banderCua = true;
                    }
                    break;
            }
            try {
                semantica1.pila(pilaSintaxis, oper, ambito.getPadreHijoAmbito(), semantica2Contadores, cte, semantica3Contadores);
            } catch (Exception e) {
                this.semantica1 = new Semantica1(this.sql, this.tablas);
            }
            if (banderCua && cuadruploTokens(pilaSintaxis.peek())) {
                cuadruplo.add(new NodoToken(ambito.getAmbitoActual(), oper.obtenerPrimero().getToken(), oper.obtenerPrimero().getLexema()));
            }
            if (banderCua && pilaSintaxis.peek() == 311) {
                cuadruplo.add(new NodoToken(ambito.getAmbitoActual(), -501, ambito.getNombreVariable()));
                banderCua = false;
            }
            try {
                semantica2.pila(pilaSintaxis, oper, ambito.getPadreHijoAmbito(), semantica1, semantica2Contadores, cte, sql);
            } catch (Exception e) {
                this.semantica2 = new Semantica2();
            }
            ambito.pila(pilaSintaxis, oper, semantica2Contadores, cte);
            ultimaLinea = oper.getUlt().getLinea();
            int produccion, lugar;
            if (pilaSintaxis.peek() > 0 && pilaSintaxis.peek() < 300) {
                fila = pilaSintaxis.peek();
                columna = new Tokens().getColumn(oper.obtenerPrimero());
                produccion = matrizSintaxis[fila][columna];
//                System.out.print("Sintaxis: Fila:" + (fila + 1) + "/ Columna:" + (columna + 1) + "/ Produccion:" + produccion + "/ Lexema: " + oper.obtenerPrimero().getLexema().trim());
//                System.out.println("");
            } else {
                produccion = 0;
            }
            if ((pilaSintaxis.peek() >= 0 && produccion < 500 && produccion != 137) && !oper.listaVacia()) {
                pilaSintaxis.pop();
                lugar = produccion;
                for (int i = 0; i < producciones[lugar].length; i++) {
                    pilaSintaxis.push(producciones[lugar][i]);
                }
            } else if (produccion == 137) {
                pilaSintaxis.pop();
            } else if (produccion > 500) {
                switch (produccion) {
                    default:
                        cte.agregarError(produccion, "Se esperaba " + oper.obtenerPrimero().getLexema(), ant, oper.mostrarLineaPrimero(), "Sintaxis");
                        System.out.println("Sintaxis: Error:" + oper.obtenerPrimero().getLexema().trim() + "/ Fila:" + fila + "/ Columna:" + columna + "/ Estado:" + produccion);
                        break;
                }
                oper.eliminarInicio();
            } else {
                ant = oper.mostrarLexemaPrimero();
//                System.out.print("Sintaxis: Se esperaba:" + pilaSintaxis.peek() + "/ Se recibió:" + oper.mostrarPrimero() + " Token:" + oper.mostrarLexemaPrimero().trim());
//                System.out.println("");
                if (pilaSintaxis.peek() == oper.mostrarPrimero()) {
                    if (ambito.comprobarVariableDuplicada()) {
                        cte.agregarError(601, "Variable duplicada", "Variable:" + ambito.getNombreVariable().trim(), ambito.getVaribleLinea(), "Ambito");
                        ambito.setDuplicadaVariable(false);
                    }
                    if (ambito.comprobarRegNoDeclarado()) {
                        cte.agregarError(602, "Registro No Declarado", "Registro:" + ambito.getNombreVariable().trim(), ambito.getVaribleLinea(), "Ambito");
                        ambito.setRegNoDeclarado(false);
                    }
                    if (ambito.isVarNoDeclarado()) {
                        cte.agregarError(603, "Variable No Declarado", "Variable:" + ambito.getNombreVariable().trim(), ambito.getVaribleLinea(), "Ambito");
                        cte.agregarError(632, "Regla 1030", "Error", semantica1.getLastLinea(), "Semantica2");
                        semantica2Contadores.add(new Contador2(1030));
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setTopeLinea("id");
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setValorReal(semantica1.getLastLexema());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setLinea(semantica1.getLastLinea());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setAmbito(semantica1.getLastAmbito());
                        semantica2Contadores.get(semantica2Contadores.size() - 1).setEdo("Error");
                        ambito.setVarNoDeclarado(false);
                    }
                    oper.eliminarInicio();
                    pilaSintaxis.pop();
                } else {
                    cte.agregarError(597, "Fuerza bruta", oper.mostrarLexemaPrimero(), oper.mostrarLineaPrimero(), "Sintaxis");
                    imprimirPila();
                    vaciarPila();
                    break;
                }
            }
        }
        finalAmbito();
        if (!ambito.comprobarAmbitobase()) {
            cte.agregarError(600, "Desfase de Ámbito", "Ámbito discrepante: " + ambito.getAmbitoActual(), ultimaLinea, "Ámbito");
        }
        if (bandCuad) {
            cuadruplos.cuadruplos(cuadruplo, TCuad, TCuadT2);
        }
    }

    private void finalAmbito() {
        DefaultTableModel modeloTabla = new DefaultTableModel(0, 0);
        TAmbito.setModel(modeloTabla);
        TAmbito.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
        modeloTabla.addColumn("Ambito");
        modeloTabla.addColumn("char");
        modeloTabla.addColumn("char[]");
        modeloTabla.addColumn("int");
        modeloTabla.addColumn("real");
        modeloTabla.addColumn("bool");
        modeloTabla.addColumn("exp");
        modeloTabla.addColumn("reg");
        modeloTabla.addColumn("void");
        modeloTabla.addColumn("file");
        modeloTabla.addColumn("err");
        modeloTabla.addColumn("total");
        for (int i = 0; i < ambito.getContador().size(); i++) {
            modeloTabla.addRow(new Object[]{
                i,
                ambito.getContador().get(i).getChaR(),
                ambito.getContador().get(i).getChaRR(),
                ambito.getContador().get(i).getInT(),
                ambito.getContador().get(i).getReal(),
                ambito.getContador().get(i).getBool(),
                ambito.getContador().get(i).getExp(),
                ambito.getContador().get(i).getReg(),
                ambito.getContador().get(i).getVoiD(),
                ambito.getContador().get(i).getFile(),
                ambito.getContador().get(i).getError(),
                ambito.getContador().get(i).getTotal()});
        }
    }

    private void imprimirPila() {
        bandCuad = false;
        Object[] arr = pilaSintaxis.toArray();
        for (int i = arr.length - 1; i > -1; i--) {
            System.out.println("Sintaxis: pila[" + i + "] " + arr[i]);
        }
    }

    private void vaciarPila() {
        while (!oper.listaVacia()) {
            oper.eliminarInicio();
        }
    }

    private boolean cuadruploTokens(int token) {
        boolean band = true;
        switch (token) {
            case -140:
            case -141:
            case -143:
            case -144:
            case -147:
            case -149:
            case -208:
            case -211:
            case -212:
            case -217:
            case -218:
            case -219:
            case -220:
            case -226:
            case -243:
                band = false;
                break;
        }
        if (token >= 0) {
            band = false;
        }
        return band;
    }
}
