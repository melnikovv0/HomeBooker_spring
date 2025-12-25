package com.example.homebooker.repository;

import com.example.homebooker.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
//Дотаз SQL се провади помоси Къури
// зконтралуе зда се дата резервацисе прекрываи с эксистуицеми дати

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("""
        SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END
        FROM Reservation r
        WHERE r.accommodation.id = :accommodationId
          AND (
              :startDate BETWEEN r.startDate AND r.endDate OR
              :endDate BETWEEN r.startDate AND r.endDate OR
              r.startDate BETWEEN :startDate AND :endDate
          )
    """)
    boolean existsOverlappingReservation(
            @Param("accommodationId") Long accommodationId,
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate
    );
}
