package za.ac.cput.repository;
/* TutorRepository.java
Implementation of TutorRepository
Author: 214258041_Lelihle Gazi
 */
import za.ac.cput.entity.Tutor;

import java.util.HashSet;
import java.util.Set;


public class TutorRepository implements ITutorRepository {
    private static TutorRepository repository = null;
    private Set<Tutor> tutorDB = null;

    private TutorRepository() {
        tutorDB = new HashSet<>();
    }

    public static TutorRepository getRepository(){
        if(repository == null){
            repository = new TutorRepository();
        }
        return repository;
    }

    @Override
    public Tutor create(Tutor tutor) {
        boolean success = tutorDB.add(tutor);
        if(!success){
            return null;
        }
        return tutor;
    }

    @Override
    public Tutor read(String id) {
        Tutor tutor = tutorDB.stream().filter(u -> u.getId().equals(id))
                .findAny().orElse(null);
        return tutor;
    }

    @Override
    public Tutor update(Tutor tutor) {
        Tutor oldTutor = read(tutor.getId());
        if(oldTutor != null){
            tutorDB.remove(oldTutor);
            tutorDB.add(tutor);
            return null;
        }
        return tutor;
    }

    @Override
    public boolean delete(String id) {
        Tutor tutorToDelete = read(id);
        if(tutorToDelete == null){
            return false;
        }
        tutorDB.remove(tutorToDelete);
        return true;
    }

    @Override
    public Set<Tutor> getAll() {
        return tutorDB;
    }
    @Override
    public Tutor getTutor(String id) {
        return read(id);
    }
}
