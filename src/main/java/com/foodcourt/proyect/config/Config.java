package com.foodcourt.proyect.config;

import com.foodcourt.proyect.domain.repositoryPort.PlatePersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.UserPersistencePort;
import com.foodcourt.proyect.domain.servicePort.PlateServicePort;
import com.foodcourt.proyect.domain.servicePort.RestaurantServicePort;
import com.foodcourt.proyect.domain.servicePort.UserServicePort;
import com.foodcourt.proyect.domain.useCase.CreateOwnerUseCase;
import com.foodcourt.proyect.domain.useCase.CreatePlateUseCase;
import com.foodcourt.proyect.domain.useCase.CreateRestaurantUseCase;
import com.foodcourt.proyect.domain.useCase.UpdatePlateUseCase;
import com.foodcourt.proyect.infrastructure.persistence.repository.UserRepository;
import com.foodcourt.proyect.infrastructure.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class Config {

    private final UserRepository userRepository;

    @Bean
    public UserServicePort userServicePort(UserPersistencePort userRepository) {
        return new CreateOwnerUseCase(userRepository);
    }

    @Bean
    public RestaurantServicePort restaurantServicePort(RestaurantPersistencePort restaurantPersistence, UserPersistencePort userRepository) {
        return new CreateRestaurantUseCase(restaurantPersistence, userRepository);
    }

    @Bean
    @Qualifier("create")
    public PlateServicePort createplateusecase(PlatePersistencePort platePersistencePort, RestaurantPersistencePort restaurantPersistencePort) {
        return new CreatePlateUseCase(platePersistencePort, restaurantPersistencePort);

    }

    @Bean
    @Qualifier("update")
    public PlateServicePort updateplateusecase(PlatePersistencePort platePersistencePort, RestaurantPersistencePort restaurantPersistencePort, UserPersistencePort userRepository) {
        return new UpdatePlateUseCase(platePersistencePort, restaurantPersistencePort, userRepository);

    }

    @Bean
    public AuthenticationManager authenticationManagerBean(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Bean
    public UserDetailsService userDetailService() {
        return mail -> userRepository.findByMail(mail)
                .orElseThrow(() -> new UsernameNotFoundException("Mail not found"));
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
