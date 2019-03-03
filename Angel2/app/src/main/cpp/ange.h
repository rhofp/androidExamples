//
// Created by f_oli on 16/12/2018.
//

#ifndef ANGEL2_ANGE_H
#define ANGEL2_ANGE_H

class ange {

public:
    explicit ange(int re,int blu,int gre);
    void paco1(float * pixel, int r);
    void paco2(float * pixel,int r);
    void paco3(float * pixel, int r);
    void paco4(float * pixel, int r);
    void paco5(float * pixel, int r);
    float big_as_ice(float colorPixel,float colorreal,float pixe);
    float squert(float rrr,float ggg,float bbb);
    float small_funtion(float eee);


    private:
    float big_funtion(float eee);
    int azul;
    int verde;
    int rojo;
    int b;
    int red,blue,green;
int blues;
};

#endif //ANGEL2_ANGE_H
