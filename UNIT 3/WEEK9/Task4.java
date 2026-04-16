import java.util.*;

// Interface
interface Notification {
    void sendNotification(String message);
}

// Email Notification
class EmailNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Email notification: " + message);
    }
}

// SMS Notification
class SMSNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent SMS notification: " + message);
    }
}

// Push Notification
class PushNotification implements Notification {
    public void sendNotification(String message) {
        System.out.println("Sent Push notification: " + message);
    }
}

public class Task4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        for(int i = 0; i < n; i++) {
            String type = sc.next();
            String message = sc.next();

            Notification notification;

            if(type.equals("E")) {
                notification = new EmailNotification();
            }
            else if(type.equals("S")) {
                notification = new SMSNotification();
            }
            else {
                notification = new PushNotification();
            }

            notification.sendNotification(message);
        }

        sc.close();
    }
}