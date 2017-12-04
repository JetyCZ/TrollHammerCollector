package net.jetensky.trollhammer.services;

import net.jetensky.trollhammer.dao.PortalDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortalService {

    @Autowired
    private PortalDAO portalDao;

    public String hello (Long portalId) {
        return "hello " + portalDao.getOne(portalId).getTitle();
    }
}
