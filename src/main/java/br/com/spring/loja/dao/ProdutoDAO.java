package br.com.spring.loja.dao;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import br.com.spring.loja.models.TipoPreco;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.spring.loja.models.Produto;

@Repository
@Transactional
public class ProdutoDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public void gravar(Produto produto) {
		manager.persist(produto);
	}

	public List<Produto> listar() {
		return manager.createQuery("select DISTINCT(p) from Produto p JOIN FETCH p.precos", Produto.class)
				.getResultList();
	}

	public Produto find(Integer id) {
        return manager.createQuery("select distinct(p) from Produto p join fetch p.precos precos where p.id = :id", Produto.class).setParameter("id", id).getSingleResult();
	}

	public BigDecimal somaPrecosPorTipoPreco(TipoPreco tipoPreco) {
		TypedQuery<BigDecimal> query = manager.createQuery("SELECT SUM(preco.valor) FROM Produto p " +
				"JOIN p.precos preco where preco.tipo = :tipoPreco", BigDecimal.class);
		query.setParameter("tipoPreco", tipoPreco);

		return query.getSingleResult();
	}

	public BigDecimal somaPrecosPorTipoPrecoString(TipoPreco tipoPreco) {
		TypedQuery<BigDecimal> query = manager.createQuery("SELECT SUM(preco.valor) FROM Produto p " +
				"JOIN p.precos preco where preco.tipo = :tipoPreco", BigDecimal.class);
		query.setParameter("tipoPreco", tipoPreco.name());

		return query.getSingleResult();
	}
}