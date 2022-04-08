package jsondemo;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.*;

public class CreatJSON {

    public static void main(String[] args) throws IOException {
        Tool tool = new Tool();

        JsonObject object = new JsonObject();

        JsonArray array = new JsonArray();

        JsonObject user1 = new JsonObject();
        user1.addProperty("bookingNum", "001");
        user1.addProperty("surname", "Yunhan");
        user1.addProperty("firstname", "Xi");
        user1.addProperty("flightNum", "AB6060");
        user1.addProperty("seatNum", "06B");
        user1.addProperty("meal", "Normal");
        user1.addProperty("flyingDate", "2022-04-01");
        user1.addProperty("depAddr", "Shanxi");
        user1.addProperty("desAddr", "Beijing");
        user1.addProperty("totalTime", "1.5h");
        user1.addProperty("delayStatus", "No");
        user1.addProperty("luggage", "1.5kg");
        array.add(user1);

        JsonObject user2 = new JsonObject();
        user2.addProperty("bookingNum", "002");
        user2.addProperty("surname", "Ruxu");
        user2.addProperty("firstname", "Zhang");
        user2.addProperty("flightNum", "BC7070");
        user2.addProperty("seatNum", "06C");
        user2.addProperty("meal", "Normal");
        user2.addProperty("flyingDate", "2022-04-01");
        user2.addProperty("depAddr", "Shanghai");
        user2.addProperty("desAddr", "Beijing");
        user2.addProperty("totalTime", "2.5h");
        user2.addProperty("delayStatus", "No");
        user2.addProperty("luggage", "2kg");
        array.add(user2);

        JsonObject user3 = new JsonObject();
        user3.addProperty("bookingNum", "003");
        user3.addProperty("surname", "Ruotong");
        user3.addProperty("firstname", "Cui");
        user3.addProperty("flightNum", "CD8080");
        user3.addProperty("seatNum", "06A");
        user3.addProperty("meal", "Normal");
        user3.addProperty("flyingDate", "2022-04-01");
        user3.addProperty("depAddr", "Shengyang");
        user3.addProperty("desAddr", "Beijing");
        user3.addProperty("totalTime", "2h");
        user3.addProperty("delayStatus", "No");
        user3.addProperty("luggage", "1kg");
        array.add(user3);

        object.add("UserData", array);

        //System.out.println(object.toString());
        File file=new File("Data.json");
        if(!file.exists())//判断文件是否存在，若不存在则新建
        {
            file.createNewFile();
        }
        FileOutputStream fileOutputStream=new FileOutputStream(file);//实例化FileOutputStream
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream,"utf-8");//将字符流转换为字节流
        BufferedWriter bufferedWriter= new BufferedWriter(outputStreamWriter);//创建字符缓冲输出流对象

        String jsonString=object.toString();//将jsonarray数组转化为字符串
        String JsonString=tool.stringToJSON(jsonString);//将jsonarrray字符串格式化
        bufferedWriter.write(JsonString);//将格式化的jsonarray字符串写入文件
        bufferedWriter.flush();//清空缓冲区，强制输出数据
        bufferedWriter.close();//关闭输出流
    }

}

