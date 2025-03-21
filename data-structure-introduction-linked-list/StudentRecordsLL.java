public class StudentRecordsLL {
    public static void main(String[] args) {
        StudentRecordManagement records = new StudentRecordManagement();
        records.addStudent(1, "Alice", 20, "A", null);
        records.addStudent(2, "Bob", 21, "B", 1);
        records.addStudent(3, "Charlie", 22, "C", 2);

        System.out.println("\nAll Students:");
        records.displayStudents();

        System.out.println("\nSearching for Roll No 2:");
        records.searchStudent(2);

        System.out.println("\nUpdating Grade of Roll No 2:");
        records.updateGrade(2, "A+");

        System.out.println("\nAll Students After Update:");
        records.displayStudents();

        System.out.println("\nDeleting Roll No 3:");
        records.deleteStudent(3);

        System.out.println("\nAll Students After Deletion:");
        records.displayStudents();

    }
}

class Student {
    int rollNumber;
    String name;
    int age;
    String grade;
    Student next;

    public Student(int rollNumber, String name, int age, String grade) {
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

class StudentRecordManagement {
    private Student head;

    public void addStudent(int rollNumber, String name, int age, String grade, Integer position) {
        Student newStudent = new Student(rollNumber, name, age, grade);
        if (position == null || position == 0) {  // Insert at beginning
            newStudent.next = head;
            head = newStudent;
        } else {
            Student temp = head;
            int count = 0;
            while (temp != null && count < position - 1) {
                temp = temp.next;
                count++;
            }
            if (temp == null) {
                System.out.println("Invalid position! Adding at the end.");
            }
            newStudent.next = (temp != null) ? temp.next : null;
            if (temp != null) {
                temp.next = newStudent;
            } else {
                head = newStudent;
            }
        }
    }

    public void deleteStudent(int rollNumber) {
        Student temp = head, prev = null;
        while (temp != null && temp.rollNumber != rollNumber) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Student not found!");
            return;
        }
        if (prev == null) {
            head = temp.next;
        } else {
            prev.next = temp.next;
        }
        System.out.println("Student with Roll Number " + rollNumber + " deleted.");
    }

    public void searchStudent(int rollNumber) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                System.out.println("Student Found - Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }

    public void displayStudents() {
        Student temp = head;
        if (temp == null) {
            System.out.println("No student records available.");
            return;
        }
        while (temp != null) {
            System.out.println("Roll No: " + temp.rollNumber + ", Name: " + temp.name + ", Age: " + temp.age + ", Grade: " + temp.grade);
            temp = temp.next;
        }
    }

    public void updateGrade(int rollNumber, String newGrade) {
        Student temp = head;
        while (temp != null) {
            if (temp.rollNumber == rollNumber) {
                temp.grade = newGrade;
                System.out.println("Updated Grade for Roll No " + rollNumber + " to " + newGrade);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Student not found!");
    }
}



