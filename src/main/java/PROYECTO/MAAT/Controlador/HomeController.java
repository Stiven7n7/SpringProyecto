package PROYECTO.MAAT.Controlador;

import PROYECTO.MAAT.Entidades.DetalleOrden;
import PROYECTO.MAAT.Entidades.Orden;
import PROYECTO.MAAT.Entidades.Producto;
import PROYECTO.MAAT.Servicio.SerProducto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/")
public class HomeController {

    private final Logger log = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private SerProducto serProducto;

    List<DetalleOrden> detalles = new ArrayList<DetalleOrden>();

    Orden orden = new Orden();

    @GetMapping("")
    public String home(Model model){

        model.addAttribute("productos", serProducto.findAll());
        return "Usuario/home";
    }

    @GetMapping("productohome/{id}")
    public String productoHome(@PathVariable Integer id, Model model){
        log.info("Id enviado como parametro {}", id);
        Producto producto = new Producto();
        Optional<Producto> productoOptional = serProducto.get(id);
        producto = productoOptional.get();

        model.addAttribute("producto", producto);

        return "Usuario/productohome";
    }

    @PostMapping("/cart")
    public String addCart(@RequestParam Integer id, @RequestParam Integer cantidad, Model model){
        DetalleOrden detalleOrden = new DetalleOrden();
        Producto producto = new Producto();
        double sumaTotal = 0;

        Optional<Producto> optionalProducto = serProducto.get(id);
        log.info("Producto añadido {}", optionalProducto.get());
        log.info("Cantidad: {}", cantidad);
        producto=optionalProducto.get();

        detalleOrden.setCantidad(cantidad);
        detalleOrden.setPrecio(producto.getPrecio());
        detalleOrden.setNombre(producto.getNombre());
        detalleOrden.setTotal(producto.getPrecio()*cantidad);
        detalleOrden.setProducto(producto);

        Integer idProducto = producto.getId();
        boolean ingresado = detalles.stream().anyMatch(p -> p.getProducto().getId()==idProducto);

        if (!ingresado){
            detalles.add(detalleOrden);
        }

        sumaTotal=detalles.stream().mapToDouble(dt->dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "Usuario/carrito";
    }

    @GetMapping("/delete/cart/{id}")
    public String deleteProductoCart(@PathVariable Integer id, Model model){
        List<DetalleOrden> ordenesNueva = new ArrayList<DetalleOrden>();

        for (DetalleOrden detalleOrden: detalles){
            if (detalleOrden.getProducto().getId()!=id){
                ordenesNueva.add(detalleOrden);
            }
        }
        detalles=ordenesNueva;

        double sumaTotal=0;
        sumaTotal=detalles.stream().mapToDouble(dt->dt.getTotal()).sum();

        orden.setTotal(sumaTotal);
        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "Usuario/carrito";
    }

    @GetMapping("/getCart")
    public String getCart(Model model){

        model.addAttribute("cart", detalles);
        model.addAttribute("orden", orden);

        return "/Usuario/carrito";
    }
}
