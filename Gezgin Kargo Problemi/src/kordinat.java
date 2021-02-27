
import java.util.ArrayList;


public class kordinat {
    private int id;
    private int x;
    private int y;
    public static ArrayList<kordinat>  kordinatlar=new ArrayList<>();

    public kordinat() {
       kordinatlar.add(new kordinat(1,870,730));
       kordinatlar.add(new kordinat(2,1125,654));
       kordinatlar.add(new kordinat(3,430,530));
       kordinatlar.add(new kordinat(4,1555,350));
       kordinatlar.add(new kordinat(5,903,265));
       kordinatlar.add(new kordinat(6,610,360));
       kordinatlar.add(new kordinat(7,500,760));
       kordinatlar.add(new kordinat(8,1425,200));
       kordinatlar.add(new kordinat(9,170,640));
       kordinatlar.add(new kordinat(10,200,400));
       kordinatlar.add(new kordinat(11,386,331));
       kordinatlar.add(new kordinat(12,1339,465));
       kordinatlar.add(new kordinat(13,1478,536));
       kordinatlar.add(new kordinat(14,530,285));
       kordinatlar.add(new kordinat(15,370,704));
       kordinatlar.add(new kordinat(16,302,318));
       kordinatlar.add(new kordinat(17,88,350));
       kordinatlar.add(new kordinat(18,700,280));
       kordinatlar.add(new kordinat(19,800,270));
       kordinatlar.add(new kordinat(20,290,650));
       kordinatlar.add(new kordinat(21,1314,628));
       kordinatlar.add(new kordinat(22,96,165));
       kordinatlar.add(new kordinat(23,1216,525));
       kordinatlar.add(new kordinat(24,1241,375));
       kordinatlar.add(new kordinat(25,1394,344));
       kordinatlar.add(new kordinat(26,431,383));
       kordinatlar.add(new kordinat(27,1060,755));
       kordinatlar.add(new kordinat(28,1150,265));
       kordinatlar.add(new kordinat(29,1225,276));
       kordinatlar.add(new kordinat(30,1648,633));
       kordinatlar.add(new kordinat(31,951,878));
       kordinatlar.add(new kordinat(32,433,635));
       kordinatlar.add(new kordinat(33,734,804));
       kordinatlar.add(new kordinat(34,325,202));
       kordinatlar.add(new kordinat(35,125,545));
       kordinatlar.add(new kordinat(36,1550,235));
       kordinatlar.add(new kordinat(37,730,173));
       kordinatlar.add(new kordinat(38,880,530));
       kordinatlar.add(new kordinat(39,152,102));
       kordinatlar.add(new kordinat(40,761,480));
       kordinatlar.add(new kordinat(41,387,215));
       kordinatlar.add(new kordinat(42,608,652));
       kordinatlar.add(new kordinat(43,344,426));
       kordinatlar.add(new kordinat(44,1143,577));
       kordinatlar.add(new kordinat(45,200,500));
       kordinatlar.add(new kordinat(46,1020,640));
       kordinatlar.add(new kordinat(47,1373,705));
       kordinatlar.add(new kordinat(48,222,721));
       kordinatlar.add(new kordinat(49,1450,470));
       kordinatlar.add(new kordinat(50,812,556));
       kordinatlar.add(new kordinat(51,810,640));
       kordinatlar.add(new kordinat(52,1050,250));
       kordinatlar.add(new kordinat(53,1360,195));
       kordinatlar.add(new kordinat(54,430,245));
       kordinatlar.add(new kordinat(55,900,180));
       kordinatlar.add(new kordinat(56,1476,607));
       kordinatlar.add(new kordinat(57,823,130));
       kordinatlar.add(new kordinat(58,1020,392));
       kordinatlar.add(new kordinat(59,153,208));
       kordinatlar.add(new kordinat(60,975,320));
       kordinatlar.add(new kordinat(61,1250,220));
       kordinatlar.add(new kordinat(62,1250,465));
       kordinatlar.add(new kordinat(63,1200,740));
       kordinatlar.add(new kordinat(64,329,530));
       kordinatlar.add(new kordinat(65,1650,520));
       kordinatlar.add(new kordinat(66,820,380));
       kordinatlar.add(new kordinat(67,556,175));
       kordinatlar.add(new kordinat(68,750,580));
       kordinatlar.add(new kordinat(69,1300,305));
       kordinatlar.add(new kordinat(70,675,750));
       kordinatlar.add(new kordinat(71,704,385));
       kordinatlar.add(new kordinat(72,1420,623));
       kordinatlar.add(new kordinat(73,1530,660));
       kordinatlar.add(new kordinat(74,601,137));
       kordinatlar.add(new kordinat(75,1513,170));
       kordinatlar.add(new kordinat(76,1650,315));
       kordinatlar.add(new kordinat(77,330,266));
       kordinatlar.add(new kordinat(78,625,200));
       kordinatlar.add(new kordinat(79,1040,805));
       kordinatlar.add(new kordinat(80,956,760));
       kordinatlar.add(new kordinat(81,495,245));
    }
    
    public kordinat(int id,int x, int y) {
        this.id=id;
        this.x = x;
        this.y = y;
       
       
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

   
 public int getY() {
        return y;
    } 
 public int getX(){
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
     public int getX(int id) {
           for(kordinat i:kordinatlar){
        if(i.getId()==id){
        return i.getX();
       
        }
        }
        return 0;
    }
    public int getY(int id) {
        for(kordinat i:kordinatlar){
        if(i.getId()==id){
        return i.getY();
        }
        }
        return 0;
    }

    public void setY(int y) {
        this.y = y;
    }
    
}
