package com.example.api;

import com.example.api.dto.DummyDataDto;
import com.example.api.model.DataEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataRepository extends JpaRepository<DataEntity, Long> {
}
