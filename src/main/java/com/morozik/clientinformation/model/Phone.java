package com.morozik.clientinformation.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import static jakarta.persistence.FetchType.LAZY;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(schema = "public", name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(name = "value", nullable = false)
    private String value;

    @JoinColumn(name = "client_id")
    @ManyToOne(fetch = LAZY)
    private Client client;
}
