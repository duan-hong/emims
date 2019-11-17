package top.duanhong.emims.pojo.po;

import javax.persistence.*;

/**
 * @author duanhong
 * @description 菜单实体类
 * @date 2019/4/21
 */
@Entity
@Table(name = "tbl_menu")
public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int parentId;
    private int sonId;
    private String nodeName;
    private String url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSonId() {
        return sonId;
    }

    public void setSonId(int sonId) {
        this.sonId = sonId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
