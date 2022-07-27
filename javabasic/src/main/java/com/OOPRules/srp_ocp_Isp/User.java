package com.OOPRules.srp_ocp_Isp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;

@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class User {
    String email;
    String pw;
}
