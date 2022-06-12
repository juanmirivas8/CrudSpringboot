package es.iesfranciscodelosrios.repositorio;

import es.iesfranciscodelosrios.entidad.Nota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface NotaRepositorio extends JpaRepository<Nota,Long> {

    @Transactional
    @Modifying
    @Query("delete from Nota n where n.id = :id")
    void deleteById(Long id);
}
