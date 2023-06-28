package com.mryzhan.service;


import com.mryzhan.dto.UserDTO;
import com.mryzhan.exception.TicketingProjectException;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public interface UserService{

    List<UserDTO> listAllUsers();
    UserDTO findByUserName(String username);
    void save(UserDTO dto);
    UserDTO update(UserDTO dto);
    void deleteByUserName(String username);
    void delete(String username) throws TicketingProjectException;
    List<UserDTO> listAllByRole(String role);





}
