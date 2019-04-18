package pers.arrayli.service.impl;

import java.sql.SQLException;

import pers.arrayli.dao.CheFeiPriceDao;
import pers.arrayli.dao.impl.CheFeiPriceDaoImpl;
import pers.arrayli.dao.impl.CheFeiPriceDaoImpl;
import pers.arrayli.service.CheFeiService;
import pers.arrayli.service.CheService;

/**
 * @author lzj13
 *	实现车费的业务层接口
 */
public class CheFeiServiceImpl implements CheFeiService {

	@Override
	public int findFare() throws SQLException {
		CheFeiPriceDao dao = new CheFeiPriceDaoImpl();
		return dao.findFare();
	}

}
 