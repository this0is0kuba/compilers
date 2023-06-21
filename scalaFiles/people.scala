public class People {
    def allCombinations() : Int = {
        val firstNames = List(
                "Bill",
                "Candy",
                "Karen",
                "Leo",
                "Regina"
            );

        val surNames = List(
            "Smith",
            "Jones",
            "Williams"
        );

        for(firstName <- firstNames) {
            for(lastName <- lastNames) {
                println(firstName + " " +  lastName);
            }
        }
        return 1;
    }
}