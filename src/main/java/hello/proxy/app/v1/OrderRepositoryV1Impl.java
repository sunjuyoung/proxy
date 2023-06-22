package hello.proxy.app.v1;

public class OrderRepositoryV1Impl implements OrderRepositoryV1{


    @Override
    public void save(String itemId) {
        System.out.println("Repository Saving item: " + itemId);
    }


}
