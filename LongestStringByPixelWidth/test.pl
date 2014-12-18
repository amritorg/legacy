#!/usr/bin/perl

# Update the classpath depending upon location of required library
 
$classpath = 'c:\Temp\pixel\commons-lang3-3.1.jar;c:\Temp\pixel';

$cp = "-cp";

# Input string in unicode format
$sample = "\\u30C9\\u30AD\\u30E5\\u30E1\\u30F3\\u30C8\\u3092\\u958B\\u304F";
 
# Executing the java process where $sample is input string for which pixel width need to be calculated

 system("java", $cp, $classpath, "-Dfile.encoding=UTF-8", "CalculateStringWidth", $sample);


if ( $? == -1 )
{
  print "command failed: $!\n";
}
else
{
# Calculated width is being returned as exit code  
 printf "value coming from perl script %d", $? >> 8;
}


