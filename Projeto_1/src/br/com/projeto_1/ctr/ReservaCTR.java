/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.projeto_1.ctr;

import br.com.projeto_1.dto.ReservaDTO;
import br.com_projeto_1.dao.ReservaDAO;
import br.com_projeto_1.dao.ConexaoDAO;
import java.sql.ResultSet;

/**
 *
 * @author guiva
 */
public class ReservaCTR {

    ReservaDAO reservaDAO = new ReservaDAO();

    public ReservaCTR() {

    }
    public String inserirReserva(ReservaDTO reservaDTO){
        try{
            if(reservaDAO.inserirReserva(reservaDTO)){
                return "Cliente Cadastrado com Sucesso!!";
            } else{
                return "Cliente Não Cadastrado!!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return"Cliente Não Cadastrado!!";
        }
    }
    
    public ResultSet consultarCliente(ReservaDTO reservaDTO, int opcao){
        ResultSet rs = null;
        
        rs = reservaDAO.consultarReserva(reservaDTO, opcao);
        
        return rs;
    }
    
    public void CloseDB(){
        ConexaoDAO.CloseBD();
    }

    public String alterarReserva(ReservaDTO reservaDTO) {
        try {
            if (reservaDAO.alterarReserva(reservaDTO)) {
                return "Dados da reserva alterados com sucesso";
            } else {
                return "Erro ao alterar Dados";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente não cadastrado";
        }

    }
       public String excluirCliente(ReservaDTO reservaDTO){
        try{
            if(reservaDAO.excluirReserva(reservaDTO)){
                return "Cliente Excluído com Sucesso!!";
            } else{
                return "Cliente Não Excluído!!";
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return "Cliente Não Excluído!!";
        }
    }
    
}
