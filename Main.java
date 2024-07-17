public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();
        boolean exit = false;

        while (!exit) {
            menu.display();
            int choice = menu.getChoice();
            try {
                switch (choice) {
                    case 1:
                        handleConversion("USD", "ARS");
                        break;
                    case 2:
                        handleConversion("ARS", "USD");
                        break;
                    case 3:
                        handleConversion("USD", "BRL");
                        break;
                    case 4:
                        handleConversion("BRL", "USD");
                        break;
                    case 5:
                        handleConversion("USD", "COP");
                        break;
                    case 6:
                        handleConversion("COP", "USD");
                        break;
                    case 7:
                        exit = true;
                        System.out.println("Gracias por usar el conversor de monedas. ¡Adiós!");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente de nuevo.");
                }
            } catch (Exception e) {
                System.out.println("Error al realizar la conversión: " + e.getMessage());
            }
        }
    }

    private static void handleConversion(String from, String to) throws Exception {
        CurrencyConverter converter = new CurrencyConverter(from);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese la cantidad en " + from + ":");
        double amount = scanner.nextDouble();
        double result = converter.convertTo(to, amount);
        System.out.println(amount + " " + from + " son equivalentes a " + result + " " + to);
    }
}
