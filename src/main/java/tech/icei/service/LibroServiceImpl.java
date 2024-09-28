package tech.icei.service;

import org.hibernate.SessionFactory;
import tech.icei.dao.*;
import tech.icei.model.Autor;
import tech.icei.model.Editorial;
import tech.icei.model.Libro;

import java.util.List;

public class LibroServiceImpl implements LibroService {
    private final SessionFactory factory;
    private LibroDAO libroDAO;
    private AutorDAO autorDAO;
    private EditorialDAO editorialDAO;

    public LibroServiceImpl(SessionFactory factory) {
        this.factory = factory;
        libroDAO = new LibroDAOImpl(factory);
        autorDAO = new AutorDAOImpl(factory);
        editorialDAO = new EditorialDAOImpl(factory);
    }

    /**
     * Método que obtiene la lista de libros
     * @return
     */
    @Override
    public List<Libro> obtenerLibros() {
        return libroDAO.readAll();
    }

    @Override
    public Libro guardarLibro(Libro libro) {
        return libroDAO.create(libro);
    }

    /**
     * Método que obtiene la lista de autores
     */
    @Override
    public List<Autor> obtenerAutores() {
        return autorDAO.obtenerAutores();
    }

    /**
     * Método que obtiene la lista de editoriales
     */
    @Override
    public List<Editorial> obtenerEditoriales() {
        return editorialDAO.obtenerEditoriales();
    }
}
