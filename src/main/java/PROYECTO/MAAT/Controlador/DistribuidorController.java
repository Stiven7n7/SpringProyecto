package PROYECTO.MAAT.Controlador;


import PROYECTO.MAAT.Entidades.Producto;
import PROYECTO.MAAT.Servicio.SerProducto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/Distribuidor")
public class DistribuidorController {

    @Autowired
    private SerProducto serProducto;

    @GetMapping("")
    public String home(Model model){

        List<Producto> productos = serProducto.findAll();
        model.addAttribute("productos", productos);
        return "Distribuidor/home";
    }




}
