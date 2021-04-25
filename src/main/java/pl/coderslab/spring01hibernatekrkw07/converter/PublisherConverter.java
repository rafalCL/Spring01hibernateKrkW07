package pl.coderslab.spring01hibernatekrkw07.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.coderslab.spring01hibernatekrkw07.dao.PublisherDao;
import pl.coderslab.spring01hibernatekrkw07.entity.Publisher;

public class PublisherConverter implements Converter<String, Publisher> {
    @Autowired
    private PublisherDao dao;

    @Override
    public Publisher convert(String id) {
        return dao.readById(Long.parseLong(id));
    }
}
