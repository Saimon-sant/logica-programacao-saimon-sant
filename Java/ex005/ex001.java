import java.util.Scanner;

public class ex001 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Quanto tempo em minutos passou? : ");
        double minutos = in.nextDouble();

        double funcao = 50 + (minutos * 2);

        String condiçao;

        if (minutos <= 100) {
            condiçao = "Valor a pagar: R$50";
        }else {
            condiçao = "Valor a pagar:" + funcao;
        }

        System.out.print(condiçao);

        in.close();
    }
}