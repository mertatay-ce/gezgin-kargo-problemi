
import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;


public class harita extends JFrame{
          ImageIcon resim=new ImageIcon("turkiye.png");

        public  List<Integer> enKisaYol = new ArrayList<Integer>();

	
    public harita(String title) throws HeadlessException {
        super(title); 
          setSize(1800,1000); 
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          
    }

    public List<Integer> getEnKisaYol() {
        return enKisaYol;
    }

    public void setEnKisaYol(List<Integer> enKisaYol) {
        this.enKisaYol = enKisaYol;
    }
    
    @Override
    public void paint(Graphics g) {
        kordinat kordinat=new kordinat();
        super.paint(g); //To change body of generated methods, choose Tools | Templates
         g.drawImage(resim.getImage(),0,0,getWidth(),getHeight(), this);
                g.setColor(Color.BLACK);
        for(kordinat i:kordinat.kordinatlar){
             g.fillRect(i.getX(),i.getY(),10,10);
             
        }
        g.setColor(Color.RED);
        for(int i=0;i<enKisaYol.size()-2;i++){
            int x1=new kordinat().getX(enKisaYol.get(i));
            int y1=new kordinat().getY(enKisaYol.get(i));
            int x2=new kordinat().getX(enKisaYol.get(i+1));
            int y2=new kordinat().getY(enKisaYol.get(i+1));
            g.fillRect(x1,y1,10,10);
            g.drawLine(x1,y1,x2,y2);
            
        
        }
  
    }
    
    
    
    
}
