import java.lang.annotation.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DataProcessor {
}

class FilterProcessor {
    @DataProcessor
    public Stream<String> filterWordsStartingWithA(Stream<String> words) {
        System.out.println("\n ФИЛЬТРАЦИЯ: слова на букву 'a' ");

        List<String> originalList = words.collect(Collectors.toList());
        System.out.println("Исходные слова: " + originalList);

        return originalList.stream()
                .filter(word -> {
                    boolean startsWithA = word.toLowerCase().startsWith("a");
                    if (startsWithA) {
                        System.out.println("  Сохранено: '" + word + "' (начинается на 'a')");
                    } else {
                        System.out.println("  Отфильтровано: '" + word + "' (не начинается на 'a')");
                    }
                    return startsWithA;
                });
    }
}

class TransformProcessor {
    @DataProcessor
    public Stream<String> transformToUpperCase(Stream<String> words) {
        System.out.println("\n ПРЕОБРАЗОВАНИЕ: в верхний регистр ");


        List<String> list = words.collect(Collectors.toList());
        System.out.println("Слова для преобразования: " + list);


        return list.stream()
                .map(word -> {
                    String transformed = word.toUpperCase();
                    System.out.println("  Преобразовано: '" + word + "' → '" + transformed + "'");
                    return transformed;
                });
    }
}

class AggregateProcessor {
    @DataProcessor
    public Stream<String> sortAndRemoveDuplicates(Stream<String> words) {
        System.out.println("\n АГРЕГАЦИЯ: сортировка и удаление дубликатов ");

        List<String> list = words.collect(Collectors.toList());
        System.out.println("Слова перед обработкой: " + list);

        List<String> uniqueList = new ArrayList<>();
        for (String word : list) {
            if (!uniqueList.contains(word)) {
                uniqueList.add(word);
                System.out.println("  Уникальное слово: '" + word + "'");
            } else {
                System.out.println("  Удалён дубликат: '" + word + "'");
            }
        }

        Collections.sort(uniqueList);
        System.out.println("Отсортированный список: " + uniqueList);

        return uniqueList.stream();
    }
}

class DataManager {
    private List<Object> processors = new ArrayList<>();
    private List<String> data = new ArrayList<>();
    private List<String> processedData = new ArrayList<>();

    public void registerDataProcessor(Object processor) {
        processors.add(processor);
        System.out.println(" Зарегистрирован обработчик: " + processor.getClass().getSimpleName());
    }

    public void loadData() {
        System.out.println("\n ЗАГРУЗКА ДАННЫХ ");
        data = Arrays.asList(
                "apple", "banana", "apricot", "avocado", "Apple",
                "cherry", "Ant", "date", "apricot", "avocado", "almond"
        );
        System.out.println("Загружено слов: " + data);
        System.out.println("Всего: " + data.size());
    }

    public void processData() {
        System.out.println("\n НАЧАЛО ОБРАБОТКИ");

        Stream<String> currentStream = data.stream();

        for (Object processor : processors) {
            java.lang.reflect.Method[] methods = processor.getClass().getDeclaredMethods();
            for (java.lang.reflect.Method method : methods) {
                if (method.isAnnotationPresent(DataProcessor.class)) {
                    try {
                        System.out.println("\n Применение метода: " +
                                method.getDeclaringClass().getSimpleName() +
                                "." + method.getName() + "()");

                        currentStream = (Stream<String>) method.invoke(processor, currentStream);

                        List<String> intermediateResult = currentStream.collect(Collectors.toList());
                        System.out.println("Промежуточный результат: " + intermediateResult);

                        currentStream = intermediateResult.stream();

                    } catch (Exception e) {
                        System.err.println("Ошибка при выполнении метода: " + e.getMessage());
                    }
                }
            }
        }

        processedData = currentStream.collect(Collectors.toList());
        System.out.println("\n Обработка завершена");
    }

    public void displayResults() {
        System.out.println("\n ИТОГОВЫЕ РЕЗУЛЬТАТЫ ");
        System.out.println("Исходные данные: " + data);
        System.out.println("Обработанные данные: " + processedData);
        System.out.println("\nДетальный отчет:");
        System.out.println("- Исходное слов: " + data.size());
        System.out.println("- После обработки: " + processedData.size() + " слов");
        System.out.println("- Удалено дубликатов: " + (data.size() - processedData.size()));

        System.out.println("\nФинальный список слов:");
        for (int i = 0; i < processedData.size(); i++) {
            System.out.println((i + 1) + ". " + processedData.get(i));
        }
    }
}

public class Lab8 {
    public static void main(String[] args) {
        DataManager manager = new DataManager();

        manager.registerDataProcessor(new FilterProcessor());
        manager.registerDataProcessor(new TransformProcessor());
        manager.registerDataProcessor(new AggregateProcessor());

        manager.loadData();

        manager.processData();

        manager.displayResults();
    }
}