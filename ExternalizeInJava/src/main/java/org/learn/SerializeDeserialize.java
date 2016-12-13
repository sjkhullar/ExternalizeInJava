package org.learn;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializeDeserialize {

	public static void serialize() throws IOException {
		Person person = new Person("Mike", 34, "001894536");
		//Set static variable
		Person.lastName = "harvey";		
		FileOutputStream output = new FileOutputStream(new File("savePerson.txt"));
		ObjectOutputStream outputStream = new ObjectOutputStream(output);
		outputStream.writeObject(person);
		outputStream.flush();
		outputStream.close();

		System.out.println("1. Serialized the person object : ");
		System.out.println(person);
		System.out.println("LastName:"+Person.lastName);
	}
	public static void deSerialize() throws IOException, ClassNotFoundException {
		
		FileInputStream inputStream = new FileInputStream(new File("savePerson.txt"));
		ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
		Person person = (Person) objectInputStream.readObject();
		inputStream.close();

		System.out.println("\n2. Deserialized person object : ");
		System.out.println(person);
		System.out.println("LastName:"+Person.lastName);
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		serialize();
		deSerialize();
	}
}
