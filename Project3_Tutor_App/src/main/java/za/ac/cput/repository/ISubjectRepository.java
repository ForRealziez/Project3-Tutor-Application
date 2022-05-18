package za.ac.cput.repository;

import za.ac.cput.entity.Subject;

import java.util.Set;

public interface ISubjectRepository extends za.ac.cput.repository.IRepository<Subject, String> {

    public Set<Subject> getAll();

}
