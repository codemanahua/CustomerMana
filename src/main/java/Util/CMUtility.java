package Util;
import java.util.Scanner;

public class CMUtility {
    private static Scanner scanner=new Scanner(System.in);

    //读取菜单项char类型的数组
    public static char readMenuSelection(){
        char c;
        for (;;){
            String str=readKeyBoard(1,false);
            c=str.charAt(0);
            if(c!='1'&&c!='2'&&c!='3'&&c!='4'&&c!='5'){
                System.out.println("选择错误，请重新输入");
            }else break;
        }
        return c;
    }
    public static char readChar(){
        String str=readKeyBoard(1,false);
        return str.charAt(0);
    }
    //读取一个字符
    public static char readChar(char defaultValue){
        String str=readKeyBoard(1,true);
        return (str.length()==0)?defaultValue:str.charAt(0);
    }

    //读取一个int类型数据
    public static int readInt(){
        int n;
        for (;;){
            String str=readKeyBoard(2,false);
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }
        }
        return n;
    }
    //读一个int类型的数据，如果用户没有输入，读取默认值defaultValue
    public static int readInt(int defaultValue){
        int n;
        for (;;){
            String str=readKeyBoard(2,true);
            if(str.equals("")){
                return defaultValue;
            }
            try{
                n=Integer.parseInt(str);
                break;
            }catch (NumberFormatException e){
                System.out.println("数字输入错误，请重新输入：");
            }

        }
        return n;
    }
    //读取一个字符串
    public static String readString(int limit){
        return readKeyBoard(limit,false);
    }
    //读取一个字符串，如果用户没有输入读取默认值defaultValue
    public static String readString(int limit,String defaultValue){
        String str=readKeyBoard(limit,true);
        return str.equals("")? defaultValue:str;
    }
    //读取是否确认只有y/n
    public static char readConfirmSelection(){
        char c;
        for (;;){
            String str=readKeyBoard(1,false).toUpperCase();
            c=str.charAt(0);
            if(c=='Y'||c=='N'){
                break;
            }else {
                System.out.println("选择错误，请重新输入：");
            }
        }
        return c;
    }


    private static String readKeyBoard(int limit, boolean blankReturn) {
        String line="";
        while (scanner.hasNextLine()){
            line=scanner.nextLine();
            if (line.length()==0){
                if(blankReturn) return line;
                else continue;
            }
            if (line.length()<1||line.length()>limit){
                System.out.println("输入长度（不大于"+limit+"）错误，请重新输入：");
                continue;
            }
            break;
        }
        return line;
    }


}