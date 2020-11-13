package com.zhou.springboot.controller;

import com.zhou.springboot.model.TestBean;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * springboot学习
 *
 * @author zhou
 * @data 2018-8-7
 */
@Log4j2
@Controller
@RequestMapping(value = "/base64")
@Lazy
public class Base64Controller {

    //0,0,1,0,1,0,1,0,1,0,1,1,0,0,

/*    @Test
    public void test() {
        //        int[] ss = new int[]{0,1,0,1,0,1,0};
        Scanner in = new Scanner(System.in);
        List list = new ArrayList();
        while (in.hasNextInt()) {
            list.add(in.nextInt());
        }
        System.out.println(list);

        String maxS = "";
        int prev = 0;
        boolean valid = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ss.length; i++) {
            int a = ss[i];
            if (a == 0 && prev == 0) {
                if (valid && sb.length() > maxS.length() && sb.length() > 1) {
                    maxS = sb.toString();
                }
                sb = new StringBuilder();
                valid = true;
            } else if (prev == 0 && a == 1) {
                prev = 1;
            } else if (prev == 1 && a == 0) {
                prev = 0;
            } else if (prev == 1 && a == 1) {
                valid = false;
            }
            sb.append(a);
        }
        if (valid && sb.length() > maxS.length() && sb.length() > 1) {
            maxS = sb.toString();
        }
        System.out.println(maxS);
    }*/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        //        int a = 525;
        //        int b = 6;
        int c = b * (b - 1) / 2;
        int begin = (a - c) / b;
        if ((begin * b) != (a - c)) {
            System.out.println(-1);
        } else {
            for (int i = 0; i < b; i++) {
                System.out.print(begin + i);
                if (i != b - 1) {
                    System.out.print(" ");
                }
            }
        }
    }

    public static void main1(String[] args) {
        Scanner in = new Scanner(System.in);
        String maxS = "0";
        int prev = 0;
        boolean valid = true;
        StringBuilder sb = new StringBuilder();
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int a = in.nextInt();
            if (a == 0 && prev == 0) {
                if (valid && sb.length() > maxS.length() && sb.length() > 1) {
                    maxS = sb.toString();
                }
                sb = new StringBuilder();
                valid = true;
            } else if (prev == 0 && a == 1) {
                prev = 1;
            } else if (prev == 1 && a == 0) {
                prev = 0;
            } else if (prev == 1 && a == 1) {
                valid = false;
            }
            sb.append(a);
        }
        if (valid && sb.length() > maxS.length() && sb.length() > 1) {
            maxS = sb.toString();
        }
        System.out.println(maxS.length() <= 1 ? "-1" : 0 + maxS);
    }


    @RequestMapping(value = "/exception")
    @ResponseBody
    @Transactional
    public String exceptionTest(@RequestBody TestBean data, HttpServletRequest request) {
        int a = 10 / 0;
        return "end";
    }

/*    @PostMapping(value = "/post")
    public JSONObject getBase64(@RequestBody String data) {
        return null;
    }*/

    @PostMapping(value = "/post")
    public String getStream(HttpServletRequest request) {
        InputStream inputStream = null;
        int length = request.getContentLength();
        String data = null;
        try {
            inputStream = request.getInputStream();
            data = getStreamData(inputStream, length);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }

    /**
     * 获取流中的数据
     *
     * @param inputStream
     * @param length
     * @throws IOException
     */
    private String getStreamData(InputStream inputStream, int length) throws IOException {
        byte[] bytes = new byte[length];
        int count = -1;
        ByteArrayOutputStream bos = new ByteArrayOutputStream(length);
        while ((count = inputStream.read(bytes)) != -1) {
            bos.write(bytes);
        }
        bytes = null;
        return new String(bytes);
    }

}
