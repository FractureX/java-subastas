package com.sistema.subastas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.sistema.subastas.model.Bid;
import com.sistema.subastas.service.BidService;

@Controller
public class BidController {

    @Autowired
    private BidService bidService;

    @PostMapping("/placeBid")
    public String placeBid(Bid bid) {
        bidService.saveBid(bid);
        return "redirect:/auctionList";
    }
}