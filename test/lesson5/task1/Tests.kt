package lesson5.task1

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test

class Tests {
    @Test
    @Tag("Example")
    fun shoppingListCostTest() {
        val itemCosts = mapOf(
            "Хлеб" to 50.0,
            "Молоко" to 100.0
        )
        assertEquals(
            150.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко"),
                itemCosts
            )
        )
        assertEquals(
            150.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко", "Кефир"),
                itemCosts
            )
        )
        assertEquals(
            0.0,
            shoppingListCost(
                listOf("Хлеб", "Молоко", "Кефир"),
                mapOf()
            )
        )
    }

    @Test
    @Tag("Example")
    fun filterByCountryCode() {
        val phoneBook = mutableMapOf(
            "Quagmire" to "+1-800-555-0143",
            "Adam's Ribs" to "+82-000-555-2960",
            "Pharmakon Industries" to "+1-800-555-6321"
        )

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+1")
        assertEquals(2, phoneBook.size)

        filterByCountryCode(phoneBook, "+999")
        assertEquals(0, phoneBook.size)
    }

    @Test
    @Tag("Example")
    fun removeFillerWords() {
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я как-то люблю Котлин".split(" "),
                "как-то"
            )
        )
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я как-то люблю таки Котлин".split(" "),
                "как-то",
                "таки"
            )
        )
        assertEquals(
            "Я люблю Котлин".split(" "),
            removeFillerWords(
                "Я люблю Котлин".split(" "),
                "как-то",
                "таки"
            )
        )
    }

    @Test
    @Tag("Example")
    fun buildWordSet() {
        assertEquals(
            mutableSetOf("Я", "люблю", "Котлин"),
            buildWordSet("Я люблю Котлин".split(" "))
        )
        assertEquals(
            mutableSetOf("Котлин", "люблю", "Я"),
            buildWordSet("Я люблю люблю Котлин".split(" "))
        )
        assertEquals(
            mutableSetOf<String>(),
            buildWordSet(listOf())
        )
    }

    @Test
    @Tag("2")
    fun buildGrades() {
        assertEquals(
            mapOf<Int, List<String>>(),
            buildGrades(mapOf())
        )
        assertEquals(
            mapOf(5 to listOf("Михаил", "Семён"), 3 to listOf("Марат")),
            buildGrades(mapOf("Марат" to 3, "Семён" to 5, "Михаил" to 5))
                .mapValues { (_, v) -> v.sorted() }
        )
        assertEquals(
            mapOf(3 to listOf("Марат", "Михаил", "Семён")),
            buildGrades(mapOf("Марат" to 3, "Семён" to 3, "Михаил" to 3))
                .mapValues { (_, v) -> v.sorted() }
        )
    }

    @Test
    @Tag("2")
    fun containsIn() {
        assertTrue(containsIn(mapOf("a" to "z"), mapOf("a" to "z", "b" to "sweet")))
        assertFalse(containsIn(mapOf("a" to "z"), mapOf("a" to "zee", "b" to "sweet")))
    }

    @Test
    @Tag("2")
    fun subtractOf() {
        val from = mutableMapOf("a" to "z", "b" to "c")

        subtractOf(from, mapOf())
        assertEquals(mapOf("a" to "z", "b" to "c"), from)

        subtractOf(from, mapOf("b" to "z"))
        assertEquals(mapOf("a" to "z", "b" to "c"), from)

        subtractOf(from, mapOf("a" to "z"))
        assertEquals(mapOf("b" to "c"), from)
    }

    @Test
    @Tag("2")
    fun whoAreInBoth() {
        assertEquals(
            emptyList<String>(),
            whoAreInBoth(emptyList(), emptyList())
        )
        assertEquals(
            listOf("Marat"),
            whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Marat", "Kirill"))
        )
        assertEquals(
            emptyList<String>(),
            whoAreInBoth(listOf("Marat", "Mikhail"), listOf("Sveta", "Kirill"))
        )
    }

    @Test
    @Tag("3")
    fun mergePhoneBooks() {
        assertEquals(
            mapOf("Emergency" to "112"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "112")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "112", "Police" to "02")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112, 911", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112"),
                mapOf("Emergency" to "911", "Police" to "02")
            )
        )
        assertEquals(
            mapOf("Emergency" to "112, 911", "Fire department" to "01", "Police" to "02"),
            mergePhoneBooks(
                mapOf("Emergency" to "112", "Fire department" to "01"),
                mapOf("Emergency" to "911", "Police" to "02")
            )
        )
    }

    @Test
    @Tag("4")
    fun averageStockPrice() {
        assertEquals(
            mapOf<String, Double>(),
            averageStockPrice(listOf())
        )
        assertEquals(
            mapOf("MSFT" to 100.0, "NFLX" to 40.0),
            averageStockPrice(listOf("MSFT" to 100.0, "NFLX" to 40.0))
        )
        assertEquals(
            mapOf("MSFT" to 150.0, "NFLX" to 40.0),
            averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0))
        )
        assertEquals(
            mapOf("MSFT" to 150.0, "NFLX" to 45.0),
            averageStockPrice(listOf("MSFT" to 100.0, "MSFT" to 200.0, "NFLX" to 40.0, "NFLX" to 50.0))
        )
    }

    @Test
    @Tag("4")
    fun findCheapestStuff() {
        assertNull(
            findCheapestStuff(
                mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                "торт"
            )
        )
        assertEquals(
            "Мария",
            findCheapestStuff(
                mapOf("Мария" to ("печенье" to 20.0), "Орео" to ("печенье" to 100.0)),
                "печенье"
            )
        )
    }

    @Test
    @Tag("3")
    fun canBuildFrom() {
        assertFalse(canBuildFrom(emptyList(), "foo"))
        assertTrue(canBuildFrom(listOf('a', 'b', 'o'), "baobab"))
        assertFalse(canBuildFrom(listOf('a', 'm', 'r'), "Marat"))
    }

    @Test
    @Tag("4")
    fun extractRepeats() {
        assertEquals(
            emptyMap<String, Int>(),
            extractRepeats(emptyList())
        )
        assertEquals(
            mapOf("a" to 2),
            extractRepeats(listOf("a", "b", "a"))
        )
        assertEquals(
            emptyMap<String, Int>(),
            extractRepeats(listOf("a", "b", "c"))
        )
    }

    @Test
    @Tag("3")
    fun hasAnagrams() {
        assertFalse(hasAnagrams(emptyList()))
        assertTrue(hasAnagrams(listOf("рот", "свет", "тор")))
        assertFalse(hasAnagrams(listOf("рот", "свет", "код", "дверь")))
        assertFalse(hasAnagrams(listOf("поле", "полено")))
        assertTrue(hasAnagrams(listOf("лунь", "нуль")))
    }

    @Test
    @Tag("5")
    fun propagateHandshakes() {
        assertEquals(
            mapOf(
                "Marat" to setOf("Mikhail", "Sveta"),
                "Sveta" to setOf("Mikhail"),
                "Mikhail" to setOf()
            ),
            propagateHandshakes(
                mapOf(
                    "Marat" to setOf("Sveta"),
                    "Sveta" to setOf("Mikhail")
                )
            )
        )
        assertEquals(
            mapOf(
                "Marat" to setOf("Mikhail", "Sveta"),
                "Sveta" to setOf("Marat", "Mikhail"),
                "Mikhail" to setOf("Sveta", "Marat"),
                "Friend" to setOf("GoodGnome"),
                "EvilGnome" to setOf(),
                "GoodGnome" to setOf()
            ),
            propagateHandshakes(
                mapOf(
                    "Marat" to setOf("Mikhail", "Sveta"),
                    "Sveta" to setOf("Marat"),
                    "Mikhail" to setOf("Sveta"),
                    "Friend" to setOf("GoodGnome"),
                    "EvilGnome" to setOf()
                )
            )
        )
    }

    @Test
    @Tag("6")
    fun findSumOfTwo() {
        assertEquals(
            Pair(-1, -1),
            findSumOfTwo(emptyList(), 1)
        )
        assertEquals(
            Pair(0, 2),
            findSumOfTwo(listOf(1, 2, 3), 4)
        )
        assertEquals(
            Pair(-1, -1),
            findSumOfTwo(listOf(1, 2, 3), 6)
        )
        assertEquals(
            Pair(221, 636),
            findSumOfTwo(
                listOf(
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    0,
                    40699,
                    5983,
                    32713,
                    0,
                    0,
                    17749,
                    40699,
                    48640,
                    33775,
                    23858,
                    40700,
                    4797,
                    40700,
                    0,
                    27562,
                    1,
                    32725,
                    13950,
                    40700,
                    40699,
                    1,
                    41595,
                    769,
                    0,
                    42155,
                    5315,
                    40700,
                    1,
                    41332,
                    40700,
                    40700,
                    40700,
                    34723,
                    38282,
                    26234,
                    49462,
                    34490,
                    1,
                    18123,
                    1,
                    10626,
                    0,
                    1,
                    20067,
                    43140,
                    4257,
                    36599,
                    49651,
                    39096,
                    32908,
                    40699,
                    1,
                    20987,
                    40699,
                    0,
                    40699,
                    40699,
                    40700,
                    0,
                    40699,
                    44332,
                    32549,
                    34783,
                    1,
                    0,
                    40700,
                    1,
                    40700,
                    1,
                    40700,
                    43989,
                    40699,
                    1,
                    0,
                    4962,
                    40699,
                    40700,
                    1,
                    40700,
                    40700,
                    1,
                    40700,
                    1,
                    40700,
                    42502,
                    0,
                    0,
                    18624,
                    15370,
                    0,
                    0,
                    1,
                    1707,
                    36279,
                    0,
                    0,
                    40699,
                    36922,
                    40699,
                    34769,
                    11153,
                    40700,
                    26129,
                    40700,
                    31420,
                    1,
                    15433,
                    40699,
                    40528,
                    27099,
                    40699,
                    49904,
                    15865,
                    40700,
                    40699,
                    11068,
                    1,
                    10430,
                    40699,
                    1,
                    2427,
                    40699,
                    40700,
                    40699,
                    2002,
                    39207,
                    38998,
                    1061,
                    6326,
                    23664,
                    29431,
                    18228,
                    40700,
                    40699,
                    48161,
                    38415,
                    40699,
                    1,
                    0,
                    44848,
                    1,
                    40700,
                    40700,
                    3400,
                    0,
                    0,
                    22891,
                    1,
                    4520,
                    43596,
                    40699,
                    11143,
                    46692,
                    0,
                    1,
                    40700,
                    15572,
                    1289,
                    0,
                    1,
                    40699,
                    18985,
                    40700,
                    1,
                    41086,
                    43546,
                    0,
                    1,
                    40700,
                    0,
                    40699,
                    24552,
                    35094,
                    0,
                    48218,
                    0,
                    34214,
                    41775,
                    40700,
                    32030,
                    11637,
                    1,
                    4012,
                    40700,
                    17781,
                    40700,
                    14555,
                    35708,
                    7335,
                    33818,
                    41127,
                    40699,
                    0,
                    1,
                    25569,
                    33578,
                    1,
                    40700,
                    1,
                    0,
                    1,
                    14771,
                    13766,
                    14733,
                    3721,
                    8254,
                    16162,
                    0,
                    40699,
                    40699,
                    48246,
                    40699,
                    40699,
                    1,
                    40700,
                    32302,
                    20158,
                    10359,
                    1,
                    1,
                    12962,
                    44994,
                    718,
                    40699,
                    40699,
                    46811,
                    1,
                    40700,
                    42782,
                    40699,
                    40700,
                    2436,
                    20091,
                    40700,
                    25252,
                    29670,
                    9100,
                    19408,
                    37209,
                    22585,
                    35675,
                    40700,
                    17536,
                    1,
                    2185,
                    26081,
                    40700,
                    1481,
                    41239,
                    46308,
                    40700,
                    4876,
                    0,
                    1,
                    14997,
                    40699,
                    40699,
                    41140,
                    27573,
                    1,
                    44115,
                    34292,
                    40699,
                    18435,
                    41891,
                    40699,
                    37093,
                    0,
                    40700,
                    40700,
                    40699,
                    1,
                    37875,
                    0,
                    30835,
                    5129,
                    14148,
                    1,
                    40700,
                    40699,
                    40700,
                    1,
                    0,
                    44863,
                    40699,
                    49418,
                    40699,
                    39607,
                    0,
                    1,
                    0,
                    40700,
                    1,
                    1,
                    12423,
                    40700,
                    44885,
                    40699,
                    7640,
                    14605,
                    40700,
                    18758,
                    6631,
                    40699,
                    40700,
                    41992,
                    11951,
                    30689,
                    30954,
                    5794,
                    40699,
                    1,
                    42801,
                    40700,
                    1717,
                    40699,
                    31705,
                    33805,
                    14588,
                    1,
                    0,
                    363,
                    43295,
                    40699,
                    40700,
                    14591,
                    49708,
                    1,
                    40700,
                    14608,
                    3502,
                    0,
                    40700,
                    40699,
                    0,
                    21184,
                    40700,
                    46324,
                    0,
                    34645,
                    47728,
                    40700,
                    39148,
                    0,
                    40699,
                    0,
                    18671,
                    40699,
                    37081,
                    0,
                    0,
                    2118,
                    25731,
                    40699,
                    40700,
                    40700,
                    2666,
                    0,
                    0,
                    31872,
                    1,
                    40700,
                    48919,
                    40699,
                    1,
                    1,
                    23138,
                    40700,
                    40699,
                    36595,
                    43336,
                    14502,
                    40699,
                    29863,
                    7942,
                    43074,
                    1,
                    15875,
                    33231,
                    40699,
                    40700,
                    40700,
                    1,
                    21942,
                    40699,
                    0,
                    40699,
                    1,
                    36258,
                    40700,
                    23871,
                    41718,
                    0,
                    40699,
                    33429,
                    27059,
                    18674,
                    0,
                    40699,
                    39321,
                    7500,
                    40699,
                    40700,
                    1,
                    0,
                    41302,
                    15295,
                    0,
                    40700,
                    19290,
                    40699,
                    5267,
                    1,
                    49014,
                    1,
                    0,
                    40700,
                    17387,
                    24027,
                    40700,
                    1956,
                    13921,
                    40700,
                    40700,
                    0,
                    3200,
                    1,
                    40699,
                    40699,
                    40699,
                    1,
                    22388,
                    0,
                    0,
                    40976,
                    22362,
                    40700,
                    40699,
                    40700,
                    33742,
                    32635,
                    1,
                    0,
                    35647,
                    29685,
                    1,
                    26970,
                    40699,
                    40699,
                    18860,
                    0,
                    40699,
                    40700,
                    0,
                    1,
                    38014,
                    38049,
                    27770,
                    8224,
                    8722,
                    29527,
                    26535,
                    31454,
                    49865,
                    3265,
                    1,
                    0,
                    40699,
                    3057,
                    40700,
                    1,
                    21990,
                    40699,
                    3118,
                    4584,
                    8271,
                    35033,
                    40700,
                    0,
                    5127,
                    40700,
                    6865,
                    40699,
                    1,
                    21839,
                    40699,
                    2875,
                    1412,
                    28821,
                    21173,
                    37290,
                    47683,
                    1,
                    19553,
                    40700,
                    40699,
                    46036,
                    0,
                    1,
                    40700,
                    32939,
                    26566,
                    0,
                    0,
                    46876,
                    40699,
                    1,
                    11785,
                    3079,
                    0,
                    35802,
                    40700,
                    0,
                    1,
                    40700,
                    39381,
                    0,
                    40699,
                    40700,
                    40699,
                    4978,
                    36377,
                ), 51810
            )
        )
    }

    @Test
    @Tag("8")
    fun bagPacking() {
        assertEquals(
            setOf("Кубок", "Слиток"),
            bagPacking(
                mapOf("Кубок" to (50 to 2000), "Слиток" to (100 to 5000), "Ожерелье" to (350 to 3000)),
                185
            )
        )
        assertEquals(
            emptySet<String>(),
            bagPacking(
                mapOf("Кубок" to (500 to 2000), "Слиток" to (1000 to 5000)),
                450
            )
        )
    }
}
