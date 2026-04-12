package fileAdvilEngine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
	// use this class for creating, saving, deleting, and loading file paths for games or other things

	// Creates a new empty file at the specified path
	public static void CreateFilePath(String filePath, String fileName) {
		try {
			File file = new File(filePath, fileName);
			if (file.exists()) {
				System.out.println("File already exists: " + file.getAbsolutePath());
			} else {
				file.getParentFile().mkdirs(); // create directories if they don't exist
				file.createNewFile();
				System.out.println("File created: " + file.getAbsolutePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Saves text content to the file (overwrites if exists)
	public static void SaveFilePath(String filePath, String fileName, String content) {
		try {
			File file = new File(filePath, fileName);
			file.getParentFile().mkdirs(); // ensure directories exist
			FileWriter writer = new FileWriter(file);
			writer.write(content);
			writer.close();
			System.out.println("File saved: " + file.getAbsolutePath());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Deletes the file at the specified path
	public static void DeleteFilePath(String filePath, String fileName) {
		File file = new File(filePath, fileName);
		if (file.exists()) {
			if (file.delete()) {
				System.out.println("File deleted: " + file.getAbsolutePath());
			} else {
				System.out.println("Failed to delete file: " + file.getAbsolutePath());
			}
		} else {
			System.out.println("File does not exist: " + file.getAbsolutePath());
		}
	}

	// Loads and returns the content of the file
	public static String LoadFilePath(String filePath, String fileName) {
		try {
			File file = new File(filePath, fileName);
			if (file.exists()) {
				String content = new String(Files.readAllBytes(Paths.get(file.getAbsolutePath())));
				return content;
			} else {
				System.out.println("File does not exist: " + file.getAbsolutePath());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}