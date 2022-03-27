import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<User> avito = User.loadUserFromFile("Data/UsersData.txt");

        List<User> subscribers = avito.stream().filter(user -> user.isSubscribed()).sorted(Comparator.comparing(User::getUserName)).collect(Collectors.toList());
        System.out.println(subscribers);//фильтрация по подписке, сортировка по имени и сбор в колекцию List subscribers

        avito.stream().filter(user -> user.getEmailAddress().substring(user.getEmailAddress().indexOf(".") + 1, user.getEmailAddress().length()).equals("com")).forEach(System.out::println);
        ///Фильтрация по домену и печать

        Map<Integer, String> map = avito.stream().collect(Collectors.toMap(User::getId, User::getUserName));
        System.out.println(map);//Сбор в мапу с ключом по id и значением имени
    }


}
