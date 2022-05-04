package za.ac.cput.entity;

public class Mark {
    private String subjectCode;
    private String subjectName;
    private String studentID;
    private String studentName;
    private int grade;

    private Mark (Builder builder){
        this.subjectCode = builder.subjectCode;
        this.subjectName = builder.subjectName;
        this.studentID = builder.studentID;
        this.studentName = builder.studentName;
        this.grade = builder.grade;
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

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Mark{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", studentID='" + studentID + '\'' +
                ", studentName='" + studentName + '\'' +
                ", grade=" + grade +
                '}';
    }
    public static class Builder{
        private String subjectCode;
        private String subjectName;
        private String studentID;
        private String studentName;
        private int grade;

        public Builder setSubjectCode(String subjectCode) {
            this.subjectCode = subjectCode;
            return this;
        }

        public Builder setSubjectName(String subjectName) {
            this.subjectName = subjectName;
            return this;
        }

        public Builder setStudentID(String studentID) {
            this.studentID = studentID;
            return this;
        }

        public Builder setStudentName(String studentName) {
            this.studentName = studentName;
            return this;
        }

        public Builder setGrade(int grade) {
            this.grade = grade;
            return this;
        }

        public Builder copy(Mark mark){
            this.subjectCode = mark.subjectCode;
            this.subjectName = mark.subjectName;
            this.studentID = mark.studentID;
            this.studentName = mark.studentName;
            this.grade = mark.grade;
            return this;
        }

        public Mark build(){
            return new Mark(this);
        }
    }
}
