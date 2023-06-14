package com.mryzhan.service;

import com.mryzhan.dto.RoleDTO;

import java.util.List;

public interface RoleService {

    List<RoleDTO> listAllRoles();
    RoleDTO findById(Long id);
}
