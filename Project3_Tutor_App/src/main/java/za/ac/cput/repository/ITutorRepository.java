package za.ac.cput.repository;
/* ITutorRepository.java
Interface for the TutorRepository
Author: 214258041_Lelihle Gazi
 */
import za.ac.cput.entity.Tutor;

import java.sql.SQLException;
import java.util.Set;

public interface ITutorRepository extends IRepository<Tutor, String> {
    public Set<Tutor> getAll() throws SQLException;
    public Tutor getTutor(String id) throws SQLException;
}
