package fr.sopra.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Origami;
import fr.sopra.projection.OrigamiProjection;


@CrossOrigin("*")
@RepositoryRestResource(excerptProjection = OrigamiProjection.class)
public interface IDAOOrigami extends JpaRepository<Origami, Integer> {

	@RestResource(path = "by-nom")
	public List<Origami> findByNomOrderByNom(@Param("nom") String nom);

//	@RestResource(path = "by-nom-containing")
//	public List<Origami> findByNomContaining(@Param("nom") String nom);
	public Optional<Origami> findByNom(@Param("nom") String nom);

//	@RestResource(path = "by-categorie")
//	public List<Origami> findByCategoriesId(@Param("id") int id);

@RestResource(path="by-nom-containing")
public List<Origami> findByNomContaining(@Param("nom") String nom);





@RestResource(path="by-filtre")
@Query(value = "SELECT distinct o FROM Origami o "
		+ "LEFT JOIN o.categories c "
		+ "WHERE o.nom LIKE CONCAT('%', :filtreRecherche, '%') "
		+ "AND (:selectedCategorieId = 0 OR c.id = :selectedCategorieId) "
		+ "AND "
		+ "((:isOccasionnel = FALSE AND :isNormal = FALSE AND :isAvance = FALSE AND :isExpert = FALSE) OR (o.niveau = 0 AND :isOccasionnel = TRUE) OR (o.niveau = 1 AND :isNormal = TRUE) OR (o.niveau = 2 AND :isAvance = TRUE) OR (o.niveau = 3 AND :isExpert = TRUE))")
public List<Origami> findByFiltration(@Param("filtreRecherche") String filtreRecherche,@Param("selectedCategorieId") int selectedCategorieId,
		@Param("isOccasionnel") Boolean isOccasionnel, @Param("isNormal") Boolean isNormal, @Param("isAvance") Boolean isAvance, @Param("isExpert") Boolean isExpert);
		

}