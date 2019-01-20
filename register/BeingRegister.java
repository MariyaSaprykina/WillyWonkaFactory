package register;

import entities.Being;
import entities.Kid;
import entities.OompaLoompa;
import java.util.ArrayList;

public class BeingRegister {
       private ArrayList<Being> beings;
       
       public BeingRegister(){
           beings = new ArrayList<>();
       }
       
       public void addKid(Kid k){
           beings.add(k);
       }
       
       public void addOompaLoompa(OompaLoompa ol){
           beings.add(ol);
       }
       
       public ArrayList<Being> getBeings(){
           return beings;
       }
       
       public ArrayList<Kid> getKids(){
           ArrayList<Kid> kids = new ArrayList<>();
           for(Being b: beings){
               if(b instanceof Kid){
                       kids.add((Kid)b);
                }
           }
           
           return kids;
       }
       
       public ArrayList<OompaLoompa> getOompaLoompas(){
           ArrayList<OompaLoompa> oompaLoompas = new ArrayList<>();
           for(Being b: beings){
               if(b instanceof OompaLoompa){
                       oompaLoompas.add((OompaLoompa)b);
                }
           }
           
           return oompaLoompas;
       }
}

