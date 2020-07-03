package test;

import com.sun.org.apache.bcel.internal.generic.POP2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;

import javax.persistence.criteria.*;
import java.nio.channels.Pipe;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/zzl")
@CrossOrigin
public class Controller {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/selectUser")
    public ResponseEntity<JSONMessge> selectUser() {
        User u = new User();
        User user = userRepository.findByUserNameAndPassword(u.getUserName(), u.getPassword());
        JSONMessge jsonMessge = new JSONMessge();
        if (user == null) {
            jsonMessge.setMessage("暂无");
            return ResponseEntity.ok(jsonMessge);
        }
        jsonMessge.setObject(user);
        return ResponseEntity.ok(jsonMessge);
    }

    @GetMapping(value = "/adduser")//保存的方法

    public String Add(@RequestParam("username") String username, @RequestParam("password") String password) {
        User user = new User();

        user.setUserName(username);
        user.setPassword(password);
        userRepository.save(user);
        return "save";
    }


    @DeleteMapping("/delete") //删除语句
    public String deleUser(@RequestParam("id") Integer id) {
        userRepository.deleteById(id);
        return "dele";
    }

    @PostMapping("/update")
    public String updateUser(@RequestBody User u) {
        User user = userRepository.findById(u.getUserId()).get();
        user.setUserName(u.getUserName());
        userRepository.save(user);
        return "update";
    }

    //查询

    public String selectU() {
        //匿名内部类
        Specification<User> spce = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //获取比较的属性  属性名称

                Path<Object> us = root.get("username");
                //构造查询条件
                Predicate p = criteriaBuilder.equal(us, "lisi");//精准匹配（比较的属性，比较的属性取值）
                return p;
            }
        };
        Optional<User> u = userRepository.findOne(spce);

        return "ss";
    }

    @PostMapping("/selectD")

    public List<User> test(@RequestBody User u) {
        /*root 获取属性
        cb 构造查询
            构造多条件靳准查询
            联系一起查询
        */
        Specification<User> spec = new Specification<User>() {
            @Override
            public Predicate toPredicate(Root<User> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                //获取数据库字段
                Path<Object> password = root.get("password");
                Path<Object> userName = root.get("userName");

                //构造查询 第一个参数 path属性参数  第二个 就是取值
                // System.out.println(u.getPassword());
                Predicate p1 = null;
                //Predicate p2 =  criteriaBuilder.equal( userName,u.getUserName());
                //将查询条件组合在一起()
                if (u.getUserName() != "") {
                    Predicate p2 = criteriaBuilder.equal(userName, u.getUserName());
                    if (p1 != null) {
                        p1 = criteriaBuilder.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                if (u.getPassword() != "") {
                    Predicate p2 = criteriaBuilder.equal(password, u.getPassword());
                    if (p1 != null) {
                        p1 = criteriaBuilder.and(p1, p2);
                    } else {
                        p1 = p2;
                    }
                }
                return p1;
               /* Predicate predicate = criteriaBuilder.and();//以 并且的形式来拼接
                //criteriaBuilder.or()//一 || 的形式来拼接
                if(u.getPassword().trim() !="" &&u.getUserName() !=""){
                     predicate = criteriaBuilder.and(p1,p2);//以 并且的形式来拼接
                    return predicate;

                }
                if(u.getUserName().trim() !=""){
                    predicate = criteriaBuilder.and(p2);//以 并且的形式来拼接
                    return predicate;
                }
                if(u.getPassword().trim()  !=""){
                    predicate = criteriaBuilder.and(p1);//以 并且的形式来拼接
                    return predicate;
                }*/
            }
        };

        List<User> list = userRepository.findAll(spec);
        return list;
    }


}
