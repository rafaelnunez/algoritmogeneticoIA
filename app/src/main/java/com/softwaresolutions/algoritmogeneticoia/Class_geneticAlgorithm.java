package com.softwaresolutions.algoritmogeneticoia;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by rn_dr on 21/03/16.
 */
public class Class_geneticAlgorithm implements method {


    @Override
    public double[] evaluationFuntion(int[] x){

        double[] valuefuntion = new double[4];
        int[] evaluation = new int[4];
            for (int i=0; i<=3; i++) {
                valuefuntion[i] = Math.pow(x[i], 2);
            }
        return valuefuntion;

    }

    @Override
    public String[] convertNumberToBinary(int[] number) {
        int numero, exp, digito;
        int binario;
        String[] resultBinaryConvert = new String[4];
        String generator = null;
        for (int i=0; i<=3; i++) {
            exp = 0;
            binario = 0;
            numero = number[i];
            while (numero != 0) {
                digito = numero % 2;
                binario = (int) (binario + digito * Math.pow(10, exp));
                exp++;
                numero = numero / 2;
            }
            if(String.valueOf(binario).length() == 1) {
                generator = "0000" + String.valueOf(binario);
            }else if (String.valueOf(binario).length() == 2){
                generator = "000" + String.valueOf(binario);
            }else if (String.valueOf(binario).length() == 3){
                generator = "00" + String.valueOf(binario);
            }else if (String.valueOf(binario).length() == 4){
                generator = "0" + String.valueOf(binario);
            }else {
                generator = String.valueOf(binario);
            }
            resultBinaryConvert[i] = generator;
        }
        return resultBinaryConvert;
    }

    @Override
    public int[] convertBinaryToNumber(String[] numberBinary) {
        int[] newgeneration = new int[4];
        for (int i=0; i<=3; i++){
             newgeneration[i]=Integer.parseInt(numberBinary[i],2);
        }
        return newgeneration;
    }

    @Override
    public int[] selectionIndividuals(int[] individuals, double[] dataValuefuntion) {
        int[] selection = new int[4];
        double[] orderdatavalue = new double[4];

        ArrayList v = new ArrayList();
            for (int i=0; i<=3; i++) {
                v.add(i,dataValuefuntion[i]);
            }
            Collections.sort(v);
        for (int i=0; i<=3; i++) {
            orderdatavalue[i] = (double) v.get(i);
        }

            for (int i=0; i<=3; i++) {
                for (int j=0; j<=3; j++){
                    if( orderdatavalue[i] == dataValuefuntion[j]){
                        selection[i] = j;
                    }

                }
            }
        return selection;
    }

    @Override
    public String[] combinationIndividuals(int[] individual, int[] selection, String[] numbersbinary) {
        String[] convination = new String[4];
        String[] convination2 = new String[1];
        String[] convination3 = new String[1];
        String[] convination4 = new String[1];
        String[] numberbinarytemporal = new String[4];


            for (int i=0; i<=3; i++){
                numberbinarytemporal[i] = "";
                for (int j=0; j<=4; j++){
                    if (j<=1){
                        numberbinarytemporal[i] += String.valueOf(String.valueOf(numbersbinary[i]).charAt(j));
                    }else if (j==2){
                        numberbinarytemporal[i] += "-" + String.valueOf(String.valueOf(numbersbinary[i]).charAt(j));
                    }else if (j==4 || j == 3){
                        numberbinarytemporal[i] += String.valueOf(String.valueOf(numbersbinary[i]).charAt(j));
                    }
                }
            }

        convination[0] = String.valueOf(numbersbinary[selection[3]]);
        convination[1] = String.valueOf(numberbinarytemporal[selection[3]]) + "-" + String.valueOf(numberbinarytemporal[selection[2]]);
        convination[2] = String.valueOf(numberbinarytemporal[selection[3]]) + "-" + String.valueOf(numberbinarytemporal[selection[1]]);
        convination[3] = String.valueOf(numberbinarytemporal[selection[2]]) + "-" + String.valueOf(numberbinarytemporal[selection[3]]);
        for (int i=0; i<=3; i++) {
            if (i==1){
                convination2 = convination[i].split("-");
            }else if (i==2){
                convination3 = convination[i].split("-");
            }else if (i==3){
                convination4 = convination[i].split("-");
            }
        }

        for (int i=0; i<=3; i++ ) {
            if (i==1){
                convination[1] = convination2[0] + convination2[3];
            }else if (i==2){
                convination[2] = convination3[0] + convination3[3];
            }else if (i==3){
                convination[3] = convination4[0] + convination4[3];
            }
        }

        return convination;
    }

    @Override
    public String[] numbersrandom() {
        int[] numbersradom = new int[4];
        String[] numberradomstring =new String[4];
        for (int i = 0; i<=3; i++){
            numbersradom[i] = (int) (Math.random() * 31 + 0);
            numberradomstring[i] = String.valueOf(numbersradom[i]);
        }

        return numberradomstring;
    }
}