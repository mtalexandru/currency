package ro.mtalexandru.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by Mau on 8/20/2016.
 */
@Entity
@Table(name="CURRENCY")

public class Currency implements Serializable {

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(unique=true, name ="SHORT_NAME")
    private String shortName;

    @Column(name ="DESCRIPTION")
    private String description;

    @OneToMany(mappedBy = "currency")
    private Set<BankCurrency> bankCurrencies = new HashSet<BankCurrency>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<BankCurrency> getBankCurrencies() {
        return bankCurrencies;
    }

    public void setBankCurrencies(Set<BankCurrency> bankCurrencies) {
        this.bankCurrencies = bankCurrencies;
    }
}
