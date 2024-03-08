package com.learning.course.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.learning.course.entities.Category;
import com.learning.course.entities.Order;
import com.learning.course.entities.OrderItem;
import com.learning.course.entities.Payment;
import com.learning.course.entities.Product;
import com.learning.course.entities.User;
import com.learning.course.entities.enums.OrderStatus;
import com.learning.course.repositories.CategoryRespository;
import com.learning.course.repositories.OrderItemRepository;
import com.learning.course.repositories.OrderRespository;
import com.learning.course.repositories.ProductRepository;
import com.learning.course.repositories.UserRespository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRespository userRepository;
	
	@Autowired
	private OrderRespository orderRespository;
	
	@Autowired
	private CategoryRespository categoryRespository;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		User u1 = new User(null, "Marcos", "marcos@gmail.com", "31 9 1234-5678", "12345");
		User u2 = new User(null, "Amanda", "amanda@gmail.com", "11 9 1234-5678", "54321");
		
		Order o1 = new Order(null, Instant.parse("2024-03-05T19:20:12-03:00"), OrderStatus.WAINTING_PAYMENT, u1);
		Order o2 = new Order(null, Instant.parse("2020-04-20T08:25:10Z"), OrderStatus.CANCELED, u2);
		Order o3 = new Order(null, Instant.parse("2021-06-20T10:56:20Z"), OrderStatus.PAID, u1);
		
		Category c1 = new Category(null, "Eletronics");
		Category c2 = new Category(null, "Books");
		Category c3 = new Category(null, "Computers");
		
		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRespository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRespository.saveAll(Arrays.asList(c1, c2, c3));
		
		p1.getCategories().add(c2);
		p2.getCategories().add(c1); 
		p3.getCategories().add(c1);
		p3.getCategories().add(c3);
		p4.getCategories().add(c1);
		p4.getCategories().add(c3);
		p5.getCategories().add(c2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice()); 
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice()); 
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice()); 
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice()); 
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(Instant.parse("2024-03-05T22:20:12-03:00"), o1);
		o1.setPayment(pay1);
		
		orderRespository.save(o1);
	}
	
}
