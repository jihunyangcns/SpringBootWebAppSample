package com.sz21c.springbootwebappsample.sampleservice.controller;

import com.sz21c.springbootwebappsample.sampleservice.service.SampleHttpService;
import com.sz21c.springbootwebappsample.sampleservice.service.SampleRdbService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SampleController {

    final static Logger LOG = LoggerFactory.getLogger(SampleController.class);

    @Autowired
    private SampleRdbService sampleRdbService;

    @Autowired
    private SampleHttpService sampleHttpService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getHome(HttpServletRequest request) throws Exception {
        String selectedDbName = sampleRdbService.getSqlTest();
        String selectedDbNameUsingInterface = sampleRdbService.getSqlTestUsingInterface();
        String httpResponse = sampleHttpService.getHttpResponse();

        request.setAttribute("h1str", "Hello World!!! via controller");
        request.setAttribute("selectedDbName", selectedDbName);
        request.setAttribute("selectedDbNameUsingInterface", selectedDbNameUsingInterface);
        request.setAttribute("httpResponse", httpResponse);

        return new ModelAndView("home");
    }
}
