package test.proxy;

public class SecondSchool implements School {
    @Override
    public String getSchoolName() {
        return "第二学校";
    }

    @Override
    public void recruit() {
        System.out.println("第二学校招生");
    }
}
