package com.rwa.data.management;

import com.google.gson.Gson;
import com.rwa.data.fixture.SeedDataFixture;
import com.rwa.data.fixture.User;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class DataManagement {

    public static final String dataPath = "src/test/resources/com/rwa/data/database.json";

    private static SeedDataFixture parseSeedDataFile() {
        try (FileReader fileReader = new FileReader(dataPath)) {
            Gson gson = new Gson();
            return gson.fromJson(fileReader, SeedDataFixture.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<User> getUsers() {
        return Objects.requireNonNull(parseSeedDataFile()).getUsers();
    }


}

