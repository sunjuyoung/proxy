package hello.proxy.app.v2;


public class OrderRepositoryV2{

    public void save(String itemId) {
        if(itemId.equals("ex")) {
            throw new IllegalArgumentException("DB Exception");
        }
        sleep(1000);
    }

    private void sleep(int mill) {
        try {
            Thread.sleep(mill);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
