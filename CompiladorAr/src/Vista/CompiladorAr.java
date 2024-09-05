package Vista;

import Cuadruplos.ContadorT2;
import Semantica1.Contador;
import Semantica2.Contador2;
import Sintaxis.Sintaxis;
import Errores.ListaError;
import Errores.NodoError;
import Externo.Excels;
import Externo.Linea;
import Externo.MySql;
import Lexico.ColumnaExcel;
import Lexico.Contadores;
import Semantica3.Contador3;
import Sintaxis.ListaToken;
import Sintaxis.NodoToken;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import jxl.Cell;
import jxl.CellType;
import jxl.Sheet;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;

public class CompiladorAr extends javax.swing.JFrame {

    Excels excel;
    Cell ncelLex;
    String texto;
    Linea nl;
    ColumnaExcel cl;
    int cicloLexico;
    //contadores
    int error, id, coment, rese, dec, text, flt, caract, exp, arit, mono, logico, rel, bit, punt, agrup, asign, linea;
    LinkedList<NodoToken> token;
    LinkedList<NodoError> mistake;
    LinkedList<Contadores> con;
    static ArrayList<Contador> semantica1Contadores;
    static ArrayList<Contador2> semantica2Contadores;
    static ArrayList<Contador3> semantica3Contadores;
    static ArrayList<ContadorT2> cuadruplosContadores;
    private String[] metodos = {"Clean()", "Sqrt()", "Sqrt_p1()", "Sqr()", "Sqr_p1()", "Pow()", "Pow_p1()", "Pow_p2()",
        "Sqrtv()", "Sqrtv_p1()", "Sqrtv_p2()", "Ins()", "Ins_p1()", "Ins_p2()", "Ins_p3()", "Conv()", "Conv_p1()", "Conv_p2()",
        "Conv_p3()", "Up()", "Up_p1()", "Low()", "Low_p1()", "Len()", "Len_p1()", "Val()", "Val_p1()", "Asc()", "Asc_p1()",
        "$()", "$_p1()", "$_p2()", "$_p3()", "~()", "~_p1()", "<+()", "<+_p1()", "<+_p2()", ">+()", ">+_p1()", ">+_p2()",};
    ListaToken oper;
    Sintaxis syn;
    ListaError cte;
    MySql sql;
    Cuadruplos cuad;

    public CompiladorAr() {
        initComponents();
        init();
    }

    private void init() {
        TTokens.removeAll();
        TMistakes.removeAll();
        TAmbito.removeAll();
        TCon.removeAll();
        token = new LinkedList<>();
        mistake = new LinkedList<>();
        con = new LinkedList<>();
        semantica1Contadores = new ArrayList<>();
        semantica2Contadores = new ArrayList<>();
        semantica3Contadores = new ArrayList<>();
        cuadruplosContadores = new ArrayList<>();
        for (int i = 0; i < metodos.length; i++) {
            semantica3Contadores.add(new Contador3(metodos[i]));
        }
        oper = new ListaToken();
        excel = new Excels();
        error = id = coment = rese = dec = text = flt = caract = exp = arit = mono = logico = rel = bit = punt = agrup = asign = 0;
        linea = 1;
        texto = "";
        syn = null;
        cte = new ListaError(TTokens, TMistakes);
        nl = new Linea(TAText);
        jSP.setRowHeaderView(nl);
        cl = new ColumnaExcel();
        cicloLexico = 0;
        cuad = new Cuadruplos();
    }

    public void showCont() {
        Object[][] cont = new Object[con.size()][17];
        for (int j = 0; j < con.size(); j++) {
            cont[j][0] = con.get(j).getErrores()+(cte.getErrores()-1);
            cont[j][1] = con.get(j).getId();
            cont[j][2] = con.get(j).getComent();
            cont[j][3] = con.get(j).getPr();
            cont[j][4] = con.get(j).getCedec();
            cont[j][5] = con.get(j).getCtext();
            cont[j][6] = con.get(j).getCdeci();
            cont[j][7] = con.get(j).getCcar();
            cont[j][8] = con.get(j).getCexp();
            cont[j][9] = con.get(j).getArit();
            cont[j][10] = con.get(j).getMono();
            cont[j][11] = con.get(j).getLogico();
            cont[j][12] = con.get(j).getRel();
            cont[j][13] = con.get(j).getBit();
            cont[j][14] = con.get(j).getPunt();
            cont[j][15] = con.get(j).getAgrup();
            cont[j][16] = con.get(j).getAsig();
        }
        TCon.setModel(new javax.swing.table.DefaultTableModel(cont, new String[]{"Errores", "Id", "Coment", "Reser",
            "Dec", "Text", "Decimal", "Car", "Expo", "Arit", "Mono", "Logico", "Bit", "Puntuacion",
            "Agrupacion", "Asignacion", "Rela"}));
    }

    public void showTokens() {
        Object[][] tok = new Object[token.size()][3];
        for (int j = 0; j < token.size(); j++) {
            tok[j][0] = token.get(j).getLinea();
            tok[j][1] = token.get(j).getToken();
            tok[j][2] = token.get(j).getLexema();
        }
        TTokens.setModel(new javax.swing.table.DefaultTableModel(tok, new String[]{"Linea", "Token", "Lexema"}));
    }

    public void showMistakes() {
        Object[][] mis = new Object[mistake.size()][5];
        for (int j = 0; j < mistake.size(); j++) {
            mis[j][0] = mistake.get(j).getLinea();
            mis[j][1] = mistake.get(j).getError();
            mis[j][2] = mistake.get(j).getDescripcion();
            mis[j][3] = mistake.get(j).getLexema();
            mis[j][4] = mistake.get(j).getTipo();
        }
        TMistakes.setModel(new javax.swing.table.DefaultTableModel(mis, new String[]{"Linea", "Error", "Descripcion", "Lexema", "Tipo"}));
    }

    public void tablaSemantica1() {
        Object[][] sem1 = new Object[semantica1Contadores.size() + 1][13];
        for (int j = 0; j < semantica1Contadores.size(); j++) {
            sem1[j][0] = semantica1Contadores.get(j).getLinea();
            sem1[j][1] = semantica1Contadores.get(j).getTint();
            sem1[j][2] = semantica1Contadores.get(j).getTreal();
            sem1[j][3] = semantica1Contadores.get(j).getTexp();
            sem1[j][4] = semantica1Contadores.get(j).getTchar();
            sem1[j][5] = semantica1Contadores.get(j).getTcharll();
            sem1[j][6] = semantica1Contadores.get(j).getTbool();
            sem1[j][7] = semantica1Contadores.get(j).getTreg();
            sem1[j][8] = semantica1Contadores.get(j).getTvoid();
            sem1[j][9] = semantica1Contadores.get(j).getTfile();
            sem1[j][10] = semantica1Contadores.get(j).getTvariant();
            sem1[j][11] = semantica1Contadores.get(j).getTotal();
            sem1[j][12] = semantica1Contadores.get(j).getAsignacion();
        }
        for (int j = semantica1Contadores.size(); j < semantica1Contadores.size() + 1; j++) {
            int aux = 0;
            sem1[j][0] = "Total";
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTint();
            }
            sem1[j][1] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTreal();
            }
            sem1[j][2] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTexp();
            }
            sem1[j][3] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTchar();
            }
            sem1[j][4] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTcharll();
            }
            sem1[j][5] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTbool();
            }
            sem1[j][6] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTreg();
            }
            sem1[j][7] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTvoid();
            }
            sem1[j][8] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTfile();
            }
            sem1[j][9] = aux;
            aux = 0;
            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTvariant();
            }
            sem1[j][10] = aux;
            aux = 0;

            for (int i = 0; i < semantica1Contadores.size(); i++) {
                aux += semantica1Contadores.get(i).getTotal();
            }
            sem1[j][11] = aux;
            sem1[j][12] = j;
        }
        TSemanica1.setModel(new javax.swing.table.DefaultTableModel(sem1, new String[]{"Linea", "Tint", "Treal", "Texp", "Tchar", "Tchar[]", "Tbool", "Treg", "Tvoid", "Tfile", "Tvaraint", "total", "Asinacion"}));
    }

    public void tablaSemantica2() {
        Object[][] sem2 = new Object[semantica2Contadores.size()][7];
        for (int j = 0; j < semantica2Contadores.size(); j++) {
            sem2[j][0] = semantica2Contadores.get(j).getRegla();
            sem2[j][1] = semantica2Contadores.get(j).getFuncion();
            sem2[j][2] = semantica2Contadores.get(j).getTopeLinea();
            sem2[j][3] = semantica2Contadores.get(j).getValorReal();
            sem2[j][4] = semantica2Contadores.get(j).getLinea();
            sem2[j][5] = semantica2Contadores.get(j).getEdo();
            sem2[j][6] = semantica2Contadores.get(j).getAmbito();
        }
        TSemanica2.setModel(new javax.swing.table.DefaultTableModel(sem2, new String[]{"Regla", "Función", "Tope Pila", "Valor Real", "Linea", "Edo", "Ambito"}));
    }

    public void tablaSemantica3() {
        Object[][] sem2 = new Object[semantica3Contadores.size()][6];
        for (int j = 0; j < semantica3Contadores.size(); j++) {
            sem2[j][0] = semantica3Contadores.get(j).getFuncion();
            sem2[j][1] = semantica3Contadores.get(j).getEntrada();
            sem2[j][2] = semantica3Contadores.get(j).getSalida();
            sem2[j][3] = semantica3Contadores.get(j).getAceptados();
            sem2[j][4] = semantica3Contadores.get(j).getErrores();
        }
        TSemanica3.setModel(new javax.swing.table.DefaultTableModel(sem2, new String[]{"Función", "Entradas", "Salidas", "Aceptados", "Errores"}));
    }
//Leemos el archivo

    private String abrirArchivo() {
        String aux = "";
        String texto = "";
        int li = -1;
        try {
            JFileChooser file = new JFileChooser();
            file.showOpenDialog(lbt);
            File abre = file.getSelectedFile();
            if (abre != null) {
                FileReader archivos = new FileReader(abre);
                BufferedReader lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    li++;
                }
                archivos = new FileReader(abre);
                lee = new BufferedReader(archivos);
                while ((aux = lee.readLine()) != null) {
                    if (li != 0) {
                        texto += aux + "\n";
                    } else {
                        texto += aux;
                    }
                }
                lee.close();
            }
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex + ""
                    + "\nNo se ha encontrado el archivo",
                    "ADVERTENCIA!!!", JOptionPane.WARNING_MESSAGE);
        }
        return texto;
    }

    public void leeMatriz() throws WriteException, IOException, BiffException {
        texto = TAText.getText();
        if (!texto.equals("")) {
            File fileName = new File("Ultima prueba.txt");
            BufferedWriter outFile = null;
            try {
                outFile = new BufferedWriter(new FileWriter(fileName));
                TAText.write(outFile);   // *** here: ***
            } catch (IOException ex) {
                ex.printStackTrace();
            } finally {
                if (outFile != null) {
                    try {
                        outFile.close();
                    } catch (IOException e) {
                    }
                }
            }
            compilar(excel.cargarExcelLexico());
        } else {
            System.out.println("Text Area vacia");
        }
    }

    public void compilar(Sheet s) {
        String lexema = "", descError = "", tipo = "";
        char car = ' ';
        int columna, estado = 0;
        boolean end = false;
        TAText.setText(TAText.getText() + "\n");
        while (cicloLexico < TAText.getText().length()) {
            car = TAText.getText().charAt(cicloLexico);
            if (car == '\n') {
                linea++;
            }
            columna = cl.Ciclo(car);
            ncelLex = s.getCell(columna, estado);
            if (ncelLex.getType() == CellType.NUMBER) {
                estado = Integer.parseInt(ncelLex.getContents());
            }
            if (estado < 0) {
                end = false;
                switch (estado) {
                    case -100:
                        switch (lexema.trim()) {
                            case "if":
                                estado = -200;
                                rese++;
                                break;
                            case "then":
                                estado = -201;
                                rese++;
                                break;
                            case "while":
                                estado = -202;
                                rese++;
                                break;
                            case "do":
                                estado = -203;
                                rese++;
                                break;
                            case "for":
                                estado = -204;
                                rese++;
                                break;
                            case "func":
                                estado = -205;
                                rese++;
                                break;
                            case "Proc":
                                estado = -206;
                                rese++;
                                break;
                            case "switch":
                                estado = -207;
                                rese++;
                                break;
                            case "INT":
                                estado = -208;
                                rese++;
                                break;
                            case "String":
                                estado = -209;
                                rese++;
                                break;
                            case "float":
                                estado = -210;
                                rese++;
                                break;
                            case "REAL":
                                estado = -211;
                                rese++;
                                break;
                            case "BOOL":
                                estado = -212;
                                rese++;
                                break;
                            case "true":
                                estado = -213;
                                rese++;
                                break;
                            case "false":
                                estado = -214;
                                rese++;
                                break;
                            case "main":
                                estado = -215;
                                rese++;
                                break;
                            case "reg":
                                estado = -216;
                                rese++;
                                break;
                            case "CHAR":
                                estado = -217;
                                rese++;
                                break;
                            case "EXP":
                                estado = -218;
                                rese++;
                                break;
                            case "VOID":
                                estado = -219;
                                rese++;
                                break;
                            case "FILE":
                                estado = -220;
                                rese++;
                                break;
                            case "else":
                                estado = -221;
                                rese++;
                                break;
                            case "repeat":
                                estado = -222;
                                rese++;
                                break;
                            case "until":
                                estado = -223;
                                rese++;
                                break;
                            case "case":
                                estado = -224;
                                rese++;
                                break;
                            case "default":
                                estado = -225;
                                rese++;
                                break;
                            case "break":
                                estado = -226;
                                rese++;
                                break;
                            case "return":
                                estado = -227;
                                rese++;
                                break;
                            case "clean":
                                estado = -244;
                                rese++;
                                break;
                            case "sqrt":
                                estado = -228;
                                rese++;
                                break;
                            case "sqr":
                                estado = -229;
                                rese++;
                                break;
                            case "sqrtv":
                                estado = -230;
                                rese++;
                                break;
                            case "pow":
                                estado = -231;
                                rese++;
                                break;
                            case "ins":
                                estado = -232;
                                rese++;
                                break;
                            case "conv":
                                estado = -233;
                                rese++;
                                break;
                            case "up":
                                estado = -234;
                                rese++;
                                break;
                            case "low":
                                estado = -235;
                                rese++;
                                break;
                            case "len":
                                estado = -236;
                                rese++;
                                break;
                            case "asc":
                                estado = -237;
                                rese++;
                                break;
                            case "val":
                                estado = -238;
                                rese++;
                                break;
                            case "setcolorf":
                                estado = -239;
                                rese++;
                                break;
                            case "setcolorb":
                                estado = -240;
                                rese++;
                                break;
                            case "getcolorf":
                                estado = -241;
                                rese++;
                                break;
                            case "getcolorb":
                                estado = -242;
                                rese++;
                                break;
                            case "REG":
                                estado = -243;
                                rese++;
                                break;
                            default:
                                id++;
                                break;
                        }
                        break;
                    case -101:
                        arit++;
                        break;// /
                    case -102:
                        coment++;
                        break;// //
                    case -103:
                        asign++;
                        break;// /=
                    case -104:
                        coment++;
                        break;// /* */
                    case -105:
                        dec++;
                        break;// dec
                    case -106:
                        flt++;
                        break;// deci
                    case -107:
                        exp++;
                        break;// expo
                    case -108:
                        caract++;
                        break;// caracter
                    case -109:
                        text++;
                        break;// texto
                    case -110:
                        arit++;
                        break;// +
                    case -111:
                        mono++;
                        break;// ++
                    case -112:
                        asign++;
                        break;// +=
                    case -113:
                        arit++;
                        break;// *
                    case -114:
                        mono++;
                        break;// **
                    case -115:
                        asign++;
                        break;// *=
                    case -116:
                        arit++;
                        break;// -
                    case -117:
                        mono++;
                        break;// --
                    case -118:
                        asign++;
                        break;// -=
                    case -119:
                        arit++;
                        break;// %
                    case -120:
                        arit++;
                        break;// ^
                    case -121:
                        logico++;
                        break;// !
                    case -122:
                        rel++;
                        break;// !=
                    case -123:
                        bit++;
                        break;// &
                    case -124:
                        logico++;
                        break;// &&
                    case -125:
                        bit++;
                        break;// |
                    case -126:
                        logico++;
                        break;// ||
                    case -127:
                        logico++;
                        break;// #
                    case -128:
                        rel++;
                        break;// <
                    case -129:
                        bit++;
                        break;// <<
                    case -130:
                        rel++;
                        break;// <=
                    case -131:
                        bit++;
                        break;// <+
                    case -132:
                        rel++;
                        break;// >
                    case -133:
                        bit++;
                        break;// >>
                    case -134:
                        rel++;
                        break;// >=
                    case -135:
                        bit++;
                        break;// >+
                    case -136:
                        asign++;
                        break;// =
                    case -137:
                        rel++;
                        break;// ==
                    case -138:
                        rel++;
                        break;// =<
                    case -139:
                        rel++;
                        break;// =>
                    case -140:
                        punt++;
                        break;// ;
                    case -141:
                        punt++;
                        break;// ,
                    case -142:
                        punt++;
                        break;// .
                    case -143:
                        agrup++;
                        break;// (
                    case -144:
                        agrup++;
                        break;// )
                    case -145:
                        agrup++;
                        break;// [
                    case -146:
                        agrup++;
                        break;// ]
                    case -147:
                        agrup++;
                        break;// {
                    case -148:
                        agrup++;
                        break;// }
                    case -149:
                        punt++;
                        break;// :
                    case -150:
                        arit++;
                        break;// $
                    case -151:
                        arit++;
                        break;// ~
                }
                if (end == false) {
                    if (car == '\n') {
                        linea--;
                        if (estado != -102 && estado != -104) {
                            oper.insertarUltimo(linea, estado, lexema);
                            cte.agregarToken(estado, lexema, linea);
                        }
                    } else {
                        if (estado != -102 && estado != -104) {
                            oper.insertarUltimo(linea, estado, lexema);
                            cte.agregarToken(estado, lexema, linea);
                        }
                    }
                } else if (end == true) {
                    if (car == '\n') {
                        linea--;
                    }
                }
                estado = 0;
                lexema = "";

            } else if (estado >= 500) {
                error++;
                switch (estado) {
                    case 501:
                        descError = "Se esperaba una numero";
                        tipo = "Lexico";
                        break;
                    case 502:
                        descError = "Se esperaba + o -";
                        tipo = "Lexico";
                        break;
                    case 503:
                        descError = "No se aceptan salto de linea, tab y espacio";
                        tipo = "Lexico";
                        break;
                    case 504:
                        lexema = "No se aceptan salto de linea, tab y espacio";
                        tipo = "Lexico";
                        break;
                    default:
                        descError = "Error";
                        tipo = "Lexico";
                        break;
                }
                if (estado == 500) {
                    lexema += car;
                    cte.agregarError(estado, descError, lexema, linea, tipo);
                    estado = 0;
                    lexema = "";
                    cicloLexico++;
                } else {
                    cte.agregarError(estado, descError, lexema, linea, tipo);
                    estado = 0;
                    lexema = "";
                }
            } else {
                if (car == ' ' || car == '\r') {//Quitar los espacios 
                    car = '\00';
                    lexema += car;
                    cicloLexico++;
                } else if (car != ' ') {
                    lexema += car;
                    cicloLexico++;
                }
            }
        }
        con.add(new Contadores(error, id, coment, rese, dec, text, flt, caract, exp, arit, mono, logico, rel, bit, punt, agrup, asign, linea));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("nchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        T4 = new javax.swing.JTable();
        lbt = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TSemanica1 = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        TSemanica2 = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        TSemanica3 = new javax.swing.JTable();
        jScrollPane9 = new javax.swing.JScrollPane();
        TCuad = new javax.swing.JTable();
        jSP = new javax.swing.JScrollPane();
        TAText = new javax.swing.JTextArea();
        jScrollPane1 = new javax.swing.JScrollPane();
        TTokens = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        TMistakes = new javax.swing.JTable();
        btnTxt = new javax.swing.JButton();
        btnCompilar = new javax.swing.JButton();
        btnExcel = new javax.swing.JToggleButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TCon = new javax.swing.JTable();
        btnUltima = new javax.swing.JToggleButton();
        btnExcel2 = new javax.swing.JToggleButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        TAmbito = new javax.swing.JTable();
        btnCadruplo = new javax.swing.JToggleButton();

        T4.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Linea", "Error"
            }
        ));
        T4.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane4.setViewportView(T4);

        TSemanica1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Linea", "TInt", "TReal", "TExp", "TChar", "TChar[]", "TBool", "TReg", "TVoid", "TFile", "Tvariant", "Total"
            }
        ));
        TSemanica1.setMinimumSize(new java.awt.Dimension(1, 64));
        TSemanica1.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane6.setViewportView(TSemanica1);
        if (TSemanica1.getColumnModel().getColumnCount() > 0) {
            TSemanica1.getColumnModel().getColumn(4).setHeaderValue("TChar");
            TSemanica1.getColumnModel().getColumn(5).setHeaderValue("TChar[]");
            TSemanica1.getColumnModel().getColumn(6).setHeaderValue("TBool");
            TSemanica1.getColumnModel().getColumn(7).setHeaderValue("TReg");
            TSemanica1.getColumnModel().getColumn(8).setHeaderValue("TVoid");
            TSemanica1.getColumnModel().getColumn(9).setHeaderValue("TFile");
            TSemanica1.getColumnModel().getColumn(10).setHeaderValue("Tvariant");
            TSemanica1.getColumnModel().getColumn(11).setHeaderValue("Total");
        }

        TSemanica2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null}
            },
            new String [] {
                "Regla", "Tope Pila", "Valor Real", "Linea", "Edo", "Ambito"
            }
        ));
        TSemanica2.setMinimumSize(new java.awt.Dimension(1, 64));
        TSemanica2.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane7.setViewportView(TSemanica2);
        if (TSemanica2.getColumnModel().getColumnCount() > 0) {
            TSemanica2.getColumnModel().getColumn(4).setResizable(false);
            TSemanica2.getColumnModel().getColumn(4).setHeaderValue("Edo");
            TSemanica2.getColumnModel().getColumn(5).setHeaderValue("Ambito");
        }

        TSemanica3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Funcion", "Entradas", "Salidas", "Aceptados", "Errores"
            }
        ));
        TSemanica3.setMinimumSize(new java.awt.Dimension(1, 64));
        TSemanica3.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane8.setViewportView(TSemanica3);

        TCuad.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null}
            },
            new String [] {
                "Funcion", "Entradas", "Salidas", "Aceptados", "Errores"
            }
        ));
        TCuad.setMinimumSize(new java.awt.Dimension(1, 64));
        TCuad.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane9.setViewportView(TCuad);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 255, 204));
        setMinimumSize(new java.awt.Dimension(500, 1));
        setResizable(false);

        TAText.setColumns(20);
        TAText.setFont(new java.awt.Font("Monospaced", 1, 24)); // NOI18N
        TAText.setRows(5);
        TAText.setMaximumSize(new java.awt.Dimension(421, 575));
        TAText.setSelectionColor(new java.awt.Color(153, 153, 255));
        jSP.setViewportView(TAText);

        TTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Linea", "Token", "Lexema"
            }
        ));
        TTokens.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(TTokens);

        TMistakes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Linea", "Error", "Descripcion", "Lexema", "Tipo"
            }
        ));
        TMistakes.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(TMistakes);

        btnTxt.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnTxt.setText("Cargar");
        btnTxt.setBorder(null);
        btnTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTxtActionPerformed(evt);
            }
        });

        btnCompilar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCompilar.setText("Compilar");
        btnCompilar.setBorder(null);
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnExcel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExcel.setText("Excel");
        btnExcel.setBorder(null);
        btnExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcelActionPerformed(evt);
            }
        });

        TCon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Errores", "Id", "Coment", "Reser", "Dec", "Text", "Decimal", "Car", "Arit", "Mono", "Logico", "Bit", "Puntuacion", "Agrupacion", "Asignacion", "Rela"
            }
        ));
        TCon.setMinimumSize(new java.awt.Dimension(1, 64));
        TCon.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane3.setViewportView(TCon);

        btnUltima.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        btnUltima.setText("Ultima Prueba");
        btnUltima.setBorder(null);
        btnUltima.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUltimaActionPerformed(evt);
            }
        });

        btnExcel2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btnExcel2.setText("Reiniciar");
        btnExcel2.setBorder(null);
        btnExcel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcel2ActionPerformed(evt);
            }
        });

        TAmbito.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Ambito", "char", "char[]", "int", "real", "bool", "exp", "reg", "void", "file", "err", "total"
            }
        ));
        TAmbito.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jScrollPane5.setViewportView(TAmbito);

        btnCadruplo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCadruplo.setText("Cuadruplo");
        btnCadruplo.setBorder(null);
        btnCadruplo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadruploActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnUltima, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(btnExcel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCompilar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnTxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnExcel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnCadruplo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 325, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 1288, Short.MAX_VALUE)
                    .addComponent(jScrollPane5))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                    .addComponent(jSP)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnCompilar, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnUltima, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnExcel2, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(btnCadruplo, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcelActionPerformed
        try {
            excel.generarExcel(TTokens, TMistakes, TCon, TAmbito, TSemanica1, TSemanica2, TSemanica3,cuad.getTCuad(),TCuad);
        } catch (IOException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExcelActionPerformed

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed
        init();
        try {
            sql = new MySql();
            sql.limpiarTablaSimbolos();
            leeMatriz();
        } catch (WriteException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        }
        showTokens();
        showMistakes();
        error = 0;
        syn = new Sintaxis(oper, cte, sql, TAmbito, semantica1Contadores, semantica2Contadores, semantica3Contadores, cuad.getTCuad(), TCuad);
        syn.iniciarSintaxis();
        tablaSemantica1();
        tablaSemantica2();
        tablaSemantica3();
        cte.actualizarTablas();
        showCont();
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTxtActionPerformed
        String x = abrirArchivo();
        TAText.setText(x);
    }//GEN-LAST:event_btnTxtActionPerformed

    private void btnUltimaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUltimaActionPerformed
        // TODO add your handling code here:
        File file = new File("Ultima prueba.txt");
        BufferedReader br;
        String st = "", st2 = "";
        try {
            br = new BufferedReader(new FileReader(file));
            while ((st = br.readLine()) != null) {
                st2 += st + "\n";
            }
            TAText.setText(st2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnUltimaActionPerformed

    private void btnExcel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcel2ActionPerformed
        // TODO add your handling code here:
        setVisible(false);
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CompiladorAr x = new CompiladorAr();
                x.setVisible(true);
                x.setResizable(false);
                x.pack();
                x.setLocationRelativeTo(null);
            }
        });
    }//GEN-LAST:event_btnExcel2ActionPerformed

    private void btnCadruploActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadruploActionPerformed
        // TODO add your handling code heren
        cuad.setDefaultCloseOperation(HIDE_ON_CLOSE);
        cuad.setResizable(false);
        cuad.setVisible(true);
        cuad.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCadruploActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                CompiladorAr x = new CompiladorAr();
                x.setVisible(true);
                x.setResizable(false);
                x.pack();
                x.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable T4;
    private javax.swing.JTextArea TAText;
    private javax.swing.JTable TAmbito;
    private javax.swing.JTable TCon;
    private javax.swing.JTable TCuad;
    private javax.swing.JTable TMistakes;
    private javax.swing.JTable TSemanica1;
    private javax.swing.JTable TSemanica2;
    private javax.swing.JTable TSemanica3;
    private javax.swing.JTable TTokens;
    private javax.swing.JToggleButton btnCadruplo;
    private javax.swing.JButton btnCompilar;
    private javax.swing.JToggleButton btnExcel;
    private javax.swing.JToggleButton btnExcel2;
    private javax.swing.JButton btnTxt;
    private javax.swing.JToggleButton btnUltima;
    private javax.swing.JScrollPane jSP;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel lbt;
    // End of variables declaration//GEN-END:variables
}
