#include <stdio.h>

typedef struct{
	int x,y;
	int size;
  	char texto[99];
}Texto;

void print(Texto* t){
	printf("Texto %s de tamanho (%d) na posicao (%d,%d)\n",
	t->texto,t->size,t->x,t->y);	
}

int main (){
	Texto t1 = {3,5,10,"Alo mundo!"};
	print(&t1);
}
