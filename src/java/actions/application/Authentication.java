package actions.application;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.Date;
import java.util.Map;
import model.beans.User;
import model.common.ModelUser;
import org.apache.log4j.Logger;

/**
 *
 * @author skuarch
 */
public class Authentication extends ActionSupport {

    private final Logger logger = Logger.getLogger(Authentication.class);
    private Map<String, Object> session = null;
    private String username = null;
    private String password = null;
    private String message = null;

    //==========================================================================
    /**
     * create a instance.
     */
    public Authentication() {
    } // end Authentication

    //==========================================================================
    @Override
    public String execute() throws Exception {

        String result = Action.SUCCESS;
        User user = null;

        try {

            //here validate if username or password are correct (SQL injection)

            user = ModelUser.getUser(username, password);

            if (user == null) {

                result = Action.INPUT;
                message = getText("login.error");

            } else {

                session = ActionContext.getContext().getSession();
                session.put("logined", "true");
                session.put("username", username);
                session.put("level", user.getLevel());
                session.put("user", user);
                session.put("serverTypeId", 0);
                
                //update the last login
                user.setLastLogin(new Date().toString());
                ModelUser.updateUser(user);
                
                result = Action.SUCCESS;

            }

        } catch (IllegalArgumentException iae) {
            result = Action.INPUT;
            message = getText("login.error");
        } catch (Exception e) {
            logger.error("Authentication", e);
            message = getText("login.error");
            result = Action.INPUT;
        }

        return result;

    } // end execute  

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
} // end class