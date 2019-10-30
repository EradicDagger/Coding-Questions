"""
Read file into texts and calls.
It's ok if you don't understand how to read files.
"""
import csv
with open('texts.csv', 'r') as f:
    reader = csv.reader(f)
    texts = list(reader)

with open('calls.csv', 'r') as f:
    reader = csv.reader(f)
    calls = list(reader)


"""
TASK 1:
How many different telephone numbers are there in the records? 
Print a message:
"There are <count> different telephone numbers in the records."
"""

# Get unique telephone numbers for both receving and sending columns in texts and calls
texts_sending_telephone_set = set([text[0] for text in texts])
texts_receiving_telephone_set = set([text[1] for text in texts])

calls_calling_telephone_set = set([call[0] for call in calls])
calls_receiving_telephone_set = set([call[1] for call in calls])

# Getting union of all the sets
unique_telephone_number_set = set(texts_sending_telephone_set
                                    .union(texts_receiving_telephone_set)
                                    .union(calls_calling_telephone_set)
                                    .union(calls_receiving_telephone_set))
print("There are " + str(len(unique_telephone_number_set)) +" different telephone numbers in the records.")

