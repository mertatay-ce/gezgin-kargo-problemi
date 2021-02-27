import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class  GezginKargo {
	static Scanner veriAl = new Scanner(System.in);
	public static List<Integer> enKisaYol = new ArrayList<Integer>();
	public static int maliyet = 0;
	public static int N = 81;
	public static int[][] maliyet_matrisi = new int[N][N];
	public static int[][] yol_matrisi = new int[N][N];
        public static List<Integer> enKisaYol1 = new ArrayList<Integer>();
	public static List<Integer> enKisaYol2 = new ArrayList<Integer>();
	public static List<Integer> enKisaYol3 = new ArrayList<Integer>();
	public static List<Integer> enKisaYol4 = new ArrayList<Integer>();
	public static List<Integer> enKisaYol5 = new ArrayList<Integer>();
	

	
	final static int S = Integer.MAX_VALUE; //Sonsuzluğu S ile tanımladık
	static int[][] turkiye  = new int[][] {
        {0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,191,S,69,S,S,S,S,335,S,S,S,S,S,S,S,192,S,S,S,S,207,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,87,S},
        {S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,207,S,S,S,S,S,150,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,187,S,163,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,112,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,0,S,S,S,S,S,S,S,S,S,S,S,169,S,S,S,S,222,S,S,S,S,S,144,S,S,S,S,S,168,S,S,S,S,S,S,S,S,S,223,100,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,115,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,0,S,S,S,S,S,S,S,S,234,S,S,S,S,S,S,S,S,S,S,S,183,S,S,S,S,S,S,S,S,S,S,214,S,S,S,S,S,S,S,S,S,S,S,S,245,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,228,S,S,S,S,S,S,S,S,S,S,143,S,S,S,S,S},
        {S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,92,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,131,S,S,S,S,114,S,S,S,S,S,200,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,0,S,S,S,S,S,S,S,191,S,S,S,130,S,S,S,S,S,S,S,233,S,S,S,S,S,S,S,S,S,S,S,S,S,184,S,258,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,225,S,S,75,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,0,S,S,S,S,S,S,S,122,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,130,466,S,S,S,S,S,S,S,S,322,S,S,S,S,S,311,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,374,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,226,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,161,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,116,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,126,S,S,S,S,S,S,S,S,S,S,S,S,S,S,126,S,S,S,S,S,S,S,S,S,155,S,S,99,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,151,198,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,176,S,S,S,S,S,S,S,228,S,141,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,0,S,S,213,S,94,S,S,S,S,S,S,S,S,S,83,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,112,S,S,S,S,S,S,S,S,S,S,99,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,141,S,144,275,177,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,111,S,S,S,S,S,S,S,S,S,S,S,S,144,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,234,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,83,S,S,S,S,S,S,96,S,S,S,S,S,S,S,S,161,S,S,S,S,S,S,135,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,191,S,S,S,S,213,S,S,0,S,S,S,233,S,S,S,S,S,S,S,291,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,114,S,S,S,S,S,S,S,S,S,S,S,S,157,S,S,S,S,S,S,S,S,S,S,134,S,S,45},
        {S,S,169,S,S,S,122,S,S,S,S,S,S,S,0,S,S,S,S,150,S,S,S,S,S,S,S,S,S,S,S,51,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,241,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,151,94,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,132,S,177,S,S,S,S,S,S,S,S,S,S,157,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,69,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,198,S,S,S,S,S,S,0,S,S,S,S,216,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,187,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,130,S,S,S,S,S,S,S,233,S,S,S,0,156,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,106,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,104,S,S,S,S,S,S,193,S,S,S},
        {S,S,S,S,92,S,S,S,S,S,S,S,S,S,S,S,S,156,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,197,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,172,S,266,S,S,S,S,S,S,S,S,108,S,S,S,S,166,S,S,S,S,S,S,S,S,S,S},
        {S,S,222,S,S,S,S,S,126,S,S,S,S,S,150,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,208,S,S,145,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,150,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,207,S,S,S,S,S,S,S,S,S,141,S,S,S,S,S,S,S,S,0,S,153,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,249,S,S,96,S,252,S,S,S,S,S,S,S,S,S,S,S,S,S,176,S,S,S,S,S,S,S,S,100,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,216,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,140,S,S,S,S,S,S,S,S,S,S,S,761,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,144,S,S,S,S,S,S,S,S,153,S,0,267,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,98,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,136,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,275,S,S,S,S,S,S,S,S,S,S,267,0,190,S,S,295,133,S,S,S,S,S,S,S,S,S,S,S,S,S,S,363,S,S,S,S,S,S,S,S,S,S,S,S,S,248,S,S,S,131,S,S,S,S,S,S,155,S,S,S,S,S,S,S,S,S,S,672,S},
        {S,S,S,183,S,S,S,226,S,S,S,177,S,S,S,S,S,S,S,S,S,S,S,190,0,S,S,S,S,S,S,S,S,S,S,203,S,S,S,S,S,S,S,S,S,S,S,S,266,S,S,S,259,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,125,S,S,S,S,S,233,S,S,S,S,S,S},
        {S,S,144,S,S,233,S,S,S,S,83,S,S,291,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,338,78,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,150,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,193,S,S,S,S,S,S,S,S,S,S,S,S,S,S,76,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,137,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,64,125,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,295,S,S,S,0,162,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,44,S,S,S,S,S,298,S,S,136,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,133,S,S,S,162,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,100,S,S,S,S,S,S,S,78,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,197,S,S,S,S,S,S,S,189,S,S,S,S,S,S,S,S},
        {191,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,193,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,129,S},
        {S,S,168,S,S,S,130,S,S,S,S,S,S,S,51,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,263,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {69,S,S,S,S,S,466,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,348,S,S,S,S,S,S,S,S,200,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,235,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,111,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,131,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,126,176,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,35,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,214,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,203,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,94,140,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,106,197,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,183,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,183,S,S,S,114,S,S,S},
        {335,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,261,S,S,S,81,128,S,S,S,S,S,S,194,S,S,S,S,S,S,S,197,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,62,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,121,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,184,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,91,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,112,S,110,S,S,113,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,132,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,111,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,37,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,65,S,S,S,S},
        {S,S,223,S,S,258,322,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,338,S,S,S,S,S,263,348,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,242,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,148,S,119,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,100,S,S,S,S,S,S,228,112,S,S,S,S,177,S,S,S,S,S,S,S,S,S,78,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,316,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,139,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,187,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,249,S,98,363,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,224,S,S,S,S,S,S,S,S,S,S,S,243,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,155,141,S,S,S,S,S,S,S,S,S,208,S,S,S,S,S,S,S,S,S,S,S,S,S,S,35,S,S,S,S,S,S,S,316,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,195,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {192,163,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,76,S,S,S,S,S,261,S,S,S,S,S,S,S,S,S,S,224,S,0,S,S,S,S,S,S,S,S,S,S,S,327,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,105,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,96,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,227,S,S,S,S,S,S,188,S,S,S,S,S,S,S,S,150,197,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,311,S,99,S,S,S,S,S,241,S,S,S,S,145,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,245,S,S,S,S,S,S,S,111,83,S,S,S,S,S,S,S,252,S,S,S,266,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,218,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,81,S,91,S,S,S,S,S,S,S,S,S,0,82,S,S,S,S,S,S,S,S,S,S,S,S,S,S,203,S,75,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {207,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,200,S,S,S,S,128,S,S,S,242,S,S,S,S,S,S,S,82,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,122,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,44,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,150,S,S,314,S,216,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,161,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,259,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,75,S,S,S,S,S,S,S,253,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,99,S,S,114,S,157,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,37,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,69},
        {S,S,S,S,131,S,S,S,S,S,S,S,S,S,S,S,S,S,172,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,150,S,S,0,S,155,S,S,229,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,96,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,227,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,257,S,S,S,S,S,S,86,100,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,266,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,183,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,155,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,248,S,S,S,298,S,S,S,S,S,S,S,S,S,194,S,S,S,S,S,243,S,327,S,S,S,S,S,314,S,S,S,S,S,0,S,108,S,S,S,S,S,224,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,187,S,S,S,S,140,S,S,S,S,S,S,S,S,S,S,S,131,S,S,S,S,121,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,114,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,216,S,S,229,S,S,108,S,0,S,S,S,S,S,205,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,136,100,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,75,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,178,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,144,S,S,S,S,S,S,S,S,S,S,136,131,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,112,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,176,S,S,S,S,S,137,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,188,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,115,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,150,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,139,S,195,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,228,S,S,S,S,S,S,S,S,161,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,197,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,257,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,357,S,S,S,S,S,S,S,S},
        {S,S,S,S,200,S,S,S,S,S,S,S,S,S,S,S,S,S,108,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,197,S,112,S,S,S,S,S,S,S,S,S,203,S,S,S,S,S,S,S,224,S,205,S,S,S,S,S,0,S,S,S,S,140,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,157,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,87,S,S,S,100,S,S,113},
        {S,S,S,S,S,225,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,110,S,148,S,S,S,S,S,S,S,75,122,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,155,125,S,S,S,78,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,253,S,S,S,S,S,S,S,178,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,374,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,235,S,S,S,S,S,S,S,S,119,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,75,S,S,S,S,S,S,S,S,S,S,S,104,166,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,113,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,140,S,S,S,S,0,S,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,135,S,S,S,S,S,S,S,100,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,150,S,218,S,S,S,S,S,S,86,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,189,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,197,S,S,S,S,S,S,S,S,100,S,S,S,S,S,S,S,S,357,S,S,S,S,S,S,S,0,S,S,S,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,183,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,87,S,S,S,S,S,S,0,S,S,S,89,S,S,S},
        {S,S,S,S,S,S,S,116,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,233,S,S,S,S,S,S,S,S,S,S,94,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S,S},
        {S,S,S,143,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,140,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,69,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,65,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,134,S,S,S,193,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,114,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,100,S,S,S,S,S,S,89,S,S,S,0,S,S,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,64,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S,S},
        {87,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,125,S,S,S,129,S,S,S,S,S,S,S,S,S,S,S,S,S,S,105,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,0,S},
        {S,S,S,S,S,S,S,S,S,S,S,S,S,45,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,S,69,S,S,S,S,S,S,S,S,S,S,S,S,113,S,S,S,S,S,S,S,S,S,S,S,S,S,0}
	};
	public static void main(String[] args) throws FileNotFoundException {
                SehirOku();
                  
                  
		System.out.println("Teslimat Sayisi Gir:");
		int tes_say = 1;
		tes_say = veriAl.nextInt();
		while (tes_say >= 11) {
			System.out.println("Teslimat Sayisi 10 a esit ve 10 dan buyuk olamaz.");
			System.out.println("Teslimat Sayisini Yeniden Gir:");
			tes_say = veriAl.nextInt();
		}
		List<Integer> tes_yer = new ArrayList<Integer>();
		for (int i = 0; i < tes_say; i++) {
			System.out.printf("%d. teslimat yerinin plaka kodunu giriniz:", i + 1);
			tes_yer.add(veriAl.nextInt());
		}

		System.out.println();
		System.out.println("EN KISA ROTA OLUŞTURULUYOR...");
		System.out.println();
		
		FloydWarshallAlgoritmasi(turkiye);
		
		YolBulucu(tes_yer, tes_say);
		
		Yazdir();
		enKisaYol1=new ArrayList<>(enKisaYol);
		enKisaYol.clear();
		maliyet=0;
		
		
		List<Integer> komsular = Komsular(tes_yer.get(tes_say-1)-1);
		
		int i=0;
		while (i<=3) {
			if(komsular.size()<=i) {
				break;
			}
			if(komsular.get(i)==tes_yer.get(tes_say-1)) {
				continue;
			}
			tes_yer.add(tes_say-1, komsular.get(i));
			YolBulucu(tes_yer, tes_say+1);
			System.out.println();
			Yazdir();
                        if(i==0){
                        enKisaYol2=new ArrayList<>(enKisaYol);
                        }
                        if(i==1){
                        enKisaYol3=new ArrayList<>(enKisaYol);
                        }
                        if(i==2){
                        enKisaYol4=new ArrayList<>(enKisaYol);
                        }
                        if(i==3){
                            //System.out.println("5.hesaplandı");
                        enKisaYol5=new ArrayList<>(enKisaYol);
                        }
			enKisaYol.clear();
			maliyet=0;
			i++;
		}
		harita Harita1=new harita("Harita1");
                harita Harita2=new harita("Harita2");
                harita Harita3=new harita("Harita3");
                harita Harita4=new harita("Harita4");
                harita Harita5=new harita("Harita5");
                  Harita1.setEnKisaYol(enKisaYol1);
                  Harita2.setEnKisaYol(enKisaYol2);
                  Harita3.setEnKisaYol(enKisaYol3);
                  Harita4.setEnKisaYol(enKisaYol4);
                  Harita5.setEnKisaYol(enKisaYol5);
                  Harita1.setVisible(true);
                  Harita2.setVisible(true);
                  Harita3.setVisible(true);
                  Harita4.setVisible(true);
                  Harita5.setVisible(true);
	}
	//İnternetten Alıntıdır:https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
	public static void FloydWarshallAlgoritmasi(int[][] matris) {
		for (int v = 0; v < N; v++) {
			for (int u = 0; u < N; u++) {

				maliyet_matrisi[v][u] = matris[v][u];

				if (v == u)
					yol_matrisi[v][u] = 0;
				else if (maliyet_matrisi[v][u] != Integer.MAX_VALUE)
					yol_matrisi[v][u] = v;
				else
					yol_matrisi[v][u] = -1;
			}
		}
		//Maliyet matrisi son halini aldı. Tüm şehirlerin tüm şehirlere maliyeti hesaplandı.
		for (int i = 0; i < N; i++) {
			for (int v = 0; v < N; v++) {
				for (int u = 0; u < N; u++) {
					if (maliyet_matrisi[v][i] != Integer.MAX_VALUE && maliyet_matrisi[i][u] != Integer.MAX_VALUE
							&& (maliyet_matrisi[v][i] + maliyet_matrisi[i][u] < maliyet_matrisi[v][u])) {
						maliyet_matrisi[v][u] = maliyet_matrisi[v][i] + maliyet_matrisi[i][u];
						yol_matrisi[v][u] = yol_matrisi[i][u];
					}
				}

				if (maliyet_matrisi[v][v] < 0) {
					System.out.println("Negatif Döngü");
					break;
				}
			}
		}
	}
	public static void EnKisaYolHesapla(int bas, int bit) {
		if (yol_matrisi[bas][bit] == bas) {
			return;
		} else {
			EnKisaYolHesapla(bas, yol_matrisi[bas][bit]);
		}
		enKisaYol.add((yol_matrisi[bas][bit] + 1));
	}
	public static void YolBulucu(List<Integer> Liste,int tes_say) {
		enKisaYol.add(41);
		EnKisaYolHesapla(40, Liste.get(0)-1);
		maliyet+= maliyet_matrisi[40][Liste.get(0)-1];
		
		for(int i=1; i<tes_say;i++) {
			enKisaYol.add(Liste.get(i-1));
			EnKisaYolHesapla(Liste.get(i-1)-1, Liste.get(i)-1);
			maliyet+= maliyet_matrisi[Liste.get(i-1)-1][Liste.get(i)-1];
		}
		enKisaYol.add(Liste.get(tes_say-1));
		EnKisaYolHesapla(Liste.get(tes_say-1)-1, 40);
		maliyet+= maliyet_matrisi[Liste.get(tes_say-1)-1][40];
		enKisaYol.add(41);
		enKisaYol.add(maliyet);
	}
	public static List<Integer> Komsular(int ilk_hedef) {
		List<Integer> komsular = new ArrayList<Integer>();
		for(int j=0; j<81; j++) {
			if( turkiye[ilk_hedef][j] != 0 && turkiye[ilk_hedef][j] != S) {
				komsular.add(j+1);
			}
		}
		return komsular;
	}
	public static void Yazdir() {
		for (Integer integer : enKisaYol) {
                       
			System.out.print(integer+" ");
		}
	}
        public static void SehirOku() throws FileNotFoundException{
        File f = new File("sehir.txt");
        File f2 = new File("mesafeler.txt");
        Scanner dosya = new Scanner(f);
        Scanner dosya2 = new Scanner(f2);
        ArrayList<String> sehirler =new ArrayList<>();
        ArrayList<String> mesafe =new ArrayList<>();
    while(dosya.hasNextLine()) {
	sehirler.add(dosya.nextLine());
        }
    while(dosya2.hasNextLine()) {
	mesafe.add(dosya2.nextLine());
    
        }
   //DOSYADAN VERİLER OKUNDU 
    ArrayList<Sehir> sehir_class=new ArrayList<>();
    String[][] sehirler_array=new String[sehirler.size()][];
    String[][] sehir_mesafe_array=new String[sehirler.size()][];
    for(int i=0;i<sehirler.size();i++){
        sehirler_array[i]=sehirler.get(i).split(",");
        sehir_mesafe_array[i]=mesafe.get(i).split(",");
        int sehir_id=Integer.valueOf(sehirler_array[i][0]);
        String sehir_adi=sehirler_array[i][1];
        sehir_class.add(new Sehir(sehir_id,sehir_adi));
          
    }// veriler parçalanıp sehirlerin clasları oluşturuldu.

    for(int i=0;i<sehir_class.size();i++){
                
        for(int j=2;j<sehirler_array[i].length;j++){
            Sehir komsu=null;
            int komsu_mesafe=Integer.valueOf(sehir_mesafe_array[i][j-1]);
            for(Sehir k : sehir_class){
                if(k.getSehir_adi().equals(sehirler_array[i][j])){
                   komsu=k;
                   
                break;
                }    
            }
            sehir_class.get(i).komsular.add(komsu);
            sehir_class.get(i).komsu_mesafe.add(komsu_mesafe);  
        }
    }// KOMSU EKLEME SONU
     
     /*  for(Sehir i: sehir_class){
    
            System.out.print(""+i.getSehir_adi());
            System.out.println("  Komşuları :");
             for(int j=0;j<i.komsular.size();j++){
                 System.out.print(i.komsular.get(j).getSehir_adi()+"("+i.komsu_mesafe.get(j)+")  -");
             }
             System.out.println("");
    
        }*/
        }
}
