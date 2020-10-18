package paquete;
import java.util.Random;
import java.util.Scanner;

public class Principal {
    Scanner entrada = new Scanner(System.in);
    Random azar = new Random();

    void iniciar(){
        int ptoJugador = 0;
        int ptoCrupier = 0;
        int otraCarta = 1;
        boolean turnoJugador = true;

        while (turnoJugador && otraCarta==1 && ptoJugador < 21){System.out.println("Jugador tomando carta...");
        ptoJugador+=darCarta();
        System.out.println("Quiere otra carta?\n1 para si, 0 para no");
        otraCarta = entrada.nextInt();
        turnoJugador = !turnoJugador;
        }
        
        

        if (!turnoJugador && ptoCrupier < 21){
            System.out.println("Crupier tomando carta...");
            ptoCrupier+=darCarta();
        }    
    winLose(ptoJugador, ptoCrupier);
    };

        
    
        int tiraCrupier(){
            
        System.out.println("Crupier tomando carta...");
        return darCarta();}
    

    void winLose(int player, int crupier){
        
        if (player <= 21 && player > crupier){
            System.out.println("Gana el player");
        
        }
        else if (crupier <= 21 && crupier > player){
            System.out.println("Gana el crupier, que malo sos."); 
        }
    }

    

    int darCarta(){
        int puntos;
        String[] numero = {"As","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int i = azar.nextInt(13);
        String[] palo = {"corazones","diamantes","pica","trébol"};
        int j = azar.nextInt(4);
        System.out.println("\n"+numero[i] + " de " + palo[j]); // agrego un \n al principio para que sea más fácil ver el número
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

    public static void main(String[] args){
        Principal p = new Principal();
        p.iniciar();
        System.out.println("Bienvenido al juego, le daremos una carta");        
    }
}