/**
 * @author MoeGammad Tasreeq Adams
 * Student no: 216173027
 * Project assignment
 */
package za.ac.cput.entity;

public class StudentRegister {
    private String registerNumber;
    private String email;
    private String password;
    private String passwordCon;
    private String course;


    private StudentRegister(){}

    private StudentRegister(Builder builder){
        this.registerNumber = builder.registerNumber;
        this.email = builder.email;
        this.password = builder.password;
        this.passwordCon = builder.passwordCon;
        this.course = builder.course;

    }

    //getters
    public String getRegisterNumber(){return registerNumber;}

    public String getEmail() {return email;}

    public String getPassword() {
        return password;
    }

    public String getPasswordCon() {
        return passwordCon;
    }

    public String getCourse() {
        return course;
    }


    //setter


    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPasswordCon(String passwordCon) {
        this.passwordCon = passwordCon;
    }

    public void setCourse(String course) {
        this.course = course;
    }


    @Override
    public String toString() {
        return "Register{" +
                "registerID='" + registerNumber + '\'' +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", passwordCon='" + passwordCon + '\'' +
                ", course='" + course + '\'' +
                '}';
    }

    public static class Builder{
        private String registerNumber;
        private String email;
        private String password;
        private String passwordCon;
        private String course;


        public Builder setRegisterNumber(String registerNumber) {
            this.registerNumber = registerNumber;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setPasswordCon(String passwordCon) {
            this.passwordCon = passwordCon;
            return this;
        }

        public Builder setCourse(String course) {
            this.course = course;
            return this;
        }


        public Builder copy (StudentRegister studentRegister){
            this.registerNumber = studentRegister.registerNumber;
            this.email = studentRegister.email;
            this.password = studentRegister.password;
            this.passwordCon = studentRegister.passwordCon;
            this.course = studentRegister.course;
            return this;
        }
        public StudentRegister build(){return new StudentRegister(this);}
    }
}