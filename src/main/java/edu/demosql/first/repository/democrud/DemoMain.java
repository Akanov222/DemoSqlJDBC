package edu.demosql.first.repository.democrud;

import java.util.*;

public class DemoMain {

    public static void main(String[] args) {
        Contact contact1 = new Contact(1, "Vasek", "102");
        Contact contact2 = new Contact(2, "Sanek", "103");
        Contact contact3 = new Contact(3, "Zoy", "104");
        Contact contact4 = new Contact(2, "Sanek", "1103");

        HashMap<Contact, String> addressMap = new HashMap<>();
        addressMap.put(contact1, "SPb, Nevskiy, 1");
        contact1.setId(2);
        contact1.setPhone("1102");

        System.out.println(addressMap.get(contact1));

        for (var pair : addressMap.entrySet()) {
            Contact key = pair.getKey();
            String value = pair.getValue();
            System.out.println(key + " --> " + value);
            System.out.println("get classes " + key.getClass() +
                    " - key.getClass()" + value.getClass() + " - value.getClass()");
        }

        System.out.println(contact1.getClass());
        System.out.println(addressMap.getClass());
        System.out.println(addressMap.getClass());
    }
}
