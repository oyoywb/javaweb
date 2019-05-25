package of.dao;

import java.util.ArrayList;

import of.entity.Food;

public interface IFoodDao {

	//�����ݿ��в������ɲ�Ʒ����������ʽ����
	public ArrayList<Food> findAllFood();
	
	//ͨ����ѯFname�жϲ�Ʒ�Ƿ����
	public boolean exsitByFname(String fname);

	//ͨ����ѯFid�жϲ�Ʒ�Ƿ����
	public boolean exsitByFid(String fid);
	
	//ͨ��Fname��ѯ��Ʒ�����ظò�Ʒ
	public Food findFoodByFname(String fname);
	
	//ͨ��Fid��ѯ��Ʒ�����ظò�Ʒ
	public Food findFoodByFid(String fid);
	
	//�����ݿ��в������ɲ�Ʒ����������ʽ����
	public ArrayList<Food> findAllDrink();
	
	//�����ݿ��в������ɲ�Ʒ����������ʽ����
	public ArrayList<Food> findAllAppetizer();
	
	
	
}
