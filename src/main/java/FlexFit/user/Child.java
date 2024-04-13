package FlexFit.user;

public class Child extends User {
    public Child() {
        super();
        checkAgeValidity();
    }

    public void checkAgeValidity() {
        if (getAge() < 1 || getAge() > 17) {
            throw new IllegalArgumentException("Child age must be between 1 and 17 years.");
        }
    }

}
