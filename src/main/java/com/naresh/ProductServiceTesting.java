package com.naresh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.naresh.model.Product;

public class ProductServiceTesting {

	public static void main(String[] args) throws IOException {

		// DB => select * from products;
		Product p1 = new Product(1,"Sugar",100);
		Product p2 = new Product(2,"Salt", 15);
		Product p3= new Product(3,"Tea", 30);
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(p1);
		productList.add(p2);
		productList.add(p3);
		
		ProductService.exportProductDetails(productList);
		
		//ProductService.importProducts();
	}

	
}