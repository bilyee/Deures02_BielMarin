package com.exercicis;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;

public class Exercici0201 {

    public static Scanner scanner;
    public static Locale defaultLocale;

    public static void main(String[] args) {
        
        scanner = new Scanner(System.in);
        defaultLocale = Locale.getDefault();
        Locale.setDefault(Locale.US);
        
        int[] arrEnters = generaArrayEnters(10);
        mostraArrayEstadistiques(arrEnters);

        ArrayList<Integer> lstEnters = generaLlistaEnters(10);
        mostraLlistaEstadistiques(lstEnters);

        filtraArrayParaulesAmbA();
        filtraLlistaParaulesAmbA();

        double[] arrDecimals = generaArrayDecimals(15);
        filtraArrayDecimalsSuperiors50(arrDecimals);

        ArrayList<Double> lstDecimals = generaLlistaDecimals(15);
        filtraLlistaDecimalsSuperiors50(lstDecimals);

        HashMap<String, Integer> persones = new HashMap<>();
        persones.put("Anna", 25);
        persones.put("Joan", 30);
        persones.put("Marc", 20);
        mostrarLlistaOrdenadesPerEdat(persones);

        mostrarFrecuenciaParaules();
        invertirMapaClauValor();
        fusionarMapesSumantValors();
        ordenarMapaPerClaus();
        calcularEstadistiquesNotesEstudiants();

        Locale.setDefault(defaultLocale);
        scanner.close();
    }

    /**
     * Genera un array d'enters aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array d'enters amb valors entre 0 i 99
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraArrayEnters
     */
    public static int[] generaArrayEnters(int mida) {
        int[] rst = new int[mida]; // Creamos un Array con la medida que introduzcamos
        Random generador = new Random(); // Llamamos a la funcion Random

        mida = generador.nextInt(100); // Introducimos tantos numeros como medida hayamos dicho
        
        return rst; // Regresamos el Array
    }

    /**
     * Calcula i mostra estadístiques d'un array d'enters.
     * 
     * Imprimeix per pantalla l'array, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Array: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     *
     * @param array l'array d'enters sobre el qual calcular les estadístiques
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostraArrayEstadistiques
     */
    public static void mostraArrayEstadistiques(int[] array) {
        Integer maximo = Integer.MIN_VALUE; // Variable para almacenar el numero max
        Integer minimo = Integer.MAX_VALUE; // Variable para almacenar el numero min
        double media = 0.0; // Calcular la media

        // Bucle para saber los valores de Max y Min
        for (int valor : array) {
            media += valor; // Sumamos los numeros a la variable
            if (valor > maximo) {
                maximo = valor; // Si el valor es mayor a la variable maximo, lo almacenamos
            } if (valor < minimo) {
                minimo = valor; // Si el valor es menor a la variable minimo, lo almacenamos
            }
        }
        media = media / array.length; // Con la suma total de los numeros, lo dividimos con la longitud del Array

        // Bucle para imprimir los numeros uno por uno con separacion
        System.out.print("Array: ["); 
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1)
                System.out.print(", ");
        }
        System.out.println("]");
        // Imprimimos el maximo, el minimo y la media
        System.out.println("Màxim: " + maximo + "  Mínim: " + minimo + "  Mitjana: " + media);
    }

    /**
     * Genera una llista d'enters aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList d'enters amb valors entre 0 i 99
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraLlistaEnters
     */
    public static ArrayList<Integer> generaLlistaEnters(int mida) {
        ArrayList<Integer> rst = new ArrayList<>(mida); // ArrayList para generar numeros enteros aleatorios
        Random random = new Random(); // Llamamos a la funcion Random

        // Bucle para introducir los numeros random dependiendo de la mida
        for (int i = 0; i < mida; i++) {
            rst.add(random.nextInt(100));
        }

        return rst; // Regresamos el ArrayList
    }

    /**
     * Calcula i mostra estadístiques d'una llista d'enters.
     * 
     * Imprimeix per pantalla la llista, el valor màxim, el mínim i la mitjana.
     * Format d'output:
     * "Llista: [valors]"
     * "Màxim: X  Mínim: Y  Mitjana: Z"
     * 
     *
     * @param llista la llista d'enters sobre la qual calcular les estadístiques
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostraLlistaEstadistiques
     */
    public static void mostraLlistaEstadistiques(ArrayList<Integer> llista) {
        Integer maxim = Integer.MIN_VALUE; // Variable para almacenar el numero Max
        Integer minimo = Integer.MAX_VALUE; // Variable para almacenar el numero Min
        double total = 0.0; // Variable para calcular la media

        // Bucle para saber los valores Max, Min y su media
        for (Integer valor : llista) {
            total += valor; // Sumamos el valor a la variable total
            if (valor > maxim) {
                maxim = valor; // Si el valor es mayor a la variable maxim, lo almacenamos
            }
            if (valor < minimo) {
                minimo = valor; // Si el valor es menor a la variable minim, lo almacenamos
            }
        }
        total = total / llista.size(); // Con la suma de los valores, dividimos con la longitud de la lista

        // Bucle para mostrar numero por numero con separacion
        System.out.print("Llista: [");
        for (int i = 0; i < llista.size(); i++) {
            System.out.print(llista.get(i));
            if (i < llista.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
        // Mostramos el maximo, el minimo y la media
        System.out.println("Màxim: " + maxim + "  Mínim: " + minimo + "  Mitjana: " + total);
    }

    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a'.
     * 
     * Guarda la llista en un "String[] paraules"
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraArrayParaulesAmbA
     */
    public static void filtraArrayParaulesAmbA() {
        // Introducimos las 5 palabras con separacion
        System.out.println("Escriu 5 paraules separades per ',' o ', ': ");
        String input = scanner.nextLine();

        // Remplacamos y dividimos las comas con separacion por comas normales
        String[] paraules = input.replace(", ", ",").split(",");
        int count = 0; // Variable para tener cuenta de las palabras que empiezan por 'a'
        
        // Bucle para buscar las palabras que empiezan por 'a'
        for (String p : paraules) {
            if (p.toLowerCase().startsWith("a")) {
                count++; // Si la palabra empieza por 'a', aumentamos el contador
            }
        }

        // Creamos Array con capacidad del contador para almacenar las palabras
        String[] filtrades = new String[count];
        int index = 0;

        // Bucle para buscar las palabras que empiezan por 'a'
        for (String p : paraules) {
            if (p.toLowerCase().startsWith("a")) {
                filtrades[index++] = p; // Si la palabra empieza por 'a', la almacenamos en el Array
            }
        }
        String rst = String.join(",", filtrades); // Unimos las palabras en el Array con un ',' de separador
        System.out.println("Paraules que començen amb 'a': " + rst); // Mostramos las palabras
    }
       
    /**
     * Demana a l'usuari que escrigui 5 paraules separades per ',' o ', ' 
     * i mostra aquelles que comencen amb 'a' en una sola línia separades per ", ".
     * 
     * Guarda la llista en un "ArrayList<String> paraules".
     * 
     * Es mostra per pantalla:
     * "Escriu 5 paraules separades per ',' o ', ':" per sol·licitar les entrades,
     * i després "Paraules que comencen amb 'a':" seguit de les paraules filtrades.
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraLlistaParaulesAmbA
     */
    public static void filtraLlistaParaulesAmbA() {
        // Introducimos las 5 palabras con separacion
        System.out.println("Escriu 5 paraules separades per ',' o ', ': ");
        String input = scanner.nextLine();

        // Remplazamos y dividimos las comas por separacion por comas normales
        String[] paraulesArray = input.replace(", ", ",").split(",");
        // Creamos un ArrayList con las palabras y otro vacio para almacenar
        ArrayList<String> paraules = new ArrayList<>(Arrays.asList(paraulesArray));
        ArrayList<String> filtrades = new ArrayList<>();

        // Bucle para buscar las palabras que empiezan por 'a'
        for (String p : paraules) {
            if (p.toLowerCase().startsWith("a")) {
                filtrades.add(p); // Si la palabra empieza por 'a', la almacenamos en el ArrayList
            }
        }

        String rst = String.join(", ", filtrades); // Juntamos las palabras con una ',' de separación
        System.out.println("Paraules que comencen amb 'a': " + rst); // Mostramos las palabras
    }

    /**
     * Genera un array de decimals aleatoris.
     *
     * @param mida la mida de l'array a generar
     * @return un array de decimals amb valors entre 0.0 i 100.0
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraArrayDecimals
     */
    public static double[] generaArrayDecimals(int mida) {
        double[] rst = new double[mida];
        Random random = new Random();
        for (int i = 0; i < mida; i++) {
            rst[i] = random.nextDouble() * 100;
        }
        return rst;
    }

    /**
     * Genera una llista de decimals aleatoris.
     *
     * @param mida la mida de la llista a generar
     * @return una ArrayList de decimals amb valors entre 0.0 i 100.0
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraArrayDecimalsSuperiors50
     */
    public static ArrayList<Double> generaLlistaDecimals(int mida) {
        ArrayList<Double> rst = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < mida; i++) {
            rst.add(random.nextDouble() * 100);
        }
        return rst;
    }

    /**
     * Filtra i mostra els decimals superiors a 50 d'un array.
     * 
     * Imprimeix per pantalla l'array original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Array original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     * 
     *
     * @param decimals l'array de decimals a filtrar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testGeneraLlistaDecimals
     */
    public static void filtraArrayDecimalsSuperiors50(double[] decimals) {
        System.out.println("Array original: [");
        for (int i = 0; i < decimals.length; i++) {
            System.out.printf("%.2f", decimals[i]);
            if (i < decimals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");

        int count = 0;
        for (double decimal : decimals) {
            if (decimal > 50) {
                count++;
            }
        }
        double[] filtrats = new double[count];
        int index = 0;
        for (double decimal : decimals) {
            if (decimal > 50) {
                filtrats[index++] = decimal;
            }
        }

        System.out.println("Valors majors que 50 [");
        for (int i = 0; i < filtrats.length; i++) {
            System.out.printf("%.2f", filtrats[i]);
            if (i < decimals.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }


    /**
     * Filtra i mostra els decimals superiors a 50 d'una llista.
     * 
     * Imprimeix per pantalla la llista original de decimals i, a continuació,
     * la llista dels decimals que són majors que 50.
     * Format d'output:
     * "Llista original: [valors]"
     * "Valors majors que 50: [valors filtrats]"
     *
     * @param decimals la llista de decimals a filtrar
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFiltraLlistaDecimalsSuperiors50
     */
    public static void filtraLlistaDecimalsSuperiors50(ArrayList<Double> decimals) {
        String original = "[";
        for (int i = 0; i < decimals.size(); i++) {
            original += String.format("%.2f", decimals.get(i));
            if (i < decimals.size() - 1) {
                original += ", ";
            }
        }
        original += "]";
        System.out.println("Llista original: " + original);

        ArrayList<Double> filtrats = new ArrayList<>();
        for (Double decimal : decimals) {
            if (decimal > 50) {
                filtrats.add(decimal);
            }
        }

        String filtrada = "[";
        for (int i = 0; i < filtrats.size(); i++) {
            filtrada += String.format("%.2f", filtrats.get(i));
            if (i < filtrats.size() - 1) {
                filtrada += ", ";
            }
        }
        filtrada += "]";
        System.out.println("Valors majors que 50: " + filtrada);
    }
    
    /**
     * Mostra per pantalla les persones ordenades per edat.
     * 
     * Recorre un HashMap de persones (nom i edat) i imprimeix cada persona en format "Nom (Edat)"
     * ordenat per edat de manera ascendent.
     *
     * @param persones un HashMap on la clau és el nom de la persona i el valor és la seva edat
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostrarLlistaOrdenadesPerEdat
     */
    public static void mostrarLlistaOrdenadesPerEdat(HashMap<String, Integer> persones) {
        ArrayList<String> keys = new ArrayList<>(persones.keySet());
        keys.sort((k1, k2) -> persones.get(k1).compareTo(persones.get(k2)));
        for (String key : keys) {
            System.out.println(key + " (" + persones.get(key) + ")");
        }
    }

    /**
     * Demana a l'usuari que introdueixi una frase i mostra la freqüència de cada paraula.
     * 
     * L'usuari escriu una frase per la consola i el mètode separa les paraules usant els espais.
     * A continuació, es calcula la freqüència de cada paraula i es mostra per pantalla en format de HashMap.
     * 
     * 
     * Es mostra per pantalla:
     * "Introdueix una frase:" i després "Freqüència de paraules: {paraula=frequencia, ...}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testMostrarFrecuenciaParaules
     */
    public static void mostrarFrecuenciaParaules() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introdueix una frase: ");
        String input = scanner.nextLine().trim();
        String[] paraules = input.split("\\s+");
        HashMap<String, Integer> frecuencia = new HashMap<>();
        for (String paraula : paraules) {
            frecuencia.put(paraula, frecuencia.getOrDefault(paraula, 0) + 1);
        }
        System.out.println("Freqüència de paraules: " + frecuencia);
    }

    /**
     * Inverteix un HashMap intercanviant claus i valors.
     * 
     * Es crea un HashMap amb elements (A=1, B=2, C=3) i es construeix un nou HashMap on cada valor 
     * es converteix en clau i cada clau es converteix en valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa original: {A=1, B=2, C=3}" i "Mapa invertit: {1=A, 2=B, 3=C}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testInvertirMapaClauValor
     */
    public static void invertirMapaClauValor() {

    }

    /**
     * Fusiona dos HashMap sumant els valors de les claus comuns.
     * 
     * Es defineixen dos mapes:
     * <ul>
     *   <li>Mapa 1: {X=10, Y=20}</li>
     *   <li>Mapa 2: {Y=5, Z=15}</li>
     * </ul>
     * El mètode crea un nou HashMap on, per cada clau existent en ambdós mapes, es suma el valor.
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa fusionat: {X=10, Y=25, Z=15}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testFusionarMapesSumantValors
     */
    public static void fusionarMapesSumantValors() {

    }

    /**
     * Ordena un HashMap per les claus mitjançant un TreeMap i mostra el resultat.
     * 
     * Es crea un HashMap amb elements (Banana=3, Poma=5, Taronja=2) i es transfereix a un TreeMap
     * per obtenir un ordre natural de les claus (alfabètic).
     * 
     * 
     * Es mostra per pantalla:
     * "Mapa ordenat per claus: {Banana=3, Poma=5, Taronja=2}".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testOrdenarMapaPerClaus
     */
    public static void ordenarMapaPerClaus() {

    }

    /**
     * Calcula i mostra les estadístiques (mitjana, màxim i mínim) de les notes dels estudiants.
     * 
     * Es defineix un HashMap on la clau és el nom de l'estudiant i el valor la seva nota.
     * El mètode calcula la mitjana, la nota màxima i la nota mínima i les mostra per pantalla.
     * 
     * 
     * Es mostra per pantalla:
     * "Mitjana: [valor], Màxim: [valor], Mínim: [valor]".
     * 
     * @test ./runTest.sh com.exercicis.TestExercici0201#testCalcularEstadistiquesNotesEstudiants
     */
    public static void calcularEstadistiquesNotesEstudiants() {

    }
}
