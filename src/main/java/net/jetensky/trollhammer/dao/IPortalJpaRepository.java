package net.jetensky.trollhammer.dao;

import net.jetensky.trollhammer.dto.Portal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface IPortalJpaRepository extends JpaRepository<Portal, Long> {
}
