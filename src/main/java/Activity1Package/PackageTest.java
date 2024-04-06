package Activity1Package;
public class PackageTest {
    public static void main (String[] args){
        Package packageAir = new Package(1, 'A');
        Package packageTruck = new Package(9, 'T');
        Package packageMail = new Package(18, 'M');
        InsuredPackage insuredPackageAir = new InsuredPackage(1, 'A');
        InsuredPackage insuredPackageTruck = new InsuredPackage(1, 'A');
        InsuredPackage insuredPackageMail = new InsuredPackage(1, 'A');
        
        
        //firstPackage.toString();
        //secondPackage.toString();
        System.out.println(packageAir.toString());
        System.out.println(packageTruck.toString());
        System.out.println(packageMail.toString());
        System.out.println("--------------------------------------------");
        System.out.println(insuredPackageAir.toString());
        System.out.println(insuredPackageTruck.toString());
        System.out.println(insuredPackageMail.toString());
        
    }
}
