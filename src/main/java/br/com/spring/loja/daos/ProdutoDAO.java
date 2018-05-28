package br.com.spring.loja.daos;

import br.com.spring.loja.models.Produto;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
@Transactional
public class ProdutoDAO {

    @PersistenceContext
    private EntityManager manager;

    public void gravar(Produto produto) {
        manager.persist(produto);
    }

    public List<Produto> lista() {
        String jpql = "SELECT p FROM Produto p";
        TypedQuery<Produto> query = manager.createQuery(jpql, Produto.class);
        return query.getResultList();
    }
}
