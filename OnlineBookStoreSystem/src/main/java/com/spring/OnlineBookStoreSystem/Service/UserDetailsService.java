package com.spring.OnlineBookStoreSystem.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.OnlineBookStoreSystem.DTO.UserDetailsDTO.UserDetailsRequestDTO;
import com.spring.OnlineBookStoreSystem.DTO.UserDetailsDTO.UserDetailsResponseDTO;
import com.spring.OnlineBookStoreSystem.Model.UserDetails;
import com.spring.OnlineBookStoreSystem.Repository.UserDetailsRepository;

@Service
public class UserDetailsService {

    @Autowired
    private UserDetailsRepository userDRepo;

    public List<UserDetailsResponseDTO> getAllUserDetails() {
        return userDRepo.findAll()
                .stream()
                .map(this::converterToResponseDTO)
                .collect(Collectors.toList());
    }

    public Optional<UserDetailsResponseDTO> getUserDetailsById(int id) {
        return userDRepo.findById(id)
                .map(this::converterToResponseDTO);
    }

    public String deleteUserDetails(int id) {
        if (!userDRepo.existsById(id)) {
            return "User Details not found";
        }
        userDRepo.deleteById(id);
        return "User details deleted successfully";
    }

    public UserDetailsResponseDTO saveUserDetails(UserDetailsRequestDTO requestDTO) {
        UserDetails details = new UserDetails();
        details.setFirstName(requestDTO.getFirstName());
        details.setLastName(requestDTO.getLastName());
        details.setEmail(requestDTO.getEmail());
        details.setAddress(requestDTO.getAddress());
        details.setPhoneNumber(requestDTO.getPhoneNumber());

        UserDetails savedDetails = userDRepo.save(details);
        return converterToResponseDTO(savedDetails);
    }

    private UserDetailsResponseDTO converterToResponseDTO(UserDetails userDetail) {
        UserDetailsResponseDTO dto = new UserDetailsResponseDTO();
        dto.setUserDetailsId(userDetail.getUserDetailsId());
        dto.setFirstName(userDetail.getFirstName());
        dto.setLastName(userDetail.getLastName());
        dto.setEmail(userDetail.getEmail());
        dto.setAddress(userDetail.getAddress());
        dto.setPhoneNumber(userDetail.getPhoneNumber());
        return dto;
    }
}
