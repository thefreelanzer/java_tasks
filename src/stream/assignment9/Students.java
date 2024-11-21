package stream.assignment9;

public class Students {
    int roll_no;
    String name;
    String gender;
    String standard;
    String grade;

    public Students(int roll_no, String name, String gender, String standard, String grade) {
        this.roll_no = roll_no;
        this.name = name;
        this.gender = gender;
        this.standard = standard;
        this.grade = grade;
    }

    public int getRoll_no() {
        return roll_no;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getStandard() {
        return standard;
    }

    public String getGrade() {
        return grade;
    }
}
