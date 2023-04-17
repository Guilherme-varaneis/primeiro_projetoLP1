    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com_projeto_1.dao;
import java.sql.*;
import br.com.projeto_1.dto.ReservaDTO;
/**
 *
 * @author guiva
 */
public class ConexaoDAO {

    public static Connection con = null;

    public ConexaoDAO() {

    }

    public static void connectDB() {
        try {
            String dsn = "projeto_hotel";
            String user = "postgres";
            String senha = "postdba";

            DriverManager.registerDriver(new org.postgresql.Driver());

            String url = "jdbc:postgresql://localhost:5432/" + dsn;

            con = DriverManager.getConnection(url, user, senha);
            con.setAutoCommit(false);
            if (con == null) {
                System.out.println("ERRO AO ABRIR O BANCO");
            }
        }
         catch(Exception e){
            System.out.println("ERRO AO ABRIR O BANCO DE DADOS" + e.getMessage());
}   
    }
   
    public static void CloseBD (){
        try {
            con.close();
        }catch (Exception e) {
            System.out.println("PROBLEMA AO FECHAR BASE DE DADOS" + e.getMessage());
        }
    }
  
}
