import java.util.Random;
import java.util.Scanner;

public class ParOuImpar{
    public static void main(String[] args){
        Scanner digito = new Scanner(System.in);
        Scanner palpite = new Scanner(System.in);

        System.out.print("Digite um número de 0 a 10: ");
        int numeroInt = digito.nextInt();
        boolean chute;

        System.out.print("Digite seu palpite, se o valor final será par ou impar?: ");
        String palavra = palpite.next();

        if(numeroInt < 0 || numeroInt > 10 ){
            System.out.println("Número inválido, tente novamente com um número de 0 a 10");
            return;
        }

        int random = new Random().nextInt(11);

        int soma = random + numeroInt;

        if(soma % 2 == 0){
            chute = true;
        }else{
            chute = false;
        }

        System.out.println("O número do usuário foi: " + numeroInt);
        System.out.println("O número do computador foi: " + random);
        System.out.println("O número da soma foi: " + soma);

        if((palavra.equals("par") && chute == true) || (palavra.equals("impar") && chute == false)){
            System.out.println("Parabéns você acertou!");
        }else{
            System.out.println("Que pena não foi dessa vez! Tente novamente!");
        }
    }
}
