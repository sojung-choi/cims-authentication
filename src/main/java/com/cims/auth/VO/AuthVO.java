package com.cims.auth.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuthVO {

    private String accessKeyID;
    private String secretAccessKey;
    private String host;
    private String regionName;
    private String serviceName;
    private String httpMethodName;
    private String action;
    private String version;

    //private String canonicalURI; //선택값
    //private String payload;//선택값

}
