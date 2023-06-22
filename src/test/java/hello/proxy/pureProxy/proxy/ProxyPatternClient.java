package hello.proxy.pureProxy.proxy;

public class ProxyPatternClient {

    private Subject subject;

    public ProxyPatternClient(Subject subject) {
        this.subject = subject;
    }

    public void excute(){
        subject.operation();
    }
}
