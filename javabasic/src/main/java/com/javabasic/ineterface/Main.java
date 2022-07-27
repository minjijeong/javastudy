package com.javabasic.ineterface;

import com.OOPRules.srp_ocp_Isp.SHA256PasswordEncoder;
import com.OOPRules.srp_ocp_Isp.UserRepository;
import com.OOPRules.srp_ocp_Isp.UserService;

public class Main {
    private static ViewInterface view = null;
    private static UserService service = null;

    public Main(){
        SHA256PasswordEncoder encoder = new SHA256PasswordEncoder();
        this.view = new PrinterView();
        this.service = new UserService(new UserRepository(), encoder, encoder);
        System.out.println(this.service.getClass());
    }

    public static void main(String[] args){
        Main main = new Main();
        view.printView("Main!!!");
        service.addUser("test", "test");
    }
}
