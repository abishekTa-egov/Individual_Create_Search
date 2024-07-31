package digit.repository;

import digit.repository.queryBuilder.IndApplicationQueryBuilder;

import digit.repository.rowmapper.IndividualRowMapper;
import digit.web.models.IndividualSearch;
import digit.web.models.Individual;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Slf4j
@Repository
public class IndRegistrationRepository {

    @Autowired
    private IndApplicationQueryBuilder queryBuilder;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private IndividualRowMapper rowMapper;

    public List<Individual>getApplications(IndividualSearch searchCriteria){
        List<Object> preparedStmtList = new ArrayList<>();
        String query = queryBuilder.getIndividualSearchQuery(searchCriteria, preparedStmtList);
        log.info("Final query: " + query);
        System.out.println("Query " + query);
        return jdbcTemplate.query(query, preparedStmtList.toArray(), rowMapper);
    }
}
