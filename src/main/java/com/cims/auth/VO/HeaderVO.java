package com.cims.auth.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HeaderVO {

    //private String host;
    private String x_amz_date;
    private String authorization;

}

