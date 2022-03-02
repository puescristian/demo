package com.demo.data;

import com.demo.exceptions.DataNotFoundException;
import com.demo.models.Meeting;
import com.github.javafaker.Faker;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;

import static io.restassured.path.json.JsonPath.from;

public class MeetingFactory {

    private static final String MEETING_PATH = "qa/documents/meeting-data.json";

    public static List<Meeting> getMeetings() throws FileNotFoundException {
        return Arrays.asList(from(getMeetingFile()).getObject("Meeting", Meeting[].class));
    }

    public static Meeting getMeetingByKey(String key) throws FileNotFoundException {
        return getMeetings().stream()
                .filter(a -> a.getKey()
                        .equals(key))
                .findFirst()
                .orElseThrow(() ->
                        new DataNotFoundException(String.format("Meeting with key %s not found", key)));
    }

    public static Meeting getMeetingByKeyWithRandomData() throws FileNotFoundException {
        Meeting meeting = getMeetingByKey(Faker.instance().random().nextInt(1, 4).toString());
        String n1 = Faker.instance().random().nextInt(1000, 9999).toString();
        String n2 = Faker.instance().random().nextInt(1, 30).toString();
        String n3 = Faker.instance().random().nextInt(100, 999).toString();
        meeting.setMeetingNumber(n1);
        meeting.setUnit("Unit "+n1);
        meeting.setParentUnit("Corp N-"+n3);
        meeting.setStartDate("06/"+n2+"/2022");
        meeting.setEndDate("06/"+n2+"/2022");
        meeting.setMeetingName(meeting.getMeetingName()+n1);

        return meeting;
    }

    private static URL getMeetingFile() throws FileNotFoundException {
        URL filePath = MeetingFactory.class.getClassLoader().getResource(MEETING_PATH);
        if (filePath == null) {
            throw new FileNotFoundException("File not found for Meeting: " + MEETING_PATH);
        }
        return filePath;
    }
}
