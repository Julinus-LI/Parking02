package pers.arrayli.dao;

import java.sql.SQLException;
import java.util.List;

import pers.arrayli.domain.CheWei;

/**
 * @author lzj13
 *	定义车位数据访问层接口
 */
public interface CheWeiDao {

	/**	按车位号查找或者按区域查找，或者按两者条件一起查找
	 * @param hao
	 * @param quyu
	 * @return
	 * @throws SQLException
	 */
	List<CheWei> QueryCheWei(String hao,String quyu) throws SQLException;
}
 