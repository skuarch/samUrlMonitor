package model.common;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import model.beans.User;
import model.dao.DAO;

/**
 * business logic for User
 *
 * @author skuarch
 */
public class ModelUser {

    //==========================================================================
    /**
     *
     */
    private ModelUser() {
    } // end ModelUser

    //==========================================================================
    public User getUser(long id) throws Exception {

        if (id < 1) {
            throw new IllegalArgumentException("illegal argument");
        }

        User user = null;
        user = new DAO().findById(id, new User());

        return user;

    } // end getUser

    //==========================================================================
    public User getUser(String name) throws Exception {

        if (name == null || name.length() < 1) {
            throw new IllegalArgumentException("illegal argument");
        }

        List<User> list = null;
        User user = null;
        ConcurrentHashMap<String, String> parameters = new ConcurrentHashMap<>();
        parameters.put("name", name);
        list = new DAO().query("getUserByName", parameters, new User());

        if (list != null && list.size() > 0) {
            user = list.get(0);
        } else {
            throw new Exception("user doesn't exists");
        }

        return user;

    } // end getUser

    //==========================================================================
    public static User getUser(String name, String password) throws Exception {
        
        if (name == null || name.length() < 1 || password == null || password.length() < 1) {
            throw new IllegalArgumentException("illegal argument");
        }

        List<User> list = null;
        User user = null;
        list = new DAO().hql("from User u where u.name = '" + name + "' and u.password = '" + password +"'", new User());

        if (list != null && list.size() > 0) {
            user = list.get(0);
        }

        return user;

    } // end getUser
    
    //==========================================================================
    /**
     * update a user.
     * @param user User
     * @throws Exception 
     */
    public static void updateUser(User user) throws Exception{
    
        if (user == null) {
            throw new IllegalArgumentException("user illegal argument");
        }
        
        new DAO().update(user);
        
    }
    
} // end class