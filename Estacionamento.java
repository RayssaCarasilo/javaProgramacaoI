import java.util.Scanner;

public class Estacionamento{
    public static void main (String args[]){
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a hora que o veículo entrou: ");
        int hEntrada = teclado.nextInt();

        System.out.print("Digite o minuto que o veículo entrou: ");
        int mEntrada = teclado.nextInt();

        System.out.print("Digite a hora que o veículo saiu: ");
        int hSaida = teclado.nextInt();

        System.out.print("Digite o minuto que o veículo saiu: ");
        int mSaida = teclado.nextInt();

        int momentoEntradaEmMinutos = (hEntrada * 60) + mEntrada;

        int momentoSaidaEmMinutos = (hSaida * 60) + mSaida; 

        if(momentoSaidaEmMinutos < momentoEntradaEmMinutos){
            momentoSaidaEmMinutos += 24 * 60;
        }

        int tempoTotal = momentoSaidaEmMinutos - momentoEntradaEmMinutos;

        System.out.println("O tempo total de permanencia do veiculo foi de " + tempoTotal + " minutos");

        double valor = 0.0;

        if(tempoTotal <= 30){
            valor = tempoTotal * 0.5;
        }else if(tempoTotal > 30 && tempoTotal <= 60){
            valor = tempoTotal * 0.4;
        }else if(tempoTotal > 60 && tempoTotal <= 120){
            valor = tempoTotal * 0.3;
        }else if(tempoTotal > 120 && tempoTotal <= 300){
            valor = tempoTotal * 0.2;
        }else{
            valor = tempoTotal * 0.1;
        }
                
        System.out.println("O valor a pagar será de R$ " + valor);
        teclado.close();
    }
}