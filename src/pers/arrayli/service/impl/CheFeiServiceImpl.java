package pers.arrayli.service.impl;

import java.sql.SQLException;
import java.util.List;

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

	@Override
	public List<CheFei> QueryCheFei(String chepai, String date) throws SQLException {
		CheFeiDao dao = new CheFeiDaoImpl();
		return dao.QueryCheFei(chepai, date);
	}
}
 