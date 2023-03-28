public class TextBasedVendingMachine implements VendingMachineInterface{

    private int selectProduct;
    private CoinBundle change;
    @Override
    public void displayProducts() {
        System.out.println("************************************");
        System.out.println("   WELCOME TO THE VENDING MACHINE   ");
        System.out.println("************************************");

        System.out.println("        Products available:         ");
        System.out.println("                                    ");

        for (Products products: Products.values()){
            System.out.println(products.getId()+ " " + products.name() + " - Price:" + products.getPrice());
        }

        System.out.println("                                    ");
        System.out.println("Please select your product: ");
    }

    @Override
    public void selectProduct(int product) {
        this.selectProduct = product;
    }

    @Override
    public void displayEnterCoinsMessage() {
        System.out.println("Please enter coins as follows: ");
        System.out.println("Num of 5 Cents coins, Num of 10 cents coins etc.");
        System.out.println("                                    ");
        System.out.println("Example: If you would like to enter two 10 cents coins : 0,2,0,0,0");
        System.out.println("Please enter coins: ");
    }

    @Override
    public void enterCoins(int... coins) {
        Calculator calculator = new SimpleCalculator();
        Products products = Products.valueOf(this.selectProduct);
        int total = calculator.calculateTotal(new CoinBundle(coins));

        int changeAmount = total - products.getPrice();
        this.change = calculator.calculateChange(changeAmount);

    }

    @Override
    public void displayChangeMessage() {
        System.out.println("Thank you for using my Vending Machine :)");
        System.out.println("                                    ");
        System.out.println("Your Change is: " + change.getTotal() + " cents splitted as follows: ");
        System.out.println("5 cents coins: " + change.number5CentsCoins);
        System.out.println("10 cents coins: " + change.number10CentsCoins);
        System.out.println("20 cents coins: " + change.number20CentsCoins);
        System.out.println("50 cents coins: " + change.number50CentsCoins);
        System.out.println("100 cents coins: " + change.number100CentsCoins);


    }
}
