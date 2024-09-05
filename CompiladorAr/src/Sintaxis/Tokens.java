package Sintaxis;

public class Tokens {

    public int getColumn(NodoToken token) {
        switch (token.getToken()) {
            case -100:
                return 6;//id
            case -101:
                return 54;///
            case -103:
                return 85;///=
            case -105:
                return 20;//Constentero
            case -106:
                return 24;//Constreal
            case -107:
                return 29;//ConstExponencial
            case -108:
                return 26;//Constcaracter
            case -109:
                return 25;//Constcadena
            case -110:
                return 22;//+
            case -111:
                return 60;//++
            case -112:
                return 84;//+=
            case -113:
                return 53;//*
            case -114:
                return 62;//**
            case -115:
                return 86;//*=
            case -116:
                return 23;//-
            case -117:
                return 61;//--
            case -118:
                return 87;//-=
            case -119:
                return 57;//%
            case -121:
                return 59;//!
            case -122:
                return 48;//!=
            case -123:
                return 56;//&
            case -124:
                return 58;//&&
            case -125:
                return 51;//|
            case -126:
                return 52;//||
            case -127:
                return 55;//#
            case -128:
                return 43;//<
            case -129:
                return 31;//<<
            case -130:
                return 46;//<=
            case -131:
                return 69;//<+
            case -132:
                return 50;//>
            case -133:
                return 30;//>>
            case -134:
                return 44;//>=
            case -135:
                return 70;//>+
            case -136:
                return 8; //=
            case -137:
                return 49; //==
            case -138:
                return 47;//=<
            case -139:
                return 45;//=>
            case -140:
                return 7; //;
            case -141:
                return 9; //,
            case -142:
                return 63;//.
            case -143:
                return 1; //(
            case -144:
                return 2; //)
            case -145:
                return 19; //[
            case -146:
                return 21; //]
            case -147:
                return 3; //{
            case -148:
                return 4; //}
            case -149:
                return 10; //:
            case -150:
                return 82;//$
            case -151:
                return 83;//~
            //-----Palabras Reservadas--------------
            case -200:
                return 32;//if
            case -202:
                return 36;//while
            case -204:
                return 35;//for
            case -207:
                return 37;//switch
            case -208:
                return 12;//INT
            case -211:
                return 13;//REAL
            case -212:
                return 14;//BOOL
            case -213:
                return 27;//true
            case -214:
                return 28;//false
            case -215:
                return 0;//main
            case -216:
                return 5;//reg
            case -217:
                return 11;//CHAR
            case -218:
                return 15;//EXP
            case -219:
                return 17;//VOID
            case -220:
                return 18;//FILE
            case -221:
                return 40;//else
            case -222:
                return 33;//repeat
            case -223:
                return 34;//until
            case -224:
                return 38;//case
            case -225:
                return 41;//default
            case -226:
                return 42;//break
            case -227:
                return 39;//return
            case -228:
                return 65;//sqrt
            case -229:
                return 66;//sqr
            case -230:
                return 68;//sqrtv
            case -231:
                return 67;//pow
            case -232:
                return 71;//ins
            case -233:
                return 72;//conv
            case -234:
                return 73;//up
            case -235:
                return 74;//low
            case -236:
                return 75;//len
            case -237:
                return 76;//asc
            case -238:
                return 77;//val
            case -239:
                return 78;//setcolorb
            case -240:
                return 79;//setcolorf
            case -241:
                return 80;//getcolorb
            case -242:
                return 81;//getcolorf
            case -243:
                return 16;//REG
            case -244:
                return 64;//clean
        }
        return 1;
    }
}
