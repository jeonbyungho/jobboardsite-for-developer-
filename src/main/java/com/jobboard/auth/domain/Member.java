package com.jobboard.auth.domain;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Member {
	private long id;
	private String username;
	private String password;
	private String email;
	private LocalDateTime createdAt;
}