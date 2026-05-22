int numRowpackage com.dao_impl;

import com.dao.IncidentDao;
import com.enums.IncidentStatus;
import com.enums.IncidentType;
import com.exception.ResourceNotFoundException;
import com.model.Incident;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class IncidentDaoImpl implements IncidentDao {

    private final JdbcTemplate jdbcTemplate;

    public IncidentDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    private RowMapper<Incident> mapper() {

        return (rs, num) -> {

            return new Incident(

                    rs.getInt("id"),

                    IncidentType.valueOf(rs.getString("type").toUpperCase().replace(" ", "_")),

                    rs.getString("progress_details"),

                    IncidentStatus.valueOf(rs.getString("status").toUpperCase().replace(" ", "_"))
            );
        };
    }


    @Override
    public void insert(Incident incident) {

        String sql =
                "insert into incident(officer_id,type,progress_details,status) values(?,?,?,?)";

        jdbcTemplate.update(
                sql,
                incident.getId(),
                incident.getIncidentType().toString(),
                incident.getProgressDetails(),
                incident.getIncidentStatus().toString()
        );

        System.out.println("Incident Added.");
    }


    @Override
    public List<Incident> getAll() {

        String sql = "select * from incident";

        return jdbcTemplate.query(sql, mapper());
    }


    @Override
    public Incident getById(int id) throws ResourceNotFoundException {

        String sql = "select * from incident where id=?";

        List<Incident> list =
                jdbcTemplate.query(sql, mapper(), id);

        if (list.isEmpty()) {
            throw new ResourceNotFoundException("Invalid id");
        }

        return list.get(0);
    }


    @Override
    public void deleteById(int id) throws ResourceNotFoundException {

        String sql = "delete from incident where id=?";

        int numRow = jdbcTemplate.update(sql, id);

        if (numRow == 0) {
            throw new ResourceNotFoundException("Invalid id");
        }

        System.out.println("Incident deleted");
    }

    @Override
    public void update(int id, Incident incident)
            throws ResourceNotFoundException {

        String sql =
                "update incident set type=?, progress_details=?, status=? where id=?";

        int numRow = jdbcTemplate.update(
                sql,
                incident.getIncidentType().toString(),
                incident.getProgressDetails(),
                incident.getIncidentStatus().toString(),
                id
        );

        if (numRow == 0) {
            throw new ResourceNotFoundException("Invalid id");
        }

        System.out.println("Incident updated");
    }
}