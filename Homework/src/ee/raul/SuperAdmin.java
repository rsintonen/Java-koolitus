package ee.raul;

public class SuperAdmin extends Admin {
    boolean getsPaid = false;

    public SuperAdmin(String firstName, String lastName, int age, String identificationCode) {
        super(firstName, lastName, age);
        this.identificationCode = identificationCode;
        this.getsPaid = false;
    }

    public void idCode() {
        System.out.println(identificationCode);
    }

}
