//
// Created by f_oli on 16/12/2018.
//

#include "ange.h"
#include <math.h>
#include "Angel.h"

ange::ange(int re,int blu,int gre){


    int red=re; int blue=blu; int green=gre;

}
void ange::paco1(float * pixel,int t) {
    const float uy=-16711936;
    float valor=-16777216;
    Angel angel(*pixel);
    float pixel31 = *pixel;
    float pio=*pixel;
    pixel31=(pixel31*((1.000075)*(pixel31*((valor/pixel31)/((pixel31)/((pixel31/valor)*pixel31)))))/(pixel31));
    pixel31= ((valor/pixel31)/((pixel31)/(valor)));
    double qq=(pio/valor);
    pixel31=(float)pow(pixel31,qq);
    pixel31=(pixel31*uy)/valor;
    pixel31=pixel31*pio;
    pixel31=pixel31/valor;
    pixel31=pixel31*angel.getRGB(210,180,20);
    angel.getComponentes(pixel31);

    if(pixel31<b){
        pixel31=angel.getRGB(230,160,0);
    }

    pixel31=angel.mayoresRGB(pixel31);

    if (pixel31 < valor){
        pixel31 = valor;
    }
    if(pixel31>-1){
        pixel31=-1;
    }
    if(pixel31<-4194304.000000){
        pixel31=pixel31*small_funtion(pixel31);

    }
    pixel31=pixel31/valor;
    pixel31=pixel31*uy;
    if(pixel31<b){
       pixel31=angel.pixelnegro(pixel31);
    }
    pixel31=angel.mayoresRGB(pixel31);

    *pixel=pixel31;
}
void ange::paco2(float * pixel, int t) {
    float valor=-16777216; float pendiente2,pendiente, pendiente1;
    float uy=-255;
    Angel angel(200,200,15);
    float    pixel31 = *pixel;
    float pio= *pixel;
    float r=(2*(1-(pixel31/valor)));
    float	gra=(2-(((pixel31/valor))*(2-(pixel31/valor)))/r);
    double w=exp(gra );
    double ee=pow(log(gra),gra );
    float pendiente5=(float)((1+ee)/(w+1));
    pendiente5=pendiente5*gra;
    pendiente=-((pendiente5)*pixel31);
    pixel31=pixel31/valor;
    pixel31=pixel31*angel.getRGB(230,250,34);

    if(t==2){
        pendiente2=(pendiente+(pendiente1+2));
        double j=0.2*(pow(pendiente2, 3));
        pendiente2=(float)(j*(pow(pendiente2,-2)));
        pixel31= (pixel31-pendiente2);
        pixel31= ((valor/pixel31)/((pixel31)/(valor)));
        double qq=(pio/valor);
        pixel31=(float)pow(pixel31,qq);
        pixel31=(pixel31)/valor;
        pixel31=((pixel31*uy));
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(215,168,25);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.getRGB(230,160,0);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }
    if(t==3){
        pendiente2=(pendiente-(pendiente1+1));
        pendiente2=(1.20085* pendiente2);
        pixel31= ((pixel31-pendiente2));
        pixel31= ((valor/pixel31)/((pixel31)/(valor)));
        double qq=(pio/(20*valor));
        pixel31=(float)pixel31*pow(pixel31,qq);
        pixel31=((pixel31*uy)/valor);
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(230,194,0);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.pixelnegro(pixel31);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }
    if(t==4){
        pendiente2=(pendiente-(pendiente1+1));
        pendiente2=(1.40085* pendiente2);
        pixel31= (pixel31+pendiente2);
        pixel31= ((valor/pixel31)/((pixel31)/(valor)));
        double qq=1+(pio/valor);
        pixel31=(float)-pow(pixel31,qq);
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(251,230,35);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.pixelnegro(pixel31);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }


    if (pixel31 < valor){
        pixel31 = valor;
    }
    if(pixel31>-1){
        pixel31=-1;
    }
    if(pixel31<-4194304.000000){
        pixel31=pixel31*small_funtion(pixel31);
    }
    if(pixel31<b){
        pixel31=angel.pixelnegro(pixel31);
    }
    pixel31=angel.mayoresRGB(pixel31);

    *pixel=pixel31;
}

void ange::paco3(float * pixel, int t) {
    float uy=-65281;
    float valor=-16777216; float pendiente2,pendiente, pendiente1;
    float pixel31 = *pixel;
    float pio=*pixel;
    Angel angel(255,255,1);
    float r=(2*(1-(pixel31/valor)));
    float	gra=(2-(((pixel31/valor))*(2-(pixel31/valor)))/r);
    double w=exp(gra );
    double ee=pow(log(gra),gra );
    float pendiente5=(float)((1+ee)/(w+1));
    pendiente5=pendiente5*gra;
    pendiente=-((pendiente5)*pixel31);
    if(t==6){
        float pendiente3=(pendiente*(2-((pendiente)/pixel31)));
        pendiente2=-(pendiente1-pendiente3);
        pixel31= (pixel31-pendiente2);
        pixel31= ((valor/pixel31)/((pixel31)/(valor)));
        double qq=1-(pio/valor);
        pixel31=(float)pow(pixel31,qq);
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(260,153,20);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.pixelnegro(pixel31);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }
    if(t==8){
        float pendiente3=(pendiente*(1+((pendiente)/pixel31)));
        pendiente2=-(pendiente1-pendiente3);
        pixel31=(pixel31-pendiente2);
        pixel31= ((valor/pixel31)/((pixel31)/(valor)));
        double qq=1-(pio/valor);
        pixel31=(float)-pow(pixel31,qq);
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(230,185,0);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.getRGB(230,160,0);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }
    if (pixel31 < valor){
        pixel31 = valor;
    }
    if(pixel31>-1){
        pixel31=-1;
    }
    if(pixel31<-4194304.000000){
        pixel31=pixel31*small_funtion(pixel31);
    }
    if(pixel31<b){
        pixel31=angel.pixelnegro(pixel31);
    }
    pixel31=angel.mayoresRGB(pixel31);

    *pixel=pixel31;
}

void ange::paco4(float * pixel, int t) {
    float valor=-16777216; float pendiente, pendiente1;
    float pixel31 = * pixel;
    Angel angel(pixel31);
    float r=(2*(1-(pixel31/valor)));
    float	gra=(2-(((pixel31/valor))*(2-(pixel31/valor)))/r);
    double w=exp(gra );
    double ee=pow(log(gra),gra );
    float pendiente5=(float)((1+ee)/(w+1));
    pendiente5=pendiente5*gra;
    pendiente=-((pendiente5)*pixel31);
    pendiente1=pendiente+25;
    pixel31=(pixel31+pendiente1);
    if (pixel31 < valor){
        pixel31 = valor;
    }
    if(pixel31>-1){
        pixel31=-1;
    }
    if(pixel31<b){
        pixel31=angel.pixelnegro(pixel31);
    }
    pixel31=angel.mayoresRGB(pixel31);

    *pixel=pixel31;
}
void ange::paco5(float * pixel, int t) {
    float valor=-16777216; float pendiente2,pendiente, pendiente1;
    float uy = -20561;
    Angel angel(*pixel);
    float pixel31 = *pixel;
    float pio = *pixel;
    float r = (2 * (1 - (pixel31 / valor)));
    float gra = (2 - (((pixel31 / valor)) * (2 - (pixel31 / valor))) / r);
    double w = exp(gra);
    double ee = pow(log(gra), gra);
    float pendiente5 = (float) ((1 + ee) / (w + 1));
    pendiente5 = pendiente5 * gra;
    pendiente = -((pendiente5) * pixel31);
    pixel31=angel.mayoresRGB(pixel31);

    if (t == 2) {
        pendiente2 = (pendiente + (pendiente1 + 2));
        pixel31 =  (pixel31 - pendiente2);
        pixel31 =  ((valor / pixel31) / ((pixel31) / (valor)));
        double qq = 1+(pio/valor);
        pixel31 = (float) pow(pixel31, qq);
        pixel31 = pixel31 * uy;
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(195,220,35);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.getRGB(249,180,0);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }

    if (t == 3) {
        pendiente2 = (pendiente - (pendiente1 + 1));
        pendiente2 = (1.20085 * pendiente2);
        pixel31 = ((pixel31 - pendiente2));
        pixel31 = ((valor / pixel31) / ((pixel31) / (valor)));
        double qq = (pio/valor);
        pixel31 = (float)pow(pixel31, qq);
        pixel31 = pixel31 * uy;
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(125,180,35);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.getRGB(210,135,0);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }
    if (t == 4) {
        pendiente2 = (pendiente - (pendiente1 + 1));
        pendiente2 =  (1.40085 * pendiente2);
        pixel31 = (pixel31 + pendiente2);
        pixel31 = ((valor / pixel31) / ((pixel31) / (valor)));
        double qq = (pio/valor);
        pixel31 = (float) pow(pixel31, qq);
        pixel31 = pixel31 * uy;
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(125,180,35);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.getRGB(245,185,0);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }
    if (t == 6) {
        pendiente2 = -(pendiente1 + pendiente);
        pixel31 =  (pixel31 + pendiente2);
        pixel31 = ((valor / pixel31) / ((pixel31) / (valor)));
        double qq = (pio/valor);
        pixel31 = (float)( pow(pixel31, qq));
        pixel31 = pixel31 * uy;
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(195,180,35);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.getRGB(230,160,0);
        }
        pixel31=angel.mayoresRGB(pixel31);
    }
    if (t == 7) {
        pendiente2 = (pendiente + (pendiente1 + 1));
        pendiente2 =  (1.15 * pendiente2);
        pixel31 =  (pixel31 - pendiente2);
        pixel31 =  (abs((pixel31 * (pendiente * 1.5))) / 2);
        pixel31 = ((valor / pixel31) / ((pixel31) / (valor)));
        double qq = (pio/valor);
        pixel31 = (float)( (pow(pixel31, qq)));
        pixel31 = pixel31 * uy;
        pixel31=pixel31/valor;
        pixel31=pixel31*angel.getRGB(240,180,35);
        angel.getComponentes(pixel31);
        if(pixel31<b){
            pixel31=angel.getRGB(230,160,0);
        }
       pixel31= angel.mayoresRGB(pixel31);
    }
    if (pixel31 < valor){
        pixel31 = valor;
    }
    if(pixel31>-1){
        pixel31=-1;
    }
    if(pixel31<-4194304.000000){
        pixel31=pixel31*small_funtion(pixel31);
    }

pixel31=angel.mayoresRGB(pixel31);

    *pixel=pixel31;
}
float ange::big_funtion(float eee) {
    float valor=-16777216;
    float y=1-(valor-eee)/valor;

    return y;
}
float ange::small_funtion(float eee) {
    float valor=-16777216;
    float y=(valor-eee)/valor;

    return y;
}

float ange::big_as_ice(float colorPixel,float colorreal,float pixe) {
    float y=colorPixel/pixe;
    y=y*colorreal;
    return y;
}
float ange::squert(float rrr,float ggg,float bbb) {
    float p=rrr*rrr+ggg*ggg+bbb*bbb;
    float q=sqrt(p);
    q=q/255;
    return q;
}
int valor=-16777216;
int b=valor*0.8;
int azul=-16777216/16776961;
int verde=-16777216/16711881;
int rojo=-16777216/65481;
