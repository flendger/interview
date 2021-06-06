package ru.flendger.interview.lesson5;

public class StudentDemo {
    public static void main(String[] args) {
        StudentDAO dao = new StudentDAO();
        addStudents(dao);
        updateStudents(dao);
    }

    private static void addStudents(StudentDAO dao) {
        dao.beginTransaction();
        for (int i = 0; i < 100; i++) {
            dao.saveOrUpdate(new Student(null, "student_" + i, 3));
        }
        dao.commit();
    }

    private static void updateStudents(StudentDAO dao) {
        Student student = dao.findByName("student_20").orElseThrow(() -> new RuntimeException("No such student"));
        if (student.getMark()%2 == 0) {
            student.setMark(student.getMark()+1);
        } else {
            student.setMark(student.getMark()-1);
        }
        dao.beginTransaction();
        dao.saveOrUpdate(student);
        dao.commit();
    }
}
