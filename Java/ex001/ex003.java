import java.util.Scanner;

public class ex003 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Quanto é 2 + 2?");
        System.out.print("Digite a resposta: ");

        int resposta = input.nextInt();

        System.out.println("A resposta é: " + resposta);

        input.close();
    }
    
}