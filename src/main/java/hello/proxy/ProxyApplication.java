package hello.proxy;

import hello.proxy.app.config.AppV2Config;
import hello.proxy.app.config.v1_proxy.ConcreteProxyConfig;
import hello.proxy.app.config.v1_proxy.InterfaceProxyConfig;
import hello.proxy.app.config.v2_dynamicProxy.DynamicProxyBasicConfig;
import hello.proxy.app.config.v2_dynamicProxy.DynamicProxyFilterConfig;
import hello.proxy.trace.logtrace.LogTrace;
import hello.proxy.trace.logtrace.ThreadLocalLogTrace;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;


//@Import(AppV2Config.class)
//@Import(InterfaceProxyConfig.class)
//@Import(ConcreteProxyConfig.class)
@Import(DynamicProxyFilterConfig.class)
@SpringBootApplication(scanBasePackages = "hello.proxy.app")
public class ProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProxyApplication.class, args);
	}

	@Bean
	public LogTrace logTrace(){
		return new ThreadLocalLogTrace();
	}
}
