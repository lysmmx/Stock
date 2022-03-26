public class Cd {
    private String cdID;
    private String cdTitle;
    private double cdPrice;

    public Cd(String theCDId,String theCDTitle,double theCDPrice) {
        cdID=theCDId;
        cdTitle=theCDTitle;
        cdPrice=theCDPrice;
    }

    public String getcdID() {
        return cdID;
    }
    public String getcdTitle() {
        return cdTitle;
    }
    public double getcdPrice() {
        return cdPrice;
    }

}
