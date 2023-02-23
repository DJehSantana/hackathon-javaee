package com.stefanini.repository;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.NoResultException;
import com.stefanini.dao.GenericDAO;
import com.stefanini.model.Usuario;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<Usuario, Long> {
    public Usuario buscarPorLogin(String login) {
        try {
            return this.createQuery("SELECT u FROM usuario u WHERE u.login = login").setParameter("login", login)
                    .getSingleResult();

        } catch (NoResultException e) {
            return null;
        }
    }

    public List<Usuario> listarPorMesNascimento(int month) {
        return this.createQuery("SELECT u from usuario u WHERE month(u.dataNascimento) = :month")
                .setParameter("month", month).getResultList();
    }
}
