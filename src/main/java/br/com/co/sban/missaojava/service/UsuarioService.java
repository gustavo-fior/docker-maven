package br.com.co.sban.missaojava.service;

import br.com.co.sban.missaojava.model.Usuario;
import br.com.co.sban.missaojava.model.input.UsuarioForm;
import br.com.co.sban.missaojava.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Optional<Usuario> getById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);

        return usuario;
    }

    public List<Usuario> getAll() {
        List<Usuario> usuarios = usuarioRepository.findAll();

        return usuarios;
    }

    public void save(Usuario usuario) {

        usuarioRepository.save(usuario);
    }

    public void deleteById(Long id) {
        usuarioRepository.deleteById(id);
    }

    public void update(Usuario usuario, UsuarioForm usuarioForm) {

        usuario.setCpf(usuarioForm.getCpf());
        usuario.setNome(usuarioForm.getNome());
        usuario.setSobreNome(usuarioForm.getSobreNome());
        usuario.setEmail(usuarioForm.getEmail());
        usuario.setDataNascimento(LocalDate.parse(usuarioForm.getDataNascimento()));

        usuarioRepository.save(usuario);

    }
}
