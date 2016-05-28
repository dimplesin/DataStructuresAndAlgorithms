package com.company.Microsoft;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class RubicCube {
    static InputStream is;
    static PrintWriter out;
    static String INPUT = "";

    static void solve()
    {
        for(int T = ni();T >= 1;T--){
            char[] str = ns(1000);
            int[][] coms = new int[1000][2];
            int p = 0;
            for(int i = 0;i < str.length;i++){
                coms[p][1] = 1;
                if(str[i] == 'U'){
                    coms[p++][0] = 0;
                }else if(str[i] == 'D'){
                    coms[p++][0] = 1;
                }else if(str[i] == 'L'){
                    coms[p++][0] = 2;
                }else if(str[i] == 'R'){
                    coms[p++][0] = 3;
                }else if(str[i] == 'F'){
                    coms[p++][0] = 4;
                }else if(str[i] == 'B'){
                    coms[p++][0] = 5;
                }else if(str[i] == '\''){
                    coms[p-1][1] = 3;
                }else if(str[i] == '2'){
                    coms[p-1][1] = 2;
                }
            }

            coms = Arrays.copyOf(coms, p);
//			tr(coms);
            int[][][] s = new int[6][3][3];
            for(int i = 0;i < 6;i++){
                for(int j = 0;j < 3;j++){
                    for(int k = 0;k < 3;k++){
                        s[i][j][k] = i*9+j*3+k;
                    }
                }
            }
            //FRONT, BACK, UP, DOWN, LEFT and RIGHT
            for(int j = 0;j < p;j++){
                if(coms[j][0] == 0){
                    for(int k = 0;k < coms[j][1];k++){
                        for(int u = 0;u < 3;u++){
                            int d = s[4][0][u]; s[4][0][u] = s[0][0][u]; s[0][0][u] = s[5][0][u]; s[5][0][u] = s[1][0][u]; s[1][0][u] = d;
                        }
                        rot(s[2]);
                    }
                }else if(coms[j][0] == 1){
                    for(int k = 0;k < coms[j][1];k++){
                        for(int u = 0;u < 3;u++){
                            int d = s[5][2][u]; s[5][2][u] = s[0][2][u]; s[0][2][u] = s[4][2][u]; s[4][2][u] = s[1][2][u]; s[1][2][u] = d;
                        }
                        rot(s[3]);
                    }
                }else if(coms[j][0] == 2){
                    for(int k = 0;k < coms[j][1];k++){
                        for(int u = 0;u < 3;u++){
                            int d = s[0][u][0]; s[0][u][0] = s[2][u][0]; s[2][u][0] = s[1][2-u][2];s[1][2-u][2] = s[3][u][0]; s[3][u][0] = d;
                        }
                        rot(s[4]);
                    }
                }else if(coms[j][0] == 3){
                    for(int k = 0;k < coms[j][1];k++){
                        for(int u = 0;u < 3;u++){
                            int d = s[0][u][2]; s[0][u][2] = s[3][u][2]; s[3][u][2] = s[1][2-u][0];s[1][2-u][0] = s[2][u][2]; s[2][u][2] = d;
                        }
                        rot(s[5]);
                    }
                }else if(coms[j][0] == 4){
                    for(int k = 0;k < coms[j][1];k++){
                        for(int u = 0;u < 3;u++){
                            int d = s[2][2][u]; s[2][2][u] = s[4][2-u][2]; s[4][2-u][2] = s[3][0][2-u];s[3][0][2-u] = s[5][u][0]; s[5][u][0] = d;
                        }
                        rot(s[0]);
                    }
                }else if(coms[j][0] == 5){
                    for(int k = 0;k < coms[j][1];k++){
                        for(int u = 0;u < 3;u++){
                            int d = s[2][0][u]; s[2][0][u] = s[5][u][2]; s[5][u][2] = s[3][2][2-u];s[3][2][2-u] = s[4][2-u][0]; s[4][2-u][0] = d;
                        }
                        rot(s[1]);
                    }
                }
            }

            int[] f = new int[6*3*3];
            for(int i = 0;i < 6;i++){
                for(int j = 0;j < 3;j++){
                    for(int k = 0;k < 3;k++){
                        f[i*9+j*3+k] = s[i][j][k];
                    }
                }
            }
            out.println(splitIntoCycleCounts(f));
        }
    }

    public static int splitIntoCycleCounts(int[] f)
    {
        int n = f.length;
        boolean[] ved = new boolean[n];
        int ret = 1;
        for(int i = 0;i < n;i++){
            if(!ved[i]){
                int cy = 0;
                for(int cur = i;!ved[cur];cur = f[cur]){
                    ved[cur] = true;
                    cy++;
                }
                ret = ret * cy / gcd(ret, cy);
            }
        }
        return ret;
    }

    public static int gcd(int a, int b) {
        while (b > 0) {
            int c = a;
            a = b;
            b = c % b;
        }
        return a;
    }


    static void rot(int[][] f)
    {
        int d = f[0][0]; f[0][0] = f[2][0]; f[2][0] = f[2][2]; f[2][2] = f[0][2]; f[0][2] = d;
        d = f[1][0]; f[1][0] = f[2][1]; f[2][1] = f[1][2]; f[1][2] = f[0][1]; f[0][1] = d;
    }

    public static char[] ns(int n) {
        char[] buf = new char[n];
        try {
            int b = 0, p = 0;
            while ((b = is.read()) != -1
                    && (b == ' ' || b == '\r' || b == '\n'))
                ;
            if (b == -1)
                return null;
            buf[p++] = (char) b;
            while (p < n) {
                b = is.read();
                if (b == -1 || b == ' ' || b == '\r' || b == '\n')
                    break;
                buf[p++] = (char) b;
            }
            return Arrays.copyOf(buf, p);
        } catch (IOException e) {
        }
        return null;
    }

    public static void main(String[] args) throws Exception
    {
        long S = System.currentTimeMillis();
        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());
        out = new PrintWriter(System.out);

        solve();
        out.flush();
        long G = System.currentTimeMillis();
        tr(G-S+"ms");
    }

    static boolean eof()
    {
        try {
            is.mark(1000);
            int b;
            while((b = is.read()) != -1 && !(b >= 33 && b <= 126));
            is.reset();
            return b == -1;
        } catch (IOException e) {
            return true;
        }
    }

    static int ni()
    {
        try {
            int num = 0;
            boolean minus = false;
            while((num = is.read()) != -1 && !((num >= '0' && num <= '9') || num == '-'));
            if(num == '-'){
                num = 0;
                minus = true;
            }else{
                num -= '0';
            }

            while(true){
                int b = is.read();
                if(b >= '0' && b <= '9'){
                    num = num * 10 + (b - '0');
                }else{
                    return minus ? -num : num;
                }
            }
        } catch (IOException e) {
        }
        return -1;
    }

    static void tr(Object... o) { if(INPUT.length() != 0)System.out.println(Arrays.deepToString(o)); }
}
