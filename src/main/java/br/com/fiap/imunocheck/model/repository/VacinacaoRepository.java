package br.com.fiap.imunocheck.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.imunocheck.model.bean.DadosUsuario;



public class VacinacaoRepository extends Repository{
	
	/***
	 * Método que realiza a busca de todos usuarios cadastrados no banco de dados e na API
	 * @author Luiz Fillipe
	 * @return ArrayList dados
	 */
		public static ArrayList<DadosUsuario> findAll(){
			ArrayList<DadosUsuario> dados = new ArrayList<DadosUsuario>();
			String sql = "select * from challenge_vistoria";
			
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
			
				if (rs != null) {
					while (rs.next()) {
						DadosUsuario dado = new DadosUsuario();
					dado.setNome(rs.getString("nome"));
					dado.setIdade(rs.getInt("idade"));
					dado.setCidade(rs.getString("vacinasTomadas"));
					dado.setVacinasTomadas(rs.getString("vacinasTomadas"));
					dados.add(dado);
					}
					
				}
				else {
					return null;
				}
			} catch (SQLException e) {
				System.out.println("Erro ao listar: " + e.getMessage());
			}
			finally {
				closeConnection();
			}
			return dados;
		}
		
		/***
		 * Método que realiza a busca dos usuarios cadastrados pelo nome de usuario no banco de dados e na API
		 * @author Luiz Fillipe
		 * @return ArrayList dados
		 */
		public static ArrayList<DadosUsuario> findOne(String usuario){
			ArrayList<DadosUsuario> dados = new ArrayList<DadosUsuario>();
			String sql = "select * from where usuario = ?";
			
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, usuario);
				ResultSet rs = ps.executeQuery();
			
				if (rs != null) {
					while (rs.next()) {
						DadosUsuario dado = new DadosUsuario();
						dado.setNome(rs.getString("nome"));
						dado.setIdade(rs.getInt("idade"));
						dado.setCidade(rs.getString("vacinasTomadas"));
						dado.setVacinasTomadas(rs.getString("vacinasTomadas"));
					dados.add(dado);
					}	
				}
				else {
					return null;
				}
			} catch (SQLException e) {
				System.out.println("Erro ao listar: " + e.getMessage());
			}
			finally {
				closeConnection();
			}
			return dados;
		}
		
		/***
		 * Método que realiza a inserção dos clientes e seus dados da vistoria cadastrados no banco de dados e na API
		 * @author Luiz Fillipe
		 */
		
		public static DadosUsuario save(DadosUsuario dado) {
			String sql = "insert into values(?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, dado.getUsuario());
				ps.setString(2, dado.getSenha());
				ps.setString(3, dado.getNome());
				ps.setInt(4, dado.getIdade());
				ps.setString(5, dado.getCidade());
				ps.setString(6, dado.getVacinasTomadas());
				if(ps.executeUpdate() > 0) {
					return dado;
				}
				else {
					return null;
				}
				
			} catch (SQLException e) {
				System.out.println("Erro ao salvar: " + e.getMessage());
			}
			finally {
				closeConnection();
			}
			return null;	
		}
		
		/***
		 * Método que faz alterações nos dados de um usuario cadastrado 
		 * @author Luiz Fillipe
		 */
		
		public static DadosUsuario update(DadosUsuario dado) {
			String sql = "update set nome = ?, idade = ?, cidade = ?, vacinasTomadas = ? where usuario = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, dado.getNome());
				ps.setInt(2, dado.getIdade());
				ps.setString(3, dado.getCidade());
				ps.setString(4, dado.getVacinasTomadas());
				ps.setString(5, dado.getUsuario());
				if (ps.executeUpdate() > 0) {
					return dado;
				} else {
					return null;
				}
				
			}
			catch (SQLException e) {
				System.out.println("Erro ao atualizar: " + e.getMessage());
			}
			finally {
				closeConnection();
			}
			return null;
		}
		
	   /***
	    * Método para deletar o cadastro e os dados do usuário
	    * @author Luiz Fillipe
	    */	
		
		public static boolean delete(String usuario) {
			String sql = "delete from where usuario = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, usuario);
				if (ps.executeUpdate() > 0) {
					return true;
				} else {
					return false;
				}
			} catch (SQLException e) {
				System.out.println("Erro ao deletar: " + e.getMessage());
			} finally {
				closeConnection();
			}
			return false;
		}

}
