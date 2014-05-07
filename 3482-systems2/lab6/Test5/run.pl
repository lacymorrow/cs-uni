#!/usr/bin/perl
#This one tests whether the name mangling is being handled properly

system "../instrResolve main.o foo.o > instructor.out";
system "../resolve main.o foo.o > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o foo.o\n";
} else
{
    print "Passed: ../resolve main.o foo.o\n";
}
system "rm -f instructor.out student.out diffs";


system "../instrResolve main.o foo.o foo.o > instructor.out";
system "../resolve main.o foo.o foo.o > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o foo.o foo.o\n";
} else
{
    print "Passed: ../resolve main.o foo.o foo.o\n";
}
system "rm -f instructor.out student.out diffs";

