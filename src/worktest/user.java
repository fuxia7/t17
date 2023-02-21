package worktest;

public class user {
	private int id ;
	private String name ;
	private String password ;

	
	public void setUserData(String name, String password) {
		        //这个方法是设计为用一行代码填充实例，一面多行调用set方法显得代码冗长，作用相当于有参构造方法，但是作用会有点区别
		         this.name = name;
		          this.password = password;
		         

		      }
	 public void  user (int id, String name,String password) {
		       
		          this.id = id;
		          this.name = name;
		          this.password = password;
		         
		      }
	


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	@Override
	public String toString() {
		return "Database [id=" + id + ", name=" + name + ", password=" + password + "]";
	}

	

}
