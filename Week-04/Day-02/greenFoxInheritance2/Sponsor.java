package greenFoxInheritance2;

public class Sponsor extends Person {

  String company;
  int hiredStudents;

  public Sponsor() {
    this.name = "Joe Doe";
    this.age = 30;
    this.gender = "female";
    this.company = "Google";
    this.hiredStudents = 0;
  }

  public Sponsor(String name, int age, String gender, String company) {
    this.name = name;
    this.age = age;
    this.gender = gender;
    this.company = company;
    this.hiredStudents = 0;
  }

  @Override
  public void introduce() {
    System.out.println("Hi, I'm " + name + ", a " + age + "year old " + gender + " who represents " + company + " and hired " + hiredStudents + " students so far.");
  }
  public void hire() {
    this.hiredStudents = hiredStudents++;
  }
  public void getGoal() {
    System.out.println("Hire brilliant junior software developers.");
  }
}
