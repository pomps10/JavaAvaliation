package ex;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Formatter;

import connection.ConnectionFactory;

public class Exercicio {
	public static void main(String[] args) {

		ConnectionFactory factory = new ConnectionFactory();
//		Autoclose
		try (Connection con = factory.getConnection()) {
//			Autoclose
			try (Statement st = con.createStatement()) {
				
//	            Zerar tabelas
				st.addBatch("DELETE FROM Autores20170184");
				st.addBatch("DELETE FROM Livros20170184");

//				Inserindo autores
				st.addBatch("INSERT INTO Autores20170184(Id, Nome) VALUES(1, 'Machado de Assis')");
				st.addBatch("INSERT INTO Autores20170184(Id, Nome) VALUES(2, 'Euclides da Cunha')");
				st.addBatch("INSERT INTO Autores20170184(Id, Nome) VALUES(3, 'Lima Barreto')");
				st.addBatch("INSERT INTO Autores20170184(Id, Nome) VALUES(4, 'Jorge Amado')");
				st.addBatch("INSERT INTO Autores20170184(Id, Nome) VALUES(5, 'Carlos Drummond de Andrade')");

//	            Inserindo livros
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(1, 1, 'Dom Casmurro')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(2, 1, 'Helena')");
				st.addBatch(
						"INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(3, 1, 'Memorias Postumas de Bras Cubas')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(4, 1, 'Quincas Borba')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(5, 2, 'Os Sertoes')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(6, 2, 'Contrastes e Confrontos')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(7, 2, 'A Margem da Historia')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(8, 2, 'Ondas')");
				st.addBatch(
						"INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(9, 3, 'Triste Fim de Policarpo Quaresma')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(10, 3, 'Clara dos Anjos')");
				st.addBatch(
						"INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(11, 3, 'O Homem que Sabia Javanes')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(12, 3, 'Os Brazundungas')");
				st.addBatch(
						"INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(13, 4, 'Farda Fardao Camisola de Dormir')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(14, 4, 'Mar Morto')");
				st.addBatch(
						"INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(15, 4, 'Dona Flor e Seus Dois Maridos')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(16, 4, 'Capitaes de Areia')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(17, 5, 'Sentimento do Mundo')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(18, 5, 'A Rosa do Povo')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(19, 5, 'Contos de Aprendiz')");
				st.addBatch("INSERT INTO Livros20170184(Id, AutorId, Titulo) VALUES(20, 5, 'Antologia Poetica')");

				int counts[] = st.executeBatch();

				System.out.println("Dados adicionados ao banco: " + counts.length);
			}
//			Query que pega os dados do banco
			String sql = "SELECT A.Nome, B.Titulo FROM Autores20170184 A, Livros20170184 B "
					+ "WHERE A.Id = B.AutorId";
//			Autoclose
			try (PreparedStatement pst = con.prepareStatement(sql)) {
//				Autoclose
				try (ResultSet rs = pst.executeQuery()) {
					
//					Pegando metadata
					ResultSetMetaData meta = rs.getMetaData();

					String col1 = meta.getColumnName(1);
					String col2 = meta.getColumnName(2);

					Formatter fmt1 = new Formatter();
					fmt1.format("%-45s%s", col1, col2);
					System.out.println(fmt1);

					while (rs.next()) {
						Formatter fmt2 = new Formatter();
						fmt2.format("%-45s", rs.getString(1));
						System.out.print(fmt2);
						System.out.println(rs.getString(2));
					};
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
