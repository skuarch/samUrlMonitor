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
@Table(name = "task")
@NamedQueries({
    @NamedQuery(name="getTaskByName",query="from Task t where t.name = :name")
})
public class Task implements Serializable {

    @Id
    @Column(name = "task_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private long id;
    
    @Column(name = "task_name",nullable = false)
    private String name;    
    
    @Column(name = "task_url",nullable = false)
    private String url;
    
    @Column(name = "task_method",nullable = false)
    private String method;
    
    @Column(name = "task_email")
    private String email;
    
    @Column(name = "task_sms")
    private String sms;
    
    @Column(name = "task_trigger")
    private int trigger;
    
    @Column(name = "task_timeout")
    private int timeout;
    
    @Column(name = "task_period")
    private int period;
    
    @Column(name = "task_status")
    private int status;
    
    //==========================================================================
    public Task() {
    } // end task

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getTrigger() {
        return trigger;
    }

    public void setTrigger(int trigger) {
        this.trigger = trigger;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }    

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSms() {
        return sms;
    }

    public void setSms(String sms) {
        this.sms = sms;
    }    

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }    
    
} // end class