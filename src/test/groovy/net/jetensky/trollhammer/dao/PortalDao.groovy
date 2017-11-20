package net.jetensky.trollhammer.dao

import net.jetensky.trollhammer.dto.Portal


class PortalDao {

    private HashMap<Long,Portal> portals = new HashMap<>();
    private static long idCounter = 0;


    long save() {
        Portal portal = new Portal(++idCounter);
        portals.put(portal.id,portal);
        return portal.id;
    }

    Portal get(long i) {
        return portals.get(i);
    }
}
