package com.shunaier.demo.server.controller;

import com.shunaier.demo.biz.model.bean.ComplaintOrder;
import com.shunaier.demo.biz.service.TestService;
import com.shunaier.demo.common.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用途描述
 *
 * @author gsw
 * @version $Id: TestController, v0.1
 * 
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping(value = "test.json")
    public JsonResult<Object> test() {
        ComplaintOrder complaintOrder = testService.getById("3213");
        return JsonResult.success(complaintOrder);
    }

}
