# Day of the Programmer

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

Marie invented a [Time Machine](https://en.wikipedia.org/wiki/Time_machine) and wants to test it by time-traveling to visit Russia on the [Day of the Programmer](https://en.wikipedia.org/wiki/Day_of_the_Programmer) (the 256th day of the year) during a year in the inclusive range from 1700 to 2700. 

From 1700 to 1917, Russia's official calendar was the [Julian calendar](https://en.wikipedia.org/wiki/Julian_calendar); since 1919 they used the [Gregorian calendar](https://en.wikipedia.org/wiki/Gregorian_calendar) system. The transition from the Julian to Gregorian calendar system occurred in 1918, when the next day after January 31st was February 14th. This means that in 1918, February 14th was the 32nd day of the year in Russia.

In both calendar systems, February is the only month with a variable amount of days; it has 29 days during a *leap year*, and 28 days during all other years. In the Julian calendar, leap years are divisible by 4; in the Gregorian calendar, leap years are either of the following:

- Divisible by 400.
- Divisible by 4 and *not* divisible by 100.

Given a year, $y$, find the date of the 256th day of that year *according to the official Russian calendar during that year*. Then print it in the format `dd.mm.yyyy`, where `dd` is the two-digit day, `mm` is the two-digit month, and `yyyy` is $y$.

For example, the given $year$ = 1984.  1984 is divisible by 4, so it is a leap year.  The 256th day of a leap year after 1918 is September 12, so the answer is $\texttt{12.09.1984}$.  

**Function Description**  

Complete the *dayOfProgrammer* function in the editor below.  It should return a string representing the date of the 256th day of the year given.  

dayOfProgrammer has the following parameter(s):  

- *year*: an integer  

**Input Format**

A single integer denoting year $y$.

**Constraints**

- 1700 \le y \le 2700

**Output Format**

Print the full date of *Day of the Programmer* during year $y$ in the format `dd.mm.yyyy`, where `dd` is the two-digit day, `mm` is the two-digit month, and `yyyy` is $y$.

## Solution

**Language:** Go  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-07-09T13:17:00.167Z  

```go
package main

import (
    "bufio"
    "fmt"
    "io"
    "os"
    "strconv"
    "strings"
)

/*
 * Complete the 'dayOfProgrammer' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts INTEGER year as parameter.
 */

func dayOfProgrammer(year int32) string {
    if year == 1918 {
        // Calendar transition year
        return "26.09.1918"
    }

    leap := false

    if year < 1918 {
        // Julian calendar
        if year%4 == 0 {
            leap = true
        }
    } else {
        // Gregorian calendar
        if year%400 == 0 || (year%4 == 0 && year%100 != 0) {
            leap = true
        }
    }

    if leap {
        return fmt.Sprintf("12.09.%04d", year)
    }

    return fmt.Sprintf("13.09.%04d", year)
}

func main() {
    reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)

    stdout, err := os.Create(os.Getenv("OUTPUT_PATH"))
    checkError(err)

    defer stdout.Close()

    writer := bufio.NewWriterSize(stdout, 16*1024*1024)

    yearTemp, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
    checkError(err)

    year := int32(yearTemp)

    result := dayOfProgrammer(year)

    fmt.Fprintf(writer, "%s\n", result)

    writer.Flush()
}

func readLine(reader *bufio.Reader) string {
    str, _, err := reader.ReadLine()

    if err == io.EOF {
        return ""
    }

    return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
    if err != nil {
        panic(err)
    }
}

```

---

[View on HackerRank](https://www.hackerrank.com/challenges/day-of-the-programmer/problem)