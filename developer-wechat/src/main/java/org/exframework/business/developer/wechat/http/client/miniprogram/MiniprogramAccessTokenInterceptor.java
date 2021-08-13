package org.exframework.business.developer.wechat.http.client.miniprogram;

import com.dtflys.forest.exceptions.ForestRuntimeException;
import com.dtflys.forest.http.ForestRequest;
import com.dtflys.forest.http.ForestRequestBody;
import com.dtflys.forest.http.ForestResponse;
import com.dtflys.forest.http.body.NameValueRequestBody;
import com.dtflys.forest.interceptor.Interceptor;
import org.exframework.business.developer.wechat.service.WechatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author rwe
 * @version 创建时间：Sep 21, 2020 11:07:51 AM 增加 AccessToken
 */

@Component
public class MiniprogramAccessTokenInterceptor implements Interceptor<Object> {

    @Autowired
    WechatService wechatService;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean beforeExecute(ForestRequest request) {
        Map<String, Object> data = new ConcurrentHashMap<String, Object>();
        Map<String, Object> queryMap = request.getQuery();
        for (Map.Entry<String, Object> entry : queryMap.entrySet()) {
            data.put(entry.getKey(), entry.getValue());
        }
        List<ForestRequestBody> bodies = request.getBody();
        for (ForestRequestBody body : bodies) {
            if (NameValueRequestBody.class.isAssignableFrom(body.getClass())) {
                NameValueRequestBody nameBody = (NameValueRequestBody) body;
                data.put(nameBody.getName(), nameBody.getValue());
            }
        }
        if (data.containsKey("appid")) {
            String appid = (String) data.get("appid");
            String token = wechatService.getAppToken(appid);
            String message = MessageFormat.format("add token [{0}] for request url: {1}", token, request.getUrl());
            log.debug(message);
            request.addQuery("access_token", token);

        }
        return true;
    }

    @Override
    public void onSuccess(Object data, ForestRequest request, ForestResponse response) {

    }

    @Override
    public void onError(ForestRuntimeException ex, ForestRequest request, ForestResponse response) {

    }

}
