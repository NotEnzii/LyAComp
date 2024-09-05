/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Externo;

/**
 *
 * @author Usuario
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySql {

    Connection conexionSQL;
    Statement st;

    public MySql() {
        establecerConexion();
    }

    private void establecerConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexionSQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/a16130476?verifyServerCertificate=false&useSSL=true", "root", "root");
            st = conexionSQL.createStatement();
        } catch (SQLException e) {
            System.err.println("<SQL> Error SQL al intentar establecer conexion con la base de datos");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.err.println("<SQL> Error SQL al intentar establecer conexion con la base de datos");
        } catch (Exception e) {
            System.err.println("<SQL> Error detectado: " + e.getMessage());
            System.err.println("<SQL> Excepcion simple al intentar establecer conexion con la base de datos");
        }
    }

    public int obtenerValorVariable(String variable, int ambito) {
        String query = "SELECT valor FROM tablasimbolos WHERE (id = '" + variable + "' AND (ambito = '" + ambito + "' OR ambito = '0'))";
        String valorVariable = "";
        try {
            ResultSet rs = obtenerResultSet(query);
            while (rs.next()) {
                valorVariable = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Integer.parseInt(valorVariable);
    }

    public void cerrarConexion() {
        try {
            conexionSQL.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("<MySQL> Error al intentar cerrar la conexion a la base de datos");
        }
    }

    public void limpiarTablaSimbolos() {
        try {
            st.executeUpdate("DELETE FROM tablasimbolos");
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("<SQL> Error al vaciar tabla de simbolos");
        }
    }

    public void ejecutarQuery(String query) {
        try {
            st.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("<SQL> Error al ejecutar el query: " + query);
        }
    }

    public ResultSet obtenerResultSet(String query) throws SQLException {
        return st.executeQuery(query);
    }

    public String obtenerTipoVariable(String variable, int ambito) {
        String query = "SELECT tipo FROM tablasimbolos WHERE (id = BINARY '" + variable.trim() + "' AND ambito = '" + ambito + "')";
        String tipoVariable = "";
        try {
            ResultSet rs = obtenerResultSet(query);
            while (rs.next()) {
                tipoVariable = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoVariable;
    }

    public String obtenerClaseVariable(String variable, int ambito) {
        String query = "SELECT clase FROM tablasimbolos WHERE (id = BINARY '" + variable.trim() + "' AND ambito = '" + ambito + "')";
        String claseVariable = "";
        try {
            ResultSet rs = obtenerResultSet(query);
            while (rs.next()) {
                claseVariable = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return claseVariable;
    }
    
    public String obtenerNumeroParamtro(String variable, int ambito) {
        String query = "SELECT noPar FROM tablasimbolos WHERE (id = BINARY '" + variable.trim() + "' AND ambito = '" + ambito + "')";
        String claseVariable = "";
        try {
            ResultSet rs = obtenerResultSet(query);
            while (rs.next()) {
                claseVariable = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return claseVariable;
    }

    public String obtenerTamañoArreglo(String variable, int ambito) {
        String query = "SELECT tarr FROM tablasimbolos WHERE (id = BINARY '" + variable.trim() + "' AND ambito = '" + ambito + "');";
        String tipoVariable = "";
        try {
            ResultSet rs = obtenerResultSet(query);
            while (rs.next()) {
                tipoVariable = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoVariable;
    }
    
    public String obtenerDimecionesArreglo(String variable, int ambito) {
        String query = "SELECT dimArr FROM tablasimbolos WHERE (id = BINARY '" + variable.trim() + "' AND ambito = '" + ambito + "');";
        String tipoVariable = "";
        try {
            ResultSet rs = obtenerResultSet(query);
            while (rs.next()) {
                tipoVariable = rs.getString(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return tipoVariable;
    }

    public boolean comprobarVariableDeclarada(String id, String ambito) {
        String idAuxiliar = id.replaceAll("\\s", "");
        String query = "SELECT * FROM tablasimbolos WHERE (id = BINARY "
                + "'" + idAuxiliar + "' AND (ambito='" + ambito + "' OR ambito='0'))";
        try {
            ResultSet rs = obtenerResultSet(query);
            return rs.next();

        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean comprobarVariableDuplicada(String id, String ambito) {
        String query = "SELECT * FROM tablasimbolos WHERE (id = BINARY '" + id.trim() + "' AND (ambito='" + ambito.trim() + "'))";
        try {
            ResultSet rs = obtenerResultSet(query);
            return rs.next();
        } catch (SQLException ex) {
            Logger.getLogger(MySql.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

}
