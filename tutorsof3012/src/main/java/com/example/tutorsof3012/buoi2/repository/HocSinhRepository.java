package com.example.tutorsof3012.buoi2.repository;

import com.example.tutorsof3012.buoi2.entity.HocSinh;
import com.example.tutorsof3012.buoi2.util.HibernateConfigBuoi2;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class HocSinhRepository {
    private Session session = null;

    public HocSinhRepository() {
        session = HibernateConfigBuoi2.getFACTORY().openSession();
    }

    public List<HocSinh> getAll() {
        return session.createQuery("FROM HocSinh").list();
    }

    // JPQL
    public List<HocSinh> timKiemTheoTen(String ten) {
        Query query = session.createQuery("SELECT hs FROM HocSinh hs WHERE hs.tenHocSinh LIKE :ten");
        query.setParameter("ten", "%" + ten + "%");
        return query.list();
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

    public List<HocSinh> phanTrang(Integer pageNumber, Integer pageSize) {
        Query query = session.createQuery("FROM HocSinh hs");
        query.setFirstResult(pageNumber * pageSize);
        query.setMaxResults(pageSize);
        return query.list();
    }
}














