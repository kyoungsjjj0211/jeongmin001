package spring003_di;

import lombok.Data;
import lombok.Getter;

@Data   
public class IceCreamShop {
    private String   name;
    private IceCream iceCream;
    
    public void open() {
       System.out.print("아이스크림 가게 오픈! 오늘의 맛은: ");
       iceCream.taste();
    }

    
	@Override
	public String toString() {
		return "IceCreamShop [name=" + name + ", iceCream=" + iceCream + "]";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public IceCream getIceCream() {
		return iceCream;
	}


	public void setIceCream(IceCream iceCream) {
		this.iceCream = iceCream;
	}

 
 
   
}   