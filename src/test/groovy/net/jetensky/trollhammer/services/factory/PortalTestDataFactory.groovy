package net.jetensky.trollhammer.services.factory

import net.jetensky.trollhammer.dao.ICompanyJpaRepository
import net.jetensky.trollhammer.dao.IPortalJpaRepository
import net.jetensky.trollhammer.dto.Company
import net.jetensky.trollhammer.dto.Portal
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component


@Component
class PortalTestDataFactory {
    @Autowired
    IPortalJpaRepository portalDao;

    @Autowired
    ICompanyJpaRepository companyJpaRepository;

    long save() {
        Portal portal = new Portal()
        return save(portal)
    }


    long save(Portal portal) {
        def company = new Company()

        if (portal.getTitle()==null) portal.setTitle("iDnes")

        companyJpaRepository.save(company)

        portal.setCompany(company)
        long id = portalDao.save(portal).id
        return id
    }
}
