package za.ac.cput.entity;

/* Student.java
Entity for the Student
Author: Chante Lewis: 216118395
Date: 02 May 2022
 */
public class Student {
    private String studentID;
    private String fullname;
    private String surname;
    private String email;
    private String password;
    private String course;

    public Student(StudentBuilder builder) {
        this.studentID = builder.studentID;
        this.fullname = builder.fullname;
        this.surname = builder.surname;
        this.email = builder.email;
        this.password = builder.password;
        this.course = builder.course;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFullname() {
        return fullname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getCourse() {
        return course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID='" + studentID + '\'' +
                ", fullname='" + fullname + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", course=" + course +
                '}';
    }

    public static class StudentBuilder {
        private String studentID;
        private String fullname;
        private String surname;
        private String email;
        private String password;
        private String course;

        public StudentBuilder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public StudentBuilder setFullname(String fullname) {
            this.fullname = fullname;
            return this;
        }

        public StudentBuilder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public StudentBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public StudentBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public StudentBuilder setCourse(String course) {
            this.course = course;
            return this;
        }

        public StudentBuilder copy(Student student) {
            this.studentID = student.studentID;
            this.fullname = student.fullname;
            this.surname = student.surname;
            this.email = student.email;
            this.password = student.password;
            this.course = student.course;
            return this;
        }

        public Student build() {
            return new Student(this);
        }


    }
}





