package net.jetensky.trollhammer.dao

import net.jetensky.trollhammer.Application
import net.jetensky.trollhammer.dto.Portal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(classes = Application)
class PortalDaoTest extends Specification {

    @Autowired
    PortalDAO portalDao;

    @Transactional
    def "saved portal can be read"() {
        when:
        Portal portal = new Portal();

        long id = portalDao.save(portal).id
        Portal retVal = portalDao.getOne(id)
        then:
        retVal != null;
        id == retVal.getId();
    }

}
