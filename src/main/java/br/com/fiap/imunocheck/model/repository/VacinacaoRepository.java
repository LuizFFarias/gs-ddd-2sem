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
			String sql = "select * from challenge_vistoria";
			
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
			
				if (rs != null) {
					while (rs.next()) {
						DadosUsuario dado = new DadosUsuario();
					dado.setNome(rs.getString("nome"));
					dado.setIdade(rs.getInt("idade"));
					dado.setCidade(rs.getString("cidade"));
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
						dado.setCidade(rs.getString("cidade"));
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
			String sql = "insert into values(?, ?, ?, ?, ?)";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, dado.getUsuario());
				ps.setString(2, dado.getSenha());
				ps.setString(3, dado.getNome());
				ps.setInt(4, dado.getIdade());
				ps.setString(5, dado.getCidade());
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
			String sql = "update set nome = ?, idade = ?, cidade = ? where usuario = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, dado.getNome());
				ps.setInt(2, dado.getIdade());
				ps.setString(3, dado.getCidade());
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
		
		/***
		 * Método para pegar as informaçoes da tabela de vacinas
		 * @author luizfillipe
		 */
		
		public static ArrayList<Vacinas> findVac(Vacinas vacinas, DadosUsuario dado){
			ArrayList<Vacinas> tabelaVac = new ArrayList<Vacinas>();
			String sql = "select * from where usuario = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, dado.getUsuario());
				ResultSet rs = ps.executeQuery();
				if (rs != null) {
					while (rs.next()) {
						vacinas.setBcg(rs.getString("bcg"));
						vacinas.setHepatiteB(rs.getString("hepatite"));
						vacinas.setPentavalente(rs.getString("pentavalente"));
						vacinas.setVipVop(rs.getString("vipvop"));
						vacinas.setPneumococica10Valente("pneumocica10valente");
						vacinas.setMeningococicaC(rs.getString("meningocicac"));
						vacinas.setRotaVirus(rs.getString("rotavirus"));
						vacinas.setFebreAmarela(rs.getString("febreamarela"));
						vacinas.setTripliceViral(rs.getString("tripliceviral"));
						vacinas.setHepatiteA("hepatitea");
						vacinas.setDtp(rs.getString("dtp"));
						vacinas.setVaricela(rs.getString("varicela"));
						vacinas.setHpv(rs.getString("hpv"));
						vacinas.setHepatiteBAdlc("hepatitebadlc");
						vacinas.setHpvAdlc(rs.getString("hpvadlc"));
						vacinas.setTripliceViralReforco(rs.getString("tripliceviralreforco"));
						vacinas.setDuplaDT(rs.getString("dupladt"));
						vacinas.setHepatiteBDirecinado("hepatitebdirecionado");
						vacinas.setInfluenza(rs.getString("influenza"));
						vacinas.setPneumococicaDirecionado("pneumococicadirecionado");
						vacinas.setMeningococicaC(rs.getString("meningocicadirecionado"));
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
		
		public static Vacinas saveVac(Vacinas vacinas, DadosUsuario dado) {
			String sql = "insert into values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,"
					+ " ?, ?, ?, ?, ?, ?, ?, ?)";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, dado.getUsuario());
				ps.setString(2, vacinas.getBcg());
				ps.setString(3, vacinas.getHepatiteB());
				ps.setString(4, vacinas.getPentavalente());
				ps.setString(5, vacinas.getVipVop());
				ps.setString(6, vacinas.getPneumococica10Valente());
				ps.setString(7, vacinas.getMeningococicaC());
				ps.setString(8, vacinas.getRotaVirus());
				ps.setString(9, vacinas.getFebreAmarela());
				ps.setString(10, vacinas.getTripliceViral());
				ps.setString(11, vacinas.getHepatiteA());
				ps.setString(12, vacinas.getDtp());
				ps.setString(13, vacinas.getVaricela());
				ps.setString(14, vacinas.getHpv());
				ps.setString(15, vacinas.getHepatiteBAdlc());
				ps.setString(16, vacinas.getHpvAdlc());
				ps.setString(17, vacinas.getTripliceViralReforco());
				ps.setString(18, vacinas.getDuplaDT());
				ps.setString(19, vacinas.getHepatiteBDirecinado());
				ps.setString(20, vacinas.getInfluenza());
				ps.setString(21, vacinas.getPneumococicaDirecionado());
				ps.setString(22, vacinas.getMeningococicaDirecionado());
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
		
		public static Vacinas updateVac(Vacinas vacinas, DadosUsuario dado){
			String sql = "update set bcg = ?, hepatiteB = ?, pentavalente = ?, vipvop = ?, Pneumocica10valente = ?, "
					+ "MeningocicaC = ?, rotavirus = ?, febreamarela = ?, tripliceviral = ?, hepatiteA = ?, dtp = ?, "
					+ "varicela = ?, hpv = ?, hepatitebadlc = ?, hpvadlc = ?, tripliceviralreforco = ?, dupladt = ?, "
					+ "hepatitebdirecionado = ?, influenza = ?, pneumococicaDirecionado = ?, meningococicaDirecionado = ?";
			try {
				PreparedStatement ps = getConnection().prepareStatement(sql);
				ps.setString(1, vacinas.getBcg());
				ps.setString(2, vacinas.getHepatiteB());
				ps.setString(3, vacinas.getPentavalente());
				ps.setString(4, vacinas.getVipVop());
				ps.setString(5, vacinas.getPneumococica10Valente());
				ps.setString(6, vacinas.getMeningococicaC());
				ps.setString(7, vacinas.getRotaVirus());
				ps.setString(8, vacinas.getFebreAmarela());
				ps.setString(9, vacinas.getTripliceViral());
				ps.setString(10, vacinas.getHepatiteA());
				ps.setString(11, vacinas.getDtp());
				ps.setString(12, vacinas.getVaricela());
				ps.setString(13, vacinas.getHpv());
				ps.setString(14, vacinas.getHepatiteBAdlc());
				ps.setString(15, vacinas.getHpvAdlc());
				ps.setString(16, vacinas.getTripliceViralReforco());
				ps.setString(17, vacinas.getDuplaDT());
				ps.setString(18, vacinas.getHepatiteBDirecinado());
				ps.setString(19, vacinas.getInfluenza());
				ps.setString(20, vacinas.getPneumococicaDirecionado());
				ps.setString(21, vacinas.getMeningococicaDirecionado());
				ps.setString(22, dado.getUsuario());
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
