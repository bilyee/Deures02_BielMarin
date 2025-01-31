package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Exercici0200 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Suma de numeros con concatenación
        System.out.println(addImaginaries("1+2i", "4+5i"));

        // Dibujar y calcular triangulo de Pascal
        drawPascal(5);

        // Sumar numeros dentro de un ArrayList
        ArrayList<Double> list = new ArrayList<>(Arrays.asList(1.5, 2.3, 3.7));
        System.out.println(addList(list));

        // Imprimir una matriz
        int[][] matrixA = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        printMatrix(matrixA);

        // Imprimir y ordenar una matriz por columnas
        int[][] matrixB = {{1, 2, 3}, {4, 5, 6}};
        int[][] matrixC = {
            {1,  2,  3,  4,  5}, 
            {6,  7,  8,  9, 10}, 
            {11, 12, 13, 14, 15}, 
            {16, 17, 18, 19, 20}
        };
        printMatrix(transpose(matrixB));
        printMatrix(transpose(matrixC));

        // Saber la primera letra que no se repite
        System.out.println(firstNonRepeated("swiss"));     // w
        System.out.println(firstNonRepeated("redivider")); // v
        System.out.println(firstNonRepeated("aabbcc"));    // _

        // Invertir un numero
        System.out.println(inverInt(3645)); 

        // Calculo del numero mas pequeño y el mas grande
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(3, 6, 1, 5, 0));
        System.out.println(minMaxAdd(nums));

        // Sumar numeros sin el operador de sumar
        System.out.println(sumaSenseSumar(5, 6) + ":" + sumaSenseSumar(-3, 3) + ":" + sumaSenseSumar(10, -4));

        // Saber la distancia de cada letra
        System.out.println(minDistances("algoritmo", 'o'));
        System.out.println(minDistances("abcdefga", 'a'));

        // Encuentra el numero que no se repite
        System.out.println(findUniqueNumber(new ArrayList<>(Arrays.asList(2.0, 2.0, 1.0))));
        System.out.println(findUniqueNumber(new ArrayList<>(Arrays.asList(4.0, 1.0, 2.0, 1.0, 2.0))));

        scanner.close();
    }

    /**
     * Fes una funció que sumi números inmaginaris 
     * definits per una cadena de text
     * 
     *  "1+2i" + "4+5i" = "5+7i"
     * 
     * @param String el primer número imaginari
     * @param String el segon número imaginari
     * @return String el resultat de la suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesSimple
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesNegative
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesZero
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesWithZeroRealPart
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesWithZeroImaginaryPart
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddImaginariesLargeNumbers
     */
    public static String addImaginaries(String num0, String num1) {
        String[] part0 = num0.split("\\+|i");

        // Guardamos en variables los 2 numeros
        Integer parte0 = Integer.parseInt(part0[0]);
        Integer parte1 = Integer.parseInt(part0[1]);

        String[] part1 = num1.split("\\+|i");

        Integer parte2 = Integer.parseInt(part1[0]);
        Integer parte3 = Integer.parseInt(part1[1]);

        String suma1 = Integer.toString(parte0) + Integer.toString(parte2);
        String suma2 = Integer.toString(parte1) + Integer.toString(parte3);

        return suma1 + "+" + suma2 + "i";
    }

    /**
     * Fes un programa que dibuixi el triangle de pascal
     * 
     * @param int nivells del triangle (0 fins a n)
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalZero
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalOne
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalTwo
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalThree
     * @test ./runTest.sh com.exercicis.TestExercici0000#testDrawPascalFive
     */
    public static void drawPascal(int n) {
        if (n < 1) {
            return;
        }

        ArrayList<ArrayList<Integer>> pascal = new ArrayList<>();
        pascal.add(new ArrayList<>(List.of(1))); // Primera fila siempre es [1]

        // Hacemos un bucle para los calculos de cada linia del triangulo
        for (int row = 1; row < n; row++) {
            ArrayList<Integer> prevLine = pascal.get(row - 1);
            ArrayList<Integer> nextLine = new ArrayList<>();
            nextLine.add(1); // Primer elemento siempre es 1

            for (int col = 1; col < prevLine.size(); col++) {
                int sum = prevLine.get(col - 1) + prevLine.get(col);
                nextLine.add(sum);
            }

            nextLine.add(1); // Ultimo elemento siempre es 1
            pascal.add(nextLine);

            // Imprimir el triangulo de Pascal correctamente
            for (ArrayList<Integer> line : pascal) {
                for (int i = 0; i < line.size(); i++) {
                    System.out.print(line.get(i));
                    if (i < line.size() - 1) {
                        System.out.print(", ");
                    }
                }
                System.out.println();
            }
        }
    }

    /**
     * Fes una funció que sumi els valors d'un ArrayList<double>
     * 
     * @param llista de valors
     * @return resultat de la suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListEmpty
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListSingleElement
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListMultipleElements
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListNegativeNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListMixedNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0000#testAddListDecimals
     */
    public static double addList(ArrayList<Double> list) {
        return 0.0;
    }

    /** 
     * Fes una funció que dibuixi els valors d'una matriu
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6}, {7, 8, 9} };
     * 
     * @param int[][] matriu a dibuixar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixSingleElement
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixRow
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixColumn
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixSquare
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixRectangular
     * @test ./runTest.sh com.exercicis.TestExercici0000#testPrintMatrixEmpty
     */
    public static void printMatrix(int[][] matrix) {

    }

    /**
     * Fes una funció que retorni la trasposada d'una matriu
     * 
     * int[][] entrada = { {1, 2, 3}, {4, 5, 6} };
     * int[][] sortida = { {1, 4}, {2, 5}, {3, 6} };
     * 
     * int[][] entrada = { 
     *      {1,  2,  3,  4,  5}, 
     *      {6,  7,  8,  9, 10}, 
     *      {11, 12, 13, 14, 15}, 
     *      {16, 17, 18, 19, 20} };
     * 
     * int[][] sortida = { 
     *     {1, 6, 11, 16},
     *     {2, 7, 12, 17},
     *     {3, 8, 13, 18},
     *     {4, 9, 14, 19},
     *     {5, 10, 15, 20}
     * };
     * 
     * @param int[][] matriu a transposar
     * @return int[][] matriu transposada
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testTransposeSquareMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0000#testTransposeRectangularMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0000#testTransposeColumnMatrix
     * @test ./runTest.sh com.exercicis.TestExercici0000#testTransposeSingleElement
     */
    public static int[][] transpose(int[][] matrix) {
        return null;
    }

    /**
     * Fes una funció que troba el primer caràcter que
     * no es repeteix dins d'una cadena de text
     * si totes les lletres es repeteixen torna '_'
     * 
     * Exemple:
     * 
     * Entrada: "swiss"
     * Sortida: 'w'
     * 
     * Entrada: "redivider"
     * Sortida: 'v'
     * 
     * @param String cadena de text
     * @return char primer caràcter que no es repeteix
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFirstNonRepeatedBasic
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFirstNonRepeatedAllRepeated
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFirstNonRepeatedLongString
     */
    public static char firstNonRepeated(String str) {
        return '_';
    }

    /**
     * Fes una funció que inverteixi els caràcters
     * d'un número enter: 3645 > 5463
     * 
     * @param int número a invertir
     * @return int número resultant
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testInverIntPositive
     * @test ./runTest.sh com.exercicis.TestExercici0000#testInverIntWithZeros
     * @test ./runTest.sh com.exercicis.TestExercici0000#testInverIntSingleDigit
     */
    public static int inverInt(int num) {
        return 0;
    }

    /**
     * Fes una funció que rebi una llista (`ArrayList`) amb 5 números
     * i calculi el número més petit i el número més gran
     * que es poden calcular sumant 4 dels 5 números rebuts.
     * 
     * Exemple:
     * 
     * Entrada: [3, 6, 1, 5, 0]
     * Sortida: [9, 15]
     * 
     * Explicació:
     *  9  = 0 + 1 + 3 + 5 (sumant els quatre números més petits)
     *  15 = 1 + 3 + 5 + 6 (sumant els quatre números més grans)
     * 
     * @param ArrayList<Integer> nums Llista de números d'entrada (exactament 5 números)
     * @return ArrayList<Integer> Llista amb els dos números de sortida [mínim, màxim]
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinMaxAddBasic
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinMaxAddWithNegatives
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinMaxAddWithDuplicates
     */
    public static ArrayList<Integer> minMaxAdd(ArrayList<Integer> nums) {
        return null;
    }

    /**
     * Fes una funció que sumi dos números sense fer servir 
     * la operació de suma.
     * 
     * Exemple:
     * 
     * Entrada: 5, 7
     * Sortida: 12
     * 
     * Entrada: -3, 3
     * Sortida: 0
     * 
     * @param int a Primer número a sumar
     * @param int b Segon número a sumar
     * @return int Resultat de la suma de a i b sense utilitzar l'operació de suma
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarPositiveNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarNegativeNumbers
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarPositiveAndNegative
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarZero
     * @test ./runTest.sh com.exercicis.TestExercici0000#testSumaSenseSumarLargeNumbers
     */
    public static int sumaSenseSumar(int a, int b) {
        return 0;
    }

    /**
     * Fes una funció que retorni les distàncies mínimes
     * de cada lletra fins a un caràcter d'una cadena de text.
     * 
     * Exemple:
     * 
     * Entrada: "algoritmo", 'o'
     * Sortida: [3, 2, 1, 0, 1, 2, 2, 1, 0]
     * 
     * Entrada: "abcdefga", 'a'
     * Sortida: [0, 1, 2, 3, 3, 2, 1, 0]
     * 
     * @param String text Cadena de text d'entrada
     * @param char target Caràcter objectiu
     * @return ArrayList<Integer> Llista de distàncies mínimes de cada lletra fins al caràcter objectiu
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinDistancesBasic
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinDistancesMultipleTargets
     * @test ./runTest.sh com.exercicis.TestExercici0000#testMinDistancesNoTargetFound
     */
    public static ArrayList<Integer> minDistances(String text, char target) {
        return null;
    }

    /**
     * A partir d'una llista de números on cada 
     * número es repeteix dos cops excepte un, troba
     * el número que no es repeteix.
     * 
     * Exemple:
     * 
     * Entrada: [2.0, 2.0, 1.0]
     * Sortida: 1.0
     * 
     * Entrada: [4.0, 1.0, 2.0, 1.0, 2.0]
     * Sortida: 4.0
     * 
     * @param ArrayList<Double> nums Llista de números d'entrada
     * @return Double Número que no es repeteix
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFindUniqueNumberBasic
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFindUniqueNumberMultiplePairs
     * @test ./runTest.sh com.exercicis.TestExercici0000#testFindUniqueNumberNoUnique
     */
    public static Double findUniqueNumber(ArrayList<Double> nums) {
        return null;
    }
}
