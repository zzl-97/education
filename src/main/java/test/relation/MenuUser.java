package test.relation;


import test.User;
import test.menu.MenuTest;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//菜单跟角色的关系表
@Entity
@Table(name = "JT_MENU_USER")
public class MenuUser {
    @Id
    private Integer menuUserId;


    @ManyToOne
    private User user;
    @ManyToOne
    private MenuTest menuTest;

    public MenuUser() {
    }

    public Integer getMenuUserId() {
        return menuUserId;
    }

    public void setMenuUserId(Integer menuUserId) {
        this.menuUserId = menuUserId;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MenuTest getMenuTest() {
        return menuTest;
    }

    public void setMenuTest(MenuTest menuTest) {
        this.menuTest = menuTest;
    }

}
