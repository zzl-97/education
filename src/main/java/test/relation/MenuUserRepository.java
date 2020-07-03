package test.relation;

import com.huaye.ddd.bean.Menu;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import test.menu.MenuTest;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.rowset.Predicate;
import java.util.List;

public interface MenuUserRepository extends JpaRepository<MenuUser, Integer> {
    //根据用户Id查询对应的菜单
    @Query(value = "select m from MenuUser m  join m.user u  join m.menuTest c  " +
            "  where u.id=?1")
    List<MenuUser> selectRelation(Integer userId);
}
