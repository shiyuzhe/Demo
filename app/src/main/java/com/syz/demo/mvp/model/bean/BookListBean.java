package com.syz.demo.mvp.model.bean;

/**
 * Created by shiyuzhe on 2018/9/8.
 * WeChat:18091664559
 * Description:
 */
public class BookListBean {
    private String list_id;
    private String list_name;
    private String list_img;
    private String banner_img;
    private String desc;
    private String slogan;
    private String books;
    private String discount;
    private String manual_price;
    private String content;
    private int num;
    private int sort;
    private int create_time;
    private int status;
    private String price;
    private String discountPrice;
    private int isRight;//1为已购买

    public BookListBean(String list_id, String list_name, String list_img, String banner_img, String desc, String slogan, String books, String discount, String manual_price, String content, int num, int sort, int create_time, int status, String price, String discountPrice, int isRight) {
        this.list_id = list_id;
        this.list_name = list_name;
        this.list_img = list_img;
        this.banner_img = banner_img;
        this.desc = desc;
        this.slogan = slogan;
        this.books = books;
        this.discount = discount;
        this.manual_price = manual_price;
        this.content = content;
        this.num = num;
        this.sort = sort;
        this.create_time = create_time;
        this.status = status;
        this.price = price;
        this.discountPrice = discountPrice;
        this.isRight = isRight;
    }

    public String getList_id() {
        return list_id;
    }

    public void setList_id(String list_id) {
        this.list_id = list_id;
    }

    public String getList_name() {
        return list_name;
    }

    public void setList_name(String list_name) {
        this.list_name = list_name;
    }

    public String getList_img() {
        return list_img;
    }

    public void setList_img(String list_img) {
        this.list_img = list_img;
    }

    public String getBanner_img() {
        return banner_img;
    }

    public void setBanner_img(String banner_img) {
        this.banner_img = banner_img;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getBooks() {
        return books;
    }

    public void setBooks(String books) {
        this.books = books;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getManual_price() {
        return manual_price;
    }

    public void setManual_price(String manual_price) {
        this.manual_price = manual_price;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getSort() {
        return sort;
    }

    public void setSort(int sort) {
        this.sort = sort;
    }

    public int getCreate_time() {
        return create_time;
    }

    public void setCreate_time(int create_time) {
        this.create_time = create_time;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPrice() {
        return discountPrice;
    }

    public void setDiscountPrice(String discountPrice) {
        this.discountPrice = discountPrice;
    }

    public int getIsRight() {
        return isRight;
    }

    public void setIsRight(int isRight) {
        this.isRight = isRight;
    }

    @Override
    public String toString() {
        return "BookListBean{" +
                "list_id='" + list_id + '\'' +
                ", list_name='" + list_name + '\'' +
                ", list_img='" + list_img + '\'' +
                ", banner_img='" + banner_img + '\'' +
                ", desc='" + desc + '\'' +
                ", slogan='" + slogan + '\'' +
                ", books='" + books + '\'' +
                ", discount='" + discount + '\'' +
                ", manual_price='" + manual_price + '\'' +
                ", content='" + content + '\'' +
                ", num=" + num +
                ", sort=" + sort +
                ", create_time=" + create_time +
                ", status=" + status +
                ", price='" + price + '\'' +
                ", discountPrice='" + discountPrice + '\'' +
                ", isRight=" + isRight +
                '}';
    }
}
