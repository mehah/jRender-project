package service;

import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import com.jrender.database.DatabaseConnection;
import com.jrender.kernel.JRenderContext;
import com.jrender.util.SecurityUtils;
import com.jrender.util.SecurityUtils.TYPE;

import greendb.GreenDB;
import modal.User;

public class UserService {

	public static User getUserBy(String email, String password) throws NoSuchAlgorithmException, SQLException {
		DatabaseConnection conn = JRenderContext.getInstance().getDatabaseConnection();

		List<User> users = GreenDB.findByColumns(conn, User.class, null, new String[] { "email", "password" }, null, email, SecurityUtils.generateString(password, TYPE.SHA1));

		if (users != null) {
			User user = users.get(0);
			user.setAdmin(user.isAdmin());
			return user;
		}

		return null;
	}

	public static Optional<List<User>> getAllUsers() {
		DatabaseConnection conn = JRenderContext.getInstance().getDatabaseConnection();

		List<User> users;
		try {
			users = GreenDB.findAll(conn, User.class);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return Optional.ofNullable(users);
	}
}
