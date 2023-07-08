package PROYECTO.MAAT.Servicio;

import PROYECTO.MAAT.Entidades.Producto;

import java.util.Optional;

public interface SerProducto {
    public Producto save(Producto producto);
    public Optional <Producto> get(Integer id);
    public void update (Producto producto);
    public void delete (Integer id);
}
