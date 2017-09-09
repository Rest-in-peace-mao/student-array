import java.util.Date;
import java.util.Calendar;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		if (students.length != 0)
			return students;
		else
		    return null;
	}

	@Override
	public void setStudents(Student[] students) {
	    if (students == null)
            throw new IllegalArgumentException();
	    else
	        this.students = students;
	}

	@Override
	public Student getStudent(int index) {
	    if (index < 0 || index >= students.length)
            throw new IllegalArgumentException();
	    else
            return  students[index];
	}

	@Override
	public void setStudent(Student student, int index) {
		if (index < 0 || index >= students.length || student == null)
            throw new IllegalArgumentException();
		else
		    students[index] = student;
	}

	@Override
	public void addFirst(Student student) {
	    if (student == null)
            throw new IllegalArgumentException();
	    else
            add(student, 0);
	}

	@Override
	public void addLast(Student student) {
        if (student == null)
            throw new IllegalArgumentException();
        else {
            Student[] tmp = new Student[students.length+1];
            for (int i = 0; i < students.length; i++)
                tmp[i] = students[i];
            tmp[students.length] = student;
            students = tmp;
        }
	}

	@Override
	public void add(Student student, int index) {
        if (index < 0 || index >= students.length || student == null)
            throw new IllegalArgumentException();
        else {
            Student[] tmp = new Student[students.length+1];
            for (int i = 0; i < index; i++)
                tmp[i] = students[i];
            tmp[index] = student;
            for (int i = index; i < tmp.length - 1; i++)
                tmp[i+1] = students[i];
            students = tmp;
        }
	}

	@Override
	public void remove(int index) {
        if (index < 0 || index >= students.length)
            throw new IllegalArgumentException();
        else {
            Student[] tmp = new Student[students.length-1];
            for (int i = 0; i < index; i++)
                tmp[i] = students[i];
            for (int i = index; i < students.length - 1; i++)
                tmp[i] = students[i+1];
            students = tmp;
        }
	}

	@Override
	public void remove(Student student) {
	    boolean flag = false;
	    if (student == null) {
            throw new IllegalArgumentException();
        }
        else {
            for (int i = 0; i < students.length; i++)
                if (students[i] == student) {
                    remove(i);
                    flag = true;
                    break;
                }
            if (flag == false)
                throw new IllegalArgumentException("Student not exist");
        }
	}

	@Override
	public void removeFromIndex(int index) {
        if (index < 0 || index >= students.length)
            throw new IllegalArgumentException();
        else {
            Student[] tmp = new Student[index+1];
            for (int i = 0; i <= index; i++)
                tmp[i] = students[i];
            students = tmp;
        }
	}

	@Override
	public void removeFromElement(Student student) {
        boolean flag = false;
        if (student == null)
            throw new IllegalArgumentException();
        else {
            for (int i = 0; i < students.length; i++)
                if (students[i] == student) {
                    removeFromIndex(i);
                    flag = true;
                    break;
                }
            if (flag == false)
                throw new IllegalArgumentException("Student not exist");
        }
	}

	@Override
	public void removeToIndex(int index) {
        if (index < 0 || index >= students.length)
            throw new IllegalArgumentException();
        else {
            Student[] tmp = new Student[students.length-index+1];
            for (int i = 0; i < index; i++)
                tmp[i] = students[i+index];
            students = tmp;
        }
	}

	@Override
	public void removeToElement(Student student) {
        boolean flag = false;
        if (student == null) {
            throw new IllegalArgumentException();
        }
        else {
            for (int i = 0; i < students.length; i++)
                if (students[i] == student) {
                    removeToIndex(i);
                    flag = true;
                    break;
                }
            if (flag == false)
                throw new IllegalArgumentException("Student not exist");
        }
	}

	@Override
	public void bubbleSort() {
        int j;
        boolean flag = true;
        Student temp;
        while (flag) {
            flag= false;
            for(j=0; j < students.length-1; j++)
                if (students[j].getId() > students[j+1].getId()) {
                    temp = students[j];
                    students[j] = students[j+1];
                    students[j+1] = temp;
                    flag = true;
                }
        }
    }

	@Override
	public Student[] getByBirthDate(Date date) {
        if (date == null)
            throw new IllegalArgumentException();
        else {
            int size = 0;
            for (int i = 0; i < students.length; i++)
                if (students[i].getBirthDate().equals(date))
                    size++;
            if (size!=0) {
                Student[] tmp = new Student[size];
                for (int i = 0, j = 0; j < size; i++)
                    if (students[i].getBirthDate().equals(date)) {
                        tmp[j] = students[i];
                        j++;
                    }
                return tmp;
            }
            else return null;
        }
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
        if (firstDate == null || lastDate == null)
            throw new IllegalArgumentException();
        else {
            int size = 0;
            for (int i = 0; i < students.length; i++)
                if (students[i].getBirthDate().after(firstDate) && students[i].getBirthDate().before(lastDate) || students[i].getBirthDate().equals(firstDate) || students[i].getBirthDate().equals(lastDate))
                    size++;
            Student[] tmp = new Student[size];
            for (int i = 0, j = 0; i < students.length; i++)
                if (students[i].getBirthDate().after(firstDate) && students[i].getBirthDate().before(lastDate) || students[i].getBirthDate().equals(firstDate) || students[i].getBirthDate().equals(lastDate)) {
                    tmp[j] = students[i];
                    j++;
                }
            return tmp;
        }
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
        if (date == null)
            throw new IllegalArgumentException();
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, days);
        Date tmp = c.getTime();
        c.add(Calendar.DATE, -days);
        date=c.getTime();
	    return getBetweenBirthDates(date, tmp);
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		if (indexOfStudent == 0)
            throw new IllegalArgumentException();
		else{
            Calendar dob = Calendar.getInstance();
            Calendar today = Calendar.getInstance();
            dob.setTime(students[indexOfStudent].getBirthDate());
            dob.add(Calendar.DAY_OF_MONTH, -1);
            int age = today.get(Calendar.YEAR) - dob.get(Calendar.YEAR);
            if (today.get(Calendar.DAY_OF_YEAR) <= dob.get(Calendar.DAY_OF_YEAR))
                age--;
            return age;
        }
	}

	@Override
	public Student[] getStudentsByAge(int age) {
        int size = 0;
        for (int i = 1; i < students.length; i++)
            if (this.getCurrentAgeByDate(i) == age)
                size++;
        if (size!=0) {
            Student[] tmp = new Student[size];
            for (int i = 1, j = 0; i < students.length; i++)
                if (this.getCurrentAgeByDate(i) == age) {
                    tmp[j] = students[i];
                    j++;
                }
            return tmp;
        }
        return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		double max = 0;
		int size = 0;
		for (int i = 0; i < students.length; i++)
		    if (students[i].getAvgMark() > max) {
                max = students[i].getAvgMark();
                size = 1;
            } else if (students[i].getAvgMark() == max)
                size++;
        Student[] tmp = new Student[size];
		for (int i = 0, j = 0; i < students.length; i++){
            if (students[i].getAvgMark() == max) {
                tmp[j] = students[i];
                j++;
            }
        }
		return tmp;
	}

	@Override
	public Student getNextStudent(Student student) {
        return null;
	}
}

