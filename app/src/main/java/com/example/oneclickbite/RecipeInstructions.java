package com.example.oneclickbite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.collect.LinkedHashMultimap;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RecipeInstructions extends AppCompatActivity {

    LinkedHashMultimap<Object, Object> map2 = LinkedHashMultimap.create();
    LinkedHashMultimap<Object, Object> map1 = LinkedHashMultimap.create();
    int i=0;
    List<List<String>> urls = new ArrayList<>();
    List<String> urlList = new ArrayList<>();
    TextView heading;
    Button button1, button2, button3, button4, button5;
    Button[] buttons = new Button[] {button1, button2, button3, button4, button5};

    String food;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_instructions);

        heading = findViewById(R.id.heading);
//        button1 = findViewById(R.id.button1);
//        button2 = findViewById(R.id.button2);
//        button3 = findViewById(R.id.button3);
//        button4 = findViewById(R.id.button4);
//        button5 = findViewById(R.id.button5);


        Intent iGet = getIntent();

        food = iGet.getStringExtra("foodTag");

        heading.append(" FOR " + food.toUpperCase());

//        Toast.makeText(this, food, Toast.LENGTH_SHORT).show();

        Intent recipeIntent = new Intent(RecipeInstructions.this, RecipeDetail.class);

        buttons[0] = (Button) findViewById(R.id.button1);
        buttons[1] = (Button) findViewById(R.id.button2);
        buttons[2] = (Button) findViewById(R.id.button3);
        buttons[3] = (Button) findViewById(R.id.button4);
        buttons[4] = (Button) findViewById(R.id.button5);

        //Mapping for map1
        map1.put("garlic bread", "garlic bread");
        map1.put("french fries", "french fries");
        map1.put("churros", "churros");
        map1.put("cake", "red velvet cake");
        map1.put("cake", "chocolate cake");
        map1.put("cake", "carrot cake");
        map1.put("cake", "strawberry cake");
        map1.put("cake", "cheesecake");
        map1.put("pasta", "veg spaghetti");
        map1.put("pasta", "non-veg spaghetti");
        map1.put("pasta", "lasagna");
        map1.put("pasta", "mac and cheese");
        map1.put("tacos", "tacos");
        map1.put("spring rolls", "spring rolls");
        map1.put("chicken wings", "chicken wings");
        map1.put("chicken curry", "chicken curry");
        map1.put("bruschetta", "bruschetta");
        map1.put("salad", "greek salad");
        map1.put("salad", "caprese salad");
        map1.put("salad", "caesar salad");
        map1.put("dumplings", "dumplings");
        map1.put("falafel", "falafel");
        map1.put("macarons", "macarons");
        map1.put("donuts", "donuts");
        map1.put("soup", "hot and sour soup");
        map1.put("soup", "other soups");
        map1.put("apple pie", "apple pie");
        map1.put("burger", "burger");
        map1.put("fish", "fish");
        map1.put("sandwich", "sandwich");
        map1.put("ramen", "ramen");
        map1.put("burrito", "burrito");
        map1.put("omelette", "omelette");
        map1.put("pancakes", "pancakes");
        map1.put("french toast", "french toast");
        map1.put("onion rings", "onion rings");
        map1.put("pizza", "margherita pizza");
        map1.put("pizza", "veggie pizza");
        map1.put("pizza", "chicken pizza");
        map1.put("waffles", "waffles");
        map1.put("fried rice", "fried rice");
        map1.put("cupcakes", "cupcakes");
        map1.put("sushi", "sushi");
        map1.put("samosa", "samosa");
        map1.put("tiramisu", "tiramisu");
        map1.put("hot dog", "hot dog");
        map1.put("ice cream", "chocolate ice cream");
        map1.put("ice cream", "strawberry ice cream");
        map1.put("ice cream", "vanilla ice cream");
        map1.put("ice cream", "other flavors");


        //garlic bread links-->
        urlList.add("https://natashaskitchen.com/garlic-bread-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a24803098/easy-garlic-bread-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a49850/cheesy-garlic-pull-apart-bread-recipe/");
        urlList.add("https://www.thespruceeats.com/roasted-garlic-bread-for-bread-machime-479038");
        urlList.add("https://www.thespruceeats.com/onion-garlic-bread-427663");
        //french fries links-->
        urlList.add("https://natashaskitchen.com/air-fryer-french-fries/");
        urlList.add("https://www.thespruceeats.com/french-fries-3056165");
        urlList.add("https://www.thespruceeats.com/oven-french-fries-3051061");
        urlList.add("https://www.thespruceeats.com/easy-homemade-truffle-fries-recipe-1375725");
        urlList.add("https://www.allrecipes.com/recipe/50223/homemade-crispy-seasoned-french-fries/");
        //churros links-->
        urlList.add("https://www.allrecipes.com/recipe/24700/churros/");
        urlList.add("https://www.allrecipes.com/recipe/263642/homemade-churros-with-cardamom-and-chocolate/");
        urlList.add("https://www.thespruceeats.com/easy-spanish-churros-recipe-3082995");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a27117110/easy-churros-recipe/");
        urlList.add("https://www.thespruceeats.com/churros-recipe-3029721");
        //red velvet cake links-->
        urlList.add("https://www.lifeloveandsugar.com/nutella-red-velvet-poke-cake/");
        urlList.add("https://www.lifeloveandsugar.com/red-velvet-layer-cake/");
        urlList.add("https://addapinch.com/red-velvet-cake/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a32715827/keto-red-velvet-cake-recipe/");
        urlList.add("https://natashaskitchen.com/red-velvet-cake-recipe/");
        //chocolate cake links-->
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a25351821/keto-chocolate-cake-recipe/");
        urlList.add("https://www.lifeloveandsugar.com/drunken-chocolate-truffle-cake/");
        urlList.add("https://www.lifeloveandsugar.com/oreo-chocolate-poke-cake/");
        urlList.add("https://www.allrecipes.com/recipe/17528/extreme-chocolate-cake/");
        urlList.add("https://www.thespruceeats.com/gluten-free-chocolate-cake-1450964");
        //carrot cake links-->
        urlList.add("https://www.lifeloveandsugar.com/best-carrot-cake-recipe/");
        urlList.add("https://pinchofyum.com/carrot-cake-coffee-cake");
        urlList.add("https://www.thespruceeats.com/best-carrot-cake-482725");
        urlList.add("https://natashaskitchen.com/the-healthier-carrot-cake-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a58283/best-carrot-cake-recipe/");
        //strawberry cake links-->
        urlList.add("https://www.allrecipes.com/recipe/8201/strawberry-shortcake/");
        urlList.add("https://www.allrecipes.com/recipe/8516285/strawberry-crunch-cake/");
        urlList.add("https://www.allrecipes.com/recipe/179358/classic-strawberry-shortcakes/");
        urlList.add("https://www.thespruceeats.com/old-fashioned-strawberry-shortcake-3061349");
        urlList.add("https://www.lifeloveandsugar.com/strawberry-shortcake-cake/");
        //cheesecake links-->
        urlList.add("https://www.allrecipes.com/recipe/13477/double-layer-pumpkin-cheesecake/");
        urlList.add("https://www.thespruceeats.com/maple-walnut-cheesecake-3052576");
        urlList.add("https://natashaskitchen.com/cheesecake-recipe/");
        urlList.add("https://natashaskitchen.com/raspberry-apricot-cheesecake-with-chocolate-crust/");
        urlList.add("https://www.allrecipes.com/recipe/244929/lemon-meringue-cheesecake/");
        //veg spaghetti links-->
        urlList.add("https://pinchofyum.com/spaghetti-with-crispy-zucchini");
        urlList.add("https://pinchofyum.com/roasted-tomato-puttanesca");
        urlList.add("https://www.thespruceeats.com/garlic-spaghetti-aglio-e-olio-recipe-101815");
        urlList.add("https://www.thespruceeats.com/spinach-pesto-sauce-with-spaghetti-3061237");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a22363721/vegetable-spaghetti-pasta-recipe/");
        //non-veg spaghetti links-->
        urlList.add("https://pinchofyum.com/garlic-herb-spaghetti-chicken-meatballs");
        urlList.add("https://www.allrecipes.com/recipe/245775/spaghetti-alla-carbonara-the-traditional-italian-recipe/");
        urlList.add("https://www.allrecipes.com/recipe/232865/loaded-chicken-carbonara/");
        urlList.add("https://www.thespruceeats.com/classic-spaghetti-and-meatballs-3058257");
        urlList.add("https://natashaskitchen.com/spaghetti-and-meatballs-recipe/");
        //lasagna links-->
        urlList.add("https://www.allrecipes.com/recipe/229764/easy-vegetarian-spinach-lasagna/");
        urlList.add("https://www.allrecipes.com/recipe/261026/ultimate-low-carb-zucchini-lasagna/");
        urlList.add("https://natashaskitchen.com/chicken-lasagna-recipe/");
        urlList.add("https://www.thespruceeats.com/vegetable-lasagna-with-alfredo-sauce-3054081");
        urlList.add("https://natashaskitchen.com/lasagna-recipe/");
        //mac n cheese links-->
        urlList.add("https://www.thespruceeats.com/creamy-avocado-mac-and-cheese-4690696");
        urlList.add("https://www.thespruceeats.com/tex-mex-mac-n-cheese-3061022");
        urlList.add("https://www.allrecipes.com/recipe/11679/homemade-mac-and-cheese/");
        urlList.add("https://www.thespruceeats.com/truffled-mac-and-cheese-481870");
        urlList.add("https://www.thespruceeats.com/ham-and-macaroni-bake-with-broccoli-3057442");
        //tacos links-->
        urlList.add("https://pinchofyum.com/caramelized-pork-tacos-with-pineapple-salsa");
        urlList.add("https://pinchofyum.com/crispy-black-bean-tacos-with-cilantro-lime-sauce");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a32687489/breakfast-tacos-recipe/");
        urlList.add("https://natashaskitchen.com/fish-tacos-recipe/");
        urlList.add("https://pinchofyum.com/red-chile-chicken-tacos-with-creamy-corn");
        //spring rolls links-->
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a4257/asian-spring-rolls-recipes/");
        urlList.add("https://natashaskitchen.com/fresh-spring-rolls/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a36691231/disney-pepperoni-pizza-spring-rolls/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a27650/pork-spring-rolls-3194/");
        urlList.add("https://www.allrecipes.com/recipe/149687/thai-chicken-spring-rolls/");
        //chicken wings links-->
        urlList.add("https://www.allrecipes.com/recipe/24087/restaurant-style-buffalo-chicken-wings/");
        urlList.add("https://www.allrecipes.com/recipe/270194/air-fryer-buffalo-chicken-wings/");
        urlList.add("https://natashaskitchen.com/lemon-pepper-wings-recipe/");
        urlList.add("https://www.thespruceeats.com/sesame-chicken-wings-3053262");
        urlList.add("https://www.thespruceeats.com/honey-barbecued-chicken-wings-recipe-3053267");
        //chicken curry links-->
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a54696/easy-indian-chicken-curry-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a34763042/instant-pot-chicken-curry-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a36133/coconut-chicken-curry-recipe-wdy0214/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a34206/brazilian-chicken-curry-recipe-122654/");
        urlList.add("https://www.allrecipes.com/recipe/212721/indian-chicken-curry-murgh-kari/");
        //bruschetta links-->
        urlList.add("https://www.allrecipes.com/recipe/54165/balsamic-bruschetta/");
        urlList.add("https://www.allrecipes.com/recipe/24634/artichoke-bruschetta/");
        urlList.add("https://www.allrecipes.com/recipe/20545/bruschetta-iii/");
        urlList.add("https://www.thespruceeats.com/italian-buttery-garlic-crab-bruschetta-1300497");
        urlList.add("https://www.thespruceeats.com/easy-vegan-bruschetta-recipe-3378349");
        //greek salad links-->
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a54226/best-greek-salad-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a43149265/greek-chickpea-salad-recipe/");
        urlList.add("https://www.thespruceeats.com/classic-greek-salad-3964419");
        urlList.add("https://www.thespruceeats.com/easy-greek-style-barley-salad-3378301");
        urlList.add("https://www.allrecipes.com/recipe/14403/mediterranean-greek-salad/");
        //caprese salad links-->
        urlList.add("https://www.allrecipes.com/recipe/143071/spinach-caprese-salad/");
        urlList.add("https://www.allrecipes.com/recipe/228126/caprese-salad-with-balsamic-reduction/");
        urlList.add("https://www.thespruceeats.com/avocado-tomato-and-mozzarella-salad-recipe-3378346");
        urlList.add("https://www.thespruceeats.com/caprese-salad-tomato-salad-2217097");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a43031793/chicken-avocado-caprese-salad-recipe/");
        //caesar salad links-->
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a19695267/best-caesar-salad-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a40231391/chicken-caesar-salad-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a34373415/brussels-sprouts-caesar-salad-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a47748/crunchy-chickpea-kale-caesar-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a36808/garlic-shrimp-caesar-salad-recipe-ghk1114/");
        //dumplings links-->
        urlList.add("https://www.thespruceeats.com/easy-vegetarian-pumpkin-dumplings-3377134");
        urlList.add("https://www.thespruceeats.com/sticky-rice-dumplings-3217468");
        urlList.add("https://www.thespruceeats.com/jiaozi-chinese-dumplings-694504");
        urlList.add("https://www.thespruceeats.com/har-gow-shrimp-dumplings-recipe-694503");
        urlList.add("https://www.allrecipes.com/recipe/14759/pork-dumplings/");
        //falafel links-->
        urlList.add("https://www.allrecipes.com/recipe/241705/chef-johns-falafel/");
        urlList.add("https://www.thespruceeats.com/what-is-falafel-2355693");
        urlList.add("https://www.thespruceeats.com/sweet-potato-falafel-2355340");
        urlList.add("https://www.thespruceeats.com/beet-falafel-2355749");
        urlList.add("https://www.thespruceeats.com/baked-falafel-recipe-2355687");
        //macarons links-->
        urlList.add("https://www.allrecipes.com/recipe/223232/macarons/");
        urlList.add("https://www.thespruceeats.com/easy-classic-chocolate-macaron-recipe-434873");
        urlList.add("https://www.thespruceeats.com/almond-macarons-recipe-1374962");
        urlList.add("https://natashaskitchen.com/raspberry-macarons-recipe-video-tutorial/");
        urlList.add("https://www.thespruceeats.com/go-to-gluten-free-macaron-recipe-4019326");
        //donuts links-->
        urlList.add("https://natashaskitchen.com/glazed-donuts-recipe/");
        urlList.add("https://natashaskitchen.com/baked-donuts/");
        urlList.add("https://www.delish.com/cooking/nutrition/a27572637/best-keto-donuts-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a29131601/apple-cider-donuts-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a41802692/mochi-donuts-recipe/");
        //hot n sour-->
        urlList.add("https://www.allrecipes.com/recipe/13185/chinese-spicy-hot-and-sour-soup/");
        urlList.add("https://www.allrecipes.com/recipe/80694/hot-and-sour-chicken-soup/");
        urlList.add("https://www.allrecipes.com/recipe/56358/thai-hot-and-sour-soup/");
        urlList.add("https://www.allrecipes.com/recipe/50747/vegan-hot-and-sour-soup/");
        urlList.add("https://www.thespruceeats.com/vegetarian-hot-and-sour-soup-1001181");
        //other soups-->
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a21566440/easy-miso-soup-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a23514357/best-cauliflower-soup-recipe/");
        urlList.add("https://www.allrecipes.com/recipe/13218/absolutely-ultimate-potato-soup/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a21581173/best-cabbage-soup-recipe/");
        urlList.add("https://www.thespruceeats.com/basic-miso-soup-3377886");
        //apple pie links-->
        urlList.add("https://www.allrecipes.com/recipe/12298/apple-crumble-pie/");
        urlList.add("https://www.allrecipes.com/recipe/15683/dutch-apple-pie-with-oatmeal-streusel/");
        urlList.add("https://www.lifeloveandsugar.com/homemade-apple-pie/");
        urlList.add("https://www.allrecipes.com/recipe/54628/easy-swedish-apple-pie/");
        urlList.add("https://www.thespruceeats.com/old-fashioned-gluten-free-apple-pie-1450966");
        //burger links-->
        urlList.add("https://www.thespruceeats.com/indian-style-burger-1957599");
        urlList.add("https://www.thespruceeats.com/sriracha-bacon-burger-333539");
        urlList.add("https://www.allrecipes.com/recipe/25473/the-perfect-basic-burger/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a43122115/smash-burger-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a27423024/lamb-burger-recipe/");
        //fish links-->
        urlList.add("https://natashaskitchen.com/teriyaki-salmon-recipe/");
        urlList.add("https://natashaskitchen.com/baked-salmon-with-garlic-and-dijon/");
        urlList.add("https://www.thespruceeats.com/basic-beer-batter-fish-and-chips-1300586");
        urlList.add("https://www.thespruceeats.com/baked-fish-fillets-with-seasoned-crumb-topping-3057298");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a28414646/air-fryer-fish-recipe/");
        //sandwich links-->
        urlList.add("https://www.thespruceeats.com/cemita-mexican-pulled-pork-sandwich-4042459");
        urlList.add("https://www.thespruceeats.com/chicken-tikka-sandwich-1957615");
        urlList.add("https://www.allrecipes.com/recipe/217267/jalapeno-popper-grilled-cheese-sandwich/");
        urlList.add("https://www.allrecipes.com/recipe/189891/pesto-grilled-cheese-sandwich/");
        urlList.add("https://addapinch.com/caprese-grilled-cheese-sandwich-recipe/");
        //ramen links-->
        urlList.add("https://pinchofyum.com/quick-homemade-ramen");
        urlList.add("https://pinchofyum.com/coconut-curry-ramen");
        urlList.add("https://www.thespruceeats.com/creamy-vegan-miso-butter-ramen-recipe-6754158");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a26258249/homemade-ramen-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a39281830/birria-ramen-recipe/");
        //burrito links-->
        urlList.add("https://www.thespruceeats.com/basic-rice-and-bean-vegetarian-burrito-3377050");
        urlList.add("https://www.thespruceeats.com/beef-and-bean-burritos-3057244");
        urlList.add("https://natashaskitchen.com/breakfast-burrito-recipe/");
        urlList.add("https://www.allrecipes.com/recipe/13954/addictive-sweet-potato-burritos/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a24569400/breakfast-burrito-recipe/");
        //omelette links-->
        urlList.add("https://www.thespruceeats.com/chicken-omelets-4589770");
        urlList.add("https://natashaskitchen.com/perfect-omelette-recipe/");
        urlList.add("https://natashaskitchen.com/bacon-spinach-egg-white-omelette/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a32391934/french-omelette-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a24892843/how-to-make-omelet/");
        //pancakes links-->
        urlList.add("https://www.eitanbernath.com/2020/01/20/easy-chocolate-chip-pancakes/");
        urlList.add("https://addapinch.com/pumpkin-pancakes/");
        urlList.add("https://addapinch.com/perfect-buttermilk-pancake-recipe/");
        urlList.add("https://pinchofyum.com/fluffiest-blueberry-pancakes");
        urlList.add("https://natashaskitchen.com/apple-pancakes/");
        //french toast links-->
        urlList.add("https://addapinch.com/perfect-french-toast-recipe/");
        urlList.add("https://natashaskitchen.com/caramel-french-toast/");
        urlList.add("https://www.thespruceeats.com/basic-french-toast-3056820");
        urlList.add("https://www.thespruceeats.com/creme-brulee-french-toast-1664969");
        urlList.add("https://www.eitanbernath.com/2020/05/03/french-toast-sticks-with-maple-yogurt/");
        //onion rings links-->
        urlList.add("https://addapinch.com/onion-rings-recipe/");
        urlList.add("https://natashaskitchen.com/crisp-onion-rings-recipe/");
        urlList.add("https://www.eitanbernath.com/2020/07/17/onion-bhaji/");
        urlList.add("https://www.thespruceeats.com/oven-fried-onion-rings-recipe-102147");
        urlList.add("https://www.allrecipes.com/recipe/20942/beer-battered-onion-rings/");
        //margheritta pizza links-->
        urlList.add("https://addapinch.com/margherita-pizza-recipe/");
        urlList.add("https://www.eitanbernath.com/2020/08/16/ny-style-margherita-pizza/");
        urlList.add("https://www.allrecipes.com/recipe/133948/four-cheese-margherita-pizza/");
        urlList.add("https://www.allrecipes.com/recipe/222197/authentic-pizza-margherita/");
        urlList.add("https://www.allrecipes.com/recipe/275573/margherita-pizza-with-sausage-and-pesto/");
        //veggie pizza links-->
        urlList.add("https://natashaskitchen.com/homemade-individual-pizzas-and-giveaway/");
        urlList.add("https://natashaskitchen.com/california-pizza-recipe/");
        urlList.add("https://www.eitanbernath.com/2020/11/30/wild-mushroom-white-pizza/");
        urlList.add("https://www.eitanbernath.com/2019/06/03/penne-alla-vodka-pizza/");
        urlList.add("https://www.thespruceeats.com/keto-pizza-5180298");
        //chicken pizza links-->
        urlList.add("https://addapinch.com/chicken-artichoke-pizza-recipe/");
        urlList.add("https://natashaskitchen.com/chicken-pizza-with-creamy-garlic-sauce/");
        urlList.add("https://www.thespruceeats.com/copycat-bbq-chicken-pizza-4684634");
        urlList.add("https://www.allrecipes.com/recipe/23735/buffalo-style-chicken-pizza/");
        urlList.add("https://www.allrecipes.com/recipe/57243/chicken-pesto-pizza/");
        //waffles links-->
        urlList.add("https://addapinch.com/chocolate-chip-waffles/");
        urlList.add("https://www.lifeloveandsugar.com/easy-fluffy-homemade-waffles/");
        urlList.add("https://natashaskitchen.com/whole-wheat-and-blueberry-waffles/");
        urlList.add("https://www.thespruceeats.com/keto-waffles-4777047");
        urlList.add("https://www.thespruceeats.com/red-velvet-waffles-4588906");
        //fried rice links-->
        urlList.add("https://www.lifeloveandsugar.com/quick-and-easy-chicken-fried-rice/");
        urlList.add("https://natashaskitchen.com/shrimp-fried-rice-recipe/");
        urlList.add("https://www.eitanbernath.com/2018/11/26/turkey-fried-rice/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a25325036/how-to-make-fried-rice/");
        urlList.add("https://www.thespruceeats.com/fried-rice-vietnamese-style-3030342");
        //cupcakes links-->
        urlList.add("https://addapinch.com/chocolate-cupcakes-recipe/");
        urlList.add("https://www.lifeloveandsugar.com/mississippi-mud-cupcakes/");
        urlList.add("https://www.lifeloveandsugar.com/strawberries-and-cream-cupcakes/");
        urlList.add("https://www.thespruceeats.com/vegan-pumpkin-cupcakes-1000898");
        urlList.add("https://www.allrecipes.com/recipe/157877/vanilla-cupcake/");
        //sushi links-->
        urlList.add("https://natashaskitchen.com/sushi-rice-and-california-rolls-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a19437/brown-rice-sushi-recipe-del0312/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a57729/greek-sushi-recipe/");
        urlList.add("https://www.thespruceeats.com/tekkamaki-suchi-roll-recipe-2031512");
        urlList.add("https://www.allrecipes.com/recipe/19511/smoked-salmon-sushi-roll/");
        //samosa links-->
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a37224993/samosa-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a33909/curried-beef-pies-samosas-recipe-122384/");
        urlList.add("https://www.thespruceeats.com/easy-vegetable-samosas-recipe-2098695");
        urlList.add("https://www.allrecipes.com/recipe/237027/easy-baked-indian-samosas/");
        urlList.add("https://www.allrecipes.com/recipe/270114/samosadilla-samosa-quesadilla/");
        //tiramisu links-->
        urlList.add("https://www.lifeloveandsugar.com/tiramisu-cheesecake/");
        urlList.add("https://www.lifeloveandsugar.com/oreo-brookie-tiramisu/");
        urlList.add("https://www.lifeloveandsugar.com/tiramisu-cupcakes/");
        urlList.add("https://natashaskitchen.com/berry-tiramisu-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a39578398/raspberry-tiramisu-recipe/");
        //hot dog links-->
        urlList.add("https://www.eitanbernath.com/2021/07/04/el-completo-italiano/");
        urlList.add("https://www.thespruceeats.com/italian-hot-dog-5225454");
        urlList.add("https://www.thespruceeats.com/new-york-hot-dogs-recipe-333560");
        urlList.add("https://www.thespruceeats.com/classic-coney-island-hot-dog-sauce-3057553");
        urlList.add("https://www.allrecipes.com/recipe/134483/chicago-style-hot-dog/");
        //chocolate ice cream links-->
        urlList.add("https://addapinch.com/chocolate-ice-cream-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/a26977162/chocolate-ice-cream-recipe/");
        urlList.add("https://www.thespruceeats.com/classic-chocolate-ice-cream-4057478");
        urlList.add("https://www.allrecipes.com/recipes/16189/desserts/frozen-desserts/ice-cream/chocolate-ice-cream/");
        urlList.add("https://pinchofyum.com/chocolate-banana-naturally-sweet-ice-cream");
        //strawberry ice cream links-->
        urlList.add("https://addapinch.com/strawberry-ice-cream-recipe/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a19844/sophisticated-strawberry-ice-cream-recipe-opr0812/");
        urlList.add("https://www.thespruceeats.com/strawberry-ice-cream-5190417");
        urlList.add("https://www.allrecipes.com/recipe/140877/easy-eggless-strawberry-ice-cream/");
        urlList.add("https://www.lifeloveandsugar.com/strawberry-shortcake-popsicles/");
        //vanilla ice cream links-->
        urlList.add("https://addapinch.com/homemade-vanilla-ice-cream/");
        urlList.add("https://www.delish.com/cooking/recipe-ideas/recipes/a34769/vanilla-ice-cream-caramel-pear-sauce-recipe-clv1012/");
        urlList.add("https://www.thespruceeats.com/dairy-free-vanilla-ice-cream-1001042");
        urlList.add("https://www.allrecipes.com/recipe/233928/how-to-make-vanilla-ice-cream/");
        urlList.add("https://www.eitanbernath.com/2019/08/05/homemade-ish-icecream/");
        //other ice creams-->
        urlList.add("https://addapinch.com/mint-chocolate-chip-ice-cream-recipe/");
        urlList.add("https://addapinch.com/coffee-chip-ice-cream-recipe/");
        urlList.add("https://addapinch.com/peach-ice-cream-recipe/");
        urlList.add("https://addapinch.com/oreo-ice-cream-sandwich-dessert/");
        urlList.add("https://www.lifeloveandsugar.com/no-churn-peppermint-bark-ice-cream/");


        //Mapping item classes with urls
        for (Object key : map1.keySet()){
//            System.out.println(map1.keySet());
            Set<Object> valuesForKey1 = map1.get(key);
            for (Object value : valuesForKey1){
                int k=5;
                while(k>0){
                    map2.put(value, urlList.get(i));
                    i += 1;
                    k -= 1;
                }
            }
        }

        //Access urls
        for (Object key : map2.keySet()){
//            System.out.println("foooood"+food.toLowerCase());
//            System.out.println("keyyy"+key);
            if(key.equals(food.toLowerCase())){
                key = food.toLowerCase();
//                System.out.println("keeeeeeyyy"+key);
                Set<Object> valuesForKey1 = map2.get(key);
                int i=0;
                //System.out.println("LINK::::"+valuesForKey1);
                for (Object value : valuesForKey1){
                    //System.out.println("LINK::::"+value);
                    if(i<5) {
                        //System.out.println("LINK::::"+value);
                        buttons[i].setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                //System.out.println("LINK::::"+value);
                                recipeIntent.putExtra("EXTRA_URL",(CharSequence) value);
                                startActivity(recipeIntent);
                            }
                        });
                        i++;
                    }
                }
            }
        }
    }
}