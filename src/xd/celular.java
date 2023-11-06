package xd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class celular {
	Connection cx;

	public celular() {

	}

	public Connection conectar() {
		try {
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/celular", "root", "");
			System.out.println("CONEXION EXITOSA");
		} catch (SQLException e) {
			System.out.println("FALLO DE CONEXION");
			e.printStackTrace();
		}
		return cx;
	}

	public boolean insertar(datacelular c) {
		PreparedStatement ps = null;
		try {
			ps = conectar().prepareStatement("INSERT INTO celulares VALUES (?,?,?,?,?)");
			ps.setInt(1, c.getId());
			ps.setString(2, c.getMarca());
			ps.setString(3, c.getModelo());
			ps.setString(4, c.getSistema());
			ps.setString(5, c.getProcesador());
			ps.execute();
			return true;

		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}

	public boolean cargar(datacelular c) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conectar().prepareStatement("SELECT * FROM  celulares WHERE id=?");
			ps.setInt(1, c.getId());
			rs = ps.executeQuery();
			if (rs.next()) {
				c.setMarca(rs.getString(2));
				c.setModelo(rs.getString(3));
				c.setProcesador(rs.getString(4));
				c.setSistema(rs.getString(5));
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}

	public boolean eliminar(int id) {
		PreparedStatement ps = null;
		try {
			datacelular x = new datacelular();
			x.setId(id);
			if (x.cargar()) {
				ps = conectar().prepareStatement("DELETE FROM celulares WHERE id=?");
				ps.setInt(1, id);
				ps.execute();
				return true;
			} else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean actualizar(datacelular c) {
		PreparedStatement ps = null;
		try {
			datacelular x = new datacelular();
			x.setId(c.getId());
			if (x.cargar()) {
				ps = conectar().prepareStatement(
						"UPDATE celulares SET marca=?,modelo=?,sistema=?,procesador=?" + "WHERE id=?");
				ps.setString(1, c.getMarca());
				ps.setString(2, c.getModelo());
				ps.setString(3, c.getProcesador());
				ps.setString(4, c.getSistema());
				ps.setInt(5, c.getId());
				ps.execute();
				return true;
			}else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();

			return false;
		}
	}
}
