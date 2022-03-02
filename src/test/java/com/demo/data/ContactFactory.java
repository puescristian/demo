package com.demo.data;

import com.demo.exceptions.DataNotFoundException;
import com.demo.models.Contact;
import com.github.javafaker.Faker;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class ContactFactory {

    private static final String CONTACT_PATH = "qa/documents/contact-data.json";

    public static List<Contact> getContacts() throws FileNotFoundException {
        return Arrays.asList(from(getContactFile()).getObject("Contact", Contact[].class));
    }

    public static Contact getContactByKey(String key) throws FileNotFoundException {
        return getContacts().stream()
                .filter(a -> a.getKey()
                        .equals(key))
                .findFirst()
                .orElseThrow(() ->
                        new DataNotFoundException(String.format("Contact with key %s not found", key)));
    }

    public static Contact getContactByKeyWithRandomData() throws FileNotFoundException {
        Contact contact = getContactByKey(Faker.instance().random().nextInt(1, 4).toString());
        String id = Faker.instance().random().nextInt(1000, 9999).toString();
        contact.setIdentityNo(id);
        contact.setFirstName(contact.getFirstName()+id);
        return contact;
    }

    private static URL getContactFile() throws FileNotFoundException {
        URL filePath = ContactFactory.class.getClassLoader().getResource(CONTACT_PATH);
        if (filePath == null) {
            throw new FileNotFoundException("File not found for Contact: " + CONTACT_PATH);
        }
        return filePath;
    }
}
