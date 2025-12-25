package com.example.homebooker.service;

import com.example.homebooker.model.Accommodation;
import com.example.homebooker.model.User;
import com.example.homebooker.repository.AccommodationRepository;
import com.example.homebooker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationService {

    private final AccommodationRepository accommodationRepository;
    private final UserRepository userRepository;

    public AccommodationService(
            AccommodationRepository accommodationRepository,
            UserRepository userRepository
    ) {
        this.accommodationRepository = accommodationRepository;
        this.userRepository = userRepository;
    }

    public List<Accommodation> getAll() {
        return accommodationRepository.findAll();
    }

    public Optional<Accommodation> getById(Long id) {
        return accommodationRepository.findById(id);
    }

    public Accommodation create(Accommodation accommodation) {
        // загружаем владельца по id (JPA сам подтянет данные из базы)
        Long ownerId = accommodation.getOwner().getId();
        User owner = userRepository.findById(ownerId)
                .orElseThrow(() -> new RuntimeException("Owner not found with id " + ownerId));

        accommodation.setOwner(owner);
        return accommodationRepository.save(accommodation);
    }


    public Accommodation update(Long id, Accommodation updatedAccommodation) {
        return accommodationRepository.findById(id)
                .map(accommodation -> {
                    accommodation.setName(updatedAccommodation.getName());
                    accommodation.setDescription(updatedAccommodation.getDescription());
                    accommodation.setPrice(updatedAccommodation.getPrice());
                    accommodation.setLocation(updatedAccommodation.getLocation());
                    accommodation.setOwner(updatedAccommodation.getOwner());
                    return accommodationRepository.save(accommodation);
                })
                .orElseThrow(() -> new RuntimeException("Accommodation not found"));
    }

    public void delete(Long id) {
        accommodationRepository.deleteById(id);
    }
}
