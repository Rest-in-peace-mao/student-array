import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
public class Main {

	public static void main(String[] args) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Student Victor = new Student(145, "Victor Destructor", formatter.parse("1998-03-16"), 0.2);
		Student Annie = new Student(132, "Annie Bane", formatter.parse("2002-08-05"), 5.8);
		Student Bob = new Student(113, "Bob Bob", formatter.parse("2001-12-15"), 2.7);
		Student Lary = new Student(184, "Lary Jones", formatter.parse("2003-11-10"), 4.5);
		Student Karly = new Student(102, "Karly Keks", formatter.parse("2002-01-25"), 1.2);
		Student Petr = new Student(105, "Petr Kolbasin", formatter.parse("2000-05-17"), 8.9);
		StudentGroup Group = new StudentGroup(5);
		Group.setStudent(Annie,0);
		Group.setStudent(Bob,1);
		Group.setStudent(Lary,2);
		Group.setStudent(Karly,3);
		Group.setStudent(Petr,4);
		Group.add(Victor,3);
		Student a = Group.getNextStudent(Petr);
	}

}
