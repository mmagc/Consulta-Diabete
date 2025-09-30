package br.com.consultadiabete.repositories;

import br.com.consultadiabete.entities.GlucoseData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface GlucoseDataJpaRepository extends JpaRepository<GlucoseData, UUID> {

    Page<GlucoseData> findByUser_Id(UUID userId, Pageable pageable);

    List<GlucoseData> findByUser_IdAndMeassurementTimeBetween(
            UUID userId, LocalDateTime start, LocalDateTime end, Sort sort);

}
