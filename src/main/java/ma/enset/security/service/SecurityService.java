package ma.enset.security.service;


import ma.enset.security.entities.AppRole;
import ma.enset.security.entities.AppUser;

public interface SecurityService {
    AppUser saveNewUser(String username, String passwordString, String rePassword);

    AppRole saveNewRole(String roleName, String description);

    void addRoleToUser(String username, String roleName);

    void removeRoleFromUser(String username, String roleName);

    AppUser loadUserByUsername(String username);


}