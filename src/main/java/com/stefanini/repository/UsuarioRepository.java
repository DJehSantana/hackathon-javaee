package com.stefanini.repository;

import javax.enterprise.context.ApplicationScoped;

import com.stefanini.dao.GenericDAO;
import com.stefanini.model.Usuario;

@ApplicationScoped
public class UsuarioRepository extends GenericDAO<Usuario, Long> {

}
