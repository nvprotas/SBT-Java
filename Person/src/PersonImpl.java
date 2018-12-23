public class PersonImpl implements Person {

    private final String name;
    private final int age;
    private Person spouse;
//    private final int sex; // 0 -- female; 1 -- male;
    private final boolean man; /* true -- male, false -- female */

    public PersonImpl(String name, int age, boolean man) {
        this.name = name;
        this.age = age;
        this.man = man;
        this.spouse = null;
    }

    public boolean isMan() {
        return man;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public boolean marry(Person person) {
        if (this.getSpouse() == person) {
            return true;
        }
        if ((person != this)&&(this.isMan() != person.isMan())&&(age>=18)) {
            if((this.spouse != null)&&(this.getSpouse() != person)) {
                this.divorce();
            }
            this.spouse = person;
            person.marry(this);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void divorce() {
        if (this.spouse != null) {
            Person sp = this.spouse;
            this.spouse = null;
            sp.divorce();
        }
    }

    @Override
    public Person getSpouse() {
        return spouse;
    }

    @Override
    public int getAge() {
        return age;
    }


}
