package za.ac.cput.repository;

import za.ac.cput.entity.Resource;

import java.util.Set;

public interface IResource extends IRepository<Resource,String>
{
    Set<Resource> getAll();
}
