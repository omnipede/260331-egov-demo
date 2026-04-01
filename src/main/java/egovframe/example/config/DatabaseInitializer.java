package egovframe.example.config;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

@Component
public class DatabaseInitializer {

    @Resource(name = "jdbcTemplate")
    private JdbcTemplate jdbcTemplate;

    @PostConstruct
    public void init() {
        try {
            String sql = readSqlFile("/schema.sql");
            String[] statements = sql.split(";");
            for (String statement : statements) {
                statement = statement.trim();
                if (!statement.isEmpty()) {
                    try {
                        jdbcTemplate.execute(statement);
                    } catch (Exception e) {
                        // Ignore errors (tables may already exist)
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to initialize database", e);
        }
    }

    private String readSqlFile(String path) throws IOException {
        InputStream inputStream = getClass().getResourceAsStream(path);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
        StringBuilder sql = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            sql.append(line).append("\n");
        }
        reader.close();
        return sql.toString();
    }
}
