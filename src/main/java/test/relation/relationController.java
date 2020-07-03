package test.relation;

import org.springframework.web.bind.annotation.*;
import test.User;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

@RestController
@RequestMapping("/zzl")
public class relationController {
    @Resource
    private  MenuUserRepository menuUserRepository;

    //查询的方法
    @PostMapping("/selectMenuss")

    public List<MenuUser> selectMenu(@RequestBody User u){
        List<MenuUser> dto = menuUserRepository.selectRelation(u.getUserId());
        return dto;
    }
}
