package br.com.fiap.imunocheck.model.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import br.com.fiap.imunocheck.model.bean.DadosUsuario;
import br.com.fiap.imunocheck.model.bean.Vacinas;



public class VacinacaoRepository extends Repository{
	
	/***
	 * Método que realiza a busca de todos usuarios cadastrados no banco de dados e na API
	 * @author Luiz Fillipe
	 * @return ArrayList dados
	 */
		public static ArrayList<DadosUsuario> findAll(){
			ArrayList<DadosUsuario> dados = new ArrayList<DadosUsuario>();
			String sql = "select nomecompleto, idade, estado from Cadastro";
			
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
			
				if (rs != null) {
					while (rs.next()) {
						DadosUsuario dado = new DadosUsuario();
					dado.setNome(rs.getString("nomecompleto"));
					dado.setIdade(rs.getInt("idade"));
					dado.setEstado(rs.getString("estado"));
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
			String sql = "select nomecompleto, idade, estado from Cadastro where usuario = ?";
			
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, usuario);
				ResultSet rs = ps.executeQuery();
			
				if (rs != null) {
					while (rs.next()) {
						DadosUsuario dado = new DadosUsuario();
						dado.setNome(rs.getString("nomecompleto"));
						dado.setIdade(rs.getInt("idade"));
						dado.setEstado(rs.getString("estado"));
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
			String sql = "insert into Cadastro (usuario, senha, nomeCompleto, idade, estado) values(?, ?, ?, ?, ?)";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, dado.getUsuario());
				ps.setString(2, dado.getSenha());
				ps.setString(3, dado.getNome());
				ps.setInt(4, dado.getIdade());
				ps.setString(5, dado.getEstado());
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
			String sql = "update Cadastro set nomeCompleto = ?, idade = ?, estado = ? where usuario = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, dado.getNome());
				ps.setInt(2, dado.getIdade());
				ps.setString(3, dado.getEstado());
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
			String sql = "delete from Cadastro where usuario = ?";
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
		
		/***
		 * Método para pegar as informaçoes da tabela de vacinas
		 * @author luizfillipe
		 */
		
		public static ArrayList<Vacinas> findVac(String usuario){
			ArrayList<Vacinas> tabelaVac = new ArrayList<Vacinas>();
			String sql = "select * from VacinasUsuario where usuario = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				Vacinas vacinas = new Vacinas();
				ps.setString(1, vacinas.getUsuarioVac());
				ResultSet rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						vacinas.setId(rs.getInt("id"));
						vacinas.setStatusVac(rs.getString("statusVac"));
						vacinas.setUsuarioVac(rs.getString("usuarioVac"));
						tabelaVac.add(vacinas);
					}
				}
				else {
					return null;
				}
			} catch (SQLException e) {
				System.out.println("Erro ao listar vacinas: " + e.getMessage());
			}
			return tabelaVac;
		}
		
		/***
		 * Método que insere dentro da tabela quais vacinas o usuário tomou 
		 * @author Luiz Fillipe
		 */
		
		public static Vacinas saveVac(Vacinas vacinas) {
			String sql = "insert into VacinasUsuario values(?, ?, ?)";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, vacinas.getUsuarioVac());
				ps.setInt(2, vacinas.getId());
				ps.setString(3, vacinas.getStatusVac());
				if (ps.executeUpdate() > 0) {
					return vacinas;
				} else {
					return null;
				}
			} catch (SQLException e) {
				System.out.println("Erro ao salvar vacinas: " + e.getMessage());
			}
			finally {
				closeConnection();
			}
			return null;
		}
		
		/***
		 * Método que realiza alteraçoes nas vacinas tomadas pelo usuário
		 * @author luizfillipe
		 */
		
		public static Vacinas updateVac(Vacinas vacinas){
			String sql = "update VacinasUsuario set idVacina = ?, statusVacina = ? where usuario = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setInt(1, vacinas.getId());
				ps.setString(2, vacinas.getStatusVac());
				ps.setString(3, vacinas.getUsuarioVac());
				if (ps.executeUpdate() > 0) {
					return vacinas;
				} else {
					return null;
				}
			}
			catch (SQLException e) {
				System.out.println("Erro ao editar vacinas: " + e.getMessage());
			}
			finally {
				closeConnection();
			}
			return null;
			
		}

}
