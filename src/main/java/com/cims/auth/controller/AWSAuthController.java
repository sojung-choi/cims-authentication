package com.cims.auth.controller;

import com.cims.auth.VO.AuthVO;
import com.cims.auth.VO.HeaderVO;
import com.cims.auth.awsv4auth.AWSV4Auth;
import org.springframework.web.bind.annotation.*;

import java.util.TreeMap;

@RestController
@RequestMapping("/aws") // localhost:8070/aws
public class AWSAuthController {


    @RequestMapping(method = RequestMethod.GET, path="/getTest")
    public String getRequest(){
        return "test-method";
    }

    // aws 인증 header - 헤더 생성에 필요한 값 전달
    @PostMapping(path="/v4auth")
    public HeaderVO AWSV4Auth(@RequestBody AuthVO authvo) throws Exception {

        TreeMap<String, String> awsHeaders = new TreeMap<String, String>();
        awsHeaders.put("host", authvo.getHost());

        TreeMap<String, String> queryParametes = new TreeMap<String, String>();
        queryParametes.put("Action",authvo.getAction());
        queryParametes.put("Version",authvo.getVersion()) ;


        AWSV4Auth aWSV4Auth = new AWSV4Auth.Builder(authvo.getAccessKeyID(), authvo.getSecretAccessKey())
                .regionName(authvo.getRegionName())
                .serviceName(authvo.getServiceName())
                .httpMethodName(authvo.getHttpMethodName())
                //.canonicalURI("/inventory/simple/123") //end point
                .queryParametes(queryParametes) //query parameters if any
                .awsHeaders(awsHeaders) //aws header parameters
                //.payload(null) // payload if any
                .debug() // turn on the debug mode
                .build();

        return aWSV4Auth.getHeaderVO();
    }

}
