package com.checkup.user.form;

import com.checkup.server.adapter.DozerAdapter;
import com.checkup.user.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.time.OffsetDateTime;
import java.util.UUID;

public class UserFORM implements Serializable {

    @NotNull
    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$", message = "Invalid user name")
    private String userName;

    @NotNull
    @NotBlank
    private String fullName;

    @NotNull
    @NotBlank
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(final String userName) {
        this.userName = userName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(final String fullName) {
        this.fullName = fullName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public User toUser() {
       final User user = new User();
       user.setId(UUID.randomUUID());
       user.setUserName(userName);
       user.setFullName(fullName);
       user.setPassword(codePassword());
       user.setAccountNonExpired(Boolean.TRUE);
       user.setAccountNonLocked(Boolean.TRUE);
       user.setCredentialsNonExpired(Boolean.TRUE);
       user.setEnabled(Boolean.TRUE);
       user.setCreatedAt(OffsetDateTime.now());
       user.setUpdatedAt(OffsetDateTime.now());
       return user;
    }

    private String codePassword() {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16);
		return bCryptPasswordEncoder.encode(password);
    }
}