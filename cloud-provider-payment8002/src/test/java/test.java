public class test {
    public static void main(String[] args) {
        String a="acdbacbabccbacbddd";
        System.out.println(getStr(a));
    }
    public static String getStr(String string){
        StringBuffer sb=new StringBuffer(string);
        StringBuffer b1=null;
        boolean flag=false;
        for(int i=0;i<string.length();i++){
            if (string.contains("b")){
                b1 = sb.deleteCharAt(string.indexOf("b"));
                string=b1.toString();
            }else{
                break;
            }
        }
        for (int i=0;i<b1.length()-1;i++){
            if (b1.charAt(i)=='a') {
               if(b1.charAt(i+1)=='c'){
                   flag=true;
               }else {
                   flag=false;
               }
            }else {
                flag=false;
            }
            if(flag){
                b1.deleteCharAt(i);
                System.out.println(b1.toString());
                b1.deleteCharAt(i);
                System.out.println(b1.toString());
                i--;
            }
        }
        return b1.toString();
    }
}
