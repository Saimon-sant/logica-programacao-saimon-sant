import java.util.Scanner;

public class ex003 {
    public static void main(String[] args) {
        System.out.println("Qual é a temperatura atual em Celsius?");
            Scanner scanner = new Scanner(System.in);
            double C = scanner.nextDouble();
            double fahrenheit = (C*1.8) + 32 ;
            double kelvin = C + 273.15 ;
            System.out.println("O valor da temperatura em fahrenheit é: " + fahrenheit );
            System.out.println("O valor da temperatura em kelvin é: " + kelvin );
    }
}
