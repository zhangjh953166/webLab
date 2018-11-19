package com.example.webLab.controller.server;

import com.example.webLab.constants.OAuth2Constants;
import com.example.webLab.model.AuthClient;
import com.example.webLab.service.IAuthClientService;
import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/server")
public class AuthorizationController {

//    @Autowired
//    private HttpServletRequest request;
//
//    @Autowired
//    private HttpServletResponse response;

    @Autowired
    private IAuthClientService authClientService;

    @RequestMapping("applyAuthorize")
    @ResponseBody
    public Object applyAuthorize(HttpServletRequest request, HttpServletResponse response) throws OAuthProblemException, OAuthSystemException {
        //构建OAuth请求
        OAuthAuthzRequest oAuthzRequest = new OAuthAuthzRequest(request);
        //获取OAuth客户端Id
        String clientId = oAuthzRequest.getClientId();
        //校验客户端Id是否正确
        AuthClient authClient = authClientService.findByClientId(Long.parseLong(clientId));
        if(authClient==null){
            Map map = new HashMap();
            map.put(OAuth2Constants.OAUTH_AUTHORIZE_FAILED_KEY,"无效的客户端Id");
            return map;
        }

        String username = authClient.getClientName();

        //生成授权码
        String authCode = null;
        String responseType = oAuthzRequest.getParam(OAuth.OAUTH_RESPONSE_TYPE);
        //ResponseType仅支持CODE和TOKEN
        if(responseType.equals(ResponseType.CODE.toString())){

        }
        return null;
    }
}
