package dao;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import model.Product;

@Transactional
@Repository
public class ProductDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    public void createProduct(Product product) {
        this.hibernateTemplate.save(product);
    }

    public List<Product> getProducts() {
        return this.hibernateTemplate.loadAll(Product.class);
    }

    public void deleteProduct(int pid) {
        Product p = this.hibernateTemplate.load(Product.class, pid);
        if (p != null) {
            this.hibernateTemplate.delete(p);
        }
    }

    public Optional<Product> getProduct(int pid) {
        return Optional.ofNullable(this.hibernateTemplate.get(Product.class, pid));
    }
}
