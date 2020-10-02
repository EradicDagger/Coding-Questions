import calendar 
  
# using calender to print calendar of year 
# prints calendar of 2012 
print ("The calender of year 2012 is : ") 
print (calendar.calendar(2012,2,1,6)) 
  
#using firstweekday() to print starting day number 
print ("The starting day number in calendar is : ",end="") 
print (calendar.firstweekday())
