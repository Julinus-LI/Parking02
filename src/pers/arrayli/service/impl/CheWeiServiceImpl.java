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

}
 