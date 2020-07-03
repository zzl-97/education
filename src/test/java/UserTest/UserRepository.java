package UserTest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


import javax.transaction.Transactional;

@Transactional
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    //查询用户
    User findByUserNameAndPassword(String userName, String password);

}
