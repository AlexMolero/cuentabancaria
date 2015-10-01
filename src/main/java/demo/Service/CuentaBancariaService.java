package demo.Service;

import demo.Model.CuentaBancaria;
import demo.Repository.CuentaBancariaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;

/**
 * Created by jhipster on 1/10/15.
 */
@Service
@Transactional

public class CuentaBancariaService {

    @Autowired
    private CuentaBancariaRepository cuentaBancariaRepository;

    public void ingreso(Long idCuentaBancaria, Double cantidad){
        CuentaBancaria cuentaBancaria = cuentaBancariaRepository.findOne(idCuentaBancaria);
        cuentaBancaria.setSaldo(cuentaBancaria.getSaldo()+cantidad);
        cuentaBancariaRepository.save(cuentaBancaria);
    }

    public void reintegro(Long idCuentaBancaria, Double cantidad){
        CuentaBancaria cuentaBancaria = cuentaBancariaRepository.findOne(idCuentaBancaria);
        cuentaBancaria.setSaldo(cuentaBancaria.getSaldo()-cantidad);
        cuentaBancariaRepository.save(cuentaBancaria);
    }

    public void traspaso(Long idCuentaBancariaOrigen, Long idCuentaBancariaDestino, Double cantidad){
        CuentaBancaria cuentaBancariaOrigen = cuentaBancariaRepository.findOne(idCuentaBancariaOrigen);
        CuentaBancaria cuentaBancariaDestino = cuentaBancariaRepository.findOne(idCuentaBancariaDestino);
        cuentaBancariaOrigen.setSaldo(cuentaBancariaOrigen.getSaldo()-cantidad);
        cuentaBancariaDestino.setSaldo(cuentaBancariaDestino.getSaldo()+cantidad);
        cuentaBancariaRepository.save(cuentaBancariaOrigen);
        cuentaBancariaRepository.save(cuentaBancariaDestino);
    }

    public void testCuentasBancarias(){

        CuentaBancaria cuentaBancaria1 = new CuentaBancaria();
        cuentaBancaria1.setNumeroCuenta("123456");
        cuentaBancaria1.setSaldo(100.0);
        cuentaBancaria1.setTitular("Andreu");
        cuentaBancaria1.setTipoInteres(3.0);
        cuentaBancariaRepository.save(cuentaBancaria1);

        CuentaBancaria cuentaBancaria2 = new CuentaBancaria();
        cuentaBancaria2.setNumeroCuenta("654321");
        cuentaBancaria2.setSaldo(900.0);
        cuentaBancaria2.setTitular("Pepe");
        cuentaBancaria2.setTipoInteres(9.0);
        cuentaBancariaRepository.save(cuentaBancaria2);

        System.out.println("cuentaBancaria1 " + cuentaBancaria1);
        System.out.println("cuentaBancaria2 " + cuentaBancaria2);

        this.traspaso(cuentaBancaria1.getId(), cuentaBancaria2.getId(), 20.0);

        System.out.println("cuentaBancaria1 " + cuentaBancaria1);
        System.out.println("cuentaBancaria2 " + cuentaBancaria2);
    }

}





































