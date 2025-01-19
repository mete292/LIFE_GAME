package default_package;


import java.util.Iterator;
import java.util.Spliterator.OfPrimitive;

public class LifeGame {
	
	int habitatsatir=19;
	int habitatsutun=19;
	String hucrehabitat[][];		
	String hucrehabitattmp[][];	
	String[] pulsarsatir;
	int [] pSatir;
	String pulsarsutun[];
	public  LifeGame () {
		pSatir=new int[] {3,8,10,15};
		pulsarsatir=new String[] {"-","-","-","-","-","#","#","#","-","-","-","#","#","#","-","-","-","-","-"};
		pulsarsutun=new String[] {"-","-","-","-","-","#","#","#","-","-","-","#","#","#","-","-","-","-","-"};
		hucrehabitat=new String[habitatsatir][habitatsutun];
		hucrehabitattmp=new String[habitatsatir][habitatsutun];
		int sifir=0;
		for(int i=0;i<habitatsatir;i++) {
			for(int j=0;j<habitatsutun;j++) {
				hucrehabitattmp[i][j]="-";
				hucrehabitat[i][j]="-";
			}
			
		}
	 for(int satır=0;satır<pSatir.length;satır++) {
		 for(int sutun=0;sutun<pulsarsutun.length;sutun++) {
			 hucrehabitat[pSatir[satır]][sutun]=pulsarsatir[sutun];
			 
		 }
	 }
	 for(int sutun=0;sutun<pSatir.length;sutun++) {
		 for(int satır=0;satır<pulsarsatir.length;satır++) {
			 hucrehabitat[satır][pSatir[sutun]]=pulsarsutun[satır];
		 }
		 
	 }
		
	
	}
	public void drawhabitat() {
		for(int i =0;i<habitatsatir;i++) {
			for(int j=0;j<habitatsutun;j++) {
				System.out.print(hucrehabitat[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
		
	
	}
	public void drawhabitattmp() {
		for(int i =0;i<habitatsatir;i++) {
			for(int j=0;j<habitatsutun;j++) {
				System.out.print(hucrehabitattmp[i][j]+" ");
			}
			System.out.println();
		}
		
	
	}
	public int CanliKomsuSayisi(int satir,int sutun) {
		int komsusayisi=0;
		for(int i =-1;i<2;i++) {
			for(int j =-1;j<2;j++) {
				
				if (hucrehabitat[satir+i][sutun+j]=="#") {
					komsusayisi+=1;
					}
			}
		}
		return komsusayisi;
	}
	
	public void NewHabitatRule() {
		
		for(int i=1;i<habitatsatir-1;i++) {
			for(int j=1;j<habitatsutun-1;j++) {
				if (CanliKomsuSayisi(i,j)<2) {
					hucrehabitattmp[i][j]="-";
					}
				else if ((CanliKomsuSayisi(i,j)==2 || CanliKomsuSayisi(i,j)==3) &&hucrehabitat[i][j]=="#") {
					hucrehabitattmp[i][j]="#";
			    }
				else if (hucrehabitat[i][j]=="#" && CanliKomsuSayisi(i, j)>3) {
					hucrehabitattmp[i][j]="-";
					}
				else if (hucrehabitat[i][j]=="-" && CanliKomsuSayisi(i, j)==3) {
					hucrehabitattmp[i][j]="#";
					}
				}
			}
			
		}
	public void CopyHabitat() {
		for(int i=1;i<habitatsatir-1;i++) {
			for(int j=1;j<habitatsutun-1;j++) {
				hucrehabitat[i][j]=hucrehabitattmp[i][j];
			}
		}
		
	}
	

	public static void main(String[] args) throws Exception {
		LifeGame game=new LifeGame();
		for(int i=0;i<20;i++) {
			game.drawhabitat();
			game.NewHabitatRule();
			game.CopyHabitat();
			System.out.println();
			Thread.sleep(750);
			
		
		}
	}
}

