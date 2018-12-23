public interface Person {

    boolean marry(Person person); // начала развод, потом женятся, ельзя женить на себе, нельзя одного пола женить

    void divorce();

    Person getSpouse();

    int getAge();

    boolean isMan();

    String getName();
}
