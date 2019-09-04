package dao;

import model.Song;

public interface BaseDao<T> {
	 int deleteByPrimaryKey(Integer srid);

	 int insert(T record);
		
     int insertSelective(T record);
		
     T selectByPrimaryKey(Integer srid);
		
     int updateByPrimaryKeySelective(T record);
		
     int updateByPrimaryKey(T record);

}
