package com.twoTableManipulation.workingSets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TwoTableService {
	@Autowired
	private TwoTableDao twoTableDao;

	public void saveForm(TwoTableEntity twoTableEntity) {
		// TODO Auto-generated method stub
		//twoTableDao.saveForm(twoTableEntity);
		
	}

}
