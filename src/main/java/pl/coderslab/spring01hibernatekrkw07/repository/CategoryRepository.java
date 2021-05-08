package pl.coderslab.spring01hibernatekrkw07.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.spring01hibernatekrkw07.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
