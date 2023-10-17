package com.example.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DataServiceApplication {

    private static List<AttachData> attachDataList = new ArrayList<>();

    static {
        attachDataList.add(new AttachData(1L, "attach 1"));
        attachDataList.add(new AttachData(2L, "attach 2"));
        attachDataList.add(new AttachData(3L, "attach 3"));
    }

    public static void main(String[] args) {
        SpringApplication.run(DataServiceApplication.class, args);
    }

    private AttachData getAttachData(long id) {
        return attachDataList.stream().filter(e -> e.getId().equals(id)).findFirst().get();
    }

}
