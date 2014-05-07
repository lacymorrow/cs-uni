#!/usr/bin/perl

#The main in this test is complete without the library, so
#nothing in the library is actually included

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

system "../instrResolve libfoo.a main.o > instructor.out";
system "../resolve libfoo.a main.o > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve libfoo.a main.o\n";
} else
{
    print "Passed: ../resolve libfoo.a main.o\n";
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

#multiply defined foo
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


