package com.stefanini.service;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.*;
import java.util.stream.Collectors;

import com.stefanini.dto.UsuarioDTO;
import com.stefanini.model.Usuario;
import com.stefanini.repository.UsuarioRepository;

@ApplicationScoped
public class UsuarioService {

    @Inject
    private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> getAll() {
        return usuarioRepository.listAll().stream().map(usuario -> new UsuarioDTO(usuario))
                .collect(Collectors.toList());
    }

    public UsuarioDTO getById(Long id) {
        Usuario usuario = usuarioRepository.findById(id);
        if (!Objects.nonNull(usuario)) {
            return null;
        }
        return new UsuarioDTO(usuario);
    }

    public void delete(Long id) {
        usuarioRepository.delete(id);
    }

    public UsuarioDTO save(Usuario usuario) {
        usuarioRepository.save(usuario);
        return new UsuarioDTO(usuario);
    }

    public UsuarioDTO update(Usuario usuario) {
        Usuario usuarioOriginal = usuarioRepository.findById(usuario.getId());

        if (!Objects.nonNull(usuarioOriginal)) {
            return null;
        }

        Usuario usuarioAtualizado = usuarioRepository.update(usuario);

        return new UsuarioDTO(usuarioAtualizado);
    }

    public List<UsuarioDTO> getAllUsersFromBirthdayMonth(int month) {

        return usuarioRepository.listarPorMesNascimento(month).stream().map(usuario -> new UsuarioDTO(usuario))
                .collect(Collectors.toList());
    }

}
