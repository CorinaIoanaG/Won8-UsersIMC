package com.fasttrackit.imcapplication.service;

import com.fasttrackit.imcapplication.model.User;
import com.fasttrackit.imcapplication.model.UserData;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository

public class IMCReader {
    public List<User> getUsers() {
        try {
            return Files.lines(Path.of("src/main/resources/usersdata.txt"))
                    .map(line -> {
                        try {
                            return lineToUser(line);
                        } catch (ParseException e) {
                            throw new RuntimeException(e);
                        }
                    })
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private User lineToUser(String line) throws ParseException {
        String[] userParts = line.split("\\|");
        return new User(0, userParts[0], userParts[1], userParts[2], userParts[3], Float.parseFloat(userParts[4]),
                userParts[5], userParts.length > 6 ? parseUsersData(userParts[6],Float.parseFloat(userParts[4])) : List.of());
    }

    private List<UserData> parseUsersData(String usersData, float userHeight) throws ParseException {
        String[] elements = usersData.split("~");
        List <UserData> result = new ArrayList<>();
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        if (elements.length > 0) {
            String[] datas;
            for (String element : elements) {
                datas = element.split("\\^");
                result.add(new UserData(dateFormat.parse(datas[0]), Integer.parseInt(datas[1]),
                        (float) (Integer.parseInt(datas[1])/Math.pow(userHeight,2))));
            }
        }
        return result;
    }
}
