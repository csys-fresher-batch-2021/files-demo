package com.naresh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.naresh.model.Product;

public class ProductService {

	public static void exportProductDetails(List<Product> productList) throws IOException {

		// select * from products - List<Product> => iterate
		// 1. Specify File Path
		Path path = Paths.get("products.txt");

		StringBuilder content = new StringBuilder();
		int noOfProducts = productList.size();
		int i = 1;
		for (Product product : productList) {
			// content.append("2-Salt-15").append("\n");
			content.append(product.getId()).append("-").append(product.getName()).append("-")
					.append(product.getPrice());
			if (noOfProducts != i) {
				content.append("\n");
			}
			i++;
		}

		String fileContent = content.toString();// Convert it to String

		// 3. Write Contents to a file
		byte[] bytes = fileContent.getBytes();
		Files.write(path, bytes);
		System.out.println("File contents written successfully");

	}

	public static void importProducts() throws IOException {

		// Step 1: Specify filename with path
		Path path = Paths.get("products.txt");
		// Step 2: read file entire content - readAllBytes
		byte[] readAllBytes = Files.readAllBytes(path);
		String content = new String(readAllBytes);
		System.out.println("TotalContents:" + content);

		System.out.println("Read file contents:");
		List<String> lines = Files.readAllLines(path);// Read the file line by line
		for (String line : lines) {
			String[] split = line.split("-");
			int id = Integer.parseInt(split[0]);
			String name = split[1];
			int price = Integer.parseInt(split[2]);
			Product product = new Product(id, name, price);
			System.out.println(product);
			// dao.addproduct(product);
		}
	}

}