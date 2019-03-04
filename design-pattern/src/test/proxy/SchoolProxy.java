package test.proxy;

public class SchoolProxy implements School {
    private School school;

    private int allowedNumber;

    private int studentNumer = 1;

    public SchoolProxy(School school, int allowedNumber) {
        this.school = school;
        this.allowedNumber = allowedNumber;
    }

    @Override
    public String getSchoolName() {
        return school.getSchoolName();
    }

    @Override
    public void recruit() {
        if (studentNumer <= allowedNumber) {
            studentNumer++;
            school.recruit();
        } else {
            System.out.println(getSchoolName() + "已招满");
        }
    }
}
