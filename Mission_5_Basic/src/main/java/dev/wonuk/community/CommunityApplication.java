package dev.wonuk.community;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommunityApplication {

	public static void main(String[] args) throws SQLException {
		SpringApplication.run(CommunityApplication.class, args);
	}

}
