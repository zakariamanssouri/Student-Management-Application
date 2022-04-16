package ma.enset.security.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.enset.security.entities.AppRole;
import ma.enset.security.entities.AppUser;
import ma.enset.security.repositories.AppRoleRepository;
import ma.enset.security.repositories.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;


@Service
@Slf4j /*à*/
@AllArgsConstructor
@Transactional
public class SecurityServiceImpl implements SecurityService {

    private AppUserRepository appUserRepository;
    private AppRoleRepository appRoleRepository;
    private PasswordEncoder passwordEncoder; /* why */

    @Override
    public AppUser saveNewUser(String username, String password, String rePassword) {
        if(!password.equals(rePassword)) throw new RuntimeException("passwords dosen't match ");

        /*encode password*/
        String hashedPassword = passwordEncoder.encode(password);
        AppUser appUser = new AppUser();

        /*generate a unique uuid for user id*/
        appUser.setUserId(UUID.randomUUID().toString());
        appUser.setUsername(username);
        appUser.setPassword(hashedPassword);
        appUser.setActive(true);

        AppUser savedAppUser = appUserRepository.save(appUser);
        return savedAppUser;
    }

    @Override
    public AppRole saveNewRole(String roleName, String description) {
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        /*chech if the role is exist*/
        if(appRole!=null) throw new RuntimeException("Role " + roleName + " Already exist");
        appRole = new AppRole();
        appRole.setRoleId(null);
        appRole.setRoleName(roleName);
        appRole.setDescription(description);
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new RuntimeException("User not found");
        }
        AppRole appRole = appRoleRepository.findByRoleName(roleName);

        if (appRole == null) {
            throw new RuntimeException("Role not found");
        }
        appUser.getAppRoles().add(appRole);
        appUserRepository.save(appUser);
    }

    @Override
    public void removeRoleFromUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        if (appUser == null) {
            throw new RuntimeException("User not found");
        }
        AppRole appRole = appRoleRepository.findByRoleName(roleName);

        if (appRole == null) {
            throw new RuntimeException("Role not found");
        }
        appUser.getAppRoles().remove(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }
}