/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ambito;

/**
 *
 * @author Usuario
 */
public class nodoContadores {

    private int chaR, chaRR, inT, real, bool, exp, reg, voiD, file, error, total;

    public nodoContadores() {
        this.chaR = 0;
        this.chaRR = 0;
        this.inT = 0;
        this.real = 0;
        this.bool = 0;
        this.exp = 0;
        this.reg = 0;
        this.voiD = 0;
        this.file = 0;
        this.error = 0;
        this.total = 0;
    }

    public void aumentarContador(String peek) {
        switch (peek) {
            case "int":
                setInT();
                setTotal();
                break;
            case "real":
                setReal();
                setTotal();
                break;
            case "exp":
                setExp();
                setTotal();
                break;
            case "char":
                setChaR();
                setTotal();
                break;
            case "char[]":
                setChaRR();
                setTotal();
                break;
            case "bool":
                setBool();
                setTotal();
                break;
            case "CHAR":
                setChaR();
                setTotal();
                break;
            case "INT":
                setInT();
                setTotal();
                break;
            case "REAL":
                setReal();
                setTotal();
                break;
            case "BOOL":
                setBool();
                setTotal();
                break;
            case "EXP":
                setExp();
                setTotal();
                break;
            case "REG":
                setReg();
                setTotal();
                break;
            case "VOID":
                setVoiD();
                setTotal();
                break;
            case "FILE":
                setFile();
                setTotal();
                break;
        }
    }

    public int getChaR() {
        return chaR;
    }

    public int getChaRR() {
        return chaRR++;
    }

    public void setChaR() {
        this.chaR++;
    }

    public int getInT() {
        return inT;
    }

    public void setInT() {
        this.inT++;
    }

    public int getReal() {
        return real;
    }

    public void setReal() {
        this.real++;
    }

    public int getBool() {
        return bool;
    }

    public void setBool() {
        this.bool++;
    }

    public int getExp() {
        return exp;
    }

    public void setExp() {
        this.exp++;
    }

    public int getReg() {
        return reg;
    }

    public void setReg() {
        this.reg++;
    }

    public int getVoiD() {
        return voiD;
    }

    public void setVoiD() {
        this.voiD++;
    }

    public int getFile() {
        return file;
    }

    public void setFile() {
        this.file++;
    }

    public int getError() {
        return error;
    }

    public void setError() {
        this.error++;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal() {
        this.total++;
    }

    public void setChaRR() {
        this.chaRR++;
    }
}
