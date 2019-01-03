package com.jibug.cetty;

import com.jibug.cetty.core.Bootstrap;
import com.jibug.cetty.core.Payload;
import com.jibug.cetty.core.handler.ConsoleReduceHandler;
import com.jibug.cetty.handler.KuaidailiPageHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author heyingcai
 */
@Component
public class CettyRunner implements CommandLineRunner{

    @Override
    public void run(String... strings) throws Exception {
        Bootstrap.me().
                startUrl("https://www.kuaidaili.com/free").
                addHandler(new KuaidailiPageHandler()).setThreadNum(1).
                addHandler(new ConsoleReduceHandler()).
                setPayload(Payload.custom()).
                isAsync(true).
                start();
    }
}
