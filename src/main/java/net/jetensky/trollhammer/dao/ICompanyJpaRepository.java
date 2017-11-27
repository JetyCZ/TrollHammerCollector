package net.jetensky.trollhammer.dao;

import net.jetensky.trollhammer.dto.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface ICompanyJpaRepository extends JpaRepository<Company, Long> {
}
