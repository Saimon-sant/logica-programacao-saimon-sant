import java.util.Scanner;

public class ex003 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        float a = in.nextFloat();

        System.out.print("Digite o segundo número: ");
        float b = in.nextFloat();

        System.out.print("Digite o terceiro número: ");
        float c = in.nextFloat();

        float classificacao;

        if (a > b && a > c) {
            classificacao = a;
        }else if (b > a && b > c) {
            classificacao = b;
        }else {
            classificacao = c;
        }

        System.out.println("O maior número é: " + classificacao);

        in.close();
    }
}
