package com.foodcourt.proyect.config;

import com.foodcourt.proyect.domain.repositoryPort.PlatePersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.RestaurantPersistencePort;
import com.foodcourt.proyect.domain.repositoryPort.UserPersistencePort;
import com.foodcourt.proyect.domain.servicePort.PlateServicePort;
import com.foodcourt.proyect.domain.servicePort.RestaurantServicePort;
import com.foodcourt.proyect.domain.servicePort.UserServicePort;
import com.foodcourt.proyect.domain.useCase.*;
import com.foodcourt.proyect.infrastructure.mapper.PlateDTOMapper;
import com.foodcourt.proyect.infrastructure.persistence.repository.UserRepository;
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
    @Qualifier("createOwner")
    public UserServicePort createOwner(UserPersistencePort userRepository) {
        return new CreateOwnerUseCase(userRepository);
    }

    @Bean
    @Qualifier("createEmployee")
    public UserServicePort createEmployee(UserPersistencePort userRepository) {
        return new CreateEmployeeUseCase(userRepository);
    }

    @Bean
    @Qualifier("createClient")
    public UserServicePort createClient(UserPersistencePort userRepository) {
        return new CreateClientUseCase(userRepository);
    }

    @Bean
    @Qualifier("listRestaurant")
    public RestaurantServicePort restaurantServicePort(RestaurantPersistencePort restaurantPersistence) {
        return new ListRestaurantUseCase(restaurantPersistence);
    }

    @Qualifier("createRestaurant")
    @Bean
    public RestaurantServicePort listRestaurantUseCase(RestaurantPersistencePort restaurantPersistence, UserPersistencePort userRepository) {
        return new CreateRestaurantUseCase(restaurantPersistence, userRepository);
    }

    @Bean
    @Qualifier("createPlate")
    public PlateServicePort createPlateUseCase(PlatePersistencePort platePersistencePort, RestaurantPersistencePort restaurantPersistencePort) {
        return new CreatePlateUseCase(platePersistencePort, restaurantPersistencePort);

    }

    @Bean
    @Qualifier("updatePlate")
    public PlateServicePort updatePlateUseCase(PlatePersistencePort platePersistencePort, RestaurantPersistencePort restaurantPersistencePort, UserPersistencePort userRepository) {
        return new UpdatePlateUseCase(platePersistencePort, restaurantPersistencePort, userRepository);

    }

    @Bean
    @Qualifier("listPlate")
    public PlateServicePort listPlateUseCase(PlatePersistencePort platePersistencePort, RestaurantPersistencePort restaurantPersistencePort) {
        return new ListPlateUseCase(platePersistencePort, restaurantPersistencePort);
    }

    @Bean
    @Qualifier("enableUnablePlate")
    public PlateServicePort ableEnablePlate(PlatePersistencePort platePersistencePort, RestaurantPersistencePort restaurantPersistencePort, UserPersistencePort userRepository) {
        return new EnableUnablePlateUseCase(platePersistencePort, restaurantPersistencePort, userRepository);
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
