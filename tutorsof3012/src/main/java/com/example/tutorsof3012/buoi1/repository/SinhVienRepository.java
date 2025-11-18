package com.example.tutorsof3012.buoi1.repository;

import com.example.tutorsof3012.buoi1.entity.SinhVien;
import com.example.tutorsof3012.buoi1.util.HibernateConfig;
import lombok.ToString;
import org.hibernate.Session;

import java.util.List;

public class SinhVienRepository {
    private Session session = null;

    public SinhVienRepository() {
        session = HibernateConfig.getFACTORY().openSession();
    }

    public List<SinhVien> getAll() {
        return session.createQuery("FROM SinhVien").list();
    }

    public SinhVien getSinhVienById(Integer id) {
        return session.find(SinhVien.class, id);
    }

    public void addSinhVien(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.save(sinhVien);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            exception.printStackTrace();
        }
    }

    public void updateSinhVien(SinhVien sinhVien) {
        try {
            session.getTransaction().begin();
            session.merge(sinhVien);
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            exception.printStackTrace();
        }
    }

    public void deleteSinhVien(Integer id) {
        try {
            session.getTransaction().begin();
            session.delete(this.getSinhVienById(id));
            session.getTransaction().commit();
        } catch (Exception exception) {
            session.getTransaction().rollback();
            exception.printStackTrace();
        }
    }
}














