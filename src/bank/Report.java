package bank;

import java.util.List;

/**
 * Created by Maciej on 11.10.2018.
 */
public class Report {

    private List<Product> products;

    public Report() {

    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

}
