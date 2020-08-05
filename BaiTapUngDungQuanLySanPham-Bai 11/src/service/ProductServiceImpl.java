package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer,Product> products;
    private static int i=0;
    static {
        products=new HashMap<>();
        products.put(1, new Product(++i, "Miliket", "mì ngon", 45));
        products.put(2, new Product(++i, "Tomi", "kẹo su", 452));
        products.put(3, new Product(++i, "Sida", "cá chép", 454));
        products.put(4, new Product(++i, "Moom", "mèo", 12));
        products.put(5, new Product(++i, "linda", "mực", 4534));
        products.put(6, new Product(++i, "Kop", "chôn", 45213));

    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(++i,product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
