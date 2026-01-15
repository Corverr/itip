package LastTask;

public class main {
    public static void main(String[] args){
        String[] strings = {"123", "abc", "45.6"};

        for (String str : strings) {
            try {
                System.out.println(str + " -> " + Integer.parseInt(str));
            } catch (NumberFormatException e) {
                try {
                    throw new CustomNumberFormatException("Невозможно преобразовать '" + str + "' в число");
                } catch (CustomNumberFormatException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
    }
}
