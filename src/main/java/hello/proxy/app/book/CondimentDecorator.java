package hello.proxy.app.book;

public abstract class CondimentDecorator extends Beverage{

    Beverage beverage;

    public abstract String  getDesc();
}
