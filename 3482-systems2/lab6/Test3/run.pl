#!/usr/bin/perl


#This one resolves without errors
system "../instrResolve main.o foo.o goo.o > instructor.out";
system "../resolve main.o foo.o goo.o > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o foo.o goo.o\n";
} else
{
    print "Passed: ../resolve main.o foo.o goo.o\n";
}
system "rm -f instructor.out student.out diffs";

#This one resolves without errors
system "../instrResolve main.o libgoofoo.a > instructor.out";
system "../resolve main.o libgoofoo.a > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o libgoofoo.a\n";
} else
{
    print "Passed: ../resolve main.o libgoofoo.a\n";
}
system "rm -f instructor.out student.out diffs";

#undefined reference to foo
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

#undefined reference to goo
system "../instrResolve main.o foo.o> instructor.out";
system "../resolve main.o foo.o> student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o foo.o\n";
} else
{
    print "Passed: ../resolve main.o foo.o\n";
}
system "rm -f instructor.out student.out diffs";

#undefined reference to foo and k
system "../instrResolve main.o goo.o> instructor.out";
system "../resolve main.o goo.o> student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o goo.o\n";
} else
{
    print "Passed: ../resolve main.o goo.o\n";
}
system "rm -f instructor.out student.out diffs";

#resolves without errors
system "../instrResolve main.o libfoo.a libgoo.a > instructor.out";
system "../resolve main.o libfoo.a libgoo.a > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o libfoo.a libgoo.a\n";
} else
{
    print "Passed: ../resolve main.o libfoo.a libgoo.a\n";
}
system "rm -f instructor.out student.out diffs";

#unresolved reference to goo
system "../instrResolve main.o libgoo.a libfoo.a > instructor.out";
system "../resolve main.o libgoo.a libfoo.a > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o libgoo.a libfoo.a\n";
} else
{
    print "Passed: ../resolve main.o libgoo.a libfoo.a\n";
}
system "rm -f instructor.out student.out diffs";

#resolves without error
system "../instrResolve main.o libgoo.a libfoo.a libgoo.a > instructor.out";
system "../resolve main.o libgoo.a libfoo.a libgoo.a > student.out";
system "diff instructor.out student.out > diffs";
if (! system "test -s diffs")
{
    print "Failed: ../resolve main.o libgoo.a libfoo.a libgoo.a\n";
} else
{
    print "Passed: ../resolve main.o libgoo.a libfoo.a libgoo.a\n";
}
system "rm -f instructor.out student.out diffs";




