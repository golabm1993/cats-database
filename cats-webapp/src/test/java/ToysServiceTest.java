import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.kobietydokodu.catsdatabase.dao.CatRepository;
import pl.kobietydokodu.catsdatabase.dao.ToyRepository;
import pl.kobietydokodu.catsdatabase.dto.ToyDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.catsdatabase.model.Toy;
import pl.kobietydokodu.service.CatsService;
import pl.kobietydokodu.service.ToysService;

import java.util.Arrays;
import java.util.List;

import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

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

        // given
        Cat cat = new Cat();
        cat.setName("CatName");
        cat.setDateOfBirth("11.11.2018");
        cat.setKeeper("CatKeeper");
        cat.setId(1);

        ToyDTO toyDTO = new ToyDTO();
        toyDTO.setName("ToyName");
        toyDTO.setAmount(1);

        Toy toy = new Toy();
        toy.setName("ToyName");
        toy.setAmount(1);

        when(toyRepository.save(any())).thenReturn(toy);

        // when
        ToyDTO toyDTO1 = toysService.createNewToy(toyDTO, valueOf(cat.getId()));

        // then
        assertEquals(toyDTO1.getName(), "ToyName");
        assertSame(toyDTO1.getAmount(), 1);
    }

    @Test
    public void shouldReturnListOfToys() {

        // given
        Iterable<Toy> listOfToys = Arrays.asList(new Toy(), new Toy(), new Toy());
        when(toyRepository.findAll()).thenReturn(listOfToys);

        // when
        List<Toy> result = toysService.getAllToys();

        // then
        assertEquals(result.size(), 3);
    }

    @Test
    public void shouldDeleteToy() {
        // given
        String value = "2";

        // when
        toysService.deleteToy(value);

        // then
        verify(toyRepository).deleteById(2);
    }
}
