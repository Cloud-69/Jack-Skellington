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
        int whoWon = 0; // 1 blackjack jugador - 2 blackjack crupier - 3 jugador normal - 4 crupier normal 
                        // 5 jugador se pasa - 6 crupier se pasa - 7 empate

        while (whoWon == 0){                            // When someone wins, whoWon changes it value,
            for (int i = 0; i < 2; i++) {              // taking them out of the game
                ptoJugador += darCarta();
            }
            if (ptoJugador == 21){
            whoWon = 1;
            }

            while (ptoJugador < 21 && otraCarta == 1){
                System.out.println("Sus puntos suman "+ptoJugador+
                "\nQuiere otra carta?\n1 para si, 0 para no");
                otraCarta = entrada.nextInt();
                if (otraCarta == 1){ptoJugador += darCarta();}
            }
            if (ptoJugador == 21){
                System.out.println("Hiciste blackjack, pero si el crupier también hace blackjack, él ganará");
                whoWon = 1;
            } else if (ptoJugador > 21){
                whoWon = 5;
            }

            if (whoWon == 0){
                System.out.println("Se le darán cartas al crupier");
                for (int i = 0; i < 2; i++) {
                ptoCrupier += darCarta();
            }
            if (ptoCrupier == 21){
                whoWon = 2;
            }
            while (ptoCrupier<=16 && ptoCrupier <= ptoJugador){
                ptoCrupier+=darCarta();
            }}

            if (whoWon == 1){
                System.out.println("Se le darán cartas al crupier");
                for (int i = 0; i < 2; i++) {
                ptoCrupier += darCarta();
                    }
                if (ptoCrupier == 21){
                // BLACKJACK CRUPIER
                whoWon = 2;
                }
            }

            if (whoWon == 0){whoWon = winLose(ptoJugador, ptoCrupier);}

        }

        switch(whoWon){
            case 1:
                System.out.println("Genial, hiciste un blackjack");
                break;
            case 2:
                System.out.println("El crupier hizo blackjack");
                break;
            case 3:
                System.out.println("Genial, ganaste con "+ptoJugador+" puntos\nCrupier: "+ptoCrupier+" puntos");
                break;
            case 4:
                System.out.println("El crupier te ganó con "+ptoCrupier+" puntos, pero ánimo, tuviste "+ptoJugador+" puntos");
                break;
            case 5:
                System.out.println("Te pasaste de 21 puntos, tuviste "+ptoJugador);
                break;
            case 6:
                System.out.println("El crupier se pasó de 21, tuvo "+ptoCrupier);
                break;
            case 7:
                System.out.println("Empataron, el crupier gana");
                break;
            default:
                System.out.println("Disculpanos, ha ocurrido un error. Contacta a los developers para solucionarlo\nPuedes volver a iniciar el juego, posiblemente lo resuelva");
        }
        
    }


    int winLose(int player, int crupier){
        
        if (crupier > 21){
            return 6;
        }else if (player > crupier && player <=21){
            return 3;
        }
        else if (crupier > player && crupier <=21){
            return 4;
        }
        else if(player > 21){
            return 5;
        } else if(crupier == player){
            return 7;
        }
        else{
            return 10;
        }
    }

    

    int darCarta(){
        int puntos;
        String[] numero = {"As","2","3","4","5","6","7","8","9","10","J","Q","K"};
        int i = azar.nextInt(13);
        String[] palo = {"corazones","diamantes","pica","trébol"};
        int j = azar.nextInt(4);
        System.out.println("\n"+
        numero[i] + " de " + palo[j]); // agrego un \n al principio para que sea más fácil ver el número
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
        System.out.println("Bienvenido al juego, le daremos dos cartas");
        p.iniciar();
        
    }
}