package pl.coderslab.spring01hibernatekrkw07.ut.zad1;

import org.junit.Test;

import java.security.InvalidParameterException;

import static org.junit.Assert.assertEquals;

public class UserRepositoryTest {
    private UserRepository sut = new UserRepository();

    @Test
    public void shouldCreateEntry() {
        // given
        User u = new User()
                .setName("ala")
                .setEmail("ala@mail.pl");
        //when
        sut.create(u);
        // then
        assertEquals(1, u.getId());
        assertEquals(1, sut.size());
    }

    @Test
    public void shouldUpdateEntry() {
        // given
        User u = new User()
                .setName("ala")
                .setEmail("ala@mail.pl");
        //when
        sut.create(u);
        u.setName("ola");
        u.setEmail("ola@mail.pl");
        sut.update(u);
        User u2 = sut.findById(u.getId());
        // then
        assertEquals(1, sut.size());
        assertEquals(1, u.getId());
        assertEquals(u.getId(), u2.getId());
        assertEquals(u.getName(), u2.getName());
        assertEquals(u.getEmail(), u2.getEmail());
    }

    @Test(expected = InvalidParameterException.class)
    public void shouldThrowWhenUpdatingNotContained() {
        sut.update(new User().setId(42));
    }

    @Test
    public void shouldDeleteEntry() {
        // given
        User u = new User()
                .setName("ala")
                .setEmail("ala@mail.pl");
        //when
        sut.create(u);
        final int sizeAfterCreate = sut.size();
        sut.delete(u);
        // then
        assertEquals(1, sizeAfterCreate);
        assertEquals(0, sut.size());
    }
}