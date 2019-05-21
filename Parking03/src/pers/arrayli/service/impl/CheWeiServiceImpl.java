package pers.arrayli.service.impl;

import java.sql.SQLException;
import java.util.List;

import pers.arrayli.dao.CheWeiDao;
import pers.arrayli.dao.impl.CheWeiDaoImpl;
import pers.arrayli.domain.CheWei;
import pers.arrayli.service.CheWeiService;

/**
 * @author lzj13
 *	实现车位信息的接口
 */
public class CheWeiServiceImpl implements CheWeiService {

	@Override
	public List<CheWei> QueryCheWei(String hao, String quyu) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.QueryCheWei(hao,quyu);
	}

	@Override
	public boolean isReverse(String hao) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.isReverse(hao);
	}

	@Override
	public boolean updateCheWei(String hao, String adate, int id) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.updateCheWei(hao, adate, id);
	}

	@Override
	public CheWei findCheWeiById(int id) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.findCheWeiById(id);
	}

	@Override
	public boolean updateCheWeiById(int id, CheWei cheWei) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.updateCheWeiById(id, cheWei);
	}

	@Override
	public boolean DelCheWeiById(int id) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.DelCheWeiById(id);
	}

	@Override
	public boolean AddCheWei(CheWei cheWei) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.AddCheWei(cheWei);
	}

	@Override
	public int GetUserMoney(String chepai) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.GetUserMoney(chepai);
	}

	@Override
	public boolean updateCheWeiByChepai(String chepai) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.updateCheWeiByChepai(chepai);
	}

	@Override
	public boolean isExistById(int id) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.isExistById(id);
	}

	@Override
	public boolean AddCheWeiByExcel(CheWei cheWei) throws SQLException {
		CheWeiDao dao = new CheWeiDaoImpl();
		return dao.AddCheWeiByExcel(cheWei);
	}

}
 