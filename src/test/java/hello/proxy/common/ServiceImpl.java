package hello.proxy.common;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ServiceImpl implements ServiceInterface{

    @Override
    public void save() {
       log.info("save");
    }

    @Override
    public void find() {
        log.info("find");
    }
}
