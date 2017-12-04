package net.jetensky.trollhammer.services.factory;

import net.jetensky.trollhammer.dao.CompanyDAO;
import net.jetensky.trollhammer.dao.PortalDAO;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import java.lang.reflect.Field;
import java.util.List;

@Component
public class Creator implements ApplicationContextAware {

    Log log = LogFactory.getLog(Creator.class);

    @Autowired
    CompanyDAO companyJpaRepository;

    @Autowired
    PortalDAO portalJpaRepository;

    private ApplicationContext applicationContext;

    public Long save(Object entity) {
        try {
            List<Field> allFields = FieldUtils.getAllFieldsList(entity.getClass());
            for (Field field : allFields) {
                try {
                    Object propValue = FieldUtils.readField(field, entity);
                    Object childEntity = saveChildEntity(field.getType(), propValue);
                    FieldUtils.writeField(field, entity, childEntity);
                } catch (IllegalAccessException e) {
                    log.info("Skipping " + field.getName() + ", as it is probably private");
                }
            }

            // Map props = PropertyUtils.describe(entity);
            /*for (Object propName : props.keySet()) {
                Object propValue = props.get(propName);
                saveChildEntity(props.getClass(), propValue);
            }
*/
            getDao(entity).save(entity);
            return (Long) PropertyUtils.getProperty(entity, "id");
        } catch (Exception e) {
            throw new IllegalStateException("Problem", e);
        }

    }

    private Object saveChildEntity(Class<?> type, Object propValue) throws IllegalAccessException, InstantiationException {
        if (propValue==null) {
            propValue = type.newInstance();
        }
        Class<?> valueClass = propValue.getClass();
        if (valueClass.getDeclaredAnnotationsByType(Entity.class).length>0) {

            save(propValue);
            String className = propValue.getClass().getSimpleName();
            String daoName = className.substring(0,1).toLowerCase() + className.substring(1) + "DAO";

            JpaRepository jpaRepository = applicationContext.getBeansOfType(JpaRepository.class).get(daoName);
            jpaRepository.save(propValue);
        }
        return propValue;

    }

    private JpaRepository getDao(Object entity) {
        String entityClass = entity.getClass().getSimpleName();
        switch (entityClass) {
            case "Portal": return portalJpaRepository;
            case "Company": return companyJpaRepository;
            default: throw new IllegalStateException("No dao for " + entityClass);
        }
    }


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {

        this.applicationContext = applicationContext;
    }
}
