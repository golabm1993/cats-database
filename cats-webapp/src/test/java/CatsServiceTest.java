import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import pl.kobietydokodu.catsdatabase.dao.CatRepository;
import pl.kobietydokodu.catsdatabase.dto.CatDTO;
import pl.kobietydokodu.catsdatabase.model.Cat;
import pl.kobietydokodu.service.CatsService;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class CatsServiceTest {

    private CatsService catsService;

    private CatRepository catRepository;

    @Before
    public void init() {
        catRepository = Mockito.mock(CatRepository.class);
        catsService = new CatsService(catRepository);
    }

    @Test
    public void shouldSaveCat() {

        // given
        CatDTO catDTO1 = new CatDTO();
        catDTO1.setName("CatName");
        catDTO1.setDateOfBirth("11.11.2018");
//        catDTO1.setWeight(1.0f);
        catDTO1.setKeeper("CatKeeper");

        Cat cat = new Cat();
        cat.setName("CatName");
        cat.setDateOfBirth("11.11.2018");
//        cat.setWeight(1.0f);
        cat.setKeeper("CatKeeper");

        Mockito.when(catRepository.save(Mockito.any())).thenReturn(cat);

        // when
        CatDTO catDTO = catsService.createNewCat(catDTO1);

        // then
        Assert.assertEquals(catDTO.getName(), "CatName");
        Assert.assertEquals(catDTO.getDateOfBirth(), "11.11.2018");
//        Assert.assertSame(catDTO.getWeight(), 1.0f);
        Assert.assertEquals(catDTO.getKeeper(), "CatKeeper");
    }

    @Test
    public void shouldReturnListOfCats() {
        // given
        Iterable<Cat> listOfCats = Arrays.asList(new Cat(), new Cat(), new Cat());
        Mockito.when(catRepository.findAll()).thenReturn(listOfCats);

        // when
        List<Cat> result = catsService.getAllCats();

        // then
        Assert.assertEquals(result.size(), 3);
    }

    @Test
    public void shouldReturnACat() {
        Cat cat = new Cat();
        cat.setId(3);
        Mockito.when(catRepository.findById(3)).thenReturn(Optional.ofNullable(cat));

        Cat cat1 = catsService.getCat(String.valueOf(3));

        Assert.assertEquals(cat1, cat);
    }

    @Test
    public void shouldReturnNull() {
//        Cat cat = new Cat();
//        cat.setId(3);
//        Mockito.when(catRepository.findById(3)).thenReturn(Optional.ofNullable(cat));
        Cat cat1 = catsService.getCat(String.valueOf(2));
        Assert.assertNull(cat1);
    }
}
