import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.kobietydokodu.catsdatabase.dao.CatRepository;
import pl.kobietydokodu.catsdatabase.dao.ToyRepository;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.dto.ToyDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.catsdatabase.model.Toy;
import pl.kobietydokodu.service.CatsService;
import pl.kobietydokodu.service.ToysService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ToysServiceTest {

    private ToysService toysService;
    private CatsService catsService;

    private ToyRepository toyRepository;
    private CatRepository catRepository;

    @Before
    public void init() {
        toyRepository = Mockito.mock(ToyRepository.class);
        catRepository = Mockito.mock(CatRepository.class);
        catsService = new CatsService(catRepository);
        toysService = new ToysService(toyRepository, catRepository);
    }

    @Test
    public void shouldSaveToy() {

        Cat cat = new Cat();
        cat.setName("CatName");
        cat.setDateOfBirth("11.11.2018");
//        cat.setWeight(1.0f);
        cat.setKeeper("CatKeeper");
        cat.setId(1);

        // given
        ToyDTO toyDTO = new ToyDTO();
        toyDTO.setName("ToyName");
        toyDTO.setAmount(1);

        Toy toy = new Toy();
        toy.setName("ToyName");
        toy.setAmount(1);

        Mockito.when(toyRepository.save(Mockito.any())).thenReturn(toy);

        // when
        ToyDTO toyDTO1 = toysService.createNewToy(toyDTO, String.valueOf(cat.getId()));

        // then
        Assert.assertEquals(toyDTO1.getName(), "ToyName");
        Assert.assertSame(toyDTO1.getAmount(), 1);
    }

    @Test
    public void shouldReturnListOfToys() {

        // given
        Iterable<Toy> listOfToys = Arrays.asList(new Toy(), new Toy(), new Toy());
        Mockito.when(toyRepository.findAll()).thenReturn(listOfToys);

        // when
        List<Toy> result = toysService.getAllToys();

        // then
        Assert.assertEquals(result.size(), 3);
    }

//    @Test
//    public void shouldDeleteToy() {
//
//        // given
//        CatDTO catDTO1 = new CatDTO();
//        catDTO1.setName("CatName");
//        catDTO1.setDateOfBirth("11.11.2018");
////        catDTO1.setWeight(1.0f);
//        catDTO1.setKeeper("CatKeeper");
//
//        Cat cat = new Cat();
//        cat.setId(1);
//        cat.setName("CatName");
//        cat.setDateOfBirth("11.11.2018");
////        cat.setWeight(1.0f);
//        cat.setKeeper("CatKeeper");
//
//        Mockito.when(catRepository.save(Mockito.any())).thenReturn(cat);
//        catsService.createNewCat(catDTO1);
//
//        Toy toy = new Toy();
//        toy.setId(cat.getId());
//        toy.setName("ToyName");
//        toy.setAmount(1);
//        toy.setCat(cat);
//        ToyDTO toyDTO = new ToyDTO();
//        toyDTO.setId(5);
//        toyDTO.setName("ToyName");
//        toyDTO.setAmount(1);
//        toyDTO.setCat(cat);
//
//        Mockito.when(toyRepository.save(Mockito.any())).thenReturn(toy);
//        toysService.createNewToy(toyDTO, String.valueOf(cat.getId()));
//
//        // when
////        toysService.deleteToy(String.valueOf(5));
//
//        System.out.println(toyRepository.count());
//        System.out.println(toysService.getAllToys().size());
//
//        // then
//        Assert.assertEquals(toyRepository.findById(5), Optional.empty());
//    }
}
