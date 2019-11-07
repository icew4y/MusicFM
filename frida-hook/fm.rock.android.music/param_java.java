    public static void a(Map arg5) {
        String v0 = e.a();
        String v1 = e.a(arg5.toString());

        //
        String v2 = e.generate_fmek();

        //
        String v3 = e.generate_fmev(v2);
        arg5.put("r", v0);
        arg5.put("e", v1);
        arg5.put("fmek", v2);
        arg5.put("fmev", v3);
        String v0_1 = String.valueOf(System.currentTimeMillis());

        //
        String v1_1 = e.generate_X_Jyzd(v0_1);
        arg5.put("device_timestamp", v0_1);
        arg5.put("X-Jyzd", v1_1);
    }

    private static String generate_fmek() {
        String v0 = a.a;
        String v0_1 = TextUtils.isEmpty(v0) ? g.a("tiktok") : g.a(v0);
        if(v0_1.length() > 8) {
            v0_1 = v0_1.toLowerCase().substring(8);
        }

        return v0_1;
    }

    private static String generate_fmev(String arg1) {
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

    private static String generate_X_Jyzd(String arg1) {
        StringBuilder v0 = new StringBuilder();
        v0.append(arg1);
        v0.append(a.a);
        v0.append("M9M7gXbwhupJE");
        return md5(v0.toString());
    }


    //md5
    private static String md5(String arg6){
        MessageDigest v0;
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
    }