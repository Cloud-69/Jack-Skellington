package paquete;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    Scanner entrada = new Scanner(System.in);
    Random azar = new Random();

    void iniciar(){
        int ptoJugador = 0;
        int ptoCrupier = 0;
        int otraCarta = 0;

        while (otraCarta == 1){
            if (ptoJugador < 21){darCarta();}
            else {winLose(ptoJugador,ptoCrupier);}
            
        }
        


        System.out.println("INICIALIZANDO... *RUIDO DE ROBOT*");
        
    }

    void winLose(int player, int crupier){
        
        if (player == 21){
            System.out.println("Gana el player");
        }else{System.out.println("Gana el crupier");}

    }

    int darCarta(){
        int puntos;
        String[] numero = {"As","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int i = azar.nextInt(13);
        String[] palo = {"corazones","diamantes","pica","trébol"};
        int j = azar.nextInt(4);
        System.out.println(numero[i] + " de " + palo[j]);
        i++;
        puntos = i;
        switch(i){
            case 1:
                puntos = 11;
                break;
            case 11: case 12: case 13:
                puntos = 10;
                break;
        }
        return puntos;
    }

    // DECLARACIÓN DE MÉTODOS DISCRETOS AHRE

    public static void main(String[] args){
        Principal p = new Principal();
        p.iniciar();
        p.darCarta();
    }
}