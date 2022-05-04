package za.ac.cput.factory;

import za.ac.cput.entity.Mark;
import za.ac.cput.util.Helper;

public class MarkFactory {
    public static Mark createMark(String subjectCode, String subjectName, String studentID, String studentName, int grade)
    {

        if (Helper.isEmpty(subjectCode) || Helper.isEmpty(studentID)) {
            return null;
        }


        return new Mark
                .Builder()
                .setSubjectCode(subjectCode)
                .setSubjectName(subjectName)
                .setStudentID(studentID)
                .setStudentName(studentName)
                .setGrade(grade)
                .build();
    }
}
