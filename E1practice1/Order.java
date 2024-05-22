package pkg;

public class Order {//資料表 Order
//field欄位,1份訂單Order打從一開始就該有的東西
	private String name;
	private int num_item1;
	private int num_item2;
	private int num_item3;
	private double sum;
//constructor,【new Order】時(一定要先做的事)➡️Order bill=new Order(給必要的東西)
	public Order(String name, int num_item1, int num_item2, int num_item3) {
		super();
		this.name = name;
		this.num_item1 = num_item1;
		this.num_item2 = num_item2;
		this.num_item3 = num_item3;
		this.sum = num_item1*50+num_item2*250+num_item3*800;
	}
//method的getter/setter,請 bill.給Xxxx/請 bill.設Xxxx
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum_Item1() {
		return num_item1;
	}
	public void setNum_Item1(int num_item1) {
		this.num_item1 = num_item1;
	}
	public int getNum_item2() {
		return num_item2;
	}
	public void setNum_item2(int num_item2) {
		this.num_item3 = num_item2;
	}
	public int getNum_item3() {
		return num_item3;
	}
	public void setNum_item3(int num_item3) {
		this.num_item3 = num_item3;
	}
	public double getSum() {
		return sum;
	}
//method的其他動作,請 bill.做動作(給需要的東西)
		String show() {
			return "顧客姓名 : "+name+
					"\n\n    單點炸雞 * "+num_item1+" : \t"+num_item1*50+
					"\n+)炸雞套餐 * "+num_item2+" : \t"+num_item2*250+
					"\n+)炸雞全家餐 * "+num_item3+" : "+num_item3*800+
					"\n\n=原價 : "+sum;
		}
}
