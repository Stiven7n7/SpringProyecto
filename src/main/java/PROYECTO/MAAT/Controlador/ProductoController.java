package PROYECTO.MAAT.Controlador;

import PROYECTO.MAAT.Entidades.Producto;
import PROYECTO.MAAT.Entidades.Usuario;
import PROYECTO.MAAT.Servicio.SerProducto;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
}