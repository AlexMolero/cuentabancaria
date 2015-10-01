package demo;

import demo.Service.CuentaBancariaService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    private static CuentaBancariaService cuentaBancariaService;

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        cuentaBancariaService = context.getBean(CuentaBancariaService.class);
        cuentaBancariaService.testCuentasBancarias();

    }
}
