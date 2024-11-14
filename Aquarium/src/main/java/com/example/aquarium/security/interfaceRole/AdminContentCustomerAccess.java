package com.example.aquarium.security.interfaceRole;

import org.springframework.security.access.prepost.PreAuthorize;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@PreAuthorize("hasAnyAuthority('ROLE_ADMINISTRATOR', 'ROLE_CONTENT_STAFF', 'ROLE_CUSTOMER')")
public @interface AdminContentCustomerAccess {
}