#include <sys/time.h>
#include <sys/resource.h>
#include <stdio.h>
#include "transpose.h"
#include "matrix.h"

#ifdef TRANSPOSE1
void transpose1(matrix_ptr src, matrix_ptr dst);
#endif
#ifdef TRANSPOSE2
void transpose2(matrix_ptr src, matrix_ptr dst);
#endif
#ifdef TRANSPOSE3
void transpose3(matrix_ptr src, matrix_ptr dst);
#endif
#ifdef TRANSPOSE4
void transpose4(matrix_ptr src, matrix_ptr dst);
#endif
#ifdef TRANSPOSE5
void transpose5(matrix_ptr src, matrix_ptr dst);
#endif
#ifdef TRANSPOSE6
void transpose6(matrix_ptr src, matrix_ptr dst);
#endif

int mini(int i, int j);
int main()
{
    long int i;
    data_t dest;
    matrix_ptr src = new_matrix(SIZE);
    matrix_ptr dst = new_matrix(SIZE);
#ifdef PRINT
    init_matrix(src);
#endif
    struct timeval start, end;        
    struct rusage ru;        
    getrusage(RUSAGE_SELF, &ru);        
    start = ru.ru_utime;
    double startsec, endsec;
#ifdef TRANSPOSE1
    transpose1(src, dst);
#endif
#ifdef TRANSPOSE2
    transpose2(src, dst);
#endif
#ifdef TRANSPOSE3
    transpose3(src, dst);
#endif
#ifdef TRANSPOSE4
    transpose4(src, dst);
#endif
#ifdef TRANSPOSE5
    transpose5(src, dst);
#endif
#ifdef TRANSPOSE6
    transpose6(src, dst);
#endif
    getrusage(RUSAGE_SELF, &ru);        
    end = ru.ru_utime;

    //convert seconds to microseconds
    startsec = start.tv_sec * 1000000.0 + start.tv_usec;
    endsec = end.tv_sec * 1000000.0 + end.tv_usec;

    //convert microseconds to milliseconds
    printf("%d\n", (long int)((endsec - startsec)/1000.0));
#ifdef PRINT
    print_matrix(src, "Source Matrix:");
    print_matrix(dst, "Dest Matrix:");
#endif
}


#ifdef TRANSPOSE1
void transpose1(matrix_ptr src, matrix_ptr dst)
{
    int i, j;
    data_t val;
    for (i = 0; i < src->len; i++)
        for (j = 0; j < src->len; j++)
        {
           val = get_matrix_element(src, i, j);
           set_matrix_element(dst, j, i, val);
        }
}
#endif


#ifdef TRANSPOSE2
void transpose2(matrix_ptr src, matrix_ptr dst)
{
    int i, j;
    data_t val;
    int n = src->len;
    for (i = 0; i < n; i++)
        for (j = 0; j < n; j++)
        {
           set_matrix_element(dst, j, i, get_matrix_element(src, i, j));
        }
}
#endif

#ifdef TRANSPOSE3
void transpose3(matrix_ptr src, matrix_ptr dst)
{
    int i, j;
    data_t val;
    int n = src->len;
    for (i = 0; i < n; i++)
        for (j = 0; j < n-1; j+=2)
        {
           set_matrix_element(dst, j, i, get_matrix_element(src, i, j));
           set_matrix_element(dst, j+1, i, get_matrix_element(src, i, j+1));
        }
        if (j < src->len)
        {
            set_matrix_element(dst, j, i, get_matrix_element(src, i, j));
        }
}
#endif


#ifdef TRANSPOSE4
void transpose4(matrix_ptr src, matrix_ptr dst)
{
    int i, j, x, y;
    int n = src->len;
    int b = 2;
    data_t val;
    for (i = 0; i < n; i++)
    {
        for (j = 0; j < n; j += b)
        {
           for (x = j; x < mini(j + b, n); x++)
           {
               set_matrix_element(dst, i, x, get_matrix_element(src, x, i));
           }
        }
    }
}
#endif

#ifdef TRANSPOSE5
void transpose5(matrix_ptr src, matrix_ptr dst)
{
    int i, j, x, y;
    int n = src->len;
    int b = 2;
    data_t val;
    for (i = 0; i < n; i += b)
        for (j = 0; j < n; j += b)
        {
           for (x = i; x < mini(i + b, n); x++)
           {
               for (y = j; y < mini(j + b, n); y++)
               {
                   set_matrix_element(dst, y, x, get_matrix_element(src, x, y));
               }
           }
        }
}
#endif

#ifdef TRANSPOSE6
void transpose6(matrix_ptr src, matrix_ptr dst)
{
    int i, j, x, y;
    int n = src->len;
    int b = 4;
    data_t val;
    for (i = 0; i < n; i += b)
        for (j = 0; j < n; j += b)
        {
           for (x = i; x < mini(i + b, n); x++)
           {
               for (y = j; y < mini(j + b, n); y++)
               {
                   set_matrix_element(dst, y, x, get_matrix_element(src, x, y));
               }
           }
        }
}
#endif

int mini(int i, int j){
    if(i < j)
    {
        return i;
    }
    return j;
}
