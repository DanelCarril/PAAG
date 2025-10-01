import csv
import os

def add_teacher():
    file_exists = os.path.exists('teachers.csv')
    
    f = open('teachers.csv', 'a')
    with f:
        fteachers = ['ID', 'Name', 'Surname', 'Born_date', 'Email', 'Phone', 'Subject', 'Hiring_date']
        writer = csv.DictWriter(f, fieldnames = fteachers)
        if not file_exists:
            writer.writeheader()
        a = 'y'
        
        while a == 'y':
            ID = input("Enter the ID: ")
            name = input("Enter the Name: ")
            surname = input("Enter the Surname: ")
            born_date = input("Enter the Born date: ")
            email = input("Enter the Email: ")
            phone = input("Enter the Phone: ")
            subject = input("Enter the Subject: ")
            hiring_date = input("Enter the Hiring date: ")
                
            writer.writerow({'ID': ID, 'Name': name, 'Surname': surname, 'Born_date': born_date, 'Email': email, 'Phone': phone, 'Subject': subject, 'Hiring_date': hiring_date})
                
            a = input("Do you want to add more registers? (y/n): ")
            while a != 'y' and a != 'n':
                a = input("Invalid input. Do you want to add more registers? (y/n): ")
    print("")
                

def read_teacher():
    try:
        f = open('teachers.csv', 'r')
        with f:
            reader = csv.DictReader(f)
            headers = reader.fieldnames
            print (headers)
            for row in reader:
                print(row['ID'], row['Name'], row['Surname'], row['Born_date'], row['Email'], row['Phone'], row['Subject'], row['Hiring_date'])
    except FileNotFoundError:
        print("The file 'teachers.csv' does not exist yet. Add teachers first.")
    print("")


while True:
    print("Teachers MENU")
    print("  1- Add a new teacher")
    print("  2- See the teachers table")
    print("  3- Exit")
    value = input("Enter your decision: ")

    if value == '1':
        add_teacher()
    elif value == '2':
        read_teacher()
    elif value == '3':
        print("Exiting the program...")
        break
    else:
        print("Please enter a valid number from the menu.")
        print("\n")


