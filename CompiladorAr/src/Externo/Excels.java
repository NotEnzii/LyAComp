/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Externo;

import Vista.CompiladorAr;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import jxl.CellType;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WriteException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author Usuario
 */
public class Excels {

    public int[][] cargarExcelSintaxis() {
        int[][] matriz;
        Workbook wb = null;
        try {
            wb = Workbook.getWorkbook(new File("Sintaxis.xls"));
        } catch (IOException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sheet hoja = wb.getSheet("Hoja");
        matriz = new int[hoja.getRows() - 1][hoja.getColumns() - 1];
        for (int f = 1; f < hoja.getRows(); f++) {
            for (int c = 1; c < hoja.getColumns(); c++) {
                matriz[f - 1][c - 1] = Integer.parseInt(hoja.getCell(c, f).getContents());
            }
        }
        return matriz;
    }

    public Sheet cargarExcelLexico() throws WriteException, IOException, BiffException {
        Workbook wb = null;
        try {
            wb = Workbook.getWorkbook(new File("Lexico.xls"));
        } catch (IOException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        }
        Sheet hoja = wb.getSheet(0);
        return hoja;
    }

    public void generarExcel(JTable TTokens, JTable TMistakes, JTable TCon, JTable TAmbito, JTable TSemanica1, JTable TSemanica2, JTable TSemanica3, JTable Tcuad, JTable Tcuad2) throws IOException {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet hoja1 = workbook.createSheet("Tokens");
        try {
            XSSFRow fila = hoja1.createRow(0);
            fila.createCell(0).setCellValue("Estado");
            fila.createCell(1).setCellValue("Lexema");
            fila.createCell(2).setCellValue("Linea");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < TTokens.getRowCount(); j++) {
                rect = TTokens.getCellRect(1, 0, true);
                try {
                    TTokens.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                TTokens.setRowSelectionInterval(j, j);
                filas = hoja1.createRow((j + 1));
                filas.createCell(0).setCellValue(TTokens.getValueAt(j, 0).toString().trim());//Estado
                filas.createCell(1).setCellValue(TTokens.getValueAt(j, 1).toString().trim());//Lexema
                filas.createCell(2).setCellValue(TTokens.getValueAt(j, 2).toString().trim());//Linea
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        XSSFSheet hoja2 = workbook.createSheet("Errores");
        try {
            XSSFRow fila = hoja2.createRow(0);
            fila.createCell(0).setCellValue("Token");
            fila.createCell(1).setCellValue("Descripcion");
            fila.createCell(2).setCellValue("Lexema");
            fila.createCell(3).setCellValue("Tipo");
            fila.createCell(4).setCellValue("Linea");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < TMistakes.getRowCount(); j++) {
                rect = TMistakes.getCellRect(1, 0, true);
                try {
                    TMistakes.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                TMistakes.setRowSelectionInterval(j, j);
                filas = hoja2.createRow((j + 1));
                filas.createCell(0).setCellValue(TMistakes.getValueAt(j, 0).toString().trim());
                filas.createCell(1).setCellValue(TMistakes.getValueAt(j, 1).toString().trim());
                filas.createCell(2).setCellValue(TMistakes.getValueAt(j, 2).toString().trim());
                filas.createCell(4).setCellValue(TMistakes.getValueAt(j, 3).toString().trim());
                filas.createCell(3).setCellValue(TMistakes.getValueAt(j, 4).toString().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        XSSFSheet hoja3 = workbook.createSheet("Contadores");
        try {
            XSSFRow fila = hoja3.createRow(0);
            fila.createCell(0).setCellValue("Errores");
            fila.createCell(1).setCellValue("Identificador");
            fila.createCell(2).setCellValue("Comentarios");
            fila.createCell(3).setCellValue("Palabras reservadas");
            fila.createCell(4).setCellValue("C-Enteras");
            fila.createCell(5).setCellValue("C-Texto");
            fila.createCell(6).setCellValue("C-Decimal");
            fila.createCell(7).setCellValue("C-Caracter");
            fila.createCell(8).setCellValue("C-Exponencial");
            fila.createCell(9).setCellValue("Aritmetico");
            fila.createCell(10).setCellValue("Monogamo");
            fila.createCell(11).setCellValue("Logico");
            fila.createCell(12).setCellValue("Relacional");
            fila.createCell(13).setCellValue("Bit");
            fila.createCell(14).setCellValue("Puntuacion");
            fila.createCell(15).setCellValue("Agrupacion");
            fila.createCell(16).setCellValue("Asignacion");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < TCon.getRowCount(); j++) {
                rect = TCon.getCellRect(1, 0, true);
                try {
                    TCon.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                TCon.setRowSelectionInterval(j, j);
                filas = hoja3.createRow((j + 1));
                filas.createCell(0).setCellValue(TCon.getValueAt(j, 0).toString().trim());
                filas.createCell(1).setCellValue(TCon.getValueAt(j, 1).toString().trim());
                filas.createCell(2).setCellValue(TCon.getValueAt(j, 2).toString().trim());
                filas.createCell(3).setCellValue(TCon.getValueAt(j, 3).toString().trim());
                filas.createCell(4).setCellValue(TCon.getValueAt(j, 4).toString().trim());
                filas.createCell(5).setCellValue(TCon.getValueAt(j, 5).toString().trim());
                filas.createCell(6).setCellValue(TCon.getValueAt(j, 6).toString().trim());
                filas.createCell(7).setCellValue(TCon.getValueAt(j, 7).toString().trim());
                filas.createCell(8).setCellValue(TCon.getValueAt(j, 8).toString().trim());
                filas.createCell(9).setCellValue(TCon.getValueAt(j, 9).toString().trim());
                filas.createCell(10).setCellValue(TCon.getValueAt(j, 10).toString().trim());
                filas.createCell(11).setCellValue(TCon.getValueAt(j, 11).toString().trim());
                filas.createCell(12).setCellValue(TCon.getValueAt(j, 12).toString().trim());
                filas.createCell(13).setCellValue(TCon.getValueAt(j, 13).toString().trim());
                filas.createCell(14).setCellValue(TCon.getValueAt(j, 14).toString().trim());
                filas.createCell(15).setCellValue(TCon.getValueAt(j, 15).toString().trim());
                filas.createCell(16).setCellValue(TCon.getValueAt(j, 16).toString().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        XSSFSheet hoja4 = workbook.createSheet("Ambito");
        try {
            XSSFRow fila = hoja4.createRow(0);
            fila.createCell(0).setCellValue("Ambito");
            fila.createCell(1).setCellValue("char");
            fila.createCell(2).setCellValue("char[]");
            fila.createCell(3).setCellValue("int");
            fila.createCell(4).setCellValue("real");
            fila.createCell(5).setCellValue("bool");
            fila.createCell(6).setCellValue("exp");
            fila.createCell(7).setCellValue("reg");
            fila.createCell(8).setCellValue("void");
            fila.createCell(9).setCellValue("file");
            fila.createCell(10).setCellValue("Errores");
            fila.createCell(11).setCellValue("Total");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < TAmbito.getRowCount(); j++) {
                rect = TAmbito.getCellRect(1, 0, true);
                try {
                    TAmbito.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                TAmbito.setRowSelectionInterval(j, j);
                filas = hoja4.createRow((j + 1));
                filas.createCell(0).setCellValue(TAmbito.getValueAt(j, 0).toString().trim());
                filas.createCell(1).setCellValue(TAmbito.getValueAt(j, 1).toString().trim());
                filas.createCell(2).setCellValue(TAmbito.getValueAt(j, 2).toString().trim());
                filas.createCell(3).setCellValue(TAmbito.getValueAt(j, 3).toString().trim());
                filas.createCell(4).setCellValue(TAmbito.getValueAt(j, 4).toString().trim());
                filas.createCell(5).setCellValue(TAmbito.getValueAt(j, 5).toString().trim());
                filas.createCell(6).setCellValue(TAmbito.getValueAt(j, 6).toString().trim());
                filas.createCell(7).setCellValue(TAmbito.getValueAt(j, 7).toString().trim());
                filas.createCell(8).setCellValue(TAmbito.getValueAt(j, 8).toString().trim());
                filas.createCell(9).setCellValue(TAmbito.getValueAt(j, 9).toString().trim());
                filas.createCell(10).setCellValue(TAmbito.getValueAt(j, 10).toString().trim());
                filas.createCell(11).setCellValue(TAmbito.getValueAt(j, 11).toString().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        XSSFSheet hoja5 = workbook.createSheet("Semantica1");
        try {
            XSSFRow fila = hoja5.createRow(0);
            fila.createCell(0).setCellValue("Linea");
            fila.createCell(1).setCellValue("Tint");
            fila.createCell(2).setCellValue("Treal");
            fila.createCell(3).setCellValue("Texp");
            fila.createCell(4).setCellValue("Tchar");
            fila.createCell(5).setCellValue("Tchar[]");
            fila.createCell(6).setCellValue("Tbool");
            fila.createCell(7).setCellValue("Treg");
            fila.createCell(8).setCellValue("void");
            fila.createCell(9).setCellValue("Tfile");
            fila.createCell(10).setCellValue("TVaraints");
            fila.createCell(11).setCellValue("Asignacion");
            fila.createCell(12).setCellValue("Error");
            fila.createCell(13).setCellValue("Total");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < TSemanica1.getRowCount(); j++) {
                rect = TSemanica1.getCellRect(1, 0, true);
                try {
                    TSemanica1.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                TSemanica1.setRowSelectionInterval(j, j);
                filas = hoja5.createRow((j + 1));
                filas.createCell(0).setCellValue(TSemanica1.getValueAt(j, 0).toString().trim());
                filas.createCell(1).setCellValue(TSemanica1.getValueAt(j, 1).toString().trim());
                filas.createCell(2).setCellValue(TSemanica1.getValueAt(j, 2).toString().trim());
                filas.createCell(3).setCellValue(TSemanica1.getValueAt(j, 3).toString().trim());
                filas.createCell(4).setCellValue(TSemanica1.getValueAt(j, 4).toString().trim());
                filas.createCell(5).setCellValue(TSemanica1.getValueAt(j, 5).toString().trim());
                filas.createCell(6).setCellValue(TSemanica1.getValueAt(j, 6).toString().trim());
                filas.createCell(7).setCellValue(TSemanica1.getValueAt(j, 7).toString().trim());
                filas.createCell(8).setCellValue(TSemanica1.getValueAt(j, 8).toString().trim());
                filas.createCell(9).setCellValue(TSemanica1.getValueAt(j, 9).toString().trim());
                filas.createCell(10).setCellValue(TSemanica1.getValueAt(j, 10).toString().trim());
                filas.createCell(11).setCellValue(TSemanica1.getValueAt(j, 12).toString().trim());
                filas.createCell(12).setCellValue(TSemanica1.getValueAt(j, 10).toString().trim());
                filas.createCell(13).setCellValue(TSemanica1.getValueAt(j, 11).toString().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //----------------------------------
        XSSFSheet hoja6 = workbook.createSheet("Semantica2");
        try {
            XSSFRow fila = hoja6.createRow(0);
            fila.createCell(0).setCellValue("Regla");
            fila.createCell(1).setCellValue("Función");
            fila.createCell(2).setCellValue("Tope Pila");
            fila.createCell(3).setCellValue("Valor Real");
            fila.createCell(4).setCellValue("Linea");
            fila.createCell(5).setCellValue("Edo");
            fila.createCell(6).setCellValue("Ambito");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < TSemanica2.getRowCount(); j++) {
                rect = TSemanica2.getCellRect(1, 0, true);
                try {
                    TSemanica2.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                TSemanica2.setRowSelectionInterval(j, j);
                filas = hoja6.createRow((j + 1));
                filas.createCell(0).setCellValue(TSemanica2.getValueAt(j, 0).toString().trim());
                filas.createCell(1).setCellValue(TSemanica2.getValueAt(j, 1).toString().trim());
                filas.createCell(2).setCellValue(TSemanica2.getValueAt(j, 2).toString().trim());
                filas.createCell(3).setCellValue(TSemanica2.getValueAt(j, 3).toString().trim());
                filas.createCell(4).setCellValue(TSemanica2.getValueAt(j, 4).toString().trim());
                filas.createCell(5).setCellValue(TSemanica2.getValueAt(j, 5).toString().trim());
                filas.createCell(6).setCellValue(TSemanica2.getValueAt(j, 6).toString().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //----------------------------------
        XSSFSheet hoja7 = workbook.createSheet("Semantica3");
        try {
            XSSFRow fila = hoja7.createRow(0);
            fila.createCell(0).setCellValue("Funcion");
            fila.createCell(1).setCellValue("Entradas");
            fila.createCell(2).setCellValue("Salidas");
            fila.createCell(3).setCellValue("Aceptados");
            fila.createCell(4).setCellValue("Errores");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < TSemanica3.getRowCount(); j++) {
                rect = TSemanica3.getCellRect(1, 0, true);
                try {
                    TSemanica3.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                TSemanica3.setRowSelectionInterval(j, j);
                filas = hoja7.createRow((j + 1));
                filas.createCell(0).setCellValue(TSemanica3.getValueAt(j, 0).toString().trim());
                filas.createCell(1).setCellValue(TSemanica3.getValueAt(j, 1).toString().trim());
                filas.createCell(2).setCellValue(TSemanica3.getValueAt(j, 2).toString().trim());
                filas.createCell(3).setCellValue(TSemanica3.getValueAt(j, 3).toString().trim());
                filas.createCell(4).setCellValue(TSemanica3.getValueAt(j, 4).toString().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //----------------------------------
        XSSFSheet hoja8 = workbook.createSheet("CuadruplosT1");
        try {
            XSSFRow fila = hoja8.createRow(0);
            fila.createCell(0).setCellValue("Ambito");
            fila.createCell(1).setCellValue("TE");
            fila.createCell(2).setCellValue("TR");
            fila.createCell(3).setCellValue("TS");
            fila.createCell(4).setCellValue("TCH");
            fila.createCell(5).setCellValue("TEX");
            fila.createCell(6).setCellValue("TB");
            fila.createCell(7).setCellValue("TRX");
            fila.createCell(8).setCellValue("TF");
            fila.createCell(9).setCellValue("Arr");
            fila.createCell(10).setCellValue("Call");
            fila.createCell(11).setCellValue("=");
            fila.createCell(12).setCellValue("Op-Rel");
            fila.createCell(13).setCellValue("Op-Log");
            fila.createCell(14).setCellValue("Op-Ari");
            fila.createCell(15).setCellValue("Op-Un");
            fila.createCell(16).setCellValue("JF");
            fila.createCell(17).setCellValue("JMP");
            fila.createCell(18).setCellValue("Valor");
            fila.createCell(19).setCellValue("If-e");
            fila.createCell(20).setCellValue("Sw-e");
            fila.createCell(21).setCellValue("For-e");
            fila.createCell(22).setCellValue("Whi-e");
            fila.createCell(23).setCellValue("Def");
            fila.createCell(24).setCellValue("PPAL");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < Tcuad2.getRowCount(); j++) {
                rect = Tcuad2.getCellRect(1, 0, true);
                try {
                    Tcuad2.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                Tcuad2.setRowSelectionInterval(j, j);
                filas = hoja8.createRow((j + 1));
                filas.createCell(0).setCellValue(Tcuad2.getValueAt(j, 0).toString().trim());
                filas.createCell(1).setCellValue(Tcuad2.getValueAt(j, 1).toString().trim());
                filas.createCell(2).setCellValue(Tcuad2.getValueAt(j, 2).toString().trim());
                filas.createCell(3).setCellValue(Tcuad2.getValueAt(j, 3).toString().trim());
                filas.createCell(4).setCellValue(Tcuad2.getValueAt(j, 4).toString().trim());
                filas.createCell(5).setCellValue(Tcuad2.getValueAt(j, 5).toString().trim());
                filas.createCell(6).setCellValue(Tcuad2.getValueAt(j, 6).toString().trim());
                filas.createCell(7).setCellValue(Tcuad2.getValueAt(j, 7).toString().trim());
                filas.createCell(8).setCellValue(Tcuad2.getValueAt(j, 8).toString().trim());
                filas.createCell(9).setCellValue(Tcuad2.getValueAt(j, 9).toString().trim());
                filas.createCell(10).setCellValue(Tcuad2.getValueAt(j, 10).toString().trim());
                filas.createCell(11).setCellValue(Tcuad2.getValueAt(j, 11).toString().trim());
                filas.createCell(12).setCellValue(Tcuad2.getValueAt(j, 12).toString().trim());
                filas.createCell(13).setCellValue(Tcuad2.getValueAt(j, 13).toString().trim());
                filas.createCell(14).setCellValue(Tcuad2.getValueAt(j, 14).toString().trim());
                filas.createCell(15).setCellValue(Tcuad2.getValueAt(j, 15).toString().trim());
                filas.createCell(16).setCellValue(Tcuad2.getValueAt(j, 16).toString().trim());
                filas.createCell(17).setCellValue(Tcuad2.getValueAt(j, 17).toString().trim());
                filas.createCell(18).setCellValue(Tcuad2.getValueAt(j, 18).toString().trim());
                filas.createCell(19).setCellValue(Tcuad2.getValueAt(j, 19).toString().trim());
                filas.createCell(20).setCellValue(Tcuad2.getValueAt(j, 20).toString().trim());
                filas.createCell(21).setCellValue(Tcuad2.getValueAt(j, 21).toString().trim());
                filas.createCell(22).setCellValue(Tcuad2.getValueAt(j, 22).toString().trim());
                filas.createCell(23).setCellValue(Tcuad2.getValueAt(j, 23).toString().trim());
                filas.createCell(24).setCellValue(Tcuad2.getValueAt(j, 24).toString().trim());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //----------------------------------
        XSSFSheet hoja9 = workbook.createSheet("CuadruplosT2");
        try {
            XSSFRow fila = hoja9.createRow(0);
            fila.createCell(0).setCellValue("Etiqueta");
            fila.createCell(1).setCellValue("Accion");
            fila.createCell(2).setCellValue("Arg1");
            fila.createCell(3).setCellValue("Arg2");
            fila.createCell(4).setCellValue("Resultado");
            XSSFRow filas;
            Rectangle rect;
            for (int j = 0; j < Tcuad.getRowCount(); j++) {
                rect = Tcuad.getCellRect(1, 0, true);
                try {
                    Tcuad.scrollRectToVisible(rect);
                } catch (java.lang.ClassCastException e) {
                }
                Tcuad.setRowSelectionInterval(j, j);
                filas = hoja9.createRow((j + 1));
                if (!Tcuad.getValueAt(j, 0).toString().trim().equals("null")) {
                    filas.createCell(0).setCellValue(Tcuad.getValueAt(j, 0).toString().trim());
                }
                if (!Tcuad.getValueAt(j, 1).toString().trim().equals("null")) {
                    filas.createCell(1).setCellValue(Tcuad.getValueAt(j, 1).toString().trim());
                }
                if (!Tcuad.getValueAt(j, 2).toString().trim().equals("null")) {
                    filas.createCell(2).setCellValue(Tcuad.getValueAt(j, 2).toString().trim());
                }
                if (!Tcuad.getValueAt(j, 3).toString().trim().equals("null")) {
                    filas.createCell(3).setCellValue(Tcuad.getValueAt(j, 3).toString().trim());
                }
                if (!Tcuad.getValueAt(j, 4).toString().trim().equals("null")) {
                    filas.createCell(4).setCellValue(Tcuad.getValueAt(j, 4).toString().trim());
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        //----------------------------------
        try {
            workbook.write(new FileOutputStream(new File("Alan Armenta.xls")));
            System.out.println("Excel Listo");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(CompiladorAr.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
