/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.jia.co.ke.main.repository;
import com.jia.co.ke.main.models.Installment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jgithu
 */

public interface InstallmentRepository extends JpaRepository<Installment, Long> {
}

