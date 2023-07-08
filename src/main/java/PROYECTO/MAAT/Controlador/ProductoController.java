package PROYECTO.MAAT.Controlador;

import PROYECTO.MAAT.Entidades.Producto;
import PROYECTO.MAAT.Entidades.Usuario;
import PROYECTO.MAAT.Servicio.SerProducto;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/productos")
public class ProductoController {

    private final Logger LOGGER = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private SerProducto serProducto;

    @GetMapping("")
    public String show(Model model) {
        model.addAttribute("productos", serProducto.findAll());
        return "productos/show";
    }

    @GetMapping("/create")
    public String create(){
        return "productos/create";
    }

    @PostMapping("/save")
    public String save(Producto producto){
        LOGGER.info("Este es el objeto producto {}", producto);
        Usuario u = new Usuario(1, "", "", "", "", "", "", "");
        producto.setUsuario(u);
        serProducto.save(producto);
        return "redirect:/productos";
    }

    @GetMapping("/edit/{id}")
    public String  edit(@PathVariable Integer id, Model model){
        Producto producto = new Producto();
        Optional<Producto> optionalProducto = serProducto.get(id);
        producto = optionalProducto.get();

        LOGGER.info("Producto Buscado {}", producto);
        model.addAttribute("producto", producto);

        return "productos/edit";
    }

    @PostMapping("/update")
    public String update(Producto producto){
        serProducto.update(producto);
        return "redirect:/productos";
    }
}
