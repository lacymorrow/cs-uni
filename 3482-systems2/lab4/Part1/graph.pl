#!/usr/bin/gnuplot
set ylabel "Time (msecs)"
set xlabel "Size (in 50000s of elements)"
set terminal jpeg font "/usr/share/fonts/liberation/LiberationSans"
set output "combine.jpg"
set style line 1 lc rgb '#ff0000' lt 1 lw 2 pt 7 ps 1.5
plot "COMBINE1.data" with line ls 1
