#!/usr/bin/perl

#These two tests result in multiply defined symbol k

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

system "../instrResolve main.o libfoo.a > instructor.out";
system "../resolve main.o libfoo.a > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o libfoo.a\n";
} else
{
    print "Passed: ../resolve main.o libfoo.a\n";
}
system "rm -f instructor.out student.out diffs";


