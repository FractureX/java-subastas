package com.sistema.subastas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.subastas.model.Auction;
import com.sistema.subastas.service.AuctionService;

@Controller
public class AuctionController {

    @Autowired
    private AuctionService auctionService;

    @GetMapping("/createAuction")
    public String showAuctionForm() {
        return "createAuction";
    }

    @PostMapping("/createAuction")
    public String createAuction(Auction auction) {
        if (auction.getTitle() != null && auction.getStartTime() != null) {
            auctionService.saveAuction(auction);
        }
        return "redirect:/auctionList";
    }

    @GetMapping("/auctionList")
    public String listAuctions(Model model) {
        model.addAttribute("auctions", auctionService.findActiveAuctions());
        return "auctionList";
    }
}