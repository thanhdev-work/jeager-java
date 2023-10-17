package com.example.api.controller;


import com.example.api.DataRepository;
import com.example.api.client.AttachDataServiceClient;
import com.example.api.dto.DummyDataDto;
import lombok.extern.log4j.Log4j2;
import lombok.var;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Log4j2
@RestController
@RequestMapping("/")
public class ApiController {
    private final AttachDataServiceClient attachDataServiceClient;
    private final DataRepository dataRepository;

    public ApiController(AttachDataServiceClient attachDataServiceClient, DataRepository dataRepository) {
        this.attachDataServiceClient = attachDataServiceClient;
        this.dataRepository = dataRepository;
    }

    @GetMapping("data/{id}")
    public ResponseEntity<DummyDataDto> getDummyData(@PathVariable("id") long id) {
        log.info("COLLECTING DATA WITH ID {} FROM API SERVICE", id);
        var data = dataRepository.findById(id).get();
        var attachData = attachDataServiceClient.getAttachData(id);

        var dummyDataDto = new DummyDataDto();
        dummyDataDto.setId(id);
        dummyDataDto.setContent(data.getData());
        dummyDataDto.setAttachContent(attachData.getAttachData());
        dummyDataDto.setAvailable(true);

        return ResponseEntity.ok(dummyDataDto);
    }
}
