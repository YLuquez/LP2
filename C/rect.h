typedef struct Color {
    int redColor, greenColor, blueColor;
} Color;

typedef struct Figure Figure;

typedef void (*Figure_Print) (struct Figure*);

typedef struct Rect Rect;

Rect* Rect_New(int, int, int, int, Color, Color);
void Rect_Print(Rect*);
void Rect_Drag(Rect*, int dx, int dy);
