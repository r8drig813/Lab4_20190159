package com.example.lab4_20190159.repository;

import com.example.lab4_20190159.entity.Employees;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employees, Integer> {

    @Query(nativeQuery = true, value = "SELECT * FROM employees where first_name = ?1 or last_name = ?1 ")
    List<Employees> buscarPorNombre(String textoIngreso);


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE employee SET phone_number = ?1 and salary = ?2 WHERE employee = ?3")
    void actualizar(String phone_number, double salary, int employee_id);

}
