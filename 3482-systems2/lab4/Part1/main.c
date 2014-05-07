#include <sys/time.h>
#include <sys/resource.h>
#include <stdio.h>
#include "combine.h"

#ifdef COMBINE1
void combine1(vec_ptr v, data_t * dest);
#endif
#ifdef COMBINE2
void combine2(vec_ptr v, data_t * dest);
#endif
#ifdef COMBINE3
void combine3(vec_ptr v, data_t * dest);
#endif
#ifdef COMBINE4
void combine4(vec_ptr v, data_t * dest);
#endif
int main()
{
    long int i;
    data_t dest;
    vec_ptr v = new_vec(SIZE);
    struct timeval start, end;        
    struct rusage ru;        
    getrusage(RUSAGE_SELF, &ru);        
    start = ru.ru_utime;
    double startsec, endsec;
  
#ifdef COMBINE1
    combine1(v, &dest);
#endif
#ifdef COMBINE2
    combine2(v, &dest);
#endif
#ifdef COMBINE3
    combine3(v, &dest);
#endif
#ifdef COMBINE4
    combine4(v, &dest);
#endif
    getrusage(RUSAGE_SELF, &ru);        
    end = ru.ru_utime;
    //convert seconds to microseconds
    startsec = start.tv_sec * 1000000.0 + start.tv_usec;
    endsec = end.tv_sec * 1000000.0 + end.tv_usec;
    //convert microseconds to milliseconds
    printf("%d\n", (long int)((endsec - startsec) / 1000.0));
}


#ifdef COMBINE1
void combine1(vec_ptr v, data_t * dest)
{
    long int i;
    *dest = IDENT;
    for (i = 0; i < vec_length(v); i++)
    {
        data_t val;
        get_vec_element(v, i, &val);
        *dest = *dest OP val;
    }
}
#endif

#ifdef COMBINE2
void combine2(vec_ptr v, data_t * dest)
{
    long int i;
    long int length = vec_length(v);
    *dest = IDENT;
    for (i = 0; i < length; i++)
    {
        data_t val;
        get_vec_element(v, i, &val);
        *dest = *dest OP val;
    }
}
#endif

#ifdef COMBINE3
void combine3(vec_ptr v, data_t * dest)
{
    long int i;
    long int length = vec_length(v);
    data_t *data = get_vec_start(v);
    *dest = IDENT;
    for (i = 0; i < length; i++)
    {
        *dest = *dest OP data[i];
    }
}
#endif

#ifdef COMBINE4
void combine4(vec_ptr v, data_t * dest)
{
    long int i;
    long int length = vec_length(v);
    data_t *data = get_vec_start(v);
    data_t acc = IDENT;
    for (i = 0; i < length; i++)
    {
        acc = acc OP data[i];
    }
    *dest = acc;
}
#endif

