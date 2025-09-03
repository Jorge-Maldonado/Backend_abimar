package config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class SwaggerStartupLogger {

    @EventListener(ApplicationReadyEvent.class)
    public void logSwaggerUrl() {
        System.out.println("-----------------------------------------------------");
        System.out.println("📘 Swagger UI disponible en: http://localhost:8080/abimar/core/swagger-ui.html");
        System.out.println("📄 OpenAPI Docs (JSON): http://localhost:8080/abimar/core/v3/api-docs");
        System.out.println("-----------------------------------------------------");
    }
}
