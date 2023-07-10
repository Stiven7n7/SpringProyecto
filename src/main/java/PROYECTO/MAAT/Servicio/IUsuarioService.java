package PROYECTO.MAAT.Servicio;

import PROYECTO.MAAT.Entidades.Usuario;

import java.util.Optional;

public interface IUsuarioService {
    Optional<Usuario> findById(Integer id);
}
