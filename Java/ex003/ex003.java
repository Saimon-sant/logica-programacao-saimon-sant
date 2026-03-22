import java.util.Scanner;

public class ex003 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Qual é o seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Qual é o seu peso em Kg: ");
        double peso = scanner.nextDouble();

        System.out.print("Qual é a sua altura em metros: ");
        double altura = scanner.nextDouble();

        double IMC = peso / (altura * altura);
        String classificacao;

            if (IMC < 18.5) {
                classificacao = "Abaixo do peso";
            }else if (IMC <= 24.9) {
                classificacao = "Peso normal";
            }else if (IMC <= 29.9) {
                    classificacao = "Sobrepeso";
            }else if (IMC <= 34.9) {
                classificacao = "Obesidade Grau I";
            }else if (IMC <= 39.9) {
                    classificacao = "Obesidade Grau II";
            }else {
                classificacao = "Obesidade Grau III (Grave)";
            }
        System.out.println("Olá, " + nome);
        System.out.println("Peso: " + peso + "Kg");
        System.out.println("Altura: " + altura + "m");
        System.out.println("Seu IMC: " + IMC);
        System.out.println("Sua Classificação: " + classificacao);

        scanner.close();
                
    }
}
