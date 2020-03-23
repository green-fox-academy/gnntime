package greenFoxInheritance;

public class Student extends Person {

  String previousOrganisation;
  int skippedDays;

  public Student() {
    this.name = "Jane Doe";
    this.age = 30;
    this.gender = "female";
    this.previousOrganisation = "THe School of Life";
    this.skippedDays = 0;
  }

  public Student(String name, int age, String gender, String previousOrganisation){
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.previousOrganisation = previousOrganisation;
    this.skippedDays = 0;
  }

  public void getGoal() {
    System.out.println("Hi, I'm " + name + ", a " +  age + "year old " + gender + " from " + previousOrganisation + " who skipped " + skippedDays + " days from the course already.");
  }
  public void skipDays(int numberOfDays) {
    this.skippedDays = skippedDays + numberOfDays;
  }
}
