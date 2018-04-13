package com.diploma.mysql.dao;

import com.diploma.mysql.model.Urlvo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UrlResitory extends JpaRepository<Urlvo,String> {
}
