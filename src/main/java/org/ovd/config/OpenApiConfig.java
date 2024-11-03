package org.ovd.config;

import jakarta.inject.Singleton;
import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeIn;
import org.eclipse.microprofile.openapi.annotations.enums.SecuritySchemeType;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.info.License;
import org.eclipse.microprofile.openapi.annotations.security.SecurityRequirement;
import org.eclipse.microprofile.openapi.annotations.security.SecurityScheme;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                contact = @Contact(
                        name = "Ousmane Vincent",
                        email = "dioneousmanevincent@gmail.com",
                        url = "https://ndiolfouta.com"
                ),
                description = "OpenApi documentation for Couches Management",
                title = "OpenApi specification - Ousmane Vincent Dione",
                version = "1.0",
                license = @License(
                        name = "Licence name",
                        url = "https://some-url.com"
                ),
                termsOfService = "Terms of service"
        ),
        servers = {
                @Server(
                        description = "Local ENV",
                        url = "http://localhost:8081"
                ),
                @Server(
                        description = "PROD ENV",
                        url = "https://ndiolfouta.com"
                )
        },
        security = {
                @SecurityRequirement(
                        name = "bearerAuth" // Assurez-vous que le nom correspond à celui défini dans @SecurityScheme
                )
        }
)
@SecurityScheme(
        securitySchemeName = "bearerAuth",
        description = "Gestion couche auth description",
        scheme = "bearer",
        type = SecuritySchemeType.HTTP,
        bearerFormat = "JWT",
        in = SecuritySchemeIn.HEADER
)

public class OpenApiConfig  extends Application {
}
