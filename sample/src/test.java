public class Student implements Serializable {
    // 实现序列号接口
    private static final long serialVersionUID = 799887342985222720L;

    // 提供私有修饰的成员变量
    private String name;
    private String age;
    private float gender;
    private Integer lala;
    private boolean is;
    private son SON;

    // 提供公共无参的构造
    public Student() {
    }

    // 为成员变量提供公共getter和setter方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    // 这里为了方便调用学生类对象内容重写toString方法
    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + ", gender=" + gender + "]";
    }

}