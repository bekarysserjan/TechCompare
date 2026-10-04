package com.techcompare.backend.repository;

import com.techcompare.backend.model.Device;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeviceRepository extends JpaRepository<Device, Long> {

    @Query("""
        SELECT d FROM Device d
        WHERE d.category = :category
        AND (
            LOWER(d.brand) LIKE LOWER(CONCAT('%', :q, '%'))
            OR LOWER(d.modelName) LIKE LOWER(CONCAT('%', :q, '%'))
        )
    """)
    List<Device> searchDevices(
            @Param("category") String category,
            @Param("q") String q
    );
}