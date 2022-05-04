package za.ac.cput.entity;

public class Subject {
    private String subjectCode;
    private String subjectName;

    private Subject (Builder builder){
        this.subjectCode = builder.subjectCode;
        this.subjectName = builder.subjectName;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    public static class Builder{
        private String subjectCode;
        private String subjectName;

        public Builder setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Builder copy(Subject subject){
            this.subjectCode = subject.subjectCode;
            this.subjectName = subject.subjectName;
            return this;
        }

        public Subject build(){
            return new Subject(this);
        }
    }

}
