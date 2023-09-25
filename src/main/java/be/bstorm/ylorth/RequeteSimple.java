package be.bstorm.ylorth;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class RequeteSimple {

    public static void create(Javanais p){

        String requete=  "INSERT INTO javanais VALUES (DEFAULT,'"
                +p.getNom() +"', '"
                +p.getPrenom() +"')";

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()){
            statement.execute(requete);

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }

    }

    public static Optional<Javanais> getOne(long id){

        String requete=  "SELECT * FROM javanais WHERE id="+id;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(requete)){


            if( rs.next() ){
                Javanais p = new Javanais();
                p.setId(rs.getLong("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));

                return Optional.of(p);

            }
            else
                return Optional.empty();


        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }

    }

    public static List<Javanais> getAll(){

        String requete=  "SELECT * FROM javanais";

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(requete)){

            List<Javanais> liste = new ArrayList<>();

            while( rs.next() ){
                Javanais p = new Javanais();
                p.setId(rs.getLong("id"));
                p.setNom(rs.getString("nom"));
                p.setPrenom(rs.getString("prenom"));
                p.setNumeroRoueInfortune(rs.getInt("numeroRoueInfortune"));

                liste.add(p);

            }

            return liste;


        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }

    }

    public static void delete(long id){
        String requete=  "DELETE FROM javanais WHERE id=" + id;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()){
            statement.execute(requete);

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }
    }

	public static void update(long id, Javanais p){

        String requete = "UPDATE javanais SET prenom = '" + p.getPrenom() + "', nom = '" + p.getNom() + "', numeroRoueInfortune = '" + p.getNumeroRoueInfortune() +"' WHERE id = "+id;

        try (Connection connection = ConnectionFactory.createConnection();
             Statement statement = connection.createStatement()){
            statement.executeUpdate(requete);

        }catch (SQLException e){
            throw new RuntimeException("create error",e);
        }
    }


}
