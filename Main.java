public class Main {
    public static void main(String[] args) {

        HashTable<Integer, Book> library = new HashTable<>(10);

        Book book1 = new Book("Неночь", "Джей Кристофф", 4);
        Book book2 = new Book("1984", "Джордж Оруэлл", 3);
        Book book3 = new Book("Сборник стихов", "Сергей Вальковский", 2);

        library.put(978-5-171-11528-9, book1);
        library.put(978-5-041-76523-1, book2);
        library.put(978-5-604-10891-8, book3);

        System.out.println(library.get(978-5-171-11528-9));
        System.out.println(library.get(978-5-041-76523-1));

        library.remove(978-5-604-10891-8);


        System.out.println(library.get(978-5-604-10891-8));



    }
}
