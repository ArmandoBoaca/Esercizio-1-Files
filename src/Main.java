/*
Scrivi un programma che che legga dei numeri inseriti in un file di testo.
Se nel file di testo non vi è niente, il programma deve avvisare che il
file è vuoto, se vi è un solo numero, questo numero deve essere stampato,
 se vi sono due numeri (disposti su due righe differenti) deve essere
 stampato il loro prodotto, se vi sono più di due numeri (disposti righe
 differenti) deve essere stampata la loro somma.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
public class Main {

    public static void main(String[] args) {

        int nParam = 1;
        if (args.length >= nParam) {
            File input = new File(args[0]);
            if(input.exists()){
                String returnS = "";
                try{
                    BufferedReader br = new BufferedReader(new FileReader(input));

                    String riga = "";
                    int numero = 0;
                    int conteggio = 0;

                    while ((riga = br.readLine()) != null) {
                        int valore = Integer.parseInt(riga);

                        if (conteggio == 0) {
                            numero = valore;
                        } else if (conteggio == 1) {
                            numero *= valore;
                        } else {
                            numero += valore;
                        }

                        conteggio++;
                    }
                    if (conteggio == 0) {
                        System.out.println("Il file è vuoto.");
                    } else if (conteggio == 1) {
                        System.out.println("Numero nel file: " + numero);
                    } else if (conteggio == 2) {
                        System.out.println("Prodotto dei due numeri: " + numero);
                    } else {
                        System.out.println("Somma di tutti i numeri: " + numero);
                    }


                    System.out.println("Fatto!");

                    br.close();

                } catch (Exception e){
                    System.err.print(e);
                }
            }

        }

    }
}