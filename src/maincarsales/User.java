/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maincarsales;

/**
 *
 * @author eng osama anter
 */
public class User extends Person {

    private String name;
    private String phone;
    private String id;
    private String sex;

    public User() {
    }

    public User(String name, String phone, String id, String sex, String username, String password) {
        super(username, password);
        this.name = name;
        this.phone = phone;
        this.id = id;
        this.sex = sex;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getId() {
        return id;
    }

    public String getSex() {
        return sex;
    }

    // @Override
    // public void showData(int indexUser) {
    //
    // }
}
