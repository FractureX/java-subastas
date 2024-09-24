package com.sistema.subastas.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.subastas.model.Auction;
import com.sistema.subastas.repository.AuctionRepository;

@Service
public class AuctionService {

    @Autowired
    private AuctionRepository auctionRepository;

    public Auction saveAuction(Auction auction) {
        if (auction.getStartTime().isBefore(LocalDateTime.now())) {
            auction.setActive(true);
        } else {
            auction.setActive(false);
        }
        return auctionRepository.save(auction);
    }

    public List<Auction> findActiveAuctions() {
        return auctionRepository.findByIsActiveTrue();
    }
}