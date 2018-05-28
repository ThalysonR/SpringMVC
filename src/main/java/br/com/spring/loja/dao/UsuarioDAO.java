package br.com.spring.loja.dao;

import br.com.spring.loja.models.Usuario;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UsuarioDAO {

    @PersistenceContext
    private EntityManager manager;

    public Usuario find(String email) {
        List<Usuario> usuarios = manager.createQuery("SELECT u FROM Usuario WHERE u.email = :email")
                .setParameter("email", email)
                .getResultList();

        if (usuarios.isEmpty()) {
            throw new RuntimeException("Usuário " + email + " não foi encontrado");
        }

        return usuarios.get(0);
    }
}
