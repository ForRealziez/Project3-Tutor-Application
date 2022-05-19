package za.ac.cput.entity;
/* Tutor.java
Entity for the Tutor
Author: 214258041_Lelihle Gazi
 */

public class Tutor {
    private String id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String studentNumber;
    private String dateCreated;

    public Tutor(Builder builder){
        this.id = builder.id;
        this.username = builder.username;
        this.email = builder.email;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.studentNumber = builder.studentNumber;
        this.dateCreated = builder.dateCreated;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public void setStudentNumber(String studentNumber) {
        this.studentNumber = studentNumber;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    @Override
    public String toString() {
        return "Tutor{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", studentNumber='" + studentNumber + '\'' +
                ", dateCreated='" + dateCreated + '\'' +
                '}';
    }

    //Implementing Builder Pattern
    public static class Builder{
        private String id;
        private String username;
        private String email;
        private String firstName;
        private String lastName;
        private String studentNumber;
        private String dateCreated;

        public Tutor.Builder setId(String id) {
            this.id = id;
            return this;
        }
        public Tutor.Builder setUsername(String username) {
            this.username = username;
            return this;
        }

        public Tutor.Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Tutor.Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Tutor.Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Tutor.Builder setStudentNumber(String studentNumber) {
            this.studentNumber = studentNumber;
            return this;
        }

        public Tutor.Builder setDateCreated(String dateCreated) {
            this.dateCreated = dateCreated;
            return this;
        }

        public Tutor.Builder copy(Tutor tutor){
            this.id = tutor.id;
            this.username = tutor.username;
            this.email = tutor.email;
            this.firstName = tutor.firstName;
            this.lastName = tutor.lastName;
            this.studentNumber = tutor.studentNumber;
            this.dateCreated = tutor.dateCreated;
            return this;
        }

        public Tutor build(){
            return new Tutor(this);
        }
    }
}
