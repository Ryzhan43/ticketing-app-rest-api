package com.mryzhan.service;

import com.mryzhan.dto.RoleDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id);
}
