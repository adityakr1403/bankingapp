package com.aditya.bankingapp.accountservice.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.ProviderManager
import org.springframework.security.authentication.dao.DaoAuthenticationProvider
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer.AuthorizationManagerRequestMatcherRegistry
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain


@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    @Throws(Exception::class)
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .authorizeHttpRequests {
                it
                    .requestMatchers("/**").authenticated()
            }
            .httpBasic(Customizer.withDefaults())
            .formLogin(Customizer.withDefaults())
//            .sessionManagement {
//                it
//                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//            }

        return http.build()
    }

//    @Bean
//    fun authenticationManager(
//        userDetailsService: UserDetailsService?,
//        passwordEncoder: PasswordEncoder?
//    ): AuthenticationManager {
//        val authenticationProvider = DaoAuthenticationProvider()
//        authenticationProvider.setUserDetailsService(userDetailsService)
//        authenticationProvider.setPasswordEncoder(passwordEncoder)
//
//        return ProviderManager(authenticationProvider)
//    }

    @Bean
    fun userDetailsService(): UserDetailsService {
        val user = User
            .withUsername("admin")
            .password(passwordEncoder().encode("admin"))
            .roles("ADMIN", "USER")
            .accountLocked(false)
            .accountExpired(false)
            .build()
        return InMemoryUserDetailsManager(user)
    }
}