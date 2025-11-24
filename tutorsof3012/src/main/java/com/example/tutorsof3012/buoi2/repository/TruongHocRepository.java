package com.example.tutorsof3012.buoi2.repository;

import com.example.tutorsof3012.buoi2.entity.TruongHoc;
import com.example.tutorsof3012.buoi2.util.HibernateConfigBuoi2;
import org.hibernate.Session;

import java.util.List;

public class TruongHocRepository {
    private Session session = null;

    public TruongHocRepository() {
        session = HibernateConfigBuoi2.getFACTORY().openSession();
    }

    public List<TruongHoc> getAll() {
        return session.createQuery("FROM TruongHoc").list();
    }

    public TruongHoc getTruongHocById(Integer id) {
        return session.find(TruongHoc.class, id);
    }
}
