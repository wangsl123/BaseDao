package service;

import dao.BaseDao;

public class BaseServiceImpl<T> implements BaseService<T> {

	protected BaseDao<T> baseDao;
	public int deleteByPrimaryKey(Integer srid) {
		// TODO Auto-generated method stub
		return baseDao.deleteByPrimaryKey(srid);
	}

	public int insert(T record) {
		// TODO Auto-generated method stub
		return baseDao.insert(record);
	}

	public int insertSelective(T record) {
		// TODO Auto-generated method stub
		return baseDao.insertSelective(record);
	}

	public T selectByPrimaryKey(Integer srid) {
		// TODO Auto-generated method stub
		return baseDao.selectByPrimaryKey(srid);
	}

	public int updateByPrimaryKeySelective(T record) {
		// TODO Auto-generated method stub
		return baseDao.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(T record) {
		// TODO Auto-generated method stub
		return baseDao.updateByPrimaryKey(record);
	}

}
