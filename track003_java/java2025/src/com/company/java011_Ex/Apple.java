package com.company.java011_Ex;


class Apple{
	
	
	   private String name;
	   private String order;
	   static int num;
	   static int price;
	   
	   public void show() {
			System.out.println("NAME : " + this.name) ;
			System.out.println("Order : " + this.order);
			System.out.println("Num : " + this.num) ;
			System.out.println("Price : " + this.price);
	   }
	   
	public Apple() {super();}
	
	  public Apple(String name, String order, int num, int price) {
		super();
		this.name = name;
		this.order = order;
		this.num = num;
		this.price = price;
	  }
	  
		@Override
		public String toString() {
			return "Apple [name=" + name + ", order=" + order + ", num=" + num + ", price=" + price + "]";
		}

}


