package com.huawei.cloud.util;

import java.io.*;

/**
 * Created by zhouyibin on 2017/12/5.
 */
public class FileUtil {

    public static String readFile(String filePath){
        StringBuilder stringBuilder = new StringBuilder();

        InputStream inputStream = null;
        BufferedReader reader = null;
        try {
            inputStream = new FileInputStream(filePath);
            reader = new BufferedReader(new InputStreamReader(inputStream));
            String line = reader.readLine();
            while (null != line){
                stringBuilder.append(line);
                stringBuilder.append("\n");
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return stringBuilder.toString();
    }
}
