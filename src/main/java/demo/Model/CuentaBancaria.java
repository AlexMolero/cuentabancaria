package demo.Model;

import javax.persistence.*;

/**
 * Created by jhipster on 1/10/15.
 */
@Entity
public class CuentaBancaria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String titular;

    private Double saldo;

    private String numeroCuenta;

    private Double tipoInteres;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public Double getTipoInteres() {
        return tipoInteres;
    }

    public void setTipoInteres(Double tipoInteres) {
        this.tipoInteres = tipoInteres;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "id=" + id +
                ", titular='" + titular + '\'' +
                ", saldo=" + saldo +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", tipoInteres=" + tipoInteres +
                '}';
    }
}
