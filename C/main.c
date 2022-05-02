#include <stdlib.h>
#include "rect.h"

void main (void) {
    Color black = {0, 0, 0};
    Color white = {255, 255, 255};

    Rect* r1 = Rect_New(40, 40, 20, 20, black, white);
    Rect_Print(r1);

    Rect* r2 = Rect_New(40, 40, 20, 20, black, white);
    Rect_Drag(r2, 10, 100);
    Rect_Print(r2);

    free(r1);
    free(r2);
}
