package net.jetensky.trollhammer.services

import net.jetensky.trollhammer.Application
import net.jetensky.trollhammer.dao.IPortalJpaRepository
import net.jetensky.trollhammer.dto.Portal
import net.jetensky.trollhammer.services.factory.PortalTestDataFactory
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

    @Autowired PortalTestDataFactory portalTestDataFactory

    @Autowired
    PortalService portalService;


    @Transactional
    def "Hello"() {
        def testTitle = "iDnes"
        given:
        long id = portalTestDataFactory.save(new Portal(title: testTitle))

    when:
        def returnVal = portalService.hello(id)
    then:
        returnVal == "hello " + testTitle


        
    }
}
