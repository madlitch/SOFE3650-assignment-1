import java.io.FileReader;
import java.io.BufferedReader;

public class ProductFactoryDrive {

    private static final ProductFactory productFactory = new ProductFactory();
    static final String fileName = "products.csv";
    static final String delimiter = ",";

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = br.readLine()) != null) {
                String[] product = line.split(delimiter);
                try {
                    Product newProduct = productFactory.create(product[0]);
                    newProduct.setPrice(Double.parseDouble(product[1]));
                    System.out.println(newProduct);
                } catch (Exception e) {
                    System.out.println("No product with name '" + product[0] + "'");
                }
            }
        } catch (Exception e) {
            System.out.println(fileName + " not found");
        }
    }
}

interface Product {
    void setPrice(double price);
    String toString();
}

class Orange implements Product {
    double price;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Orange: " + this.price;
    }
}

class Apple implements Product {
    double price;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Apple: " + this.price;
    }
}

class Banana implements Product {
    double price;

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Banana: " + this.price;
    }
}

interface AbstractFactory<T> {
    T create(String productType) throws Exception;
}

class ProductFactory implements AbstractFactory<Product> {
    @Override
    public Product create(String productType) throws Exception {
        if ("Apple".equalsIgnoreCase(productType)) {
            System.out.println("New Apple Created");
            return new Apple();
        } else if ("Orange".equalsIgnoreCase(productType)) {
            System.out.println("New Orange Created");
            return new Orange();
        } else if ("Banana".equalsIgnoreCase(productType)) {
            System.out.println("New Banana Created");
            return new Banana();
        } else {
            throw new Exception("No product with name '" + productType + "'");
        }
    }
}
