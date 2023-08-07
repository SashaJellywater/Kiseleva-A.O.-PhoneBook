import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Main{
    public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
        if (map.containsKey(key)) {
            map.get(key).add(value);
        } else {
            ArrayList<Integer> list = new ArrayList<>();
            list.add(value);
            map.put(key, list);
        }
    }
    public static void printBook(HashMap<String, ArrayList<Integer>> phoneBook) {
        HashMap<Integer, ArrayList<String>> sortedPhoneBook = new HashMap<>();
        for (String name : phoneBook.keySet()) {//
            int numNumbers = phoneBook.get(name).size();
            if (sortedPhoneBook.containsKey(numNumbers)) {
                sortedPhoneBook.get(numNumbers).add(name);
            } else {
                ArrayList<String> names = new ArrayList<>();
                names.add(name);
                sortedPhoneBook.put(numNumbers, names);
            }
        }
        ArrayList <Integer> sortedKeys = new ArrayList<>(sortedPhoneBook.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder());

        for (int key : sortedKeys) {
            ArrayList<String> names = sortedPhoneBook.get(key);
            for (String name : names) {
                    System.out.println(name + ": " + phoneBook.get(name));

                }
            }
        }
    public static void main(String[] args) {
        HashMap<String, ArrayList <Integer> >bookPhone = new HashMap<>();
        addNumber("Киселев", 8887878, bookPhone);
        addNumber("Киселева",8089878, bookPhone);
        addNumber("Дорохов", 8884835, bookPhone);
        addNumber("Петров", 8830488, bookPhone);
        addNumber("Петров", 1920878, bookPhone);
        addNumber("Киселев", 8497678, bookPhone);
        printBook(bookPhone);
    }
}