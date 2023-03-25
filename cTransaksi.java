
package pkgWarungGui;
public class cTransaksi {
    private cMenu beliMenu[];
    private cPelanggan Tplg;
    private String namaPbl;
    private String k="tA220";
    private String kode;
    private int jBeli=0, maxBeli=8, gTotal;
    private double disc=0.01;
    private int banyakBeli[], total[];
    
    cTransaksi(){
        beliMenu = new cMenu[maxBeli];
        banyakBeli=new int[maxBeli];
        total=new int[maxBeli];
    }
    public void isiPembeli(cPelanggan p){
        Tplg=p;
    }
    public void isiPembeli(String nPbl){
        namaPbl=nPbl;
    }
    public String getPembeli(){
        return namaPbl;
    }
    public cPelanggan getPelanggan(){
        return Tplg;
    }
    public double getDisc(){
        return disc;
    }
    public void setKode(int kd){
        kode=k+kd;
    }
    public String getKode(){
        return kode;
    }
    public int getJBeli(){
        return jBeli;
    }
    public int getMaxBeli(){
        return maxBeli;
    }
    public cMenu[] getBeliMenu(){
        return beliMenu;
    }
    public String beli(cMenu m,  int j){
        beliMenu[jBeli]=m;
        setbBeli(j);
        jBeli++;
        int total[]=new int[jBeli];
        total=total();
        int totalAll=gTotal(total);
        String t="Total sementara : Rp"+totalAll;
        return t;
    }
    public void setbBeli(int j){
        banyakBeli[jBeli]= banyakBeli[jBeli]+j;
    }
    public String keranjangBeli(){
        int t[]=total();
        gTotal(t);
        String nama;
        if(namaPbl!=null){
            nama=namaPbl;
        }else{
            nama =Tplg.getNama()+  "["+Tplg.getKode()+"]";
        }
        String krjg="";
        if(jBeli!=0){
            krjg = "============ STRUK PEMBELIAN ============\n";
            krjg = krjg+"Pembeli        : "+nama+"\n";
            krjg = krjg +"Kode Transaksi : "+getKode()+"\n";
            krjg = krjg +"\n   Menu      Harga     Jumlah     Total\n";
            for (int i = 0; i < jBeli; i++) {
                krjg = krjg + (i+1)+". "+beliMenu[i].getNama()+"       "+beliMenu[i].getHarga()
                        +"        "+banyakBeli[i]+"        "+total[i]+"\n";
            }
            krjg = krjg +"\n\tTOTAL       : Rp"+gTotal;
        }
        return krjg;
    }
    public String hapusBeli(int idx){
        for (int i = idx; i < jBeli; i++) {
            if(i==jBeli-1){
               beliMenu[i]=null;
               banyakBeli[i]=0;
               total[i]=0;
            }else{
               beliMenu[i]=beliMenu[i+1];
               banyakBeli[i]=banyakBeli[i+1];
               total[i]=total[i+1];
            }
        }
        int totalAll=gTotal(total);
        String t="Total sementara : Rp"+totalAll;
        jBeli--;
        return t;
    }
    public String ubah(int idx, int jB){
            banyakBeli[idx]=jB;
            int total[]=new int[jBeli];
            total=total();
            int totalAll=gTotal(total);
            String t="Total sementara : Rp"+totalAll;
            return t;
    }
    public int[] total(){
        for (int i = 0; i < jBeli; i++) {
            total[i]=beliMenu[i].getHarga()*banyakBeli[i];
        }
        return total;
    }
    public int gTotal(int total[]){
        gTotal=0;
        for (int i = 0; i < jBeli; i++) {
            gTotal=gTotal+total[i];
        }
        return gTotal;
    }
    public int getGTotal(){
        return gTotal;
    }
    public double getTA(){
        double ta;
        ta=getGTotal()-(getGTotal()*getDisc());
        return ta;
    }
    public String tampil(){
        String temp ="   Menu         Jumlah\n";
        for (int i = 0; i < jBeli; i++) {
            temp = temp+(i+1)+". "+beliMenu[i].getNama()+"       "+banyakBeli[i]+"\n";
        }
        return temp;
    }
    public String ToString(){
        String struk=keranjangBeli();
        struk=struk+"\n\n============== Terima Kasih ==============";
        return struk;
    }
}
