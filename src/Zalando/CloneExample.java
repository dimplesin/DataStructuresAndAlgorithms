package Zalando;

/**
 * Created by v-dsindhi on 3/5/16.
 */
public class CloneExample implements Cloneable {

        int a=0;
        String name="";
    CloneExample (int a,String name){
            this.a=a;
            this.name=name;
        }

        public CloneExample clone() throws CloneNotSupportedException{

            return (CloneExample ) super.clone();

        }

        public static void main(String[] args) {

            CloneExample e=new CloneExample (2,"Indhu");
            System.out.println(e.name);

            try {

                CloneExample b=e.clone();
                System.out.println(b.name);

            }
            catch (CloneNotSupportedException e1) {

                e1.printStackTrace();
            }
        }


}
