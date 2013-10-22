package interceptors;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import model.beans.User;

/**
 *
 * @author skuarch
 */
public class LoginInterceptor implements Interceptor {

    private String currentAction = null;
    private Map<String, Object> session = null;
    private User user = null;
    private boolean expiredSession = false;
    private String validActions = null;
    private List<String> validActionsList = null;

    //==========================================================================
    public LoginInterceptor() {
    } // end LoginInterceptor

    //==========================================================================
    @Override
    public void destroy() {
    } // end destroy

    //==========================================================================
    @Override
    public void init() {
    } // end init

    //==========================================================================
    @Override
    public String intercept(ActionInvocation ai) throws Exception {       
        
        validActionsList = Arrays.asList(validActions.split(","));
        currentAction = (String) ActionContext.getContext().get(ActionContext.ACTION_NAME);
        
        if (validActionsList.contains(currentAction)) {
            return ai.invoke();
        }

        session = ActionContext.getContext().getSession();
        user = (User) session.get("user");

        if (user == null) {

            if (expiredSession) {
                return "expiredSession";
            }

            return "login";

        } else {

            expiredSession = true;
            return ai.invoke();

        }

    } // end intercept

    //==========================================================================
    public String getValidActions() {
        return validActions;
    }

    public void setValidActions(String validActions) {
        this.validActions = validActions;
    }
} // end class