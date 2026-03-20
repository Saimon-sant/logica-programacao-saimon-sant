import java.util.Scanner;

public class ex002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro: ");
        int num1 = scanner.nextInt();

        System.out.print("Digite outro número inteiro: ");
        int num2 = scanner.nextInt();
        
        int soma = num1 + num2;
        System.out.print("A soma dos dois números é: " + soma);

        scanner.close();
    }
}
