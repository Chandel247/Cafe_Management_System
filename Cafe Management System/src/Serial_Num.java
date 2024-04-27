import java.util.Random;

public class Serial_Num {
    
    public String serial_genrator(){
        String chars="0123456789";
        String serial_num="";
        Random random=new Random();
        for (int i=0; i<=5;i++){
            int Random_Index=random.nextInt(chars.length());
            char Random_char=chars.charAt(Random_Index);
            serial_num+=Random_char;
        }
        return serial_num;
    }
}
