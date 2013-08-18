/**
 * 
 */
package com.jeetemplates.javaee.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;

import com.jeetemplates.javaee.service.HelloWorldService;
import com.jeetemplates.javaee.service.dto.HelloWorldDTO;
import com.jeetemplates.javaee.util.LoggerUtils;

/**
 * Implementation of {@link HelloWorldService}
 * 
 * @author jeetemplates
 */
@Singleton
public class HelloWorldServiceImpl implements HelloWorldService {

    /* ************************************ */
    /* Dependencies */
    /* ************************************ */

    /**
     * {@link HelloWorldDao}
     */
    // @Inject
    // private HelloWorldDao helloWorldDao;

    private List<HelloWorldDTO> listHellos = new ArrayList<HelloWorldDTO>();

    /* ************************************ */
    /* Methods */
    /* ************************************ */

     @Override
    // @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void create(HelloWorldDTO dto) {
        LoggerUtils.logStartMethod("create");
        // helloWorldDao.create(entity);
        listHellos.add(dto);
        LoggerUtils.logEndMethod("create");
    }

    @Override
    public List<HelloWorldDTO> retrieveAll() {
        LoggerUtils.logStartMethod("retrieveAll");
        // List<HelloWorld> listEntities = helloWorldDao.retrieveAll();
        // List<HelloWorldDTO> returnValue = (List<HelloWorldDTO>)
        // MapperUtils.mapAsList(listEntities, HelloWorldDTO.class);
        LoggerUtils.logEndMethod("retrieveAll");
        return listHellos;
    }

}
