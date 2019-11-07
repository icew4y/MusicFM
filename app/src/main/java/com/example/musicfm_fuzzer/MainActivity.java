package com.example.musicfm_fuzzer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.support.v7.widget.FastlabelText;
import android.util.Log;
import android.widget.TextView;

import com.example.musicfm_fuzzer.musicfm.misc;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import android.util.Base64;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    private Map<String, String> map = new HashMap<>();



    private void init() {
        map.put("country", "CN");
        map.put("timezone", "8");
        map.put("channel", "musicfmjp.com");
        map.put("device_type", "AOSP on angler");
        map.put("osn", "aosp_angler");
        map.put("channel_lang", "zh-hans");
        map.put("resolution", "2392x1440");
        map.put("client_id", "");
        map.put("device_manufacturer", "Huawei");
        map.put("phonetype", "android");
        map.put("rom", "eng.icew4y.20190816.220643");
        map.put("osv", "6.0.1");
        map.put("appname", "MusicFM");
        map.put("install_id", "");
        map.put("os_api", "23");
        map.put("unique_device_id", "15729575180022600v3.7.11");
        map.put("model", "ull_arm64-v8a_armeabi-v7a_armeabi");
        map.put("dpi", "560");
        map.put("lang", "zh");
        map.put("ac", "WiFi");
        map.put("version_code", "98");
        map.put("carrier", "");
        map.put("device_brand", "Android");
        map.put("v", "3.7.11");
        map.put("appid", "fm.rock.android.music");
        map.put("sig_hash", "07:CE:F4:54:10:99:B1:0A:AC:EE:B2:28:6B:24:D3:20:EA:FC:F4:32");
        map.put("jb", "false");
        map.put("android_id", "");
        map.put("carrier_code", "");

        map.put("type", "song");
        map.put("query", "SCOTTY");
        map.put("page_no", "0");

        misc.a(map);

    }
    /**
     * 将byte数组写入文件
     *
     * @param path
     * @param fileName
     * @param content
     * @throws IOException
     */
    public static void writeFile(String path, String fileName, byte[] content) {
        try {
            File f = new File(path);
            if (!f.exists()) {
                f.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(path + fileName);
            fos.write(content);
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        TextView tv = findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());



        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();


                init();
                String url = "https://rockmusicfm.com/myfm/search/v2/?";
                String urlParamsByMap = misc.getUrlParamsByMap(map);
                url = url + urlParamsByMap;
                //url = "https://rockmusicfm.com/myfm/search/v2/?os_api=23&osv=6.0.1&device_type=AOSP%20on%20angler&client_id=&dpi=560&device_manufacturer=Huawei&carrier=&e=Tq0rdZ2aT08VQN-LXLuWMw%0A&install_id=&fmek=caeeb8312f8640bd6baeb59c&rom=eng.icew4y.20190816.220643&page_no=0&jb=false&v=3.7.11&lang=zh&ac=WiFi&sig_hash=07%3ACE%3AF4%3A54%3A10%3A99%3AB1%3A0A%3AAC%3AEE%3AB2%3A28%3A6B%3A24%3AD3%3A20%3AEA%3AFC%3AF4%3A32&type=song&channel=musicfmjp.com&android_id=&appname=MusicFM&query=SCOTTY&carrier_code=&appid=fm.rock.android.music&version_code=98&unique_device_id=15731090570022601v3.7.11&osn=aosp_angler&timezone=8&fmev=741145dd8dcbc6d56e478d2daa543afc&X-Jyzd=3624a07f3ed5e6a6f8295238e7c45abe&country=CN&channel_lang=zh-hans&resolution=2392x1440&device_brand=Android&device_timestamp=1573120198356&phonetype=android&r=cfb23a&model=ull_arm64-v8a_armeabi-v7a_armeabi";
                url = url + "\n";

                byte[] bytes = misc.a_encrypt_decrypt(url.getBytes(), false);

                //writeFile("/sdcard/", "t.bin", bytes);


                //乱七八糟的数据处理
                byte[] v9 = null;
                try {
                    //添加两个包头标识符
                    byte[] v0_1 = new byte[]{((byte)getText()), ((byte)getEditText())};
                    //然后一顿操作猛如虎，仔细一看无非就是来回复制数组
                    byte[] v1_1 = new byte[0];
                    byte[] v4_2 = url.getBytes("UTF-8");
                    byte[] v1_2 = a(v1_1, v4_2);
                    String v4_3 = "GET";
                    String v4_4 = v4_3 + '\n';
                    byte[] v4_5 = v4_4.getBytes("UTF-8");
                    byte[] v1_3 = a(v1_2, v4_5);
//                    int v4_6 = bytes.length == 0 ? 1 : 0;
//                    if((v4_6 ^ 1) == 1) {
//                        v1_3 = a(v1_3, arg9);
//                    }

                    //异或一下，我就直接调用so了，懒得去分析了
                    v9 = a(v0_1, misc.a_encrypt_decrypt(v1_3, false));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                url = url + "GET";
                url = url + "\n";
                RequestBody body = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8"), v9);
                Request request = new Request.Builder()
                        .url("https://rockmusicfm.com/")
                        .post(body)
                        .addHeader("Content-Type",  "application/x-www-form-urlencoded; charset=UTF-8")
                        .addHeader("User-Agent", "arockfm/1.0")
                        .addHeader("Cookie", "")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    byte[] rsp = response.body().bytes();
                    if (response.code() == 200) {
                        byte[] decodeBytes = misc.a_encrypt_decrypt(rsp, true);
                        String info = new String(decodeBytes, "UTF-8");
                        Log.d("SUCCESS", info);
                    }else{

                        String errinfo = new String(rsp, "UTF-8");
                        Log.d("ERROR", errinfo);
                    }

                    //retValue = response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public static native byte[] drawTextWithArray(byte[] data);
    public static native byte[] drawText(byte[] data, int size);
    public final native int getEditText();

    public final native int getText();
}
