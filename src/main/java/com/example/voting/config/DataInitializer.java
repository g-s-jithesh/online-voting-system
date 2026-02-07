package com.example.voting.config;

import com.example.voting.model.Candidate;
import com.example.voting.model.User;
import com.example.voting.repository.CandidateRepository;
import com.example.voting.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initData(UserRepository userRepository, CandidateRepository candidateRepository,
            PasswordEncoder passwordEncoder) {
        return args -> {
            // Create Admin
            if (userRepository.findByUsername("admin").isEmpty()) {
                User admin = new User();
                admin.setUsername("admin");
                admin.setPassword(passwordEncoder.encode("admin123"));
                admin.setRole("ADMIN");
                userRepository.save(admin);
            }

            // Create Voter
            if (userRepository.findByUsername("voter").isEmpty()) {
                User voter = new User();
                voter.setUsername("voter");
                voter.setPassword(passwordEncoder.encode("voter123"));
                voter.setRole("VOTER");
                userRepository.save(voter);
            }

            // Create Candidates
            if (candidateRepository.count() == 0) {
                Candidate c1 = new Candidate();
                c1.setName("Alice Johnson");
                c1.setParty("Future Party");
                c1.setBio("Dedicated to verifying the future.");
                c1.setImageUrl("https://placehold.co/400x300");
                candidateRepository.save(c1);

                Candidate c2 = new Candidate();
                c2.setName("Bob Smith");
                c2.setParty("Tech Union");
                c2.setBio("Building better infrastructure.");
                c2.setImageUrl("https://placehold.co/400x300");
                candidateRepository.save(c2);
            }
        };
    }
}
