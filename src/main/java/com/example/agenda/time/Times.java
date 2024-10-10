    package com.example.agenda.time;
    
    import com.example.agenda.admin.Admin;
    import com.example.agenda.client.Client;
    import com.example.agenda.professional.Professional;
    import com.example.agenda.services.Services;
    import jakarta.persistence.*;
    import lombok.*;
    
    import java.time.LocalDateTime;
    
    
    @Table(name="times")
    @Entity(name="times")
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @EqualsAndHashCode(of="id")
    public class Times {
    
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
    
        // Relacionamento com a entidade Admin
        @ManyToOne
        @JoinColumn(name = "admin_id")
        private Admin admin;
    
        // Relacionamento com a entidade Services
        @ManyToOne
        @JoinColumn(name = "service_id")
        private Services service;
    
        // Relacionamento com a entidade Professional
        @ManyToOne
        @JoinColumn(name = "professional_id")
        private Professional professional;
    
        private int days;
        private LocalDateTime start_time;
        private LocalDateTime end_time;
    
        public Times(TimesRequestDTO data, Admin admin, Services service, Professional professional) {
            this.admin = admin;
            this.service = service;
            this.professional = professional;
            this.days = data.days();
            this.start_time = data.start();
            this.end_time = data.end();
        }
    }
