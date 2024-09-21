package tech.icei.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import tech.icei.model.Autor;
import tech.icei.model.Editorial;
import tech.icei.model.Libro;
import tech.icei.model.Usuario;

public final class HibernateConfig {
    public static SessionFactory createSessionFactory() {
        Configuration config = new Configuration();
        config.setProperty("hibernate.connection.driver_class", "org.postgresql.Driver");
        config.setProperty("hibernate.connection.url", "jdbc:postgresql://localhost:5432/libreriadb");
        config.setProperty("hibernate.connection.username", "libreria");
        config.setProperty("hibernate.connection.password", "123456");
        config.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect"); // Opcional
        config.setProperty("hibernate.hbm2ddl.auto", "update");
        config.setProperty("hibernate.show_sql", "true");
        //config.setProperty("hibernate.format_sql", "true");

        config.addAnnotatedClass(Usuario.class);
        config.addAnnotatedClass(Autor.class);
        config.addAnnotatedClass(Editorial.class);
        config.addAnnotatedClass(Libro.class);

        return config.buildSessionFactory();
    }
}
