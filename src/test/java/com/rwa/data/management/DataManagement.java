package com.rwa.data.management;

import com.google.gson.Gson;
import com.rwa.data.fixture.SeedDataFixture;
import com.rwa.data.fixture.User;
import org.concordion.api.MultiValueResult;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class DataManagement {
    public static final String dataPath = "src/test/resources/com/rwa/data/database.json";

    private DataManagement dataManagement;

    private SeedDataFixture parseSeedDataFile() {
        try (FileReader fileReader = new FileReader(dataPath)) {
            Gson gson = new Gson();
            return gson.fromJson(fileReader, SeedDataFixture.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> getUsers() {
        return Objects.requireNonNull(parseSeedDataFile()).getUsers();
    }

    public DataManagement getDataManagement() {
        return dataManagement;
    }

    public void setDataManagement(DataManagement dataManagement) {
        this.dataManagement = dataManagement;
    }

    public void delete(){
        dataManagement = null;
    }
}

