package ticket;

import entities.Product;
import java.util.ArrayList;
import java.util.Random;

public class RaffleTickets {

    public RaffleTickets() {

    }

    public static void raffleTickets(ArrayList<GoldenTicket> goldenTickets, ArrayList<Product> allProducts) {
        
        
        Random rand = new Random();
        int i = 0;
            while(i < goldenTickets.size()){
            Product product = allProducts.get(rand.nextInt(allProducts.size()));
            if (product.getPrizeTicket() == null) {
                product.setPrizeTicket(goldenTickets.get(i));
                i++;
            } 
        }
        
    }

}

