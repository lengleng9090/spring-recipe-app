package guru.springframework.services;

import guru.springframework.domain.Recipe;
import guru.springframework.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecipesServiceImplTest {

    RecipesServiceImpl recipesService;

    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        recipesService = new RecipesServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {

        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        Mockito.when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipesService.getRecipes();

        assertEquals(1, recipes.size());
        Mockito.verify(recipeRepository, Mockito.times(1)).findAll();
    }
}