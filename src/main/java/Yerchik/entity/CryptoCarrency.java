package Yerchik.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class CryptoCarrency {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id;
    @Column(unique = true)
    private String n;
    @Column
    private double maxV;
    @Column
    private double minV;
    @OneToMany(mappedBy = "currency")
    private List<Prices> listPrices;

    public CryptoCarrency() {
    }

    public CryptoCarrency(String n, double maxV, double minV, List<Prices> listPrices) {
        this.n = n;
        this.maxV = maxV;
        this.minV = minV;
        this.listPrices = listPrices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }

    public double getMaxV() {
        return maxV;
    }

    public void setMaxV(double maxV) {
        this.maxV = maxV;
    }

    public double getMinV() {
        return minV;
    }

    public void setMinV(double minV) {
        this.minV = minV;
    }

    public List<Prices> getListPrices() {
        return listPrices;
    }

    public void setListPrices(List<Prices> listPrices) {
        this.listPrices = listPrices;
    }

    @Override
    public String toString() {
        return "CryptoCarrency{" +
                "id=" + id +
                ", n='" + n + '\'' +
                ", maxV=" + maxV +
                ", minV=" + minV +
                ", listPrices=" + listPrices +
                '}';
    }
}
