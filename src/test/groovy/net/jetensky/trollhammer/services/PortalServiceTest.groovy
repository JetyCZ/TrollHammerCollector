package net.jetensky.trollhammer.services

import net.jetensky.trollhammer.Application
import net.jetensky.trollhammer.dao.IPortalJpaRepository
import net.jetensky.trollhammer.dto.Portal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification



@SpringBootTest
@ContextConfiguration(classes = Application)
class PortalServiceTest extends Specification {
    @Autowired
    IPortalJpaRepository portalDao;

    @Transactional
    def "Hello"() {
    when;
        PortalService portalService = new PortalService()
        Portal portal= new Portal()
        String title = "iDnes"
        portal.setTitle(title)
        long id = portalDao.save(portal).id
        def returnVal = portalService.hello(id)
        then:
        returnVal == title

        
    }
}
