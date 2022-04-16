package ma.enset;

import ma.enset.entities.Gender;
import ma.enset.entities.Student;
import ma.enset.repositories.StudentRepository;
import ma.enset.security.entities.AppRole;
import ma.enset.security.entities.AppUser;
import ma.enset.security.service.SecurityService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class StudentManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentManagementApplication.class, args);
	}


	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	//@Bean
	CommandLineRunner commandLineRunner(SecurityService securityService) {
		return args -> {
			securityService.saveNewUser("zakaria","12345","12345");
			securityService.saveNewUser("admin","admin","admin");

			securityService.saveNewRole("ADMIN","");
			securityService.saveNewRole("USER","");

			securityService.addRoleToUser("zakaria","USER");
			securityService.addRoleToUser("admin","ADMIN");
			securityService.addRoleToUser("admin","USER");

			AppUser appUser = securityService.loadUserByUsername("zakaria");
			System.out.println("displaying user roles");

			System.out.println("displaying user roles");
			for (AppRole appRole : appUser.getAppRoles()) {
				System.out.println(appRole.getRoleName());
			}
		};
	}
}
