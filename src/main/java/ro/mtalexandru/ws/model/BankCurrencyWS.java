package ro.mtalexandru.ws.model;

import ro.mtalexandru.model.Bank;
import ro.mtalexandru.model.Currency;

import java.util.Date;

/**
 * Created by Mau on 8/20/2016.
 */
public class BankCurrencyWS{

//	public BankCurrencyWS(Long id, Double bankBuysValue, Double bankSellsValue, Date currencyDate, Date creationDate, Date updateDate, boolean deleted, Bank bank, Currency currency){
//		this.id = id;
//		this.bankBuysValue = bankBuysValue;
//		this.bankSellsValue = bankSellsValue;
//		this.currencyDate = currencyDate;
//		this.creationDate = creationDate;
//		this.updateDate = updateDate;
//		this.deleted = deleted;
//		this.bank = bank;
//		this.currency = currency;
//	}

	public BankCurrencyWS(){
	}
	public BankCurrencyWS(Long id, Double bankBuysValue, Double bankSellsValue){
		this.id = id;
		this.bankBuysValue = bankBuysValue;
		this.bankSellsValue = bankSellsValue;
	}

//	public BankCurrencyWS(BankCurrency bankCurrency){
//		this.id = bankCurrency.getId();
//		this.bankBuysValue = bankCurrency.getBankBuysValue();
//		this.bankSellsValue = bankCurrency.getBankSellsValue();
//		this.currencyDate = bankCurrency.getCurrencyDate();
//		this.creationDate = bankCurrency.getCreationDate();
//		this.updateDate = bankCurrency.getUpdateDate();
//		this.deleted = bankCurrency.isDeleted();
//		this.bank = bankCurrency.getBank();
//		this.currency = bankCurrency.getCurrency();
//	}

    private Long id;

    private Double bankBuysValue;

    private Double bankSellsValue;

    private Date currencyDate;

    private Date creationDate;

    private Date updateDate;

    private boolean deleted;

    private Bank bank;

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

	public Date getCurrencyDate() {
		return currencyDate;
	}

	public void setCurrencyDate(Date currencyDate) {
		this.currencyDate = currencyDate;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
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

	@Override
	public String toString() {
		return "BankCurrency{" +
				"id=" + id +
				", bankBuysValue=" + bankBuysValue +
				", bankSellsValue=" + bankSellsValue +
				", currencyDate=" + currencyDate +
				", creationDate=" + creationDate +
				", updateDate=" + updateDate +
				", deleted=" + deleted +
				", bank=" + bank +
				", currency=" + currency +
				'}';
	}
}
