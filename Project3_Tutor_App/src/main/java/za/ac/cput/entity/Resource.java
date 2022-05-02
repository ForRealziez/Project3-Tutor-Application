package za.ac.cput.entity;

public class Resource {
    private String itemName;
    private String Description;
    private boolean Availability;
    private String Images;

    //private builder constructor
    private Resource(Builder builder) {
        this.itemName = builder.itemName;
        this.Description = builder.Description;
        this.Availability = builder.Availability;
        this.Images = builder.Images;
    }



    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return Description;
    }

    public boolean isAvailability() {
        return Availability;
    }

    public String getImages() {
        return Images;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setAvailability(boolean availability) {
        Availability = availability;
    }

    public void setImages(String images) {
        Images = images;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "itemName='" + itemName + '\'' +
                ", Description='" + Description + '\'' +
                ", Availability=" + Availability +
                ", Images='" + Images + '\'' +
                '}';
    }

    public static class Builder {
        private String itemName;
        private String Description;
        private Boolean Availability;
        private String Images;


        public Builder setitemName(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public Builder setDescription(String Description) {
            this.Description = Description;
            return this;
        }

        public Builder setAvailability(Boolean Availability) {
            this.Availability = Availability;
            return this;
        }

        public Builder setImages(String Images) {
            this.Images = Images;
            return this;
        }

        public Builder copy(Resource d) {
            this.itemName = d.itemName;
            this.Description = d.Description;
            this.Availability = d.Availability;
            this.Images = d.Images;

            return this;
        }

        public Resource build() {
            return new Resource(this);
        }


    }
}
