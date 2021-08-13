package org.exframework.business.developer.gateway.filter;

import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;

import reactor.core.publisher.Mono;

/**
* @author rwe
* @version 创建时间：2021年4月19日 上午8:56:58
* 类说明
*/

@Component
public class IndexFilter implements WebFilter {
	
  @Override
  public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
    if ("/".equals(exchange.getRequest().getURI().getPath())) {
        return chain.filter(exchange.mutate().request(exchange.getRequest().mutate().path("/developer-center-front/index.html").build()).build());
    }

    return chain.filter(exchange);
  }

}
