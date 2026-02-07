package com.example.voting.controller;

import com.example.voting.model.Candidate;
import com.example.voting.service.VotingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private VotingService votingService;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        List<Candidate> candidates = votingService.getAllCandidates();
        model.addAttribute("candidates", candidates);
        return "admin/dashboard";
    }

    @PostMapping("/add-candidate")
    public String addCandidate(@ModelAttribute Candidate candidate) {
        votingService.addCandidate(candidate);
        return "redirect:/admin/dashboard";
    }
}
