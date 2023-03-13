package com.example.superherov4.repositories;

import com.example.superherov4.dto.CountSuperpowersDTO;
import com.example.superherov4.dto.HeroesInCityDTO;
import com.example.superherov4.dto.HeroNameCreationDTO;
import com.example.superherov4.dto.RealNameSuperpowersDTO;
import com.example.superherov4.model.Superhero;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class SuperheroRepository_DB {

    @Value("${spring.datasource.url}")
    private String db_url;

    @Value("${spring.datasource.username}")
    private String uid;

    @Value("${spring.datasource.password}")
    private String pwd;

        public List<Superhero> getSuperheroes() {
            List<Superhero> superheroes = new ArrayList<>();
            try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
                String SQL = "SELECT * FROM superhero;";
                Statement stmt = con.createStatement();
                ResultSet rs = stmt.executeQuery(SQL);
                while (rs.next()) {
                    int ID = rs.getInt("id");
                    String superheroName = rs.getString("superheroName");
                    String reelName = rs.getString("realName");
                    boolean isHuman = rs.getBoolean("isHuman");
                    int creationYear = rs.getInt("creationYear");
                    double powerLevel = rs.getDouble("powerlevel");
                    //superheroes.add(new Superhero(ID, superheroName, reelName, isHuman, superPower, creationYear, powerLevel, city));
                    superheroes.add(new Superhero(ID, superheroName, reelName, isHuman, creationYear, powerLevel));
                }
                return superheroes;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

    public Superhero getSuperhero(String superheroName) {
        Superhero superhero1 = null;

            try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT id, superheroName, realName, creationYear FROM superhero WHERE superheroName = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, superheroName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int ID = rs.getInt("id");
                String superHeroName = rs.getString("superheroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superhero1 = new Superhero(ID, superHeroName, realName, creationYear);

            }
            return superhero1;

        } catch (SQLException e){
        throw new RuntimeException(e);
        }
    }

    public List<HeroNameCreationDTO> searchSuperheroes(String searchName) {
        List<HeroNameCreationDTO> superheroResults = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT superheroName, realName, creationYear FROM superhero WHERE superheroName = ?;";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, searchName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String superheroName = rs.getString("superheroName");
                String realName = rs.getString("realName");
                int creationYear = rs.getInt("creationYear");
                superheroResults.add(new HeroNameCreationDTO(superheroName, realName, creationYear));

            }
            return superheroResults;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<CountSuperpowersDTO> getSuperpowerCount(String searchName) {
        List<CountSuperpowersDTO> superheroResults = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT Superhero.superheroName, Superhero.realName, COUNT(Superpower.superpower) as numSuperpowers " +
                    "FROM Superhero " +
                    "LEFT JOIN SuperheroSuperpower ON Superhero.id = SuperheroSuperpower.superheroId " +
                    "LEFT JOIN Superpower ON SuperheroSuperpower.superpowerId = Superpower.id " +
                    "WHERE superheroName = ?" +
                    "GROUP BY Superhero.id";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, searchName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String superheroName = rs.getString("superheroName");
                String realName = rs.getString("realName");
                int superpowersAmount = rs.getInt("numSuperpowers");
                superheroResults.add(new CountSuperpowersDTO(superheroName, realName, superpowersAmount));

            }
            return superheroResults;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public List<RealNameSuperpowersDTO> getRealNameSuperpowers(String searchName) {
        List<RealNameSuperpowersDTO> superheroResults = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT sh.superheroName, sh.realName, GROUP_CONCAT(sp.superpower) AS superpowers " +
                    "FROM Superhero sh " +
                    "LEFT JOIN SuperheroSuperpower ss ON sh.id = ss.superheroId " +
                    "LEFT JOIN Superpower sp ON ss.superpowerId = sp.id " +
                    "WHERE sh.superheroName = ?" +
                    "GROUP BY sh.id " +
                    "ORDER BY sh.superheroName";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, searchName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String superheroName = rs.getString("superheroName");
                String realName = rs.getString("realName");
                String superpowers = rs.getString("superpowers");
                superheroResults.add(new RealNameSuperpowersDTO(superheroName, realName, superpowers));

            }
            return superheroResults;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    public List<HeroesInCityDTO> getHeroCity(String cityName) {
        List<HeroesInCityDTO> superheroResults = new ArrayList<>();

        try (Connection con = DriverManager.getConnection(db_url, uid, pwd)) {
            String SQL = "SELECT city.cityName, GROUP_CONCAT(superhero.superheroName) AS Superheroes " +
                    "FROM City " +
                    "INNER JOIN SuperheroCity ON City.cityId = SuperheroCity.cityId " +
                    "INNER JOIN Superhero ON Superhero.id = SuperheroCity.superheroId " +
                    "WHERE cityName = ? " +
                    "GROUP BY city.cityName";
            PreparedStatement pstmt = con.prepareStatement(SQL);
            pstmt.setString(1, cityName);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                String city = rs.getString("cityName");
                String superheroNames = rs.getString("Superheroes");
                superheroResults.add(new HeroesInCityDTO(city, superheroNames));
            }
            return superheroResults;

        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }





}

