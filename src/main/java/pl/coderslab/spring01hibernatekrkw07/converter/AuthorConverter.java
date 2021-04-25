package pl.coderslab.spring01hibernatekrkw07.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernatekrkw07.dao.AuthorDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Author;

public class AuthorConverter implements Converter<String, Author> {
    @Autowired
    private AuthorDao dao;

    @Override
    public Author convert(String id) {
        return dao.readById(Long.parseLong(id));
    }
}
