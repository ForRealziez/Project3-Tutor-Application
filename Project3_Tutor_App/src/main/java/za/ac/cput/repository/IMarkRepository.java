package za.ac.cput.repository;

import za.ac.cput.entity.Mark;

import java.util.Set;

public interface IMarkRepository extends IRepository<Mark, String> {

    public Set<Mark> getAll();
}
