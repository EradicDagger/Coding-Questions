import os
path = 'C:\\Users\\SG185339\\OneDrive - NCR Corporation\\Desktop\\Sarthak\\abc'
#print(path)
files = os.listdir(path)
# renaming each file
for file in files:
    os.rename(os.path.join(path, file), os.path.join(path, 'old_' + file ))
    print("Old - "+file+" \nNew - " + "old_"+file)    
