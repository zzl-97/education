package test.menu;

import org.springframework.web.bind.annotation.*;
import test.JSONMessge;

import javax.annotation.Resource;

@RestController
@RequestMapping("/zzl")
public class MenuController {
    @Resource
    private MenuRepository menuRepository;


    //添加菜单的方法
    @PostMapping("/addMenu")
    public String AddMenu(@RequestBody MenuTest menuTest){
        MenuTest menu = new MenuTest();
        menu.setMenuName(menuTest.getMenuName());
        menu.setUrl(menuTest.getUrl());
        menuRepository.save(menu);
        return "成功添加";
    }


    //修改菜单
    @PostMapping("updateMenu")
    public  String  updateMenu(@RequestBody MenuTest menuTest){
        //Repository 的方法 根据id 查询到对应的菜单信息
       System.out.println(menuTest.getMenuId());
        MenuTest menu = menuRepository.findById(menuTest.getMenuId()).get();
        menu.setUrl(menuTest.getUrl());
        menu.setMenuName(menuTest.getMenuName());
        menuRepository.save(menu);//保存修改后的   有id是新在 没有id是修改
        return "修改成功";

    }

    //删除菜单
    @DeleteMapping("/dele")
    public String deleMenu(@RequestBody MenuTest menuTest){
        menuRepository.deleteById(menuTest.getMenuId());
        return "删除成功";
    }



}
