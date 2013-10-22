package model.beans;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author skuarch
 */
@Entity
@Table(name = "user")
@NamedQueries({
    @NamedQuery(
        name = "getUserByUserNameAndPassword", query = "from User u where u.name = :name and u.password = :password"),
    @NamedQuery(
        name = "getUserByName", query = "from User u where u.name = :name")
})
public class User implements Serializable {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    @Column(name = "user_name")
    private String name = null;
    @Column(name = "user_password")
    private String password = null;
    @Column(name = "user_level")
    private int level = 0;
    @Column(name = "user_last_login")
    private String lastLogin = null;
    @Column(name = "user_date_register")
    private String dateRegister = null;

    //==========================================================================
    /**
     * create a instance
     */
    public User() {
    } // end Users    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getDateRegister() {
        return dateRegister;
    }

    public void setDateRegister(String dateRegister) {
        this.dateRegister = dateRegister;
    }
} // end class