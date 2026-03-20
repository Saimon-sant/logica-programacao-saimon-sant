import java.util.Scanner;

public class ex004 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);
        
        System.out.print("Digite um número intero, para descobrir se é ímpar ou par: ");
        int numero = in.nextInt();

        int condicaçao = numero % 2;
        String classificaçao;

        if (condicaçao == 0) {
            classificaçao = "par";
        }else {
            classificaçao = "ímpar";
        }

        System.out.print("O número " + numero + " é: " + classificaçao);

        in.close();

    }
    
}