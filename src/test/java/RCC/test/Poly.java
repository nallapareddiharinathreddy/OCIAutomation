package RCC.test;

import java.util.HashMap;
import java.util.Map;

class TestInheritance2 {
    public static void main(String args[]) {
        HashMap<String,Integer> map=new HashMap<String, Integer>();
        map.put("hari",20);
        map.put("nikhil",30);
        map.put("chandra",45);

        //System.out.println(map);
        for(Map.Entry m:map.entrySet())
        {
            //System.out.println(m.getKey()+" ...."+m.getValue());
            Integer value=40;
            //System.out.println(m.getValue());
            boolean flag=value==m.getValue();

            if(flag)
            {
                System.out.println("already key exits");
            }
            else
            {
                System.out.println(" key doesnot exits");
                //map.remove(m.getKey(),m.getValue());
                System.out.println("removing element");
                System.out.println("After removing above element remaing are"+m.getKey()+"..."+m.getValue());
            }


        }
        System.out.println(map);
        //map.put("vijay",20);
        //System.out.println(map);
    }

}
