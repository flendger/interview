package ru.flendger.interview.lesson5;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class StudentDAO {
    private Session session;
    private Transaction transaction;

    public void beginTransaction(){
        Transaction curTransaction = getCurrentTransaction();
        if (!curTransaction.isActive()) {
            curTransaction.begin();
        }
    }

    private Session getCurrentSession() {
        if (session == null) {
            session = SessionManager.getSession();
        }
        return session;
    }

    private Transaction getCurrentTransaction() {
        if (transaction == null) {
            transaction = getCurrentSession().getTransaction();
        }
        return transaction;
    }

    public void commit(){
        getCurrentTransaction().commit();
        closeSession();
    }

    public void rollback(){
        getCurrentTransaction().rollback();
        closeSession();
    }

    public void closeSession() {
        session.close();
        session = null;
        transaction = null;
    }

    public Optional<Student> find(Long id) {
        return Optional.ofNullable(getCurrentSession().find(Student.class, id));
    }

    public List<Student> findAll() {
        return getCurrentSession().createQuery("from Student", Student.class).getResultList();
    }

    public Optional<Student> findByName(String name) {
        Student student = getCurrentSession()
                .createQuery("from Student where name = :name order by id", Student.class)
                .setParameter("name", name)
                .uniqueResult();
        return Optional.ofNullable(student);
    }

    public Student saveOrUpdate(Student student) {
        getCurrentSession().saveOrUpdate(student);
        return student;
    }

    public void delete(Student student) {
        getCurrentSession().delete(student);
    }
}
