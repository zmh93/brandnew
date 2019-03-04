package test.proxy;

public class FirstSchool implements School {
    @Override
    public String getSchoolName() {
        return "第一学校";
    }

    @Override
    public void recruit() {
        System.out.println("第一学校招生");
    }
}
