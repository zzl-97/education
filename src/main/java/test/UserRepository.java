package test;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import javax.transaction.Transactional;
//实体 ，主键Id   类似于DAO层
@Transactional
public interface UserRepository extends JpaRepository<User, Integer>, JpaSpecificationExecutor<User> {

    //查询用户
    User findByUserNameAndPassword(String userName, String password);

}
