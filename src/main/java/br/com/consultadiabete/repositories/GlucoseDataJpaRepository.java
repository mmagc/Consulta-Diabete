package br.com.consultadiabete.repositories;

import br.com.consultadiabete.dto.glucoseData.CreateGlucoseDto;
import br.com.consultadiabete.dto.glucoseData.GlucoseDataResponseDTO;
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

    @org.springframework.data.jpa.repository.Query(
            value = """
            select g
            from GlucoseData g
            join fetch g.user u
            where u.id = :userId
            order by g.createdAt desc
        """,
            countQuery = """
            select count(g)
            from GlucoseData g
            where g.user.id = :userId
        """
    )
    Page<GlucoseData> findPageByUserIdFetchUser(
            @org.springframework.data.repository.query.Param("userId") UUID userId,
            Pageable pageable
    );

    List<GlucoseData> findByUser_IdAndCreatedAtBetween(
            UUID userId, LocalDateTime start, LocalDateTime end, Sort sort);
}
