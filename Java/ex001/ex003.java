import java.util.Scanner;

public class ex003 {
    public static void main(String[] args) {
        System.out.println("Quanto é 2 + 2?");
            Scanner input = new Scanner(System.in);
            System.out.print("Digite a resposta: ");
            String resposta = input.nextLine();
        System.out.println("A resposta é: " + resposta);
    }
    
}