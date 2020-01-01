package de.progen_bot.db.dao.tokenmanager;

import de.progen_bot.core.Main;
import de.progen_bot.db.connection.ConnectionFactory;
import de.progen_bot.db.dao.Dao;
import net.dv8tion.jda.api.entities.Member;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TokenManagerDao extends Dao {
    final private String sqlQuery = "CREATE TABLE if not exists `tokens`(`guildid` VARCHAR(18) NOT NULL, `userid` " +
            "VARCHAR(18) NOT NULL , `token` VARCHAR(10) NOT NULL , `time` TIMESTAMP NOT NULL DEFAULT " +
            "CURRENT_TIMESTAMP, PRIMARY KEY (`token`)) ENGINE = InnoDB;";

    @Override
    public void generateTables(String query) {
        super.generateTables(sqlQuery);
    }

    public boolean keyExists(String token) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        ResultSet rs = connection.prepareStatement("SELECT `token` FROM `tokens` WHERE `token` = '" +
                token + "'").executeQuery();
        return rs.next();
    }

    public boolean memberExists(Member member) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        ResultSet rs = connection.prepareStatement("SELECT token FROM tokens WHERE userid = '" + member.getUser().getId() + "' AND " +
                "guildid = '" + member.getGuild().getId() + "'").executeQuery();
        return rs.next();
    }

    public void addMember(String token, Member member) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        connection.prepareStatement("INSERT INTO tokens (guildid, userid, token) VALUES ('" + member.getGuild().getId() + "', " +
                "'" + member.getUser().getId() + "', '" + token + "')").execute();
    }

    public Member getMember(String token) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        ResultSet rs = connection.prepareStatement("SELECT userid, guildid FROM tokens WHERE token = '" + token +
                "'").executeQuery();
        if (!rs.next()) return null;
        return Main.getJda().getGuildById(rs.getString("guildid")).getMemberById(rs.getString("userid"));
    }

    public void deleteMember(Member member) throws SQLException {
        Connection connection = ConnectionFactory.getConnection();
        connection.prepareStatement("DELETE FROM tokens WHERE userid = '" + member.getUser().getId() +
                "' AND guildid = '" + member.getGuild().getId() + "'").executeQuery();
    }
}