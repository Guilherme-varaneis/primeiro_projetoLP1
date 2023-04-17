/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com_projeto_1.dao;

import br.com.projeto_1.dto.ReservaDTO;
import java.sql.*;

/**
 *
 * @author guiva
 */
public class ReservaDAO {

    public ReservaDAO() {

    }
    private ResultSet rs = null;
    private Statement stmt = null;

    public boolean alterarReserva(ReservaDTO reservaDTO) {
        try {
            ConexaoDAO.connectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = " Update reserva set "
                    + "nome_res = '" + reservaDTO.getNome_res() + "', "
                    + "fone_res = '" + reservaDTO.getFone_res() + "', "
                    + "email_res = '" + reservaDTO.getEmail_res() + "', "
                    + "cpf_res = '" + reservaDTO.getCpf_res() + "', "
                    + "habitacao_res = '" + reservaDTO.getHabitacao_res() + "', "
                    + "nacional_res = '" + reservaDTO.getNacional_res() + "' "
                    + "where id_res = " + reservaDTO.getId_res();
                    
            stmt.execute(comando.toUpperCase());

            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println("ERRO" + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseBD();
        }

    }
    

    public boolean inserirReserva(ReservaDTO reservaDTO) {
        try {
            ConexaoDAO.connectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into reserva (nome_res, fone_res, email_res, "
                    + "cpf_res, habitacao_res, nacional_res, pessoas_res)values( "
                    + "'" + reservaDTO.getNome_res() + "', "
                    + "'" + reservaDTO.getFone_res() + "', "
                    + "'" + reservaDTO.getEmail_res() + "', "
                    + "'" + reservaDTO.getCpf_res() + "', " 
                    + "'" + reservaDTO.getHabitacao_res() + "', "
                    + "'" + reservaDTO.getNacional_res() + "', "
                    + reservaDTO.getPessoas_res() + " ) ";
                  
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseBD();

        }
    } public boolean excluirReserva(ReservaDTO reservaDTO){
         try{
            ConexaoDAO.connectDB();
            
            stmt = ConexaoDAO.con.createStatement();
            
            String comando = "Delete from reserva where id_res = "
                                + reservaDTO.getId_res();
            
            stmt.execute(comando);
            ConexaoDAO.con.commit();
            stmt.close();
            return true;
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        finally{
            ConexaoDAO.CloseBD();
        }
}
    public ResultSet consultarReserva(ReservaDTO reservaDTO, int opcao){
        try{
            ConexaoDAO.connectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            
            switch(opcao){
                case 1:
                    comando = "Select r.* "+
                              "from reserva r "+
                              "where nome_res like '" + reservaDTO.getNome_res() + "%' " +
                              "order by r.nome_res";
                break;
                case 2:
                    comando = "Select r.* "+
                              "from reserva r " +
                              "where r.id_res = " + reservaDTO.getId_res() ;
                break;
                case 3:
                    comando = "Select r.id_res, r.nome_res " +
                              "from reserva r";
                break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch(Exception e){
            System.out.println(e.getMessage());
            return rs;
        }
    }
}