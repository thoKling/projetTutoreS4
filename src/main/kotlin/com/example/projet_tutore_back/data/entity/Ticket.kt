package com.example.projet_tutore_back.data.entity

import org.hibernate.annotations.CreationTimestamp
import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Ticket (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var ticketId: Long?,

    var seen: Boolean,

    // Open, closed
    var status: Long,

    var title: String,

    var demand: String,

    var senderId: String,

    @CreationTimestamp
    var datetimeOpen: Date?
)
