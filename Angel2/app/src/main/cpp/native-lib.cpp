#include <jni.h>
#include <string.h>
#include <math.h>
#include <android/log.h>
#include <android/bitmap.h>
#include "ange.h"


#define LOG_TAG "angel"
#define LOGI(...) __android_log_print(ANDROID_LOG_INFO,LOG_TAG,__VA_ARGS__)
#define LOGE(...) __android_log_print(ANDROID_LOG_ERROR,LOG_TAG,__VA_ARGS__)


extern "C"
JNIEXPORT void JNICALL
Java_com_example_f_1oli_angel_MainActivity_convertirGrises(JNIEnv *env, jobject instance,
                                                           jobject bitmapColor, jobject bitmapGris,
                                                           jint x2, jint e) {
    AndroidBitmapInfo infocolor;
    void* pixelscolor;
    AndroidBitmapInfo infogris;
    void* pixelsgris;
    float red,blue,green;

    int ret;

    LOGI("convertirGrises");
    if ((ret = AndroidBitmap_getInfo(env, bitmapColor, &infocolor)) < 0) {
        LOGE("AndroidBitmap_getInfo() failed ! error=%d", ret);
        return;
    }
    if ((ret = AndroidBitmap_getInfo(env, bitmapGris, &infogris)) < 0) {
        LOGE("AndroidBitmap_getInfo() failed ! error=%d", ret);
        return;
    }

    LOGI("imagen color :: ancho %d;alto %d;avance %d;formato %d;flags %d",
         infocolor.width, infocolor.height, infocolor.stride,
         infocolor.format, infocolor.flags);
    if (infocolor.format != ANDROID_BITMAP_FORMAT_RGBA_8888) {
        LOGE("Bitmap no es formato RGBA_8888 !");
        return;
    }
    LOGI("imagen color :: ancho %d;alto %d;avance %d;formato %d;flags %d",
         infogris.width, infogris.height, infogris.stride,       infogris.format, infogris.flags);
    if (infogris.format != ANDROID_BITMAP_FORMAT_RGBA_8888) {
        LOGE("Bitmap no es formato RGBA_8888 !");
        return;
    }


    if ((ret = AndroidBitmap_lockPixels(env, bitmapColor, &pixelscolor))  < 0) {
        LOGE("AndroidBitmap_lockPixels() failed ! error=%d", ret);
    }

    if ((ret = AndroidBitmap_lockPixels(env, bitmapGris, &pixelsgris))<0) {
        LOGE("AndroidBitmap_lockPixels() fallo ! error=%d", ret);
    }


    // modificacion pixeles en el algoritmo de escala grises

    for(int y=0;y<infocolor.height;y++){
        float  * line = reinterpret_cast<float *>(pixelscolor);

        float * grisline = reinterpret_cast<float *>(pixelsgris);

        for (int x=0;x<infocolor.width;x++) {
            int azul=-16777216/16776961;
            int verde=-16777216/16711881;
            int rojo=-16777216/65481;
            float valor=-16777216;
            float * serie =  &line[x];
            float output= *serie;
            red=rojo/output;
            blue=azul/output;
            green=verde/output;
            ange f(rojo,blue,green);
            if(x2==1) {
output=f.big_as_ice(azul,blue,output);
                f.paco1(&output, e);
                output=(output*0.75);
                output=red*(output/valor);
            }else if(x2==2){
                output=f.big_as_ice(rojo,red,output);
                f.paco2(&output,e);
                output=red*(output*0.35);
                output=(output/valor);
            }else if(x2==3){
                output=f.big_as_ice(rojo,green,output);
                f.paco3(&output,e);
                output=(red)*(output*0.55);
                output=green*(output/valor);
            }else if(x2==4){
                output=f.big_as_ice(rojo,blue,output);
                f.paco4(&output,e);
                output=(red)*(output*0.65);
                output=red*(output/valor);
            }
            else if(x2==5){
                output=f.big_as_ice(rojo,red,output);
                f.paco5(&output,e);
                output=(red)*(output*0.85);
                output=0.85*green*(output/valor);
            }
            output=output*f.small_funtion(output);
            grisline[x]= output;
        }
        pixelscolor=(char*)pixelscolor+infocolor.stride;
        pixelsgris = (char *) pixelsgris + infogris.stride;
    }
    LOGI("unlocking pixels");
    AndroidBitmap_unlockPixels(env, bitmapGris);
}
