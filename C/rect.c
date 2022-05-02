#include <stdio.h>
#include <stdlib.h>
#include "rect.h"

struct Figure {
    int x, y;
    int w, h;
    Color border, fill;
    void (*print) (struct Figure*);
};

typedef void (*Figure_Print) (struct Figure*);

struct Rect {
    Figure super;
};

Rect* Rect_New(int x, int y, int w, int h, Color border, Color fill) {
    Rect* this = malloc(sizeof(Rect));
    Figure* super = (Figure*) this;

    super->x = x;
    super->y = y;
    super->w = w;
    super->h = h;
    super->border = border;
    super->fill = fill;
    super->print = (Figure_Print) Rect_Print;
}

void Rect_Print(Rect* this) {
    Figure* super = (Figure*) this;

    printf("Retangulo com tamanho (%d, %d) na posicao (%d, %d).\n",
           super->w, super->h, super->x, super->y);

    printf("Cor da borda: (%d, %d, %d). Cor da fundo: (%d, %d, %d).\n",
        super->border.redColor, super->border.greenColor, super->border.blueColor,
        super->fill.redColor, super->fill.greenColor, super->fill.blueColor);
}

void Rect_Drag(Rect* this, int dx, int dy) {
    Figure* super = (Figure*) this;

    super->x += dx;
    super->y += dy;
}
