package pers.arrayli.service.impl;

import java.sql.SQLException;

import pers.arrayli.dao.CheFeiDao;
import pers.arrayli.dao.impl.CheFeiDaoImpl;
import pers.arrayli.domain.CheFei;
import pers.arrayli.service.CheFeiService;

public class CheFeiServiceImpl implements CheFeiService{

	@Override
	public boolean AddCheFei(CheFei cheFei) throws SQLException {
		CheFeiDao dao = new CheFeiDaoImpl();
		return dao.AddCheFei(cheFei);
	}
}
 