package PROYECTO.MAAT.Controlador;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/Distribuidor")
public class DistribuidorController {

    @GetMapping("")
    public String home(){
        return "Distribuidor/home";
    }




}
