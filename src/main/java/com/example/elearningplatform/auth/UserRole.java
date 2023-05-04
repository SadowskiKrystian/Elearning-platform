package com.example.elearningplatform.auth;

public enum UserRole {
    ADMIN("ADMIN", "ROLE_ADMIN"),
    STUDENT("STUDENT", "ROLE_STUDENT"),
    TEACHER("TEACHER", "ROLE_TEACHER"),
    QUEST("QUEST", "ROLE_QUEST");

    private String code;
    private String codeWithRole;

    UserRole(String code, String codeWithRole) {
        this.code = code;
        this.codeWithRole = codeWithRole;
    }

    public String getCode() {
        return code;
    }

    public String getCodeWithRole() {
        return codeWithRole;
    }
    }

