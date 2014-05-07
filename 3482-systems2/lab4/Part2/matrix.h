typedef struct {
    long int len;
    data_t * data;
} matrix_rec, *matrix_ptr;

/* Create matrixtor */
matrix_ptr new_matrix(long int len);

/* initialize matrix to some values */
void init_matrix(matrix_ptr m);

/* set matrix element */
void set_matrix_element(matrix_ptr m, int r, int c, data_t val);

/* get matrix element */
data_t get_matrix_element(matrix_ptr m, int r, int c);

/* print matrix */ 
void print_matrix(matrix_ptr m, char * msg);

