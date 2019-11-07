package com.example.musicfm_fuzzer.musicfm;

import android.net.Uri;
import android.support.v7.widget.FastlabelText;
import android.text.TextUtils;
import android.util.Base64;

import com.example.musicfm_fuzzer.MainActivity;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


class f {
    static List a(Object[] arg0) {
        return Arrays.asList(arg0);
    }
}


class d {
    public static final List a(Object[] arg1) {
        //g.b(((Object)arg1), "receiver$0");
        List v1 = f.a(arg1);
        //g.a(v1, "ArraysUtilJVM.asList(this)");
        return v1;
    }

    public static final byte[] a(byte[] arg1, int arg2, int arg3) {
        //g.b(((Object)arg1), "receiver$0");
        //a.a(arg3, arg1.length);
        byte[] v1 = Arrays.copyOfRange(arg1, arg2, arg3);
        //g.a(((Object)v1), "java.util.Arrays.copyOfR…this, fromIndex, toIndex)");
        return v1;
    }

    public static final byte[] a(byte[] arg3, byte[] arg4) {
        //g.b(((Object)arg3), "receiver$0");
        //g.b(((Object)arg4), "elements");
        int v0 = arg3.length;
        int v1 = arg4.length;
        byte[] v3 = Arrays.copyOf(arg3, v0 + v1);
        System.arraycopy(((Object)arg4), 0, ((Object)v3), v0, v1);
        //g.a(((Object)v3), "result");
        return v3;
    }
}


public class misc {



    private static final int b = 32000;

    /**
     *
     * @param arg11 要加密或者解密的字节流
     * @param arg12 true 为解密，false为加密
     * @return
     */
    public static final byte[] a_encrypt_decrypt(byte[] arg11, boolean arg12) {
        //kotlin.c.b.g.b(((Object)arg11), "byteArray");
        if(arg11.length == 0) {
            return arg11;
        }

        int v1 = 0;
        byte[] v2 = new byte[0];
        int v3 = misc.b;
        byte[] v6 = v2;
        int v2_1 = 1;
        int v5 = 0;
        while(true) {
            if(v3 > arg11.length) {
                v3 = arg11.length;
            }

            byte[] v7 = d.a(arg11, v1, v3);
            if(v1 == 0 && (arg12)) {
                v7 = MainActivity.drawTextWithArray(v7);
            }

            int v1_1 = v7.length;
            byte[] v7_1 = MainActivity.drawText(v7, v5);
            v5 += v1_1;
            v6 = d.a(v6, v7_1);
            ++v2_1;
            int v1_2 = v3 * v2_1;
            if(v3 >= arg11.length) {
                return v6;
            }

            int v9 = v3;
            v3 = v1_2;
            v1 = v9;
        }
    }

    /**
     * 将url参数转换成map
     * @param param aa=11&bb=22&cc=33
     * @return
     */
    public static Map<String, Object> getUrlParams(String param) {
        Map<String, Object> map = new HashMap<String, Object>(0);
        if (param == null || param.equals("")) {
            return map;
        }
        String[] params = param.split("&");
        for (int i = 0; i < params.length; i++) {
            String[] p = params[i].split("=");
            if (p.length == 2) {
                map.put(p[0], p[1]);
            }
        }
        return map;
    }

    /**
     * 将map转换成url
     * @param map
     * @return
     */
    public static String getUrlParamsByMap(Map<String, String> map) {
        if (map == null) {
            return "";
        }
        String s = null;
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            sb.append(Uri.encode(entry.getKey()) + "=" + Uri.encode(entry.getValue()));
            sb.append("&");
        }
        s = sb.toString();
        if (s.endsWith("&")) {
            s = org.apache.commons.lang3.StringUtils.substringBeforeLast(s, "&");
        }
        return s;
    }

    private static final String uuid = "15729575180022600v3.7.11";

    private static final Character[] a = new Character[]{Character.valueOf('0'), Character.valueOf('1'), Character.valueOf('2'), Character.valueOf('3'), Character.valueOf('4'), Character.valueOf('5'), Character.valueOf('6'), Character.valueOf('7'), Character.valueOf('8'), Character.valueOf('9'), Character.valueOf('a'), Character.valueOf('b'), Character.valueOf('c'), Character.valueOf('d'), Character.valueOf('e'), Character.valueOf('f')};


    public static String toUrlString(String arg6) {
        try {
            byte[] v6 = arg6.getBytes("UTF-8");
            StringBuilder v0 = new StringBuilder(v6.length);
            int v2 = 0;
            while(v2 < v6.length) {
                int v3 = v6[v2] < 0 ? v6[v2] + 0x100 : v6[v2];
                if(v3 > 0x20 && v3 < 0x7F && v3 != 34 && v3 != 37 && v3 != 60 && v3 != 62 && v3 != 0x20 && v3 != 91 && v3 != 92 && v3 != 93 && v3 != 94 && v3 != 0x60 && v3 != 0x7B && v3 != 0x7C) {
                    if(v3 == 0x7D) {
                        v0.append(String.format("%%%02X", Integer.valueOf(v3)));
                    }else{
                        v0.append(((char)v3));
                    }



                }
                else {
                    //label_48:
                    v0.append(String.format("%%%02X", Integer.valueOf(v3)));
                }

                ++v2;
            }

            return v0.toString();
        }
        catch(UnsupportedEncodingException unused_ex) {
            throw new RuntimeException("Java platforms are required to support UTF-8");
        }
    }

    private static String a() {
        List v0 = Arrays.asList(misc.a);
        Collections.shuffle(v0);
        StringBuilder v1 = new StringBuilder(6);
        for(Object v2: v0.subList(0, 6)) {
            v1.append(((Character)v2));
        }

        return v1.toString();
    }

    private static String a(String arg2) {
        StringBuilder v0 = new StringBuilder();
        v0.append("myFM");
        v0.append(arg2);
        return Base64.encodeToString(md5_tobytes(toUrlString(v0.toString())), 0).replace("+", "-").replace("/", "_").replace("=", "");
    }

    public static void a(Map arg5) {
        String v0 = misc.a();
        String v1 = misc.a(arg5.toString());
        String v2 = misc.b();
        String v3 = misc.b(v2);
        arg5.put("r", v0);
        arg5.put("e", v1);
        arg5.put("fmek", v2);
        arg5.put("fmev", v3);
        String v0_1 = String.valueOf(System.currentTimeMillis());
        String v1_1 = misc.c(v0_1);
        arg5.put("device_timestamp", v0_1);
        arg5.put("X-Jyzd", v1_1);
    }

    private static String b() {
        String v0 = uuid;
        String v0_1 = TextUtils.isEmpty(v0) ? md5("tiktok") : md5(v0);
        if(v0_1.length() > 8) {
            v0_1 = v0_1.toLowerCase().substring(8);
        }

        return v0_1;
    }

    private static String b(String arg1) {
        String v1;
        if(TextUtils.isEmpty(arg1)) {
            v1 = null;
        }
        else {
            StringBuilder v0 = new StringBuilder();
            v0.append(arg1);
            v0.append("justgivemeareason");
            v1 = md5(v0.toString()).toLowerCase();
        }

        return v1;
    }

    private static String c(String arg1) {
        StringBuilder v0 = new StringBuilder();
        v0.append(arg1);

        //uuid
        //String uuid = UUID.randomUUID().toString();
        v0.append("15729575180022600v3.7.11");
        v0.append("M9M7gXbwhupJE");
        return md5(v0.toString());
    }

    //md5
    private static String md5(String arg6){
        MessageDigest v0 = null;
        try {
            v0 = MessageDigest.getInstance("MD5");
            v0.reset();
            v0.update(arg6.getBytes("UTF-8"));

            if(v0 != null) {
                byte[] v6 = v0.digest();
                StringBuilder v0_1 = new StringBuilder();
                int v2;
                for(v2 = 0; v2 < v6.length; ++v2) {
                    int v3 = v6[v2] & 0xFF;
                    if(Integer.toHexString(v3).length() == 1) {
                        v0_1.append("0");
                    }

                    v0_1.append(Integer.toHexString(v3));
                }

                return v0_1.toString();
            }

        }
        catch(Exception v1) {
            v0 = null;
        }
        return "";
    }

    public static byte[] md5_tobytes(String arg0) {
        return md5_tobytes_(arg0.getBytes());
    }

    private static byte[] md5_tobytes_(byte[] arg1) {
        try {
            MessageDigest v0 = MessageDigest.getInstance("MD5");
            v0.update(arg1);
            return v0.digest();
        }
        catch(NoSuchAlgorithmException v1) {
            v1.printStackTrace();
            return null;
        }
    }
}
