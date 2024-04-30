package FlexFit.user;

import java.util.Scanner;


public class User {
    private String name;
    private double weight;
    private double height;
    private String sex;
    private double bmi;
    private double maintenanceCalories;
    private double age;

    private int workoutType;

    private String AorC;

    private Scanner scanner; // Injected dependency

    public User(Scanner scanner) {
        this.scanner = scanner;
    }

    public User() {
        promptUserInfo();
        calculateBMI();
        calculateMaintenanceCalories();
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

    public void calculateMaintenanceCalories(){
        if (this.sex.equals("Male")) {
            this.maintenanceCalories = (66 + (6.23 * weight)) + (12.7 * height) - (6.8 * age);
        } else {
            this.maintenanceCalories = (655 + (4.3 * weight)) + (4.7 * height) - (4.7 * age);
        }
    }

    public void promptUserType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Is your goal to lose weight or gain muscle (1: lose weight, 2: gain muscle?:");
        this.workoutType = scanner.nextInt();

    }

    public int getWorkoutType(){
        return workoutType;
    }

    public double getMaintenanceCalories(){
        return maintenanceCalories;
    }



    private void calculateBMI() {
        this.bmi = (weight / (height * height)) * 703;
    }


    public String getName() {
        return name;
    }

    public double getWeight() {
        return weight;
    }

    public double getAge() {
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
                ", Maintenance Calories=" + String.format("%.2f", maintenanceCalories) +
                '}';
    }


}