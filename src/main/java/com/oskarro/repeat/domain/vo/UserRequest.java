package com.oskarro.repeat.domain.vo;

import com.oskarro.repeat.domain.models.Role;
import lombok.Data;

@Data
public class UserRequest {

    String identity;
    String name;
    Role role;
}
