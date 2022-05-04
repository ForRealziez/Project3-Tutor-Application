package za.ac.cput.repository;

import za.ac.cput.entity.Mark;

import java.util.HashSet;
import java.util.Set;

public class MarkRepository implements IMarkRepository {

   private static MarkRepository repository = null;
   private Set<Mark> markDB = null;

   private MarkRepository(){
       markDB = new HashSet<Mark>();
   }

    public static MarkRepository getRepository(){
        if(repository == null){
            repository = new MarkRepository();
        }
        return repository;
    }

    @Override
    public Mark create(Mark mark) {
        boolean success = markDB.add(mark);
        if(!success){
            return null;
        }
        return mark;
    }

    @Override
    public Mark read(String subjectCode) {
        Mark mark = markDB.stream().filter(u -> u.getSubjectCode().equals(subjectCode))
                .findAny().orElse(null);
        return mark;
    }

    @Override
    public Mark update(Mark mark) {
        Mark oldUser = read(mark.getSubjectCode());
        if(oldUser != null){
           markDB.remove(oldUser);
            markDB.add(mark);
            return mark;
        }
        return null;
    }

    @Override
    public boolean delete(String subjectCode) {
        Mark markToDelete = read(subjectCode);
        if(markToDelete == null){ //nothing to delete
            return false; //nothing to delete
        }
        markDB.remove(markToDelete);
        return true;
    }

    @Override
    public Set<Mark> getAll() {
        return markDB;
    }

}
