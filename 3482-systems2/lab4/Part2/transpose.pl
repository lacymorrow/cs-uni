#!/usr/bin/perl
# Created by Lacy Morrow & Zachary Wright
# Run using 
# % perl transpose.pl
$numTests = 6;
$minsize = 100;
$maxsize = 1000;
@color = ('#ff0000','#00ff00','#0000ff','#ff36a0', '#000000', '#008800');

open(OUTG, ">transpose.plg") or die "Could not open file data";
$out = '#!/usr/bin/gnuplot'."\n";
$out .= 'set ylabel "Time (msecs)"'."\n";
$out .= 'set xlabel "Size (in 100s of elements)"'."\n";
$out .= 'set terminal jpeg font "/usr/share/fonts/liberation/LiberationSans-Regular.ttf"'."\n";
$out .= 'set output "transpose.jpg"'."\n";
$plot = 'plot ';
for ($j = 1; $j <= $numTests; $j++)
#foreach (@ARGV)
{
	#$j = $_; #comment this line to use the for (vs foreach) loop.
    open(OUT, ">TRANSPOSE".$j.".data") or die "Could not open file data";
	for ($i = $minsize; $i <= $maxsize; $i = $i + 100)
	{
		$avg = 0;
		for($k = 0; $k < 1; $k++)
		{
			$command = "gcc -O1 -DTRANSPOSE".$j." -DSIZE=" . $i . " -DINT -DPRINT *.c -o transpose";
			print "$command\n";
			#pass the gcc command to the system function
			system $command ;
			#the gcc command should have created a transpose executable
			#execute it and redirect its output to a file
			$res = system "./transpose > tmpfile";
			#read the file to obtain the result
			open(TRANSPOSEOUT, "tmpfile"); 
			$res = <TRANSPOSEOUT>;
			$avg += $res;
			system "rm tmpfile";
		}
		$avg = $avg/5;
		#output the result and the size of the data (in chunks of
		# 100 elements) to the file transpose1.data
		$chunksOf50000 = $i / 50000;
		print OUT "$chunksOf50000  $avg\n";
	}
	$out .= 'set style line '.$j.' lc rgb "'.@color[$j-1].'" lt 1 lw 2 pt 7 ps 1.5'."\n";
	$plot .= '"TRANSPOSE'.$j.'.data" with line ls '.$j;
	if($j != $numTests)
	{
		$plot .= ', ';
	}
}
seek(OUTG, 0, 0);
print OUTG $out.$plot;
system "gnuplot transpose.plg";
system "display transpose.jpg";
