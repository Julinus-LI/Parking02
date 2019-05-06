package pers.arrayli.dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import pers.arrayli.dao.CheDao;
import pers.arrayli.db.JDBCUtils;
import pers.arrayli.domain.Che;

/**
 * @author lzj13 实现 CheDao 接口 ，做一些数据访问层操作
 */
public class CheDaoImpl implements CheDao {

	@Override
	public boolean AddChe(Che che) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "insert into t_che values(null,?,?,?,?,?)";
		int result = queryRunner.update(sql, che.getHao(), che.getLeixing(), che.getPicture(), che.getInfo(),
				che.getUid());
		System.out.println("AddCheDao res = " + result);
		return result > 0;
	}

	@Override
	public Che findByUid(int uid) throws SQLException {
		System.out.println("------------------------findByUid-------------------");
		System.out.println("CheDao uid = " + uid);
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_che where uid = ?";
		Che che = queryRunner.query(sql, new BeanHandler<Che>(Che.class), uid);
		System.out.println("CheDao che: " + che);
		System.out.println("------------------------findByUid-------------------");
		return che;
	}

	@Override
	public Che findById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select* from t_che where id = ?";
		Che che = queryRunner.query(sql, new BeanHandler<Che>(Che.class), id);
		return che;
	}

	@Override
	public boolean updateCheById(int id, Che che) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "update t_che set hao = ?,leixing=?,picture=?,info=?";
		int result = queryRunner.update(sql, che.getHao(), che.getLeixing(), che.getPicture(), che.getInfo());
		return result > 0;
	}

	@Override
	public boolean delCheById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "delete from t_che where id = ?";
		int result = queryRunner.update(sql, id);
		return result > 0;
	}

	@Override
	public String getHaoByUid(int uid) throws SQLException {
		System.out.println("------------------------ CheDao getHaoByUid Debug Start -------------------");
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select hao from t_che where uid = ?";
		System.out.println("uid: " + uid);
		System.out.println("sql : " + sql);
		Che che = queryRunner.query(sql, new BeanHandler<Che>(Che.class), uid);
		System.out.println("che: " + che);
		System.out.println("------------------------CheDao getHaoByUid Debug End -------------------");
		if (che != null) {
			return che.getHao();
		}
		return null;
	}

	@Override
	public int GetUidByHao(String chepai) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select uid from t_che where hao = ?";
		Che che = queryRunner.query(sql, new BeanHandler<Che>(Che.class), chepai);
		int uid = 0;
		if (che != null) {
			uid = che.getUid();
		}
		return uid;
	}

	@Override
	public String getPicPathById(int id) throws SQLException {
		QueryRunner queryRunner = new QueryRunner(JDBCUtils.getDataSource());
		String sql = "select picture from t_che where id = ?";
		Che che = queryRunner.query(sql, new BeanHandler<Che>(Che.class),id);
		if(che != null){
			return che.getPicture();
		}
		return null;
	}
}
