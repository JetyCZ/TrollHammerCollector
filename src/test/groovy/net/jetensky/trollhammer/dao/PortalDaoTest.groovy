package net.jetensky.trollhammer.dao

import net.jetensky.trollhammer.dto.Portal
import spock.lang.Specification


class PortalDaoTest extends Specification {

    PortalDao portalDao = new PortalDao()

    def "Get"() {
        def portal = new Portal()
        when:
            portalDao.save(portal)
            def read = portalDao.get(portal.getId())

        then:
            read != null
            read.id != null
    }
}
