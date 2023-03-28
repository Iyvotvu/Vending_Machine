import java.io.StringBufferInputStream;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        VendingMachineInterface machineInterface = new TextBasedVendingMachine();

        machineInterface.displayProducts();

        String selectedProduct = scanner.nextLine();
        machineInterface.selectProduct(Integer.parseInt(selectedProduct));

        machineInterface.displayEnterCoinsMessage();

        String userEnteredCoins = scanner.nextLine();

        int [] enteredCoins = Coin.parseCoins(userEnteredCoins);

        machineInterface.enterCoins(enteredCoins);
        machineInterface.displayChangeMessage();

    }
}