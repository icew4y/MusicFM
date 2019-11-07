#include <jni.h>
#include <string>
#include <dlfcn.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_example_musicfm_1fuzzer_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

void *filehandle = nullptr;
typedef int (*_pfn_signgenerator)(const char *, char **);
_pfn_signgenerator signgenerator = nullptr;

typedef jbyteArray (*_pfn_drawTextWithArray)(JNIEnv*, jobject, jbyteArray);
_pfn_drawTextWithArray drawTextWithArray_ = nullptr;

typedef jbyteArray (*_pfn_drawText)(JNIEnv*, jobject, jbyteArray, jint);
_pfn_drawText drawText_ = nullptr;

typedef jint (*_pfn_getText)(JNIEnv*, jobject);
_pfn_getText getText_ = nullptr;

typedef jint (*_pfn_getEditText)(JNIEnv*, jobject);
_pfn_getEditText getEditText_ = nullptr;


extern "C" JNIEXPORT jbyteArray JNICALL
Java_com_example_musicfm_1fuzzer_MainActivity_drawTextWithArray(
        JNIEnv* env,
        jclass jobj,
        jbyteArray  data) {

    jbyteArray b = nullptr;

    if (filehandle == nullptr){
        filehandle = dlopen("libFastDraw.so", RTLD_LAZY);
    }
    drawTextWithArray_ = (_pfn_drawTextWithArray)dlsym(filehandle, "Java_android_support_v7_widget_FastLabelText_drawTextWithArray");
    if (drawTextWithArray_ != nullptr) {
        b = drawTextWithArray_(env, jobj, data);
        printf("%d", 1);
    }
    return b;
}


extern "C" JNIEXPORT jbyteArray JNICALL
Java_com_example_musicfm_1fuzzer_MainActivity_drawText(
        JNIEnv* env,
        jclass jobj,
        jbyteArray  data,
        jint size) {

    jbyteArray b = nullptr;

    if (filehandle == nullptr){
        filehandle = dlopen("libFastDraw.so", RTLD_LAZY);

    }
    drawText_ = (_pfn_drawText)dlsym(filehandle, "Java_android_support_v7_widget_FastLabelText_drawText");
    if (drawText_ != nullptr) {
        b = drawText_(env, jobj, data, size);
        printf("%d", 1);
    }
    return b;
}


extern "C" JNIEXPORT jint JNICALL
Java_com_example_musicfm_1fuzzer_MainActivity_getText(
        JNIEnv* env,
        jclass jobj) {

    jint b = 0;

    if (filehandle == nullptr){
        filehandle = dlopen("libFastDraw.so", RTLD_LAZY);

    }
    getText_ = (_pfn_getText)dlsym(filehandle, "Java_android_support_v7_widget_FastLabelText_getText");
    if (getText_ != nullptr) {
        b = getText_(env, jobj);
        printf("%d", 1);
    }
    return b;
}


extern "C" JNIEXPORT jint JNICALL
Java_com_example_musicfm_1fuzzer_MainActivity_getEditText(
        JNIEnv* env,
        jclass jobj) {

    jint b = 0;

    if (filehandle == nullptr){
        filehandle = dlopen("libFastDraw.so", RTLD_LAZY);

    }
    getEditText_ = (_pfn_getEditText)dlsym(filehandle, "Java_android_support_v7_widget_FastLabelText_getEditText");
    if (getEditText_ != nullptr) {
        b = getEditText_(env, jobj);
        printf("%d", 1);
    }
    return b;
}