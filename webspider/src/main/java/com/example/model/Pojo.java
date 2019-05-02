package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pojo {
    String userMain;
    String username;
    String headline;
    String replyCount;
    String articleCount;
    String followCount;
}
