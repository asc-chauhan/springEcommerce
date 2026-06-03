package com.ecommerce.anshul.config;

import com.ecommerce.anshul.model.Category;
import com.ecommerce.anshul.model.Product;
import com.ecommerce.anshul.repositories.CategoryRepository;
import com.ecommerce.anshul.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataSeeder {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    @Bean
    public CommandLineRunner seedData() {
        return args -> {
            if (categoryRepository.count() == 0) {
                // Seed categories
                Category electronics = new Category();
                electronics.setCategoryName("Electronics");
                categoryRepository.save(electronics);

                Category furniture = new Category();
                furniture.setCategoryName("Furniture");
                categoryRepository.save(furniture);

                Category apparel = new Category();
                apparel.setCategoryName("Apparel");
                categoryRepository.save(apparel);

                Category books = new Category();
                books.setCategoryName("Books & Stationery");
                categoryRepository.save(books);

                Category sports = new Category();
                sports.setCategoryName("Sports Equipment");
                categoryRepository.save(sports);

                // Seed products
                if (productRepository.count() == 0) {
                    createProduct("Laptop", "Alienware m18 R2 Gaming Laptop - 32GB LPDDR5 RAM, 1TB SSD, Lunar Silver with advanced cooling system.",
                            3499.00, 15, 10, "https://images.unsplash.com/photo-1517336714731-489689fd1ca8?w=600&h=400&fit=crop", electronics);

                    createProduct("headphones", "Sony WH-1000XM5 Best Active Noise Cancelling Wireless Bluetooth Over Ear Headphones with premium sound.",
                            200.00, 10, 25, "https://images.unsplash.com/photo-1505740420928-5e560c06d30e?w=600&h=400&fit=crop", electronics);

                    createProduct("Robot", "Its a multi-tasking, highly efficient and a cute robot. Perfect for home automation and entertainment.",
                            500.00, 10, 5, "https://images.unsplash.com/photo-1485827404703-89b55fcc595e?w=600&h=400&fit=crop", electronics);

                    createProduct("Jacket", "Vintage 90s White Nike Jacket - Medium, Polyester, Classic Swoosh Logo, Retro Sportswear style.",
                            109.00, 15, 20, "https://images.unsplash.com/photo-1551028719-00167b16eac5?w=600&h=400&fit=crop", apparel);

                    createProduct("Shoes", "Nike Pegasus 40 Men's Road Running Shoes, Black/White-Dark Grey, React foam cushioning for comfort.",
                            130.00, 25, 15, "https://images.unsplash.com/photo-1542291026-7eec264c27ff?w=600&h=400&fit=crop", apparel);

                    createProduct("sofa", "VIMLE 3-seat sofa with chaise longue, with headrest/Gunnared medium grey. Modern comfort for your living room.",
                            900.00, 10, 5, "https://images.unsplash.com/photo-1555041469-a586c61ea9bc?w=600&h=400&fit=crop", furniture);

                    createProduct("Computer Table", "Calisto Engineered Wood Study Table Laptop Table with Drawer. Perfect for home office setup.",
                            179.00, 15, 8, "https://images.unsplash.com/photo-1518455027359-f3f8164ba6bd?w=600&h=400&fit=crop", furniture);

                    createProduct("Book Shelf", "Tree Bookshelf, 9-Tier Geometric Tree Bookcase for living room, bedroom or office decor.",
                            149.00, 10, 12, "https://images.unsplash.com/photo-1507842217343-583bb7270b66?w=600&h=400&fit=crop", books);
                }
            }
        };
    }

    private void createProduct(String name, String description, double price, double discount, int quantity, String image, Category category) {
        Product product = new Product();
        product.setProductName(name);
        product.setDescription(description);
        product.setPrice(price);
        product.setDiscount(discount);
        product.setSpecialPrice(price - (price * discount / 100));
        product.setQuantity(quantity);
        product.setImage(image);
        product.setCategory(category);
        productRepository.save(product);
    }
}
