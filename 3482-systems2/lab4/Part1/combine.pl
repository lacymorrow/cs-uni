#!/usr/bin/perl
# Created by Lacy Morrow & Zachary Wright
# Run using 
# % perl combine.pl
# % display combine.jpg
$numCombines = 4;
$minsize = 50000;
$maxsize = 1000000;
@color = ('#ff0000','#00ff00','#0000ff','#ff36a0');

open(OUTG, ">combine.plg") or die "Could not open file data";
$out = '#!/usr/bin/gnuplot'."\n";
$out .= 'set ylabel "Time (msecs)"'."\n";
$out .= 'set xlabel "Size (in 50000s of elements)"'."\n";
$out .= 'set terminal jpeg font "/usr/share/fonts/liberation/LiberationSans-Regular.ttf"'."\n";
$out .= 'set output "combine.jpg"'."\n";
$plot = 'plot ';
for ($j = 1; $j <= $numCombines; $j++)
{
	open(OUT, ">COMBINE".$j.".data") or die "Could not open file data";
	for ($i = $minsize; $i <= $maxsize; $i = $i + 50000)
	{
		$avg = 0;
		for($k = 0; $k < 6; $k++)
		{
			$command = "gcc -O1 -DCOMBINE".$j." -DSIZE=" . $i . " -DINT *.c -o combine";
			print "$command\n";
			#pass the gcc command to the system function
			system $command ;
			#the gcc command should have created a combine executable
			#execute it and redirect its output to a file
			$res = system "./combine > tmpfile";
			#read the file to obtain the result
			open(COMBINEOUT, "tmpfile"); 
			$res = <COMBINEOUT>;
			$avg += $res;
			system "rm tmpfile";
		}
		$avg = $avg/5;
		#output the result and the size of the data (in chunks of
		# 50000 elements) to the file COMBINE1.data
		$chunksOf50000 = $i / 50000;
		print OUT "$chunksOf50000  $avg\n";
	}
	$out .= 'set style line '.$j.' lc rgb "'.@color[$j-1].'" lt 1 lw 2 pt 7 ps 1.5'."\n";
	$plot .= '"COMBINE'.$j.'.data" with line ls '.$j;
	if($j != $numCombines)
	{
		$plot .= ', ';
	}
}
seek(OUTG, 0, 0);
print OUTG $out.$plot;
system "gnuplot combine.plg";
system "display combine.jpg";
