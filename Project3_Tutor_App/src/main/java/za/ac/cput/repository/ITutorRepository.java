package za.ac.cput.repository;
/* ITutorRepository.java
Interface for the TutorRepository
Author: 214258041_Lelihle Gazi
 */
import za.ac.cput.entity.Tutor;

import java.util.Set;

public interface ITutorRepository extends IRepository<Tutor, String> {
    public Set<Tutor> getAll();
    public Tutor getTutor(String id);
}
