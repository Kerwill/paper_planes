package fr.sopra.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import fr.sopra.model.Categorie;
import fr.sopra.model.Origami;
import fr.sopra.projection.OrigamiProjection;

@CrossOrigin("*")
@RepositoryRestResource(excerptProjection = OrigamiProjection.class)
public interface IDAOOrigami extends JpaRepository<Origami, Integer> {

	@RestResource(path = "by-nom")
	public List<Origami> findByNomOrderByNom(@Param("nom") String nom);

	@RestResource(path = "by-nom-containing")
	public List<Origami> findByNomContaining(@Param("nom") String nom);

//	@RestResource(path = "by-categorie")
//	public List<Origami> findByCategorieNom(@Param("categorie") String nom);


//@RestResource(path="by-filtre")
//@Query(value = "SELECT o FROM Origami o"
//		+ "WHERE o.name LIKE '%:filtreRecherche' "
//		+ "AND :selectedCategorie MEMBER OF o.categories"
//		+ "AND"
//		+ "((o.niveau = Occasionnel) IS :isOccasionnel OR (o.niveau = Normal) IS :isNormal OR (o.niveau = Avance) IS :isAvance OR (o.niveau = Expert) IS :isExpert")
//public List<Origami> findByFiltration(@Param("filtreRecherche") String filtreRecherche,@Param("selectedCategories") Categorie selectedCategorie, @Param("isOccasionnel") Boolean isOccasionnel,
//		@Param("isNormal") Boolean isNormal, @Param("isAvance") Boolean isAvance, @Param("isExpert") Boolean isExpert);

}