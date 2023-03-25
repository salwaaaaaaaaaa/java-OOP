
package pkgWarungGui;
import javax.swing.JOptionPane;
public class cMenu {
    private String nama;
    private int harga;
    cMenu(String n, int h){
        nama = n;
        harga = h;
        JOptionPane.showMessageDialog(null, "Menu "+nama+" dibuat...");
    }
    public void setNama(String n){
        nama = n;
    }
    public void setHarga(int h){
        harga = h;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }
    public String ToString(){
        return nama+"  ["+harga+"]";
    }
}
