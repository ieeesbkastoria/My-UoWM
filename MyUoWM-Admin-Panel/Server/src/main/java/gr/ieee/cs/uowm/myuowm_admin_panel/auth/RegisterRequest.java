package gr.ieee.cs.uowm.myuowm_admin_panel.auth;

import gr.ieee.cs.uowm.myuowm_admin_panel.user.Role;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String user;
    private String pwd;
    private Role role;
}
