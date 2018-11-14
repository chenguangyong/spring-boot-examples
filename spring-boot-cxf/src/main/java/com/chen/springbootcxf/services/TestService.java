package com.chen.springbootcxf.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * @Auther: chen
 * @Date: 2018/11/13 14:07
 * @Description:webservice测试接口
 */

@WebService(name = "TestService", // 暴露服务名称
        targetNamespace = "http://services.springbootcxf.com"// 命名空间,一般是接口的包名倒序
)
public interface TestService {

    @WebMethod
    @WebResult(name = "String", targetNamespace = "")
    String sendMessage(@WebParam(name = "username") String username);

}
