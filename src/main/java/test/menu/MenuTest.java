package test.menu;

import javax.persistence.*;

@Entity
@Table(name="JT_MENU")
public class MenuTest {
    //主键  , 自增主键
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer menuId;

    private String menuName;

    private String  url;


    public MenuTest(){}


    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }



    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
