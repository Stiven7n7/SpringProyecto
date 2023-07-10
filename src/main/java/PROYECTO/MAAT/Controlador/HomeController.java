package PROYECTO.MAAT.Controlador;

import PROYECTO.MAAT.Servicio.SerProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private SerProducto serProducto;

    @GetMapping("")
    public String home(Model model){

        model.addAttribute("productos", serProducto.findAll());
        return "Usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id){
        log.info("Id enviado como parametro {}", id);
        return "Usuario/productohome";
    }
}
