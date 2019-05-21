package pers.arrayli.service.impl;

import java.sql.SQLException;

import pers.arrayli.dao.CheDao;
import pers.arrayli.dao.impl.CheDaoImpl;
import pers.arrayli.domain.Che;
import pers.arrayli.domain.UserInfo;
import pers.arrayli.service.CheService;

/**
 * @author lzj13
 *	实现车的相关操接口，业务层层操作代码
 */
public class CheServiceImpl implements CheService {

	@Override
	public boolean AddChe(Che che) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.AddChe(che);
	}

	@Override
	public Che findByUid(int uid) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.findByUid(uid);
	}

	@Override
	public Che findById(int id) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.findById(id);
	}

	@Override
	public boolean updateCheById(int id, Che che) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.updateCheById(id, che);
	}

	@Override
	public boolean delCheById(int id) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.delCheById(id);
	}

	@Override
	public String getHaoByUid(int uid) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.getHaoByUid(uid);
	}

	@Override
	public int GetUidByHao(String chepai) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.GetUidByHao(chepai);
	}

	@Override
	public String getPicPathById(int id) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.getPicPathById(id);
	}

	@Override
	public boolean UpadteByUid(int uid, Che che) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.UpadteByUid(uid, che);
	}

	@Override
	public Che getCheByChePai(String chepai) throws SQLException {
		CheDao dao = new CheDaoImpl();
		return dao.getCheByChePai(chepai);
	}
}
 