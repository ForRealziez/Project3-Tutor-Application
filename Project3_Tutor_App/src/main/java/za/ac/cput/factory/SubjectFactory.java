package za.ac.cput.factory;

import za.ac.cput.entity.Subject;
import za.ac.cput.util.Helper;

public class SubjectFactory {
    public static Subject createSubject(String subjectCode, String subjectName)
    {

        if (Helper.isEmpty(subjectCode) || Helper.isEmpty(subjectName)) {
            return null;
        }

        return new Subject
                .Builder()
                .setSubjectCode(subjectCode)
                .setSubjectName(subjectName)
                .build();
    }
}
