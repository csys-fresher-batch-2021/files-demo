package com.naresh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProductFileReader {

	public static void main(String[] args) throws IOException {

		testRead();
	}

	private static void testRead() throws IOException {
		
		// Step 1: Specify filename with path
		Path path = Paths.get("products.txt");
		// Step 2: read file entire content - readAllBytes
		byte[] readAllBytes = Files.readAllBytes(path);
		String content = new String(readAllBytes);
		System.out.println("TotalContents:" + content);

		System.out.println("Read file contents:");
		List<String> lines = Files.readAllLines(path);//Read the file line by line
		for (String line : lines) {
			String[] split = line.split("-");
			String id = split[0];
			String name = split[1];
			String price = split[2];
			System.out.println("id="+ id + ",name=" + name + ",price=" + price);
			//dao.addproduct(id,name,price);
		}
	}

}