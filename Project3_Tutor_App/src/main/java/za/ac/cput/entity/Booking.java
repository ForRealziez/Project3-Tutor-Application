package za.ac.cput.entity;
/* Booking.java
Entity for the Booking
Author: 214258041_Lelihle Gazi
 */

public class Booking {
    private String id;
    private String tutorId;
    private String courseId;
    private String startDate;
    private String endDate;


    public Booking(Builder builder) {
        this.tutorId = builder.tutorId;
        this.courseId = builder.courseId;
        this.startDate = builder.startDate;
        this.endDate = builder.endDate;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTutorId() {
        return tutorId;
    }

    public void setTutorId(String tutorId) {
        this.tutorId = tutorId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id='" + id + '\'' +
                ", tutorId='" + tutorId + '\'' +
                ", courseId='" + courseId + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                '}';
    }

    public static class Builder {
        private String tutorId;
        private String courseId;
        private String startDate;
        private String endDate;

        public Booking.Builder setTutorId(String tutorId) {
            this.tutorId = tutorId;
            return this;
        }

        public Booking.Builder setCourseId(String courseId) {
            this.courseId = courseId;
            return this;
        }

        public Booking.Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Booking.Builder setEndDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Booking.Builder copy(Booking booking) {
            this.tutorId = booking.tutorId;
            this.courseId = booking.courseId;
            this.startDate = booking.startDate;
            this.endDate = booking.endDate;
            return this;
        }

        public Booking build() {
            return new Booking(this);
        }
    }
}

