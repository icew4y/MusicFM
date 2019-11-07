
function hook_respone(){
    var b = Java.use('fm.rock.android.common.module.network.http.d.b')
    var NetworkResponse = Java.use('com.android.volley.NetworkResponse')
    var Response = Java.use('com.android.volley.Response')
    var g = Java.use('fm.rock.android.common.module.network.http.g')

    // var Methods = g.class.getDeclaredMethods()
    // Methods.forEach(function(e){
    //     console.log(e + '\n')
    // })

    
    var Bool=Java.use("java.lang.Boolean");
    var boolean_clz=Bool.class.getField("TYPE").get(null);
    
    var clazz = Java.use('java.lang.Class');
    var g_instance = g.$new();
    if (g_instance == undefined){
        console.log('can not new g_instance');
    }
    if (b != undefined){
        console.log('hooking parseNetworkResponse')
        b.parseNetworkResponse.overload('com.android.volley.NetworkResponse').implementation = function(){
            console.log('parseNetworkResponse onEnter');
            //const Log = Java.use('android.util.Log');
            const StringClass = Java.use('java.lang.String')
            //const Exception = Java.use('java.lang.Exception');
            //console.log(Log.getStackTraceString(Exception.$new()));
            var a1Cast = Java.cast(arguments[0].getClass(), clazz)
            var httpdata = a1Cast.getDeclaredField('data')
            httpdata.setAccessible(true)
            var vv = httpdata.get(arguments[0])

            var bytesClass = Java.use('[B')
            var Method = g.class.getDeclaredMethod('a', Java.array('java.lang.Class', [bytesClass.class, boolean_clz]))

            //object 转 byte[]
            var byteCast = Java.cast(vv, bytesClass)
            
            var bValue = Bool.$new(true)
            var argss = Java.array('java.lang.Object', [byteCast, bValue])
            var retObject = Method.invoke(g_instance, argss)
            //打印byte[]数组
            //不能直接用String.$new

            var buffer = Java.array('byte', retObject);
            var result = "";
            for(var i = 0; i < buffer.length; ++i){
                result+= (String.fromCharCode(buffer[i]));
            }
            console.log('parseNetworkResponse - >' + result)


            //console.log('retvalString:' + StringClass.$new(retBytes) + '\n') ;
            //var rs = StringClass.$new(r)
            //var a1 = StringClass.$new(arguments[0])
            //console.log('arg1:' + a1 + '\nresult:' + rs) ;
            
            
            var r = this.parseNetworkResponse(arguments[0]);
            return r;
        };

    }else{
        console.log('can not find ' + classname);
    }

}




function hook_so_drawTextWithArray(){
    console.log('hooking Java_android_support_v7_widget_FastLabelText_drawTextWithArray')
    var StringClass = Java.use('java.lang.String');
    var http_sign = Module.findExportByName('libFastDraw.so', 'Java_android_support_v7_widget_FastLabelText_drawTextWithArray');
    Interceptor.attach(http_sign, {
        onEnter: function(args){

            //arg[0] 是JNIEnv *
            //arg[1] 是调用类指针

            // console.log('sign onEnter');
            // var a1 = args[2];

            // var ARG1 = Java.cast(a1, StringClass);
            
            
			// console.log('ARG1:' + ARG1);
            
        },
        onLeave: function(retval){
            console.log('drawTextWithArray onLeave');
            //var RET = Java.cast(retval, StringClass);

            var bytesClass = Java.use('[B')
            //object 转 byte[]
            var byteCast = Java.cast(retval, bytesClass)
        
            //打印byte[]数组
            //不能直接用String.$new

            var buffer = Java.array('byte', byteCast);
            var result = "";
            for(var i = 0; i < buffer.length; ++i){
                result+= (String.fromCharCode(buffer[i]));
            }
            console.log('drawTextWithArray - >' + result + "\n")

        }
    })
}


function hook_so_drawText(){
    console.log('hooking Java_android_support_v7_widget_FastLabelText_drawText')
    var StringClass = Java.use('java.lang.String');
    var http_sign = Module.findExportByName('libFastDraw.so', 'Java_android_support_v7_widget_FastLabelText_drawText');
    Interceptor.attach(http_sign, {
        onEnter: function(args){

            //arg[0] 是JNIEnv *
            //arg[1] 是调用类指针

            // console.log('sign onEnter');
            // var a1 = args[2];

            // var ARG1 = Java.cast(a1, StringClass);
            
            
			// console.log('ARG1:' + ARG1);
            
        },
        onLeave: function(retval){
            console.log('drawText onLeave');
            //var RET = Java.cast(retval, StringClass);

            var bytesClass = Java.use('[B')
            //object 转 byte[]
            var byteCast = Java.cast(retval, bytesClass)
        
            //打印byte[]数组
            //不能直接用String.$new

            var buffer = Java.array('byte', byteCast);
            var result = "";
            for(var i = 0; i < buffer.length; ++i){
                result+= (String.fromCharCode(buffer[i]));
            }
            console.log('drawText - >' + result + "\n")

        }
    })
}


function hook_so_drawLine(){
    console.log('hooking Java_android_support_v7_widget_FastLabelText_drawLine')
    var StringClass = Java.use('java.lang.String');
    var http_sign = Module.findExportByName('libFastDraw.so', 'Java_android_support_v7_widget_FastLabelText_drawLine');
    Interceptor.attach(http_sign, {
        onEnter: function(args){

            //arg[0] 是JNIEnv *
            //arg[1] 是调用类指针

            // console.log('sign onEnter');
            // var a1 = args[2];

            // var ARG1 = Java.cast(a1, StringClass);
            
            
			// console.log('ARG1:' + ARG1);
            
        },
        onLeave: function(retval){
            console.log('drawLine onLeave');
            //var RET = Java.cast(retval, StringClass);

            var bytesClass = Java.use('[B')
            //object 转 byte[]
            var byteCast = Java.cast(retval, bytesClass)
        
            //打印byte[]数组
            //不能直接用String.$new

            var buffer = Java.array('byte', byteCast);
            var result = "";
            for(var i = 0; i < buffer.length; ++i){
                result+= (String.fromCharCode(buffer[i]));
            }
            console.log('drawLine - >' + result + "\n")

        }
    })
}


function hook_request(){
    var b = Java.use('fm.rock.android.common.module.network.http.d.b')
    if (b != undefined){
        console.log('hooking request')   
        b.getBody.overload().implementation = function(){
            var r = this.getBody();
            console.log('getBody onEnter') ;
            const StringClass = Java.use('java.lang.String')
            var rss = StringClass.$new(r)
            console.log('request:' + rss) ;

            return r;
        }
    }else{
        console.log('can not find com.android.volley.Request');
    }
}

function hook_g_a(){
    var http = Java.use('fm.rock.android.common.module.network.http.g')
    var ThrowableCls = Java.use('java.lang.Throwable'); 
    
    if (http != undefined){
        console.log('hooking http')
        http.a.overload('[B', 'boolean').implementation = function(){
             console.log('a onEnter');
             const Log = Java.use('android.util.Log');
            const StringClass = Java.use('java.lang.String')
             const Exception = Java.use('java.lang.Exception');
             

            var r = null;

            var b = arguments[1]
            //http请求
            if (b == false){
                var a1 = StringClass.$new(arguments[0])
                console.log('request:' + a1 + '\n') ;
                console.log(Log.getStackTraceString(Exception.$new()));
                r = this.a(arguments[0], arguments[1]);
            }
            //http请求返回
            else{
                var r = this.a(arguments[0], arguments[1]);
                var buffer = Java.array('byte', r);
                var result = "";
                for(var i = 0; i < buffer.length; ++i){
                    result+= (String.fromCharCode(buffer[i]));
                }
                console.log('response:' + result + '\n')
            }
            return r;
        };

    }else{
        console.log('can not find ' + classname);
    }
    
}



function enum_so_func(){
    var securityCheck = undefined;
    var exports = Module.enumerateExportsSync("libSigner.so");
    console.log('exports.length:', exports.length);
    for(var i=0;i<exports.length;i++){
        console.log('name:', exports[i].name);
        // if(exports[i].name=="Java_com_yaotong_crackme_MainActivity_securityCheck"){
        //     securityCheck=exports[i].address;
        //     send("securityCheck at "+securityCheck);
        //     break;
        // }
    }
}

function hook_test(){
    //fm.rock.android.common.c.i
    var i = Java.use('fm.rock.android.common.c.i')
    if (i != undefined){
        console.log('hooking i')   
        i.l.overload().implementation = function(){
            var r = this.l();
            console.log('l onEnter') ;
            const StringClass = Java.use('java.lang.String')
            var rss = StringClass.$new(r)
            console.log('l:' + rss) ;

            return r;
        }
    }else{
        console.log('can not find fm.rock.android.common.c.i');
    }
}


function hook_c_g_md5(){
    //fm.rock.android.common.c.i
    var g = Java.use('fm.rock.android.common.c.g')
    if (g != undefined){
        console.log('hooking c_g_md5')   
        g.a.overload('java.lang.String').implementation = function(){
            console.log('hook_c_g_md5 onEnter') ;
            console.log('hook_c_g_md5:' + arguments[0]) ;

            var r = this.a(arguments[0]);
            return r;
        }
    }else{
        console.log('can not find fm.rock.android.common.c.g');
    }
}


function hook_e_a(){
    var e = Java.use('fm.rock.android.common.module.network.http.e')
    var ThrowableCls = Java.use('java.lang.Throwable'); 
    
    if (e != undefined){
        console.log('hooking a')
        e.a.overload('java.lang.String').implementation = function(){
             console.log('a onEnter');
            const Log = Java.use('android.util.Log');
            const StringClass = Java.use('java.lang.String')
            const Exception = Java.use('java.lang.Exception');
            console.log(Log.getStackTraceString(Exception.$new()));
            console.log('a String:' + arguments[0] + '\n');
            var r = this.a(arguments[0]);
            console.log('a return String:' + r + '\n');
            return r;
        };

    }else{
        console.log('can not find ' + classname);
    }
    
}

function hook_c_k(){
    var k = Java.use('fm.rock.android.common.c.k')
    var ThrowableCls = Java.use('java.lang.Throwable'); 
    
    if (k != undefined){
        console.log('hooking a')
        k.b.overload('java.lang.String').implementation = function(){
            console.log('k.b onEnter');
            //const Log = Java.use('android.util.Log');
            //const StringClass = Java.use('java.lang.String')
            //const Exception = Java.use('java.lang.Exception');
            ////console.log(Log.getStackTraceString(Exception.$new()));
            console.log('k.b String:' + arguments[0] + '\n');
            var r = this.b(arguments[0]);
            console.log('k.b return String:' + r + '\n');
            return r;
        };

    }else{
        console.log('can not find ' + classname);
    }
    
}

function hook_f_a(){
    var f = Java.use('fm.rock.android.common.module.network.http.f')
    var ThrowableCls = Java.use('java.lang.Throwable'); 
    
    if (f != undefined){
        console.log('hooking a')
        f.a.overload('java.lang.String', 'java.lang.String').implementation = function(){
             console.log('a onEnter');
            const Log = Java.use('android.util.Log');
            const StringClass = Java.use('java.lang.String')
            const Exception = Java.use('java.lang.Exception');
            console.log(Log.getStackTraceString(Exception.$new()));
            console.log('f.a -> arg1:' + arguments[0] + '\narg2:' + arguments[1]);
            var r = this.a(arguments[0],  arguments[1]);
            return r;
        };

    }else{
        console.log('can not find ' + classname);
    }
    
}

function hook_f_a(){
    var FastLabelViewUtils = Java.use('android.support.v7.widget.FastLabelViewUtils')
    var ThrowableCls = Java.use('java.lang.Throwable'); 
    var d_b = Java.use('fm.rock.android.common.module.network.http.d.b')
    
    if (FastLabelViewUtils != undefined){
        console.log('hooking drawLine')
        FastLabelViewUtils.drawLine.overload('fm.rock.android.common.module.network.http.d.b', '[B').implementation = function(){
             console.log('drawLine onEnter');
            const Log = Java.use('android.util.Log');
            const StringClass = Java.use('java.lang.String')
            const Exception = Java.use('java.lang.Exception');
            console.log(Log.getStackTraceString(Exception.$new()));
            
            
            var a2 = arguments[1]
            //const StringClass = Java.use('java.lang.String')
            //var rss = StringClass.$new(arguments[1])
            console.log('arg2:' + a2 + '\n')

            var r = this.drawLine(arguments[0],  arguments[1]);
            return r;
        };

    }else{
        console.log('can not find ' + classname);
    }
    
}
if (Java.available){

    Java.perform(function(){
        //hook_test()
        //enum_so_func()
        //hook_g_a()
        hook_f_a()
        //hook_c_g_md5()
        //hook_e_a()
        //hook_c_k();

        //so层加密解密的两个函数
        //hook_so_drawTextWithArray()
        //hook_so_drawText()
        //hook_so_drawLine()


        //网络请求
        //hook_request();
        //hook_respone();
    });

    // Java.perform(function(){
    //     var application = Java.use("android.app.Application");
    //     var Toast = Java.use('android.widget.Toast');
 
    //     application.attach.overload('android.content.Context').implementation = function(context) {
    //         var result = this.attach(context); // 先执行原来的attach方法
    //         var classloader = context.getClassLoader(); // 获取classloader
    //         Java.classFactory.loader = classloader;
    //         var i = Java.classFactory.use("fm.rock.android.common.module.network.http.e"); //这里不能直接使用Java.use，因为java.use会检查在不在perform里面，不在就会失败
    //         console.log("AyWelcome: " + i);
    //         // 然后下面的代码就和写正常的hook一样啦
    //         if (i != undefined){
    //             hook_e_a()
    //             // console.log('hooking i')   
    //             // i.l.overload().implementation = function(){
    //             //     var r = this.l();
    //             //     console.log('l onEnter') ;
    //             //     const StringClass = Java.use('java.lang.String')
    //             //     var rss = StringClass.$new(r)
    //             //     console.log('l:' + rss) ;
        
    //             //     return r;
    //             // }
    //         }else{
    //             console.log('can not find fm.rock.android.common.c.i');
    //         }
    //         return result;
    //     }
    // });
}