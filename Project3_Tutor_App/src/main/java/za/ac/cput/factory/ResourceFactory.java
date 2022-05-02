package za.ac.cput.factory;

import za.ac.cput.entity.Resource;
import za.ac.cput.util.Helper;

public class ResourceFactory
{
    public static Resource createResource(String itemName, String Description, Boolean Availability, String Images)
    {

        if (Helper.isEmpty(itemName) || Helper.isEmpty(Description)  || Helper.isEmpty(Images)) {
            return null;
        }


        return new Resource
                .Builder()
                .setitemName(itemName)
                .setDescription(Description)
                .setAvailability(Availability)
                .setImages(Images)
                .build();
    }
}
