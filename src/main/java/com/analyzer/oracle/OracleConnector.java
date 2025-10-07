package com.analyzer.oracle;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;

import com.analyzer.oracle.Models.Table;
import com.analyzer.oracle.Models.TableReference;
import com.analyzer.oracle.Models.Trigger;
import com.analyzer.oracle.Models.View;

import java.util.List;
import java.util.logging.Logger;

@Component
public class OracleConnector {

    Logger logger = Logger.getLogger(OracleConnector.class.getName());

    private JdbcTemplate jdbcTemplate;

    public OracleConnector(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<String> schemaList() {

        String sql = "SELECT username FROM all_users WHERE username NOT IN ('SYS','AUDSYS','SYSTEM','OUTLN','VECSYS','BAASSYS','GSMADMIN_INTERNAL','GSMUSER','GGSHAREDCAP','DIP','REMOTE_SCHEDULER_AGENT','DBSFWUSER','SYS$UMF','DGPDB_INT','DBSNMP','APPQOSSYS','GSMCATUSER','GGSYS','XDB','ANONYMOUS','WMSYS','OJVMSYS','CTXSYS','OLAPSYS','MDSYS','MDDATA','LBACSYS','DVF','PDBADMIN','DVSYS','SYSBACKUP','SYSDG','SYSKM','SYSRAC','XS$NULL')";

        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<Table> tableList(List<String> ownerIds) {

        SqlParameterSource parameters = new MapSqlParameterSource("ids", ownerIds);

        List<Table> tables = new NamedParameterJdbcTemplate(jdbcTemplate).query(
                "select table_name, owner FROM all_tables WHERE owner IN (:ids)", parameters,
                (rs, num) -> new Table(rs.getString("table_name"), rs.getString("owner")));

        return tables;
    }

    public List<View> viewList(List<String> ownerIds) {
        SqlParameterSource parameters = new MapSqlParameterSource("ids", ownerIds);

        List<View> views = new NamedParameterJdbcTemplate(jdbcTemplate).query(
                "SELECT view_name, owner FROM all_views WHERE owner IN (:ids)", parameters,
                (rs, num) -> new View(rs.getString("view_name"), rs.getString("owner")));

        return views;
    }

    public List<Trigger> viewTriggers(List<String> ownerIds) {
        SqlParameterSource parameters = new MapSqlParameterSource("ids", ownerIds);

        List<Trigger> triggers = new NamedParameterJdbcTemplate(jdbcTemplate).query(
                "SELECT table_name, owner, trigger_name, trigger_type, triggering_event, trigger_body FROM all_triggers WHERE owner IN (:ids)",
                parameters,
                (rs, num) -> new Trigger(
                        rs.getString("table_name"),
                        rs.getString("owner"),
                        rs.getString("trigger_name"),
                        rs.getString("trigger_type"),
                        rs.getString("triggering_event"),
                        rs.getString("trigger_body")));

        return triggers;
    }

    public List<TableReference> viewReferences(List<String> ownerIds) {
        SqlParameterSource parameters = new MapSqlParameterSource("ids", ownerIds);

        List<TableReference> references = new NamedParameterJdbcTemplate(jdbcTemplate).query(
                "SELECT referenced_owner, name, type, referenced_name, referenced_type FROM all_dependencies WHERE referenced_name IN (:ids)",
                parameters,
                (rs, num) -> new TableReference(
                        rs.getString("referenced_owner"),
                        rs.getString("name"),
                        rs.getString("type"),
                        rs.getString("referenced_name"),
                        rs.getString("referenced_type")));

        return references;
    }
}
