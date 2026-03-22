import java.util.Scanner;

public class ex002 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.print("Digite um número: ");
        Double numero = in.nextDouble();

        String classificacao;

        if (numero > 0) {
            classificacao = "Positivo";
        }else if(numero == 0) {
            classificacao = "Zero";
        }else {
            classificacao = "Negativo";
        }

        System.out.print("O número é: " + classificacao);

        in.close();
    }
}