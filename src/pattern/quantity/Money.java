package pattern.quantity;

import java.math.BigInteger;
import java.util.Currency;

public class Money {
	
	BigInteger amount;
	Currency currency;
	
	public double amount() {
		return amount.doubleValue() / 100;
	}
	public Currency currency() {
		return currency;
	}
	
	public Money(double amount, Currency currency) {
		this.amount = BigInteger.valueOf(Math.round(amount * 100));
		this.currency = currency;
	}
	
	public Money(long amount, Currency currency) {
		this.amount = BigInteger.valueOf(amount * 100);
		this.currency = currency;
	}
	
	//If you use one currency a lot, then have this method
	public static Money dollars(double amount) {
		return new Money(amount, Currency.getInstance("USD"));
	}
	
	public Money add(Money arg) {
		assertSameCurrency(arg);
		return new Money(this.amount.add(arg.amount), currency, true);
	}
	
	public Money subtract(Money arg) {
		return this.add(arg.negate());
	}
	
	private Money negate() {
		return new Money(this.amount.negate(), this.currency, true);
	}
	
	public Money multiply(double arg) {
		return new Money(amount() * arg, this.currency);
	}
	
	public Money[] divide(int denominator) {
		BigInteger bigDenominator = BigInteger.valueOf(denominator);
		Money[] result = new Money[denominator];
		BigInteger simpleResult = amount.divide(bigDenominator);
		for (int i = 0; i < denominator ; i++) {
			result[i] = new Money(simpleResult, currency, true);
		}
		int remainder = amount.subtract(simpleResult.multiply(bigDenominator)).intValue();
		for (int i=0; i < remainder; i++) {
			result[i] = result[i].add(new Money(BigInteger.valueOf(1), currency, true));
		}
		return result;
  	}
	
	private void assertSameCurrency(Money arg) {
		assert this.currency.equals(arg);
	}
	
	private Money(BigInteger amountInPennies, Currency currency, boolean privacyMaker) {
		assert amountInPennies != null : "amountInPennies can not be null";
		assert currency != null : "currency can not be null";
		this.amount = amountInPennies;
		this.currency = currency;
	}
	
	public boolean greaterThan(Money arg) {
		return (this.compareTo(arg) == 1);
	}
	
	public boolean lessThan(Money arg) {
		return (this.compareTo(arg) == -1);
	}
	
	public int compareTo (Object arg) {
		Money moneyArg = (Money) arg;
		assertSameCurrency(moneyArg);
		return amount.compareTo(moneyArg.amount);
	}

	public boolean equals(Object arg) {
		if (!(arg instanceof Money)) 
			return false;
		Money other = (Money) arg;
		return (currency.equals(other.currency) && (amount.equals(other.amount)));
	}
	
	public int hashcode() {
		return amount.hashCode();
	}
}
