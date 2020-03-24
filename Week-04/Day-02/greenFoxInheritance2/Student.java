package greenFoxInheritance2;

public class Student extends Person implements Cloneable {

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
  @Override
  public void getGoal() {
    System.out.println("Be a junior software developer.");
  }

  @Override
  public void introduce() {
    System.out.println("Hi, I'm " + name + ", a " +  age + "year old " + gender + " from " + previousOrganisation + " who skipped " + skippedDays + " days from the course already.");
  }
  public void skipDays(int numberOfDays) {
    this.skippedDays = skippedDays + numberOfDays;
  }

  @Override
  public Student clone() throws CloneNotSupportedException {
  return (Student)super.clone();
  }
}
