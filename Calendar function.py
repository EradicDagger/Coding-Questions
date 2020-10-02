import calendar 
  
# using calender to print calendar of year 
# prints calendar of the year input by user. 
yr = (int)(input ("Enter Year :"))
print ("The calender of year %d is : " % (yr)) 
print (calendar.calendar(yr,2,1,6)) 
  
#using firstweekday() to print starting day number 
print ("The starting day number in calendar is : ",end="") 
print (calendar.firstweekday())
