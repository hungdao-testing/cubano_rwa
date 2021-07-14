package example.service;

import java.io.IOException;

import org.concordion.cubano.template.driver.services.ExampleRestApi;
import org.concordion.cubano.template.framework.CubanoTemplateFixture;

public class RestRequestFixture extends CubanoTemplateFixture {

    public boolean callService() throws IOException {
        return new ExampleRestApi()
                .getIPAddress() != null;
    }
}
