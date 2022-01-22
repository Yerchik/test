package Yerchik.entity;

import javax.persistence.*;

@Entity
@Table
public class Prices {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column
    private double v;
    @ManyToOne
    private CryptoCarrency currency;

    public Prices() {
    }

    public Prices(double v, CryptoCarrency currency) {
        this.v = v;
        this.currency = currency;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getV() {
        return v;
    }

    public void setV(double v) {
        this.v = v;
    }

    public CryptoCarrency getCurrency() {
        return currency;
    }

    public void setCurrency(CryptoCarrency currency) {
        this.currency = currency;
    }
}
