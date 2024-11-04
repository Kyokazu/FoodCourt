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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {
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
    public PlateServicePort updateplateusecase(PlatePersistencePort platePersistencePort, RestaurantPersistencePort restaurantPersistencePort) {
        return new UpdatePlateUseCase(platePersistencePort, restaurantPersistencePort);

    }



}
