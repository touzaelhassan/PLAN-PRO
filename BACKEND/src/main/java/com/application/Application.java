package com.application;

import com.application.entities.*;
import com.application.repositories.CategoryRepository;
import com.application.repositories.EventRepository;
import com.application.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;

import static com.application.constants.FileConstants.USER_FOLDER;
import static com.application.enums.Role.*;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        new File(USER_FOLDER).mkdirs();
    }

    @Bean
    CommandLineRunner run(
            UserRepository userRepositoryBean,
            CategoryRepository categoryRepositoryBean,
            EventRepository eventRepositoryBean,
            BCryptPasswordEncoder bCryptPasswordEncoder
    ){

        return args -> {

            Admin admin = new Admin();
            admin.setUserId("534376");
            admin.setFirstname("El Hassan");
            admin.setLastname("Touza");
            admin.setUsername("hassan");
            admin.setEmail("hassan@gmail.com");
            admin.setJoinDate(new Date());
            admin.setPassword(bCryptPasswordEncoder.encode("123456"));
            admin.setIsActive(true);
            admin.setIsNotLocked(true);
            admin.setRole(ROLE_ADMIN.name());
            admin.setAuthorities(ROLE_ADMIN.getAuthorities());
            userRepositoryBean.save(admin);

            Organizer organizer = new Organizer();
            organizer.setUserId("534377");
            organizer.setFirstname("Mustapha");
            organizer.setLastname("Bill");
            organizer.setUsername("mustapha");
            organizer.setEmail("mustapha@gmail.com");
            organizer.setJoinDate(new Date());
            organizer.setPassword(bCryptPasswordEncoder.encode("123456"));
            organizer.setIsActive(true);
            organizer.setIsNotLocked(true);
            organizer.setRole(ROLE_ORGANIZER.name());
            organizer.setAuthorities(ROLE_ORGANIZER.getAuthorities());
            userRepositoryBean.save(organizer);

            Attendee attendee = new Attendee();
            attendee.setUserId("534378");
            attendee.setFirstname("Yassine");
            attendee.setLastname("Mol");
            attendee.setUsername("yassine");
            attendee.setEmail("yassine@gmail.com");
            attendee.setJoinDate(new Date());
            attendee.setPassword(bCryptPasswordEncoder.encode("123456"));
            attendee.setIsActive(true);
            attendee.setIsNotLocked(true);
            attendee.setRole(ROLE_ATTENDEE.name());
            attendee.setAuthorities(ROLE_ATTENDEE.getAuthorities());
            userRepositoryBean.save(attendee);

            Category category1 = new Category();
            category1.setName("technology");
            category1.setDescription("A technology event is an event that focuses on showcasing the latest advancements in technology, including hardware, software, and emerging trends.");
            category1.setImageUrl("assets/images/categories/technology.jpg");
            categoryRepositoryBean.save(category1);

            Category category2 = new Category();
            category2.setName("sport");
            category2.setDescription("A sports event is an organized activity that brings together athletes, teams, or fans to participate in or watch a sporting competition.");
            category2.setImageUrl("assets/images/categories/sport.jpg");
            categoryRepositoryBean.save(category2);

            Category category3 = new Category();
            category3.setName("music");
            category3.setDescription("A music event is an organized gathering that showcases live musical performances by musicians or bands.");
            category3.setImageUrl("assets/images/categories/music.jpg");
            categoryRepositoryBean.save(category3);

            Event event1 = new Event();
            event1.setName("Tech Connect");
            event1.setDescription("Tech Connect is a technology-focused event that brings together professionals, entrepreneurs, investors, and technology enthusiasts to discuss the latest trends, innovations, and opportunities in the tech industry.");
            event1.setImageUrl("assets/images/events/1.jpg");
            event1.setStartDate(new Date());
            event1.setEndDate(new Date() );
            event1.setPlaces(50);
            event1.setIsAvailable(true);
            event1.setIsApproved(true);
            event1.setCategory(category1);
            event1.setOrganizer(organizer);
            eventRepositoryBean.save(event1);

            Event event2 = new Event();
            event2.setName("Power Play Challenge");
            event2.setDescription("Power Play Challenge is a sports event that focuses on showcasing the power and strength of athletes. The event could feature various competitions and challenges that require participants to demonstrate their physical prowess.");
            event2.setImageUrl("assets/images/events/2.jpg");
            event2.setStartDate(new Date());
            event2.setEndDate(new Date());
            event2.setPlaces(50);
            event2.setIsAvailable(true);
            event2.setIsApproved(true);
            event2.setCategory(category2);
            event2.setOrganizer(organizer);
            eventRepositoryBean.save(event2);

            Event event3 = new Event();
            event3.setName("Rhythm & Beats");
            event3.setDescription("Rhythm & Beats is a name that suggests a music event that showcases different types of music, particularly those with a strong beat or rhythm. This event could feature a variety of musical genres, such as hip-hop.");
            event3.setImageUrl("assets/images/events/3.jpg");
            event3.setStartDate(new Date());
            event3.setEndDate(new Date());
            event3.setPlaces(50);
            event3.setIsAvailable(true);
            event3.setIsApproved(true);
            event3.setCategory(category3);
            event3.setOrganizer(organizer);
            eventRepositoryBean.save(event3);

        };
    }

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
        corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
                "Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
                "Access-Control-Request-Method", "Access-Control-Request-Headers"));
        corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Jwt-Token", "Authorization",
                "Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
