package FlexFit.user;

public class Adult extends User {
    public Adult() {
        super();
        checkAgeValidity();
    }

    public void checkAgeValidity() {
        if (getAge() < 18) {
            throw new IllegalArgumentException("Adult age must be 18 years or older.");
        }
    }


}
