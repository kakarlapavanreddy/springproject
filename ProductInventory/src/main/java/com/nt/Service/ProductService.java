package com.nt.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nt.Model.Product;

@Service
public class ProductService {

    // Temporary storage using List
    private List<Product> productList = new ArrayList<>();

    // ADD PRODUCT
    public Product addProduct(Product product) {

        productList.add(product);

        return product;
    }

    // GET ALL PRODUCTS
    public List<Product> getAllProducts() {

        return productList;
    }

    // GET PRODUCT BY ID
    public Product getProductById(int id) {

        for (Product product : productList) {

            if (product.getProductId() == id) {

                return product;
            }
        }

        throw new RuntimeException("Product not found with ID : " + id);
    }

    // UPDATE PRODUCT
    public Product updateProduct(int id, Product updatedProduct) {

        for (Product product : productList) {

            if (product.getProductId() == id) {

                product.setProductName(updatedProduct.getProductName());
                product.setCategory(updatedProduct.getCategory());
                product.setStock(updatedProduct.getStock());
                product.setPrice(updatedProduct.getPrice());

                return product;
            }
        }

        throw new RuntimeException("Cannot update. Product not found with ID : " + id);
    }

    // DELETE PRODUCT
    public String deleteProduct(int id) {

        Product product = getProductById(id);

        productList.remove(product);

        return "Product deleted successfully";
    }
}