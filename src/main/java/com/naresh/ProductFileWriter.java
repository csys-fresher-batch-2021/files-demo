package com.naresh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ProductFileWriter {

	public static void main(String[] args) throws IOException {

		testWriteFile();
	}

	private static void testWriteFile() throws IOException {
		
		//select * from products - List<Product> => iterate
		// 1. Specify File Path
		Path path = Paths.get("products.txt");

		// 2. Prepare the File Content
		// String fileContent = "1-Sugar-100\n2-Salt-15\n,3-Tea-30";

		// StringBuffer content = new StringBuilder(); //Java 5
		StringBuilder content = new StringBuilder();
		content.append("1-Sugar-100").append("\n");
		content.append("2-Salt-15").append("\n");
		content.append("3-Tea-30");

		String fileContent = content.toString();// Convert it to String

		// 3. Write Contents to a file
		byte[] bytes = fileContent.getBytes();
		Files.write(path, bytes);
		System.out.println("File contents written successfully");

	}
}