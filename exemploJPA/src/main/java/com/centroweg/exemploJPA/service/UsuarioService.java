package com.centroweg.exemploJPA.service;

import com.centroweg.exemploJPA.model.Usuario;
import com.centroweg.exemploJPA.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public Usuario criarUsuario(Usuario usuario){
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> listarUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarPorId(Long id){
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não existe"));
    }

    public Usuario atualizarUsuarioPorId(Long id, Usuario usuario){
        Usuario usuarioSalvo = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não existe"));

        usuarioSalvo.setNome(usuario.getNome());
        return usuarioRepository.save(usuarioSalvo);
    }

    public void deletarUsuarioPorId(Long id){
        if (usuarioRepository.existsById(id)){
            usuarioRepository.deleteById(id);
        }

        throw new RuntimeException("Usuário não existe");
    }
}
