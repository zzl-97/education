package test.menu;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
//开启事务
@Transactional
@Repository
public interface MenuRepository extends JpaRepository<MenuTest, Integer> {


}
