//
// Created by f_oli on 31/12/2018.
//

#include "Angel.h"
#include <math.h>

Angel::Angel(int rojo,int verde,int azul){

    pixel2=getRGB(rojo,verde,azul);
}
Angel::Angel(int pixel1){
    pixel2=pixel1;
    getComponentes(pixel2);
}
int Angel::mayoresRGB(int pixel) {
    int yr;
getComponentes(pixel);
    if(rgb[0]<65){
        rgb[0]=255-rgb[0];
    }
    if(rgb[1]<65){
        rgb[1]=255-rgb[1];
    }
    yr=getRGB(rgb[0],rgb[1],rgb[2]);
    return yr;
}
int Angel::pixelnegro(int pixel43) {
    int e=valor*0.80;
    if(pixel43<e){
pixel43=e*0.30;
    }
    return pixel43;
}
void Angel::Componentemultiplo(int u){
    rgb[2]=u;
    u=u*256;
    rgb[1]=u;
    u=u*256;
    rgb[0]=u;

}
void Angel::componenteAzul(){
    rgb[2]=rgb[2]/landa;
}
int Angel::getRGB(int rojo1,int verde1,int azul1){
    int pixeR,pixeV,pixeB;rgb[0]=rojo1;rgb[1]=verde1;rgb[2]=azul1;
    pixeR=rgb[0]*65536;
    pixeV=rgb[1]*256;
    pixeB=rgb[2];
    pixel2=pixeR+pixeV+pixeB;
    pixel2=valor+pixel2;
    return pixel2;
}

int Angel::getRGB(){
    return pixel2;
}

void Angel::sqrt1() {
    double q1=(double)((rgb[0]*rgb[0])+(rgb[1]*rgb[1])+(rgb[2]*rgb[2]));
    q1=sqrt(q1);
    q1=q1/256;
    rgb[0]=(int) (rgb[0]*q1);
    rgb[1]=(int) (rgb[1]*q1);
    rgb[2]=(int) (rgb[2]*q1);
}
void Angel::sqrtr() {
    double q=sqrt((rgb[0]*rgb[0])+(rgb[1]*rgb[1])+(rgb[2]*rgb[2]));
    int r=(rgb[0]+rgb[1]+rgb[2])/3;
    rgb[0]=(int) (r*q);
    rgb[1]=(int) (r*q);
    rgb[2]=(int) (r*q);
}
void Angel::landa1() {
    float u=(rgb[0]+rgb[1]+rgb[2])/3;
    u=u/256;
    u=(float) (u*1.73);
    rgb[2]=(int)(rgb[2]*u);
}
void Angel::landa3comp() {
    float u=(rgb[0]+rgb[1]+rgb[2])/3;
    u=(float) (u/(landa));
    rgb[0]=(int)(rgb[0]*u);
    rgb[1]=(int)(rgb[1]*u);
    rgb[2]=(int)(rgb[2]*u);
}
void Angel::sqrtDerive() {
    double w=sqrt((rgb[0]*rgb[0])+(rgb[1]*rgb[1])+(rgb[2]*rgb[2]));
    double q=sqrt(w);
    double qq=(double)(2-(pixel2/valor));
    q=qq*q;
    rgb[2]=(int) (q);
    int e=(int)(2*q*q);
    rgb[1]=(int) (rgb[1]*qq);
    e=(int)(2*e*e);
    rgb[0]=(int) (rgb[0]*qq);
}
int Angel::powQ(int pixel1) {
    double q=2-pixel1/valor;
    q=exp(q);
    pixel1=(int) pow(pixel1,q);
    return pixel1;
}
void Angel::v2() {
    int w=rgb[1];
    w=w*w;
    rgb[0]=w;
}
void Angel::A2() {
    int w=rgb[2];
    w=w*w;
    rgb[1]=w;
}
int Angel::pixel4(int pixe) {
    int pixelq=pixe%65536;
    pixelq=pixe/256;
    pixelq=pixelq%256;
    return pixelq;
}
void Angel::factor(int o) {
    rgb[2]=o;
    int u=o*256;
    rgb[1]=u;
    u=u*256;
    rgb[0]=u;
}
int Angel::getPixel() {
    int pixeR,pixeV,pixeB;
    pixeR=rgb[0]*65536;
    pixeV=rgb[1]*256;
    pixeB=rgb[2];
    int pixel=pixeR+pixeV+pixeB;
    pixel=valor+pixel;
    return pixel;
}
void Angel::getColores() {
    for(int i=2;i>=0;i--) {
        if(rgb[i]>192) {
            rgb[i]=255-rgb[i];
        }}
}
void Angel::componentePow(int u){
    rgb[2]=u;
    u=u*u;
    rgb[1]=u;
    u=u*u;
    rgb[0]=u;
}
void Angel::getRojoVerde(){
    if(rgb[0]<108) {
        rgb[0]=(int)(rgb[0]*(2-(rgb[0]/255)));
    }
    if(rgb[1]<108) {
        rgb[1]=rgb[1]*(2-(rgb[1]/255));
    }
}

void Angel::getComponentes(int pix4) {
    int mod;
    int pix=pix4;
    rgb[0]=pix/65536;
    mod=pix%65536;
    rgb[1]=mod/256;
    mod=mod%256;
    rgb[2]=mod;
}
void Angel::b4(int pixel1) {
    int cociente=pixel1/valor;
    rgb[2]=cociente*256;
    rgb[1]=rgb[2]*rgb[2];
    rgb[0]=rgb[1]*rgb[1];
}
void Angel::b5(int pixel1) {
    int cociente1=rgb[0]*(2-(pixel1/valor));
    rgb[2]=cociente1;
    rgb[1]=rgb[2]*rgb[2];
    rgb[0]=rgb[1]*rgb[1];
}
float Angel::big_funtion(float eee) {
    float valor=-16777216;
    float y=1-(valor-eee)/valor;
    return y;
}
float Angel::small_funtion(float eee) {
    float valor=-16777216;
    float y=(valor-eee)/valor;
    return y;
}
int pixel2;
