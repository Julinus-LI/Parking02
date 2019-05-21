package pers.arrayli.service.impl;

import java.sql.SQLException;
import java.util.List;

import pers.arrayli.dao.CheFeiPriceDao;
import pers.arrayli.dao.impl.CheFeiPriceDaoImpl;
import pers.arrayli.domain.CheFeiPrice;
import pers.arrayli.dao.impl.CheFeiPriceDaoImpl;
import pers.arrayli.service.CheFeiPriceService;
import pers.arrayli.service.CheService;

/**
 * @author lzj13
 *	实现车费的业务层接口
 */
public class CheFeiPriceServiceImpl implements CheFeiPriceService {

	@Override
	public List<CheFeiPrice> findFare() throws SQLException {
		CheFeiPriceDao dao = new CheFeiPriceDaoImpl();
		return dao.findFare();
	}

	@Override
	public boolean setFare(int id, CheFeiPrice price) throws SQLException {
		CheFeiPriceDao dao = new CheFeiPriceDaoImpl();
		return dao.setFare(id, price);
	}

	@Override
	public CheFeiPrice QueryFare() throws SQLException {
		CheFeiPriceDao dao = new CheFeiPriceDaoImpl();
		return dao.QueryFare();
	}

	@Override
	public CheFeiPrice findFare(String type) throws SQLException {
		CheFeiPriceDao dao = new CheFeiPriceDaoImpl();
		return dao.findFare(type);
	}

}
 