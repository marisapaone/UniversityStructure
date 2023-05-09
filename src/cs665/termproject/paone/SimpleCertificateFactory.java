package cs665.termproject.paone;

//Part of the Simple Factory Pattern
public class SimpleCertificateFactory {

    public String certificateName;

    public CertificateProgram createCertificate(String certificateName){
        CertificateProgram certificate = new CertificateProgram(certificateName);
        return certificate;
    }


}
