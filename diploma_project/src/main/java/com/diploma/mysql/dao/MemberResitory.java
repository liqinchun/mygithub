package com.diploma.mysql.dao;

import com.diploma.mysql.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberResitory extends JpaRepository<Member,String> {
}
