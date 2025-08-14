package lab7;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void testGetQuickRecipesReturnsEmptyListIfNoData() {
        var recipes = Main.getQuickRecipes(List::of);
        assertEquals(0, recipes.size());
    }

    @Test
    void testGetQuickRecipesReturnsEmptyListIfNoQuickRecipes() {
        var recipes = Main.getQuickRecipes(() -> List.of(
                new Recipe(0, "", "", "", 4, 10, 10, 16),
                new Recipe(1, "", "", "", 4, 10, 10, 20),
                new Recipe(2, "", "", "", 4, 10, 10, 200)
        ));
        assertEquals(0, recipes.size());
    }

    @Test
    void testGetQuickRecipesReturnsAllRecipesIfAllQuick() {

        var recipes = Main.getQuickRecipes(() -> List.of(
                new Recipe(0, "", "", "", 4, 10, 10, 15),
                new Recipe(1, "", "", "", 4, 10, 10, 1),
                new Recipe(2, "", "", "", 4, 10, 10, 10)
        ));

        assertEquals(3, recipes.size());
    }

    @Test
    void testGetQuickRecipesWorksOnTypicalData() {

        var recipes = Main.getQuickRecipes(() -> List.of(
                        new Recipe(0, "", "", "", 4, 10, 10, 10),
                        new Recipe(1, "", "", "", 4, 10, 10, 15),
                        new Recipe(2, "", "", "", 4, 10, 10, 16),
                        new Recipe(3, "", "", "", 4, 10, 10, 20),
                        new Recipe(4, "", "", "", 4, 10, 10, 2343)
        ));

        assertEquals(2, recipes.size());

        // Verify that the two recipes we expected are in fact in the list
        assertEquals(0, recipes.get(0).id());
        assertEquals(1, recipes.get(1).id());
    }

    // TODO: test the searchRecipes method
    @Test
    void testSearchRecipesByName() {
        var recipes  = Main.searchRecipes(() -> List.of(
                new Recipe(1, "Chicken Soup", "A basic soup", "", 4, 10, 20, 30),
                new Recipe(2, "Beef Stew", "A hearty stew", "", 6, 15, 120, 135)
        ), "Chicken");

        assertEquals(1, recipes.size());
        assertEquals("Chicken Soup", recipes.get(0).name());
    }

    @Test
    void testSearchRecipesNameCaseInsensitive(){
        var recipes = Main.searchRecipes(() -> List.of(
                new Recipe(1, "CHICKEN Soup", "A basic soup", "", 4, 10, 20, 30),
                new Recipe(2, "Beef Stew", "A hearty stew", "", 6, 15, 120, 135)
        ), "chicken");
        assertEquals(1, recipes.size());
        assertEquals("CHICKEN Soup", recipes.get(0).name());
    }

    @Test
    void testSearchMatchesInNameAndDescription(){
        var recipes  = Main.searchRecipes(() -> List.of(
                new Recipe(1, "Chicken Soup", "A chicken based soup", "", 4, 10, 20, 30),
                new Recipe(2, "Beef with chicken", "Contains chicken stock", "", 6, 15, 120, 135)
        ), "chicken");
    }
}