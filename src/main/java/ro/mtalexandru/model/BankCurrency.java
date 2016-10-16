package ro.mtalexandru.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by Mau on 8/20/2016.
 */
@Entity
@Table(name="BANK_CURRENCY")
@NamedQueries({
//        @NamedQuery(name=BankCurrency.GET_ALL_CURRENCIES, query="Select new ro.mtalexandru.model.GoalReport(g.minutes, e.minutes, e.activity) " +
//                "from Goal g, Exercise e where g.id = e.goal.id"),
        @NamedQuery(name=BankCurrency.GET_ALL_CURRENCIES, query="Select bc from BankCurrency bc")

})
public class BankCurrency implements Serializable {

//    public static final String FIND_ALL_GOALS = "findAllGoals";
    public static final String GET_ALL_CURRENCIES = "getAllCurrencies";

    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    @Column(name="BANK_BUYS_VALUE")
    private Double bankBuysValue;

    @NotNull
    @Column(name="BANK_SELLS_VALUE")
    private Double bankSellsValue;

    @NotNull
    @Column(name="CURRENCY_DATE")
    private Date currencyDate;

    @NotNull
    @Column(name="CREATION_DATE")
    private Date creationDate;

    @Column(name="UPDATE_DATE")
    private Date updateDate;

    @NotNull
    @Column(name="DELETED", columnDefinition = "BIT", length = 1)//columnDefinition = "TINYINT")
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "BANK_ID")
    private Bank bank;

    @ManyToOne
    @JoinColumn(name = "CURRENCY_ID")
    private Currency currency;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getBankBuysValue() {
        return bankBuysValue;
    }

    public void setBankBuysValue(Double bankBuysValue) {
        this.bankBuysValue = bankBuysValue;
    }

    public Double getBankSellsValue() {
        return bankSellsValue;
    }

    public void setBankSellsValue(Double bankSellsValue) {
        this.bankSellsValue = bankSellsValue;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getCurrencyDate() {
        return currencyDate;
    }

    public void setCurrencyDate(Date currencyDate) {
        this.currencyDate = currencyDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date update_date) {
        this.updateDate = update_date;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }
}
