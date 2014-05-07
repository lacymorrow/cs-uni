#!/usr/bin/perl

#The first three tests resolve without errors
#The last one has undefined symbols

system "../instrResolve main.o sub.o > instructor.out";
system "../resolve main.o sub.o > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o sub.o\n";
} else
{
    print "Passed: ../resolve main.o sub.o\n";
}
system "rm -f instructor.out student.out diffs";

system "../instrResolve sub.o main.o > instructor.out";
system "../resolve sub.o main.o > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve sub.o main.o\n";
} else
{
    print "Passed: ../resolve sub.o main.o\n";
    system "rm -f instructor.out student.out diffs";
}

system "../instrResolve main.o > instructor.out";
system "../resolve main.o > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o\n";
} else
{
    print "Passed: ../resolve main.o\n";
}
system "rm -f instructor.out student.out diffs";

system "../instrResolve sub.o > instructor.out";
system "../resolve sub.o > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve sub.o\n";
} else
{
    print "Passed: ../resolve sub.o\n";
}
system "rm -f instructor.out student.out diffs";

