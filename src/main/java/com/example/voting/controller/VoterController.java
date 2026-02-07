package com.example.voting.controller;

import com.example.voting.model.Candidate;
import com.example.voting.model.User;
import com.example.voting.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/voter")
public class VoterController {

    @Autowired
    private VotingService votingService;

    @GetMapping("/dashboard")
    public String dashboard(Model model, Principal principal) {
        User user = votingService.getUserByUsername(principal.getName());
        List<Candidate> candidates = votingService.getAllCandidates();

        model.addAttribute("user", user);
        model.addAttribute("candidates", candidates);

        return "voter/dashboard";
    }

    @PostMapping("/vote")
    public String vote(@RequestParam Long candidateId, Principal principal, RedirectAttributes redirectAttributes) {
        try {
            User user = votingService.getUserByUsername(principal.getName());
            votingService.castVote(user.getId(), candidateId);
            redirectAttributes.addFlashAttribute("success", "Vote cast successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", e.getMessage());
        }
        return "redirect:/voter/dashboard";
    }
}
