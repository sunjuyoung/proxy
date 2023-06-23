package hello.proxy.app.book;

public class Mocha extends CondimentDecorator{


    public Mocha(Beverage beverage) {
        beverage = beverage;
    }

    @Override
    public double cost() {
        return 0;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
