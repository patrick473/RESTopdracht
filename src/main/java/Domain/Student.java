package Domain;

public class Student {

    private String name;
    private int studentid;
    private int classid;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStudentid() {
        return studentid;
    }

    public void setStudentid(int studentid) {
        this.studentid = studentid;
    }

    public int getClassid() {
        return classid;
    }

    public void setClassid(int classid) {
        this.classid = classid;
    }

    public Student(String name, int studentid, int classid) {
        this.name = name;
        this.studentid = studentid;
        this.classid = classid;
    }
}
