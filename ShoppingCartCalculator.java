import java.util.ArrayList;

public class ShoppingCartCalculator {

    /**
     * เป็นเมธอดตรวจสอบสินค้า(sku)เพื่อนำโปรโมชั่นมาคำนวณราคาสินค้าโดยใช้price,quantity
     * - ส่งค่ากลับ0.0บาทเมื่อ sku= null หรือ empty
     * - คำนวณราคาสินค้าปกติเมื่อsku="NORMAL"
     * - คำนวณราคาสินค้า(ซื้อ2จ่าย1,ซื้อ3จ่าย2,ซื้อ4จ่าย2)เมื่อsku="BOGO" 
     * - คำนวณราคาสินค้า(ซื้อ >= 6 ชิ้น ลด 10%)เมื่อsku="BULK" 
     * -@param items ประกอบด้วย(sku,name,price,quantity)
     * sku คือ string ของโค้ดสินค้าที่ใช้ตรวจจำแนกการคำนวณราคาสินค้าตามโปรโมชั่น
     * name คือ ชื่อของสินค้า(Bread,Milk) priceคือราคาของสินค้า{Bread=25บาท,Milk=15บาท}
     * quantity คือจำนวนสินค้าที่ซื้อ
     * @return ราคารวมทั้งหมดหลังคำนวณโปรโมชั่น (หน่วย: บาท)
     */
    public static double calculateTotalPrice(ArrayList<CartItem> items) {
        // TODO: เขียนโค้ด Implementation ที่นี่
        
        double count1=0,count2=0;
        if( items==null|| items.isEmpty() )
        {return 0.0; }
        else for (CartItem item : items) {
        if (item.sku().equals("NORMAL") ){ //คำนวณปกติ
            if(item.name().equals("Bread")  ) {
            count1 += item.price() * item.quantity(); }
            else if(item.name().equals("Milk"))
            {count2+=item.price() * item.quantity();}}

        if (item.sku().equals("BOGO") ) //ลดราคาโดยการแถม
        {if(item.name().equals("Bread")  ) {
            count1 += item.price() *(Math.ceil(item.quantity()/2.0)); }
            else if(item.name().equals("Milk"))
            {count2+=item.price() *(Math.ceil(item.quantity()/2.0));}
        }
        if (item.sku().equals("BULK") ) //ลดราคา10%
        {   
           if(item.name().equals("Bread")  ) {
           count1 += item.price() * item.quantity();
            if (item.quantity()>=6) {
          count1-=count1*10/100;}
        }
           else if(item.name().equals("Milk"))
           {count2+=item.price() * item.quantity();
           if (item.quantity()>=6 ) {
            count2-=count2*10/100; }
          }  } }
            return count1+count2;

    
    
}}