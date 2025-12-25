package com.example.homebooker.service;

import com.example.homebooker.model.Reservation;
import com.example.homebooker.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }

    public Optional<Reservation> getById(Long id) {
        return reservationRepository.findById(id);
    }

    // валидация бронирования
    public Reservation create(Reservation reservation) {
        boolean overlaps = reservationRepository.existsOverlappingReservation(
                reservation.getAccommodation().getId(),
                reservation.getStartDate(),
                reservation.getEndDate()
        );

        if (overlaps) {
            throw new IllegalArgumentException("This accommodation is already booked for the selected dates.");
        }

        return reservationRepository.save(reservation);
    }

    public Reservation update(Long id, Reservation updatedReservation) {
        return reservationRepository.findById(id)
                .map(reservation -> {
                    reservation.setStartDate(updatedReservation.getStartDate());
                    reservation.setEndDate(updatedReservation.getEndDate());
                    reservation.setGuest(updatedReservation.getGuest());
                    reservation.setAccommodation(updatedReservation.getAccommodation());
                    return reservationRepository.save(reservation);
                })
                .orElseThrow(() -> new RuntimeException("Reservation not found"));
    }

    public void delete(Long id) {
        reservationRepository.deleteById(id);
    }
}
