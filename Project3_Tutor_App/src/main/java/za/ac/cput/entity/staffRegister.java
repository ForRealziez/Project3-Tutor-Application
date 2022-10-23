package za.ac.cput.entity;

public class staffRegister {

    private String staffID;
    private String name;
    private String surname;
    private String gender;
    private String email;
    private String physicalAddress;
    private String course;
    private String password;
    private String confirmPassword;

    public staffRegister(){}

    private staffRegister(Builder builder){

        this.staffID = builder.staffID;
        this.name = builder.name;
        this.surname = builder.surname;
        this.gender = String.valueOf(builder.gender);
        this.email = builder.email;
        this.physicalAddress = builder.physicalAddress;
        this.course = builder.course;
        this.password = builder.password;
        this.confirmPassword = builder.confirmPassword;
    }

    //GETTERS


    public String getStaffID() {
        return staffID;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }

    public String getPhysicalAddress() {
        return physicalAddress;
    }

    public String getCourse() {
        return course;
    }

    public String getPassword() {
        return password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    //SETTERS


    public void setStaffID(String staffID) {
        this.staffID = staffID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhysicalAddress(String physicalAddress) {
        this.physicalAddress = physicalAddress;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    @Override
    public String toString() {
        return "staffRegister{" +
                "staffID='" + staffID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", physicalAddress='" + physicalAddress + '\'' +
                ", course='" + course + '\'' +
                ", password='" + password + '\'' +
                ", confirmPassword='" + confirmPassword + '\'' +
                '}';
    }

    public static class Builder{
        private String staffID;
        private String name;
        private String surname;
        private String gender;
        private String email;
        private String physicalAddress;
        private String course;
        private String password;
        private String confirmPassword;

        public Builder setStaffId(String staffID){
            this.staffID = staffID;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setSurname(String surname) {
            this.surname = surname;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setPhysicalAddress(String physicalAddress) {
            this.physicalAddress = physicalAddress;
            return this;
        }

        public Builder setCourse(String course) {
            this.course = course;
            return this;
        }

        public Builder setPassword(String password) {
            this.password = password;
            return this;
        }

        public Builder setConfirmPassword(String confirmPassword) {
            this.confirmPassword = confirmPassword;
            return this;
        }

        public Builder copy (staffRegister register){
            this.staffID = register.staffID;
            this.name = register.name;
            this.surname = register.surname;
            this.gender = register.gender;
            this.email = register.email;
            this.physicalAddress = register.physicalAddress;
            this.course = register.course;
            this.password = register.password;
            this.confirmPassword = register.confirmPassword;
            return this;
        }
        public staffRegister build(){
            return new staffRegister(this);
        }
    }


}
