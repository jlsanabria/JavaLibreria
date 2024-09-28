package tech.icei.service;

import org.hibernate.SessionFactory;
import tech.icei.dao.LibroDAO;
import tech.icei.dao.LibroDAOImpl;
import tech.icei.model.Libro;

import java.util.List;

public class LibroServiceImpl implements LibroService {
    private final SessionFactory factory;
    private LibroDAO libroDAO;

    public LibroServiceImpl(SessionFactory factory) {
        this.factory = factory;
        libroDAO = new LibroDAOImpl(factory);
    }

    @Override
    public List<Libro> obtenerLibros() {
        return libroDAO.readAll();
    }
}
