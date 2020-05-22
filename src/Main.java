import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {
            System.out.println("Hello");

            bubbleSorting();                   // Задача №1
            shakeSorting();                    // Задача №2
            changeEverySecondValueOfArray();   // Задача №3
            sortTheFirstPartOfTheArray();      // Задача №4
            digitsDescending();                // Задача №5
            lastNameAndHeight();               // Задача №6
            castingNasa();                     // Задача №7
            palidromNumbers();                 // Задача №8
        }

        /**
         * 1.	Реализовать улучшенный алгоритм пузырьковой сортировки,
         * где количество итераций будет менее чем n2
         **/

        static void bubbleSorting() { // пузырькова сортировка в обе стороны
            System.out.println("Задание №1" + '\n' + "Улучшеная пузырьковая сортировка");
            int[] numbers = new int[10];
            int sortingType;

            sortingType = TypeOfSorting();

            randomNumbersOfArrays(numbers);

            if (sortingType == 1) {

                System.out.println("Производитеся пузырьковая сортировака по возрастанию");
                ascSorting(numbers);

            } else if (sortingType == 0) {

                System.out.println("Производитеся пузырьковая сортировака по убыванию");
                descSorting(numbers);

            }
            printArray(numbers);
        }

        /**
         * 2.Реализовать улучшенный алгоритм шейкерной сортировки, где количество итераций будет менее чем n2
         **/

        static void shakeSorting() { // шейкерная сортировка в обе стороны
            System.out.println('\n' + "Задание №2" + '\n' + "Улучшеная шейкерная сортировка");
            int[] numbers2 = new int[10];
            int sortingType;

            sortingType = TypeOfSorting();

            randomNumbersOfArrays(numbers2);

            if (sortingType == 1) {

                System.out.println("Производится шейкерная сортировака по возрастанию");
                ascSorting(numbers2);
                descSorting(numbers2);

            } else if (sortingType == 0) {

                System.out.println("Производится шейкерная сортировака по убыванию");
                descSorting(numbers2);
                ascSorting(numbers2);
            }
            printArray(numbers2);
        }

        static void printArray(int[] arr) {
            System.out.print("{");
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
                if (i < arr.length - 1) {
                    System.out.print(", ");
                }
            }
            System.out.print("}" + '\n');
        }

        static void randomNumbersOfArrays(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * (200 + 1)) - 100;
            }
        }

        static void ascSorting(int[] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = 0; j < numbers.length - i - 1; j++) {
                    if (numbers[j] > numbers[j + 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j + 1];
                        numbers[j + 1] = temp;
                    }
                }
            }
        }

        static void descSorting(int[] numbers) {
            for (int i = 0; i < numbers.length - 1; i++) {
                for (int j = numbers.length - 1; j > i; j--) {
                    if (numbers[j] < numbers[j - 1]) {
                        int temp = numbers[j];
                        numbers[j] = numbers[j - 1];
                        numbers[j - 1] = temp;
                    }
                }
            }
        }

        static int TypeOfSorting() {
            System.out.println("Введите тип сортировки по возрастанию - 1 или по убыванию - 0");
            Scanner scanner = new Scanner(System.in);
            int sorting = scanner.nextInt();
            if (sorting > 1 || sorting < 0) {
                System.out.println("Вы ввели не допустимое значение, по " +
                        "умолчанию сортировка будет происходить по возрастанию");
                sorting = 1;
            }
            return sorting;
        }

        /**
         * 3.	Есть числовой массив. С клавиатуры ввести его длину и значения. Каждое второе
         * значение массиве поменять местами с впереди стоящим значением
         **/

        static void changeEverySecondValueOfArray() {
            System.out.println('\n' + "Задание № 3" + '\n' + "Введите длину массива");
            Scanner scanner = new Scanner(System.in);
            int[] arr = new int[scanner.nextInt()];

            initializationOfArrayValues(arr);

            System.out.println("Вы проинициализировали первичный массив");
            printArray(arr);

            sortingSecondValue(arr);
            System.out.println("Отсортировали массив по условиям задачи - " +
                    "каждое второе значение поменять местами");
            printArray(arr);
        }

        static void sortingSecondValue(int[] arr) {
            for (int i = 0; i < arr.length; i += 2) {
                if (i + 2 > arr.length) {
                    break;
                } else {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
        }

        static void initializationOfArrayValues(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                System.out.println("Введите значение индекса " + i);
                Scanner scanner = new Scanner(System.in);
                arr[i] = scanner.nextInt();
            }
        }

        /**
         * 4.	Есть числовой массив. С клавиатуры ввести его длину и значения.
         * Отсортировать первую половину массив по возрастанию
         **/

        static void sortTheFirstPartOfTheArray() {
            System.out.println('\n' + "Задание №4" + '\n' + "Введите длину массива");
            Scanner scanner = new Scanner(System.in);
            int[] arr = new int[scanner.nextInt()];

            initializationOfArrayValues(arr);

            System.out.println("Вы проинициализировали первичный массив");
            printArray(arr);

            sortingTheFirstPart(arr);

            System.out.println("Отсортировали массив по условиям задачи - " +
                    "сортировка первой части массива по возрастанию");
            printArray(arr);
        }

        static void sortingTheFirstPart(int[] arr) {
            for (int i = 0; i < arr.length / 2; i++) {
                for (int j = 0; j < arr.length / 2; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int temp = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = temp;
                    }
                }
            }
        }

        /**
         * 5.	Пользователь вводит с клавиатуры натуральное число, состоящие не менее чем из 2 цифр.
         * Получить новое число, цифры которого будет расположены по убыванию.
         * К примеру: 80124 будет 84210 и вывести в консоль
         **/

        static void digitsDescending() {

            System.out.println('\n' + "Задание № 5" + '\n' + "Введите натуральное число не менее чем из 2х цифр");
            Scanner scanner = new Scanner(System.in);
            int number = scanner.nextInt();
            if (number < 10) {
                System.out.println("Вы ввели число состоящее менее чем из 2х цыфр");
                return;
            }
            boolean isNext;
            int[] numbers = new int[0];
            do {
                int temp = number % 10;
                number /= 10;

                numbers = addNumberToRear(numbers, temp);

                isNext = number != 0;
            } while (isNext);

            printArray(bubbleSort(numbers));

        }

        static int[] addNumberToRear(int[] numbers, int value) {
            int[] newNumbers = new int[numbers.length + 1];
            for (int i = 0; i < numbers.length; i++) {
                newNumbers[i] = numbers[i];
            }
            newNumbers[newNumbers.length - 1] = value;
            return newNumbers;
        }

        static int[] bubbleSort(int[] arr) {
            if (arr.length == 0) {
                return arr;
            }

            int[] sorted = copyArray(arr);

            ascReversSorting(sorted);

            return sorted;
        }

        static void ascReversSorting(int[] sorted) {
            for (int i = 0; i < sorted.length - 1; i++) {
                for (int j = 0; j < sorted.length - 1; j++) {
                    if (sorted[j] < sorted[j + 1]) {
                        int temp = sorted[j];
                        sorted[j] = sorted[j + 1];
                        sorted[j + 1] = temp;
                    }
                }
            }
        }

        static int[] copyArray(int[] arr) {
            int[] copied = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                copied[i] = arr[i];
            }
            return copied;
        }


        /**
         * 6.	Известен рост и фамилии 9 человек. Определить фамилию человека,
         * рост которого оказался бы посередине, в случае выстраивания их по ранжиру
         **/

        static void lastNameAndHeight() {
            System.out.println('\n' + "Задание №6" + '\n' + "Программа определения " +
                    "фамили человека оказавшегося во время ранжирования по середине");

            // каждый изначатльный индекс значенией с указанием роста равен изначальному
            // индексу массива с фамилиями, Иванов = рост 150, Петров 165 и т.д
            int[] heightofHuman = {150, 165, 148, 206, 195, 179, 144, 182, 169};
            String[] lastName = {"Иванов", "Петров", "Сидоров", "Дуров", "Алешин",
                    "Картонов", "Боров", "Киркоров", "Степанов"};

            for (int i = 0; i < heightofHuman.length - 1; i++) {
                for (int j = 0; j < heightofHuman.length - 1; j++) {
                    if (heightofHuman[j] > heightofHuman[j + 1]) {

                        int temp = heightofHuman[j]; // сортируем по возрастанию рост
                        heightofHuman[j] = heightofHuman[j + 1];
                        heightofHuman[j + 1] = temp;

                        String temp2 = lastName[j]; // паралельно сортируем фамилии
                        lastName[j] = lastName[j + 1];
                        lastName[j + 1] = temp2;
                    }
                }
            }
//        printArray(heightofHuman);
//        System.out.println(Arrays.toString(lastName));
            System.out.println('\n' + "Фамилия человека оказавшегося по середине во время ранжирования - "
                    + lastName[(lastName.length - 1) / 2] + ", рост которого составляет "
                    + heightofHuman[(lastName.length - 1) / 2] + " см.");
        }

        /**
         * 7.	   Планируется внеочередной полет на неизведанную планету для ее колонизации.
         * Представлено двадцать кандидатов для пилотирования шаттлом, но надо отобрать только пять.
         * Известен коэффициент выживаемость в непредвиденных условиях (от 1 до 100), для каждого из кандидатов.
         * Принято решение укомплектовать шаттл из 5 пилотов с наибольшим коэффициентом и при этом коэффициент
         * должен быть кратен 2
         **/

        static void castingNasa() {
            System.out.println('\n' + "Задача № 7");
            System.out.println("Приветствуем Вас на кастинге по случаю внеочередного" +
                    " полета неизведанную плана нету для ее колонизации." + '\n' +
                    "Желаем Вам удачи, победит 5 сильнейших кандидатов, результат которых, к тому же, кратен 2.");

            int[] casting = new int[20];

            randomNumbersOfCastingNasa(casting);

            ascSorting(casting);
            System.out.println('\n' + "Представляем значения всех кандидатов в порядке возростания для оценки");

            printArray(casting);

            System.out.println();

            bestNumbersOfCasting(casting);

            System.out.println('\n' + "По итогам кастинга отобрано 5 лучших кандидатов с коэффициентами выживаемости");
            printArray(bestNumbersOfCasting(casting));
        }

        static void randomNumbersOfCastingNasa(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] = (int) (Math.random() * 100 + 1);
            }
        }

        static int[] bestNumbersOfCasting(int[] casting) {
            int[] castingResult = new int[5];
            int i = 0;

            for (int j = casting.length - 1; j > 0; j--) {

                if (casting[j] % 2 == 0) {
                    castingResult[i] = casting[j];
                    i++;
                }
                if (castingResult[4] > 0) {
                    return castingResult; // так же, дополнительно, можно прописать условие,
                    // если среди 20 кандидатов не наберется 5ти с кратными 2м значениями, с просьбой повторить кастинг
                }
            }
            return castingResult;
        }

/*8.	Есть массив из 5 элементов. Проверить, может ли массив стать палиндромом после
надлежащей сортировки правой и левой его частей и вывести подготовленный массив в консоль.
К примеру: [7, 5, 9, 8, 6, 4, 9, 6, 7, 8, 5] станет [9, 8, 7, 6, 5, 4, 5, 6, 7, 8, 9]
NOTE: Палиндром - это такое число читающиеся одинаково в обоих направлениях, к примеру 1234321
*/

        static void palidromNumbers() {
            System.out.println('\n' + "Задача № 8" + '\n' + "Определение массива как палиндрома");
            int[] arrayOfNumbers = {5, 3, 3, 1, 1};
            System.out.print("Дан массив ");
            printArray(arrayOfNumbers);

            ascSorting(arrayOfNumbers);

            palidromSorting(arrayOfNumbers);

            printArray(arrayOfNumbers);

            if (arrayOfNumbers[0] == arrayOfNumbers[4] && (arrayOfNumbers[1] ==
                    arrayOfNumbers[3]) && (arrayOfNumbers[1] > arrayOfNumbers[0]) &&
                    (arrayOfNumbers[2] > arrayOfNumbers[1])) {
                System.out.println('\n' + "Данный массив является палиндромом");
            } else {
                System.out.println('\n' + "Данный массив не является палиндромом");
            }
        }

        static void palidromSorting(int[] arrayOfNumbers) {
            int tempMaxNumber = arrayOfNumbers[4];
            arrayOfNumbers[4] = arrayOfNumbers[1];
            arrayOfNumbers[1] = arrayOfNumbers[3];
            arrayOfNumbers[3] = arrayOfNumbers[2];
            arrayOfNumbers[2] = tempMaxNumber;
        }
    }

