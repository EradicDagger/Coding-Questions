import os

def rename_files() :
    # file_list contain list of all files in the folder
    file_list = os.listdir(r"C:\Users\Manmeet\Documents\EGDownloads\prank\prank")
    # Here 'r' in directory location means that take the directory directly without any interpretation
    #print(file_list)
    #checking current working directory
    saved_path= os.getcwd()
    #print(saved_path)
    os.chdir(r"C:\Users\Manmeet\Documents\EGDownloads\prank\prank")
    saved_path= os.getcwd()
    print(saved_path)
    # renaming each file
    map = str.maketrans('', '', '0123456789')
    for file_name in file_list:
        x = os.rename(file_name, file_name.translate(map))
        print("Old - "+file_name+" \nNew - " + file_name.translate(map))    
    os.chdir(saved_path)    

rename_files()    
