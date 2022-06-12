package es.iesfranciscodelosrios.controlador;


import es.iesfranciscodelosrios.entidad.Nota;
import es.iesfranciscodelosrios.servicio.NotaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NotaControlador {

    @Autowired
    private NotaServicio servicio;

    @GetMapping({"/","notas"})
    public String listarNotas(Model model){
        model.addAttribute("allNotas",servicio.getAll());
        return "notas";
    }

    @GetMapping("/nuevaNota")
    public String nuevaNota(Model model){
        model.addAttribute("notaNueva",new Nota());
        return "nuevaNota";
    }

    @PostMapping("/postNota")
    public String addNota(@ModelAttribute("notaNueva")Nota n){
        servicio.insertNota(n);
        return "redirect:notas";
    }

    @GetMapping("/editar/{id}")
    public String editarNota(@PathVariable("id") Long id,Model model){
        model.addAttribute("nota",servicio.getNotaByID(id));
        return "editarNota";
    }

    @PostMapping("/notaEditada/{id}")
    public String actualizarNota(@PathVariable("id") Long id, @ModelAttribute("nota")Nota n){
        Nota note = servicio.getNotaByID(id);
        note.setId(id);
        note.setTexto(n.getTexto());
        note.setTitulo(n.getTitulo());
        servicio.actualizarNota(note);
        return "redirect:/notas";
    }

    @PostMapping ("/delete/{id}")
    public String eliminarNota(@PathVariable("id") Long id){
        servicio.deleteNota(id);
        return"redirect:/notas";
    }
}
