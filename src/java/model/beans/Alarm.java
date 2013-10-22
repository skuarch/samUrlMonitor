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
@Table(name = "alarm")
@NamedQueries({
    @NamedQuery(
            name = "alarmStatusChart",
            query = "select count(a.level) from Alarm a where a.date > :date group by a.level order by a.level asc")
})
public class Alarm implements Serializable {

    @Id
    @Column(name = "alarm_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id = 0;
    @Column(name = "alarm_level")
    private int level = 0;
    @Column(name = "alarm_date", nullable = false)
    private String date = null;
    @Column(name = "alarm_description")
    private String description = null;
    @Column(name = "alarm_task_name")
    private String taskName;
    @Column(name = "alarm_url")
    private String url;
   

    //==========================================================================
    public Alarm() {
    } // end Alarm

    //==========================================================================
    public Alarm(Alarm alarm) {
        this.id = alarm.getId();
        this.level = alarm.getLevel();
        this.date = alarm.date;
        this.description = alarm.getDescription();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "[id=" + id + " level=" + level + " date=" + date + " description=" + description + " taskName=" + taskName + " url=" + url + "]";
    }
} // end class