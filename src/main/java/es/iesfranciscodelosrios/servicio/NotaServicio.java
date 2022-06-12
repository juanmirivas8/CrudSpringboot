package es.iesfranciscodelosrios.servicio;

import es.iesfranciscodelosrios.entidad.Nota;
import es.iesfranciscodelosrios.repositorio.NotaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class NotaServicio {

    //Obligatorio repositorio en el servicio
    @Autowired
    private NotaRepositorio repositorio;
    public List<Nota> getAll(){
        return repositorio.findAll();
    }
    public Nota insertNota(Nota n){
        return repositorio.save(n);
    }

    public Nota getNotaByID(Long id){
        return repositorio.findById(id).get();
    }
    public Nota actualizarNota(Nota n){
        return repositorio.save(n);
    }
    /*public void deleteNota(Long id){
        repositorio.deleteById(id);
    }*/

    public void deleteNota(Long id){
        repositorio.deleteById(id);
    }
}
