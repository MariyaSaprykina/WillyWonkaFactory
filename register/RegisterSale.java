package register;

import entities.Kid;
import entities.Product;
import java.util.ArrayList;
import java.util.Random;


public class RegisterSale {

    private ArrayList<Kid> kids;
    private ArrayList<Product> allProducts;

    Random rand = new Random();

    public RegisterSale(ArrayList<Kid> kids, ArrayList<Product> allProducts) {
        this.kids = kids;
        this.allProducts = allProducts;
    }

    public void buyProduct(int code, long barcode) {
        ArrayList<Product> kidProducts;
        ArrayList<Product> sameBarcode = new ArrayList<>();
        for (Product product : allProducts) {
                    if (barcode == product.getBarcode()) {
                        sameBarcode.add(product);
                    }
                }
        for (Kid kid : kids) {
            if (kid.getCode() == code) {
                

                Product randomProduct = sameBarcode.get(rand.nextInt(sameBarcode.size()));
                kidProducts = kid.getProducts();
                kidProducts.add(randomProduct);
                allProducts.remove(randomProduct);
                System.out.println(kid.toString());
                

            }
        }
    }
}

