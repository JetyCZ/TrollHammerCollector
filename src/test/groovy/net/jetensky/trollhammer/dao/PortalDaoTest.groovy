package net.jetensky.trollhammer.dao

import net.jetensky.trollhammer.dto.Portal
import spock.lang.Specification

class PortalDaoTest extends Specification {
    def "saved portal can be read"() {
        when:
        PortalDao portalDao = new PortalDao();
        long id = portalDao.save();
        Portal retVal = portalDao.get(id);
        then:
        retVal != null;
        id == retVal.getId();
    }

}
