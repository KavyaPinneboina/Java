package object_ops;


class en_caps{
	private int balance;
	public void setBalance(int newBalance)
	{
		this.balance = this.balance +newBalance;
	}
	public int getBalance()
	{
		return this.balance;
	}
	
}
public class encaps {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		en_caps en = new en_caps();
		en.setBalance(1000);
		int balance = en.getBalance();
		System.out.println(balance);
	}

}
