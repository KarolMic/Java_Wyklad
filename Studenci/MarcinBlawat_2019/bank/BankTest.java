package bank;

import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import org.junit.jupiter.api.Test;

/*
 * System bankowy pozwala na zlecenie operacji bankowych na rachunku klienta. Do takich operacji nale��:
 * --OK--wp�ata �rodk�w na konto
 * --OK--wyp�ata �rodk�w z konta
 * --OK--wykonanie przelewu z konta na konto
 * --OK--Ka�da taka operacja jest odk�adana w historii rachunku bankowego b�d� rachunk�w 
 * (je�eli jest to przelew z konta na konto). 
 * --OK--Klient banku mo�e przegl�da� histori� swojego konta z wybranego okresu czasu. 
 * Zaprojektuj zestaw klas, kt�re b�d� modelowa�y zachowanie historii konta bankowego oraz napisz logik�, 
 * dzi�ki kt�rej b�dzie mo�na wybra� logi historii z dowolnego przedzia�u czasowego.
 */

class BankTest {

	@Test
	void testAccountPut() {
		Account account = new Account(new Client("Marcin", "Blawat"), "9021-2104");
		account.put(100.0d);
		assertEquals(100.0d, account.balance());
	}
	
	@Test
	void testAccountWithdraw() {
		Account account = new Account(new Client("Marcin", "Blawat"), "9021-2104");
		account.withdraw(100.0d);
		assertEquals(-100.0d, account.balance());
	}
	
	@Test
	void testBankTransfer() {
		Bank bank = new Bank();
		bank.addAccount(new Account(new Client("Marcin", "Blawat"), "1023-5698"));
		bank.addAccount(new Account(new Client("Jan", "Kowalski"), "1042-6420"));
		bank.transfer("1023-5698", "1042-6420", 100.0d);
		assertTrue((bank.account("1023-5698").balance() == -100.0d) && (bank.account("1042-6420").balance() == 100.0d));
	}
	
	@Test
	void testAccountNotify() {
		Bank bank = new Bank();
		bank.addAccount(new Account(new Client("Marcin", "Blawat"), "1023-5698", new TransactionLogger()));
		bank.addAccount(new Account(new Client("Jan", "Kowalski"), "1042-6420", new TransactionLogger()));
		bank.transfer("1023-5698", "1042-6420", 100.0d);
		assertTrue((bank.account("1023-5698").logger().lastLog().isEqual(new Log("1023-5698", 100.0d, "1042-6420"))));
		assertTrue((bank.account("1042-6420").logger().lastLog().isEqual(new Log("1023-5698", 100.0d, "1042-6420"))));
	}
	@Test
	void testAccountLogs()
	{
		Bank bank = new Bank();
		bank.addAccount(new Account(new Client("Marcin", "Blawat"), "1023-5698", new TransactionLogger()));
		bank.addAccount(new Account(new Client("Jan", "Kowalski"), "1042-6420", new TransactionLogger()));
		bank.transfer("1023-5698", "1042-6420", 100.0d);
		bank.transfer("1042-6420", "1023-5698", 50.0d);
		bank.transfer("1042-6420", "1023-5698", 15.0d);
		
		assertTrue(bank.account("1023-5698").logger().
				logs(LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth()),
						LocalDate.of(LocalDate.now().getYear(), LocalDate.now().getMonth(), LocalDate.now().getDayOfMonth())).
							size() == 3);
	}

}
