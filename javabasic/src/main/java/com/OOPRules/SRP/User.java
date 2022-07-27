package com.OOPRules.SRP;

import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
public class User {
    String email;
    String pw;
}
