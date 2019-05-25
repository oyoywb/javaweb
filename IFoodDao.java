package of.dao;

import java.util.ArrayList;

import of.entity.Food;

public interface IFoodDao {

	//在数据库中查找所由餐品并以链表形式返回
	public ArrayList<Food> findAllFood();
	
	//通过查询Fname判断餐品是否存在
	public boolean exsitByFname(String fname);

	//通过查询Fid判断餐品是否存在
	public boolean exsitByFid(String fid);
	
	//通过Fname查询餐品并返回该餐品
	public Food findFoodByFname(String fname);
	
	//通过Fid查询餐品并返回该餐品
	public Food findFoodByFid(String fid);
	
	//在数据库中查找所由餐品并以链表形式返回
	public ArrayList<Food> findAllDrink();
	
	//在数据库中查找所由餐品并以链表形式返回
	public ArrayList<Food> findAllAppetizer();
	
	
	
}
