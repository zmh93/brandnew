package com.brandnew.jtatest.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CasUser {
    private Long id;
    private String userName;
    private String password;
}