import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.function.Predicate;

/**
 Напишите программу, которая использует Stream API для обработки списка чисел.
 Программа должна вывести на экран среднее значение всех четных чисел в списке.
*/

public class Main {
    public static void main(String[] args) {

        // Создание коллекции из 20 случайных чисел
        Random random = new Random();
        List<Integer> myList = new ArrayList<>();
        while (myList.size() < 20){
            myList.add(random.nextInt(100));
        }
        System.out.println(myList);

        // Функция-предикат для определения четных чисел
        Predicate <Integer> isOdd = number -> {
            if (number % 2 == 0) {
                return true;
            } else {
                return false;
            }
        };

        //Вычисление суммы четных чисел
        Optional<Integer> sum = myList.stream().filter(e -> isOdd.test(e))
                .reduce(Integer::sum);

        //Вычисление количества четных чисел
        long count = myList.stream().filter(e -> isOdd.test(e))
                .count();

        //Вычисление итогового результата
        Long result = sum.get() / count;
        System.out.println("Результат: " + result);
    }
}