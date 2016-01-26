package org.learn;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Person implements Externalizable {

	private static final long serialVersionUID = 1L;
	public String firstName;
	public static String lastName = "Not Set";
	public int age;
	public transient String contact;
	public Person() {
		
	}
	public Person(String firstName,int age, String contact) {
		this.firstName = firstName;
		this.age = age;
		this.contact = contact;
	}
	public String toString() {
	    return "[" + firstName + " " + lastName +
		       " " + age + " " +contact +"]";
	}
	@Override
	public void writeExternal(ObjectOutput out) throws IOException {
		out.writeObject(firstName);
		out.writeObject(lastName);
		out.writeInt(age);
		out.writeObject(contact);
	}
	@Override
	public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
		firstName = (String) in.readObject();
		lastName = (String) in.readObject();
		age = (int) in.readInt();
		contact = (String) in.readObject();		
	}
}