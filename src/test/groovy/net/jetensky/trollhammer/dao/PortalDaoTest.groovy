package net.jetensky.trollhammer.dao

import net.jetensky.trollhammer.Application
import net.jetensky.trollhammer.dto.Portal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import javax.transaction.Transactional

@SpringBootTest
@ContextConfiguration(classes = Application)
class PortalDaoTest extends Specification {

    @Autowired PortalDao portalDao

    @Transactional
    def "getOne"() {
        def portal = new Portal()
        when:
            portalDao.save(portal)
            def read = portalDao.getOne(portal.getId())

        then:
            read != null
            read.id != null
    }
}
