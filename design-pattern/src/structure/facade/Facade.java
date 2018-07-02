package structure.facade;

// 将子系统进行封装，给外界提供一个统一的界面接口，不需要Client对子系统要有高要求的了解。
public class Facade{

    public void applyRunCompany()
    {
        // 持有对各个部门的引用
        CommercialDepartment commercialDepartment = new CommercialDepartment();
        Bank bank = new Bank();
        PoliceBureau policeBureau = new PoliceBureau();
        TaxBureau taxBureau = new TaxBureau();
        QualityInspectionBureau qualityInspectionBureau = new QualityInspectionBureau();

        // 申请开公司
        System.out.println("------开始申请开公司........");

        commercialDepartment.applyCompanyName();          //1.到工商部门申请一个公司名称;

        bank.createCheckAccount();                         // 2.去银行开一个验资账户 ;                       //

        commercialDepartment.distributeBusinessLicense(); //3.准备材料，到工商部门拿营业执照;

        policeBureau.distributeSeal();                    // 4. 到公安局备案刻章；

        qualityInspectionBureau.distributeCertificate();   // 5. 到质检局办理组织机构代码证；

        taxBureau.registerTaxBusiness();                   // 6. 到税务部门办理税务登记 ；

        bank.createBasicBank();                           // 7. 到银行开一个基本账户；

        taxBureau.appraiseTaxType();                       //8.到税务部门做税种鉴定；

        System.out.println("苍天啊，终于可以开公司了！！！");
    }
}
