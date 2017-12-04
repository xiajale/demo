package com.huawei.cloud.controller;

import com.huawei.cloud.metadata.IDPMetadataFact;
import com.huawei.cloud.util.FileUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhouyibin on 2017/12/5.
 */
@RestController
public class MetadataController {

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String sayHello(){
        return "hello world";
    }

    @RequestMapping(value = "/idp-metadata", method = RequestMethod.GET, produces = "application/xml")
    public String getIDPMetadata(){
        String path = IDPMetadataFact.class.getClassLoader().getResource("idp-metadata.xml").getPath();
        return FileUtil.readFile(path);
    }

}
