#include<stdio.h>
#include<stdlib.h>
int main()
{
    float x;
    printf("Digite um numero \n");
    scanf("%f",&x);
    printf("parte inteira %3.0f \n",x);
    printf("3 casas para a parte inteira e 2 para as decimais %3.2f \n",x);
    return 0;
}
