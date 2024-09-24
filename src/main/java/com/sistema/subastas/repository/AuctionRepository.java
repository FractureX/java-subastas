package com.sistema.subastas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.subastas.model.Auction;

public interface AuctionRepository extends JpaRepository<Auction, Long> {
    List<Auction> findByIsActiveTrue();
}