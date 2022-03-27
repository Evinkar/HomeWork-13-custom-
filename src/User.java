import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String userName;
    private String emailAddress;
    private boolean isSubscribed;
    private int id = 0;
    private static int countId = 0;

    public User(String userName, String emailAddress, String isSubscribed) {
        this.userName = userName;
        this.emailAddress = emailAddress;
        this.id = ++countId;
        //TODO подумать о замене цикла ifelse на более простой?
        if (isSubscribed.equals("Subscribed")){
            this.isSubscribed = true;
        }else if(!isSubscribed.equals("Subscribed")&&!isSubscribed.equals("NotSubscribed")){
            System.out.println("SubscribeError");
        }
    }
    public static List<User> loadUserFromFile(String path) {
        List<User> userList = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get(path));
            for (String line : lines) {
                String[] fragments = line.split("\t");
                if (fragments.length != 3) {
                    System.out.println("Wrong line: " + line);
                    continue;
                }
                userList.add(new User(fragments[0], fragments[1],fragments[2]));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public String toString() {
        return userName + " " + emailAddress + ", isSubscribed=" + isSubscribed + ", id=" + id + "\n";
    }

    public boolean isSubscribed() {
        return isSubscribed;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public int getId() {
        return id;
    }
}
