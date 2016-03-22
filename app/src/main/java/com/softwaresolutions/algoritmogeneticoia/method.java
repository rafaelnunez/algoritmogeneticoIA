package com.softwaresolutions.algoritmogeneticoia;

import org.json.JSONException;

/**
 * Created by rn_dr on 21/03/16.
 */
public interface method {

    public String[] convertNumberToBinary(int[] number);
    public int[] convertBinaryToNumber(String[] numberselect);
    public int[] selectionIndividuals(int[] individual, double[] dataValueFuntion);
    public double[] evaluationFuntion(int[] x) throws JSONException;
    public String[] combinationIndividuals(int[] individual, int[] selection,String[] numbersbinary);
    public String[] numbersrandom();


}
