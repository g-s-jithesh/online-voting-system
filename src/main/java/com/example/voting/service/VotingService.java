package com.example.voting.service;

import com.example.voting.model.Candidate;
import com.example.voting.model.User;
import com.example.voting.repository.CandidateRepository;
import com.example.voting.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VotingService {

    @Autowired
    private CandidateRepository candidateRepository;

    @Autowired
    private UserRepository userRepository;

    public List<Candidate> getAllCandidates() {
        return candidateRepository.findAll();
    }

    public Candidate getCandidateById(Long id) {
        return candidateRepository.findById(id).orElseThrow(() -> new RuntimeException("Candidate not found"));
    }

    public void addCandidate(Candidate candidate) {
        candidateRepository.save(candidate);
    }

    @Transactional
    public void castVote(Long userId, Long candidateId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Candidate candidate = candidateRepository.findById(candidateId)
                .orElseThrow(() -> new RuntimeException("Candidate not found"));

        if (user.isHasVoted()) {
            throw new RuntimeException("User has already voted");
        }

        candidate.setVoteCount(candidate.getVoteCount() + 1);
        user.setHasVoted(true);

        candidateRepository.save(candidate);
        userRepository.save(user);
    }

    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("User not found"));
    }
}
