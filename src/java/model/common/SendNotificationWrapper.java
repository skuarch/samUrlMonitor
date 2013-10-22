package model.common;

import model.beans.Task;

/**
 *
 * @author skuarch
 */
public class SendNotificationWrapper {

    private SendNotificationWrapper() {
    }

    //==========================================================================
    public static void sendNotification(Task task,String message) {
        if (task.getEmail() == null || task.getEmail().length() < 1) {            
            sendSms(task,message);
        } else {
            sendMail(task,message);
        }

    }

    //==========================================================================
    private static void sendMail(Task task,String message) {
        new SendNotification().SendNotificationEmail(task.getEmail(), "alarm " + task.getName(), message, "sam url monitor");
    }

    //==========================================================================
    private static void sendSms(Task task,String message) {
        new SendNotification().SendNotificationSms(task.getSms(), "alarm " + task.getName(), message, "sam url monitor");
    }
} // end SendNotificationWrapper