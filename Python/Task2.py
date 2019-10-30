"""
Read file into texts and calls.
It's ok if you don't understand how to read files
"""
import csv
with open('texts.csv', 'r') as f:
    reader = csv.reader(f)
    texts = list(reader)

with open('calls.csv', 'r') as f:
    reader = csv.reader(f)
    calls = list(reader)

"""
TASK 2: Which telephone number spent the longest time on the phone
during the period? Don't forget that time spent answering a call is
also time spent on the phone.
Print a message:
"<telephone number> spent the longest time, <total time> seconds, on the phone during 
September 2016.".
"""
#Get the total call time for each telephone number
def get_call_time_count(data, phone_index, time_index):
    count = {}
    for item in data:
        for index in phone_index:
            count[item[index]] = count.get(item[index], 0) + int(item[time_index])
    print(len(count))
    return count


#Get the max calling time phone number
def get_max_call_time(count_call_time):
    max_phone = {'phone': '', 'total': 0}
    for item in count_call_time:
        if max_phone['total'] < count_call_time[item]:
            max_phone['phone'] = item
            max_phone['total'] = count_call_time[item]

    return max_phone


max_call_time = get_max_call_time(get_call_time_count(calls, [0, 1], 3))

print( str(max_call_time['phone']) + " spent the longest time, "
       + str(max_call_time['total']) + " seconds, on the phone during September 2016.")
