package net.jetensky.trollhammer.services

import net.jetensky.trollhammer.Application
import net.jetensky.trollhammer.dto.Portal
import net.jetensky.trollhammer.services.factory.Creator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest
@ContextConfiguration(classes = Application)
class PortalServiceWithCreatorTest extends Specification {

    @Autowired Creator creator
    @Autowired PortalService portalService

    @Transactional
    def "Hello"() {
        def testTitle = "iDnes"
        given:
        long id = creator.save(
                new Portal(title: testTitle)
        )

        when:
        def returnVal = portalService.hello(id)
        def portal = portalService.portalDao.getOne(id)

        then:
        returnVal == "hello " + testTitle
        portal.title == testTitle



    }

}
