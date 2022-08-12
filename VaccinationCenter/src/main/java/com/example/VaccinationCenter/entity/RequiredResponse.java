package com.example.VaccinationCenter.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class RequiredResponse {
 private VaccinationCenter center;
 private List<Citizen> citizens;

}
