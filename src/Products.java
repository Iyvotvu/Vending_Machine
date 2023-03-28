public enum Products {
    TWIX(1,100),COKE(2,50),WATER(3,30),SANDWICH(4,150);

    private int id;
    private int price;

    Products(int id, int price){
        this.id = id;
        this.price = price;
    }

    public int getId(){
        return this.id;
    }
    public int getPrice(){
        return this.price;
    }

    public static Products valueOf(int productSelected){
        for (Products products: Products.values()){
            if (productSelected == products.getId()){
                return products;
            }
        }
        return null;
    }
}
