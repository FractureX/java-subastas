package com.sistema.subastas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sistema.subastas.model.Bid;

public interface BidRepository extends JpaRepository<Bid, Long> {
}