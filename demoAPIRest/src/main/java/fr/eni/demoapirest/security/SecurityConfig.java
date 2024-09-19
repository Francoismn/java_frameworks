package fr.eni.demoapirest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    /**
     *
     * @param dataSource
     * Indique à Spring Security où se trouvent les inforamtions de connexion à l'application
     *
     */

    @Bean
    UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager userDetailsManager = new JdbcUserDetailsManager(dataSource);

        //Récupère la liste des utilisateurs actifs
        userDetailsManager.setUsersByUsernameQuery("select pseudo, password, 1 from users where pseudo=?");

        //Récupère les authorisatiobns de chaque utilisateur
        userDetailsManager.setAuthoritiesByUsernameQuery("select pseudo, authority from users where pseudo=?");

        return userDetailsManager;

    };

    /**
     *
     * @param http
     * Décrit les rôles nécessaires pour accéder aux ressources
     *
     */

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                auth -> {
                    auth
                            //Tout le monde a le droit d'accéder à l'URL racine
                            .requestMatchers("/").permitAll()
                            //Autorise l'accès en GET à bonhommes aux Admin et Employés
                            .requestMatchers(HttpMethod.GET, "/bonhommes/**").hasAnyRole("ADMIN", "EMPLOYE")

                            .requestMatchers(HttpMethod.POST, "/bonhommes/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PUT, "/bonhommes/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.PATCH, "/bonhommes/**").hasRole("ADMIN")
                            .requestMatchers(HttpMethod.DELETE, "/bonhommes/**").hasRole("ADMIN")

//                            .anyRequest().authenticated();
                            .anyRequest().denyAll();
                }
        );

        //Utilise l'authentification basique d'http (user/password)
        http.httpBasic(Customizer.withDefaults());

        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}
