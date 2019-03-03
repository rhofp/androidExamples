//
// Created by f_oli on 31/12/2018.
//

#ifndef ANGEL2_ANGEL_H
#define ANGEL2_ANGEL_H
class Angel {
public:
    Angel(int,int,int);
    Angel(int);
    int getRGB(int,int,int);
    int getRGB();
    void componenteAzul();
    void landa1();
    void landa3comp();
    void sqrt1();
    void sqrtr();
    void sqrtDerive();
    int powQ(int);
    void v2();
    void A2();
    int pixel4(int);
    void factor(int);
    int getPixel();
    void getColores();
    void Componentemultiplo(int);
    void componentePow(int);
    void getRojoVerde();
    void getComponentes(int);
    float big_funtion(float eee);
    float small_funtion(float eee);
    void b4(int);
    void b5(int);
    int pixelnegro(int);
    int mayoresRGB(int pixel);
    int rgb[2];
    int pixel2;
private:
    const int valor=-16777216;
    const float landa=1.73;
};
#endif //ANGEL2_ANGEL_H
