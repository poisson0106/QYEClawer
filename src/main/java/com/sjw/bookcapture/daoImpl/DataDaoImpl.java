package com.sjw.bookcapture.daoImpl;

import java.util.Iterator;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.sjw.bookcapture.dao.DataDao;
import com.sjw.bookcapture.pojo.WeiboPojo;
import com.sjw.bookcapture.pojo.ZhihuPojo;

public class DataDaoImpl extends SqlSessionDaoSupport implements DataDao {

	@Override
	public void insertAllNewWeibo(List<WeiboPojo> toInsertList) throws Exception {
		this.getSqlSession().insert("insertAllNewWeibo", toInsertList);
	}

	@Override
	public void catchZhihuDataDao(List<ZhihuPojo> thisList) throws Exception {
		this.getSqlSession().insert("insertNewData", thisList);

		//Temp method to insert data. It's in a lower efficiency
		/*Iterator<ZhihuPojo> i = thisList.iterator();
		while(i.hasNext()){
			this.getSqlSession().insert("tmp",i.next());
		}*/
	}

}
