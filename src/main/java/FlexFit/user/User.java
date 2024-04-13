package FlexFit.user;

import java.util.Scanner;


public abstract class User {
    private String name;
    private int weight;
    private double height;
    private String sex;
    private double bmi;
    private int age;

    private int workoutType;

    private String AorC;

    private Scanner scanner; // Injected dependency

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    public User() {
        promptUserInfo();
        calculateBMI();
    }

    public void promptUserInfo() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name:");
        this.name = scanner.nextLine();

        System.out.println("Please enter your age:");
        this.age = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your sex (Male/Female):");
        this.sex = scanner.nextLine();

        System.out.println("Please enter your weight in Pounds:");
        this.weight = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Please enter your height in Inches:");
        this.height = scanner.nextDouble();
        scanner.nextLine();

    }

    public void promptUserType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is your goal to lose weight or gain muscle (1: lose weight, 2: gain muscle?:");
        this.workoutType = scanner.nextInt();

    }

    public int getWorkoutType(){
        return workoutType;
    }



    private void calculateBMI() {
        this.bmi = (weight / (height * height)) * 703;
    }


    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    public int getAge() {
        return age;
    }

    public double getHeight() {
        return height;
    }

    public String getSex() {
        return sex;
    }

    public double getBMI() {
        return bmi;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", weight=" + weight +
                ", height=" + height +
                ", sex='" + sex + '\'' +
                ", BMI=" + String.format("%.2f", bmi) +
                '}';
    }


}