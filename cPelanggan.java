
package pkgWarungGui;

public class cPelanggan {
    private String nama;
    private String kode;
    private String alamat;
    private String kd="WS0";
    private double tBlj;
    
    cPelanggan(String n,String a, String k){
        nama = n;
        alamat=a;
        kode = kd+k;
    }
    public void setNama(String n){
        nama = n;
    }
    public void setKode(String k){
        kode = kd+k;
    }
    public void setAlamat(String a){
        alamat=a;
    }
    public String getNama(){
        return nama;
    }
    public String getKode(){
        return kode;
    }
    public String getAlamat(){
        return alamat;
    }
    public String ToString(){
        return nama +" ["+kode+"]"+"     "+alamat;
    }
    public void setTBlj(double t){
        tBlj=tBlj+t;
    }
    public double getTBlj(){
        return tBlj;
    }
}
