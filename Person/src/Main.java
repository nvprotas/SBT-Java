public class Main {
    public static void main(String[] args) {

        Person dave = new PersonImpl("Dave", 21, true);
        Person alice = new PersonImpl("Alice", 25, false);
        Person bob = new PersonImpl("Bob", 26,true);
        Person carol = new PersonImpl("Carol", 22, false);


        System.out.println(alice.marry(bob));
        System.out.println(carol.marry(dave));

        checkSpouse(alice);
        checkSpouse(bob);
        checkSpouse(carol);
        checkSpouse(dave);

        System.out.println(bob.marry(carol));

        checkSpouse(alice);
        checkSpouse(bob);
        checkSpouse(carol);
        checkSpouse(dave);

        checkSpouse(null);

        System.out.println(bob.marry(dave));

        checkSpouse(alice);
        checkSpouse(bob);
        checkSpouse(carol);
        checkSpouse(dave);

    }

    public static void checkSpouse(Person person1) {
        if (person1 != null) {
            if (person1.getSpouse() != null) {
                System.out.println(person1.getName() + "'s spouse is " + person1.getSpouse().getName());
            } else {
                System.out.println(person1.getName() + " doesn't have a spouse");
            }
        } else {
            System.out.println("No person");
        }
    }


}
