def daysInMonth(year, month):
    if month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12:
        return 31
    else:
        if month == 2:
            if isLeapYear(year): return 29
            else:
                
                print("sarthak")
                print("Yaha say")
                return 28
        else: return 30
def isLeapYear(year):
    if (year % 4)==0:
       if (year % 100) == 0:
           if (year % 400) == 0:
               return 1
           else:
               return 0
       else:
           return 1
    else:
        return 0

x=daysInMonth(2000,4)
print(x)
