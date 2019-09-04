package service;

public interface BaseService<T> {
	
	int deleteByPrimaryKey(Integer srid);

	int insert(T record);
		
    int insertSelective(T record);
		
    T selectByPrimaryKey(Integer srid);
		
    int updateByPrimaryKeySelective(T record);
		
    int updateByPrimaryKey(T record);

}
