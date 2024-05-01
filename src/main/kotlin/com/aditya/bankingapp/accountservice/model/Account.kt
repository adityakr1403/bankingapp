package com.aditya.bankingapp.accountservice.model

import jakarta.persistence.*
import org.jetbrains.annotations.NotNull
import org.springframework.lang.NonNull
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import java.util.Date


@Entity
@Table
class Account(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    @Column(unique = true)
    @NotNull
    val accountNumber: Long,
    @NotNull
    val accountHolderName: String,
    @NotNull
    val phoneNumber: String,
    @NotNull
    val accountType: String,
    @NotNull
    val balance: Double,
    @Column(unique = true)
    @NotNull
    private val username: String,
    @NotNull
    private val password: String,
    @NotNull
    private val accountExpired: Boolean,
    @NotNull
    private val accountLocked: Boolean,
    @NotNull
    val credentialsExpiryDate: Date,
    @NotNull
    private val enabled: Boolean,
    @NotNull
    private val role: String

) : UserDetails {
    override fun getAuthorities(): List<GrantedAuthority> {
        return listOf(GrantedAuthority { role })
    }

    override fun getPassword(): String {
        return password
    }

    override fun getUsername(): String {
        return username
    }

    override fun isAccountNonExpired(): Boolean {
        return !accountExpired
    }

    override fun isAccountNonLocked(): Boolean {
        return !accountLocked
    }

    override fun isCredentialsNonExpired(): Boolean {
        return !credentialsExpiryDate.after(Date())
    }

    override fun isEnabled(): Boolean {
        return enabled
    }

}