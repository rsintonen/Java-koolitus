package ee.raul;

public class User {
    String firstName;
    String lastName;
    String identificationCode = "Test";
    int age;
    int pangaArve;

    public User(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void maksaPalka() {
        pangaArve += 100;
    }

}
