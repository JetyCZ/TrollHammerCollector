package net.jetensky.trollhammer.dao;

import net.jetensky.trollhammer.dto.Portal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface PortalDao extends JpaRepository<Portal, Long> {

    /*long id=0;
    Map<Long, Portal> db = new HashMap<>();

    public Portal get(Long id) {
        return db.get(id);
    };

    public void save(Portal portal) {
        portal.setId(id);
        db.put(id, portal);
        id++;
    }*/
}
