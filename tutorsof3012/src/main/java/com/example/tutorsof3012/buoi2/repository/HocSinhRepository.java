package com.example.tutorsof3012.buoi2.repository;

import com.example.tutorsof3012.buoi2.entity.HocSinh;
import com.example.tutorsof3012.buoi2.util.HibernateConfigBuoi2;
import org.hibernate.Session;

import java.util.List;

public class HocSinhRepository {
    private Session session = null;

    public HocSinhRepository() {
        session = HibernateConfigBuoi2.getFACTORY().openSession();
    }

    public List<HocSinh> getAll() {
        return session.createQuery("FROM HocSinh").list();
    }

    public HocSinh getHocSinhById(Integer id) {
        return session.find(HocSinh.class, id);
    }

    public void addHocSinh(HocSinh hocSinh) {
        try {
            session.getTransaction().begin();
            session.save(hocSinh);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            exception.printStackTrace();
        }
    }

    public void updateHocSinh(HocSinh hocSinh) {
        try {
            session.getTransaction().begin();
            session.merge(hocSinh);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            exception.printStackTrace();
        }
    }

    public void deleteHocSinh(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getHocSinhById(id));
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            exception.printStackTrace();
        }
    }
}














