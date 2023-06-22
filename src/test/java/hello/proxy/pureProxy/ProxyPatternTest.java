package hello.proxy.pureProxy;

import hello.proxy.pureProxy.proxy.CacheProxy;
import hello.proxy.pureProxy.proxy.ProxyPatternClient;
import hello.proxy.pureProxy.proxy.RealSubject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProxyPatternTest {

    @Test
    public void noProxy(){
        RealSubject realSubject = new RealSubject();
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(realSubject);
        proxyPatternClient.excute();
        proxyPatternClient.excute();
        proxyPatternClient.excute();

    }

    @Test
    public void cacheProxy(){
        RealSubject realSubject = new RealSubject();
        CacheProxy cacheProxy = new CacheProxy(realSubject);
        ProxyPatternClient proxyPatternClient = new ProxyPatternClient(cacheProxy);
        proxyPatternClient.excute();
        proxyPatternClient.excute();
        proxyPatternClient.excute();
    }

    @Test
    public void proxy2(){

    }
}
