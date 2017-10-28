package net.jetensky.trollhammer.dao;

import net.jetensky.trollhammer.dto.Portal;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class PortalDao {

    long id=0;
    Map<Long, Portal> db = new HashMap<>();

    public Portal get(Long id) {
        return db.get(id);
    };

    public void save(Portal portal) {
        portal.setId(id);
        db.put(id, portal);
        id++;
    }
}
