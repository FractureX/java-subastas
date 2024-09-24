package com.sistema.subastas.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistema.subastas.model.Bid;
import com.sistema.subastas.repository.BidRepository;

@Service
public class BidService {

    @Autowired
    private BidRepository bidRepository;

    public Bid saveBid(Bid bid) {
        bid.setTimestamp(LocalDateTime.now());
        return bidRepository.save(bid);
    }
}