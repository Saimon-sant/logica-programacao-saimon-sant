import java.util.*;

public class ex001 {
    public static void main(String[] args) {
        
        Scanner in = new Scanner(System.in);

        System.out.print("Qual a sua idade? : ");
        int idade = in.nextInt();

        String classificacao;

        if(idade >= 18){
            classificacao = "Maior de idade";
        }else{
            classificacao = "Menor de idade";
        }

        System.out.print("Você é: " + classificacao);

        in.close();
    }
}