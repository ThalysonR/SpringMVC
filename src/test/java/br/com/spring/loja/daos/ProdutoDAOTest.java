package br.com.spring.loja.daos;

import br.com.spring.loja.builders.ProdutoBuilder;
import br.com.spring.loja.conf.DataSourceConfigurationTest;
import br.com.spring.loja.conf.JPAConfiguration;
import br.com.spring.loja.dao.ProdutoDAO;
import br.com.spring.loja.models.Produto;
import br.com.spring.loja.models.TipoPreco;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {JPAConfiguration.class, ProdutoDAO.class, DataSourceConfigurationTest.class})
@ActiveProfiles("test")
public class ProdutoDAOTest {

    @Autowired
    private ProdutoDAO produtoDAO;

    @Test
    @Transactional
    public void deveSomarTodosPrecosPorTipoPreco() {

        List<Produto> livrosImpressos = ProdutoBuilder.newProduto(TipoPreco.IMPRESSO, BigDecimal.TEN).more(3).buildAll();

        List<Produto> livrosEbook = ProdutoBuilder.newProduto(TipoPreco.EBOOK, BigDecimal.TEN).more(3).buildAll();

        livrosImpressos.stream().forEach(produtoDAO::gravar);
        livrosEbook.stream().forEach(produtoDAO::gravar);

        BigDecimal preco = produtoDAO.somaPrecosPorTipoPreco(TipoPreco.EBOOK);
        Assert.assertEquals(new BigDecimal(40).setScale(2), preco);
    }
}
