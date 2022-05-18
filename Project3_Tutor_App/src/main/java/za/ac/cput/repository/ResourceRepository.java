package za.ac.cput.repository;

import za.ac.cput.entity.Resource;

import java.util.HashSet;
import java.util.Set;

public class ResourceRepository implements IResource
{
    private static ResourceRepository resourceRepository = null;
    private static Set<Resource> resourceDB = null;

    private ResourceRepository(){
        resourceDB = new HashSet<>();
    }

    public static ResourceRepository getInstance(){

        if(resourceRepository == null){
            resourceRepository = new ResourceRepository();
        }
        return resourceRepository;
    }

    @Override
    public Resource create(Resource newResource) {
        boolean success = resourceDB.add(newResource);

        if(!success)
            return null;
        return newResource;
    }

    @Override
    public Resource read(String itemName) {

        for(Resource newResource: resourceDB){
            if(newResource.getItemName().equals(itemName)){
                return newResource;
            }
        }
        return null;
    }

    @Override
    public Resource update(Resource updateResource) {
        Resource oldResource = read(updateResource.getItemName());

        if(oldResource != null){
            resourceDB.remove(oldResource);
            resourceDB.add(updateResource);
            return updateResource;

        }
        return null;
    }

    @Override
    public boolean delete(String itemName) {
        Resource deleteResource = read(itemName);

        if(deleteResource == null) {
            return false;
        }
        resourceDB.remove(deleteResource);
        return true;

    }

    @Override
    public Set<Resource> getAll() {
        return resourceDB;
    }
}

