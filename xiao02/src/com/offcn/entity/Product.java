
package com.offcn.entity;
        import java.io.Serializable;
public class Product implements Serializable {
    private int cid;
    // 类别的名称
    private String cname;
    private String color;
    private String description;
    // 图片的描述
    private String full_description;
    private String name;
    private String pic;
    // 主键
    private int pid;
    private double price;
    private String  product_date;
    private String size;
    // 五种状态
    private int state;
    //<!-- 0 正常,1热门产品，2为你推荐，3，新品 4，小米明星单品 -->
    private String version;

    public Product() {
    }

    public Product(int cid, String cname, String color, String description,
                   String full_description, String name, String pic, int pid, double price, String
                           product_date, String size, int state, String version) {
        this.cid = cid;
        this.cname = cname;
        this.color = color;
        this.description = description;
        this.full_description = full_description;
        this.name = name;
        this.pic = pic;
        this.pid = pid;
        this.price = price;
        this.product_date = product_date;
        this.size = size;
        this.state = state;
        this.version = version;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFull_description() {
        return full_description;
    }

    public void setFull_description(String full_description) {
        this.full_description = full_description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    @Override
    public String toString() {
        return "Product{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", color='" + color + '\'' +
                ", description='" + description + '\'' +
                ", full_description='" + full_description + '\'' +
                ", name='" + name + '\'' +
                ", pic='" + pic + '\'' +
                ", pid=" + pid +
                ", price=" + price +
                ", product_date=" + product_date +
                ", size='" + size + '\'' +
                ", state=" + state +
                ", version='" + version + '\'' +
                '}';
    }
}
