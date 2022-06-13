package com.pap.redminelookalike.controller.dto.UserDto;

import com.pap.redminelookalike.entity.Details;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserCreateDto {
    private Long id;
    private String username;
    private String password;
    private Details details;
}

