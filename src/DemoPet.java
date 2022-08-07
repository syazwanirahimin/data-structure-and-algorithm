import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DemoPet {

    public enum Type implements java.lang.reflect.Type {
        DOG, CAT;

        @Override
        public String getTypeName() {
            return java.lang.reflect.Type.super.getTypeName();
        }
    }


    public static void main(String[] args) {
        List<Pet> petAnimals = getPets();

        // find all dogs
        System.out.println("Find All Dogs");
        List<Pet> dogs = petAnimals.stream()
                .filter(animal -> animal.getType().equals(Type.DOG))
                .collect(Collectors.toList());
        dogs.forEach(System.out::println);

        // sort by age
        System.out.println("\nSort By Age");
        List<Pet> ages = petAnimals.stream()
                .sorted(Comparator.comparing(Pet::getAge))
                .collect(Collectors.toList());
        ages.forEach(System.out::println);

        // average age of cats
        System.out.println("\nAverage Age of Cats");
        Double avgCatAge = petAnimals.stream()
                .filter(animal -> animal.getType().equals(Type.CAT))
                .collect(Collectors.averagingInt(Pet::getAge));
        System.out.println(avgCatAge);

        // average age of all pets
        System.out.println("\nAverage Age of Pets");
        Double avgPetAge = petAnimals.stream()
                .collect(Collectors.averagingInt(Pet::getAge));
        System.out.println(avgPetAge);

        // name of youngest dog
        System.out.println("\nName of Youngest Dog");
        petAnimals.stream()
                .filter(animal -> animal.getType().equals(Type.DOG))
                .min(Comparator.comparing(Pet::getAge))
                .map(animal -> animal.getName())
                .ifPresent(System.out::println);

        // number of cats
        System.out.println("\nNumber of Cats");
        long numOfCats = petAnimals.stream()
                .filter(animal -> animal.getType().equals(Type.CAT))
                .count();
        System.out.println(numOfCats);


    }

    private static List<Pet> getPets(){
        return Arrays.asList(
                new Pet("Marley", 5, Type.DOG),
                new Pet("Beethoven", 2, Type.CAT),
                new Pet("Ernest", 4, Type.DOG),
                new Pet("Tabby", 7, Type.CAT),
                new Pet("Snowball", 1, Type.CAT),
                new Pet("Lassie", 3, Type.DOG),
                new Pet("Little Nicky", 6, Type.CAT),
                new Pet("Copper", 12, Type.DOG)
        );
    }
}