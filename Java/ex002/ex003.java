import java.util.Scanner;

public class ex003 {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Qual é a temperatura atual em Celsius?");
        double C = scanner.nextDouble();
        double fahrenheit = (C*1.8) + 32 ;
        double kelvin = C + 273.15 ;
        System.out.println("O valor da temperatura em fahrenheit é: " + fahrenheit );
        System.out.println("O valor da temperatura em kelvin é: " + kelvin );

        scanner.close();
    }
}
