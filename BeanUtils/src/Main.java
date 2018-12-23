public class Main {
    public static void main(String[] args) {

        To to = new To();
        From from = new From(123, "TestString");

        System.out.println(to.toString());

        BeanUtils.assign(to,from);

        System.out.println(to.toString());
    }

}
