/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexico;
/**
 *
 * @author Usuario
 */
public class ColumnaExcel {
    
    //ciclo
    public int Ciclo(char c) {
        int col;
        if (c == '_') {
            col = 0;
        } else if (c >= 'a' && c <= 'd') {
            col = 1;
        } else if (c >= 'A' && c <= 'D') {
            col = 2;
        } else if (c == 'e' || c == 'E') {
            col = 3;
        } else if (c >= 'f' && c <= 'z') {
            col = 4;
        } else if (c >= 'F' && c <= 'Z') {
            col = 5;
        } else if (c >= '0' && c <= '9') {
            col = 6;
        } else if (c == '/') {
            col = 7;
        } else if (c == '=') {
            col = 8;
        } else if (c == '*') {
            col = 9;
        } else if (c == '.') {
            col = 10;
        } else if (c == '+') {
            col = 11;
        } else if (c == '-') {
            col = 12;
        } else if (c == '\'' || c == '’') {
            col = 13;
        } else if (c == '"') {
            col = 14;
        } else if (c == '%') {
            col = 15;
        } else if (c == '^') {
            col = 16;
        } else if (c == '!') {
            col = 17;
        } else if (c == '&') {
            col = 18;
        } else if (c == '|') {
            col = 19;
        } else if (c == '#') {
            col = 20;
        } else if (c == '<') {
            col = 21;
        } else if (c == '>') {
            col = 22;
        } else if (c == ';') {
            col = 23;
        } else if (c == ',') {
            col = 24;
        } else if (c == '(') {
            col = 25;
        } else if (c == ')') {
            col = 26;
        } else if (c == '[') {
            col = 27;
        } else if (c == ']') {
            col = 28;
        } else if (c == '{') {
            col = 29;
        } else if (c == '}') {
            col = 30;
        } else if (c == ':') {
            col = 31;
        } else if (c == '$') {
            col = 32;
        } else if (c == '~') {
            col = 33;
        } else if (c == '\t') {
            col = 34;
        } else if (c == ' ' || c == '\r') {
            col = 35;
        } else if (c == '\n') {
            col = 36;
        } else {
            col = 37;
        }
        return col;
    }
}
