import csv
import os

def add_students():
    file_exists = os.path.exists('students.csv')
    with open('students.csv', 'a', newline='') as f:
        fnames = ['students_id', 'first_name', 'last_name', 'born_day', 'email', 'phone', 'program', 'enrollment_date', 'nationality']
        writer = csv.DictWriter(f, fieldnames=fnames)
        if not file_exists:
            writer.writeheader()
            
        while True:
            id = input("Enter the student's ID: ")
            fn = input("Enter the first name: ")
            sn = input("Enter the last name: ")
            su = input("Enter the birth date (YYYY-MM-DD): ")
            em = input("Enter the email: ")
            pn = input("Enter the phone number: ")
            pr = input("Enter the program: ")
            ed = input("Enter the enrollment date (YYYY-MM-DD): ")
            nt = input("Enter the nationality: ")

            writer.writerow({'students_id': id, 'first_name': fn, 'last_name': sn, 'born_day': su, 'email': em, 'phone': pn, 'program': pr, 'enrollment_date': ed, 'nationality': nt})

            a = input("Do you want to add another student? (y/n): ").lower()
            if a != 'y':
                break
    print("")
            
def read_students():
    try:
        with open('students.csv', 'r') as f:
            reader = csv.DictReader(f)
            headers = reader.fieldnames
            print(headers)

            for row in reader:
                print(row['students_id'], row['first_name'], row['last_name'], row['born_day'], row['email'], row['phone'], row['program'], row['enrollment_date'], row['nationality'])
    except FileNotFoundError:
        print("The file 'students.csv' does not exist yet. Add students first.")
    print("")
    
def find_students():
    if not os.path.exists('students.csv'):
        print("Error: The file is not found.")
        return
    
    with open('students.csv', 'r', newline='') as f:
        reader = csv.DictReader(f) 
        find_student = input("Enter the ID of the student: ")
        found = False
        
        for row in reader:
            if find_student == row['students_id']:
                headers = reader.fieldnames
                print(headers)
                print(row['students_id'], row['first_name'], row['last_name'], row['born_day'], row['email'], row['phone'], row['program'], row['enrollment_date'], row['nationality'])
                found = True
                break
        if not found:
            print("Student not found.")
    print()
    
def add_teachers():
    file_exists = os.path.exists('teachers.csv') #ikusteko teachers.csv existitzen den
    
    f = open('teachers.csv', 'a')
    with f:
        fteachers = ['ID', 'Name', 'Surname', 'Born_date', 'Email', 'Phone', 'Subject', 'Hiring_date'] #header-ak deklaratu
        writer = csv.DictWriter(f, fieldnames = fteachers)
        if not file_exists: #ez bada existitzen header-ak idatziko ditu
            writer.writeheader()
        a = 'y'
        
        while a == 'y': #datuak sartzeko
            ID = input("Enter the ID: ")
            name = input("Enter the Name: ")
            surname = input("Enter the Surname: ")
            born_date = input("Enter the Born date: ")
            email = input("Enter the Email: ")
            phone = input("Enter the Phone: ")
            subject = input("Enter the Subject: ")
            hiring_date = input("Enter the Hiring date: ")
            
            #idazteko datuak    
            writer.writerow({'ID': ID, 'Name': name, 'Surname': surname, 'Born_date': born_date, 'Email': email, 'Phone': phone, 'Subject': subject, 'Hiring_date': hiring_date})
                
            a = input("Do you want to add more registers? (y/n): ")
            while a != 'y' and a != 'n':
                a = input("Invalid input. Do you want to add more registers? (y/n): ")
    print("")
    
def read_teachers():
    try:
        f = open('teachers.csv', 'r')
        with f:
            reader = csv.DictReader(f)
            headers = reader.fieldnames
            print (headers) #header-ak biztaratzeko
            for row in reader: #datuak biztaratzeko
                print(row['ID'], row['Name'], row['Surname'], row['Born_date'], row['Email'], row['Phone'], row['Subject'], row['Hiring_date'])
    except FileNotFoundError: 
        print("The file 'teachers.csv' does not exist yet. Add teachers first.")
    print("")
    
def find_teachers():
    if not os.path.exists('teachers.csv'): #ikusteko teachers.csv existitzen den
        print("Error: The file is not found.")
        return
    
    with open('teachers.csv', 'r', newline='') as f:
        reader = csv.DictReader(f)
        find_teacher = input("Enter the ID of the teacher: ")
        found = False

        for row in reader:
            if find_teacher == row['ID']: #konparatzen du sartutako id existitzen direnekin
                headers = reader.fieldnames
                print(headers) #bilatutako datuak biztaratzeko
                print(row['ID'], row['Name'], row['Surname'], row['Born_date'], row['Email'], row['Phone'], row['Subject'], row['Hiring_date'])
                found = True
                break

        if not found:
            print("Teacher not found.")

    print()
    
def add_psychos():
    file_exists = os.path.exists('psychos.csv')
    
    f = open('psychos.csv', 'a')
    with f:
        fpsychos = ['psychos_id','first_name','second_name','born_date','email','phone','special_fields','hiring_date']
        writer = csv.DictWriter(f, fieldnames=fpsychos)
        if not file_exists:
            writer.writeheader()
        a='y'
        while a=='y':
            psycho_id = input("Enter psychologist's ID: ")
            first_name = input("Enter psychologist's first name: ")
            second_name = input("Enter psychologist's second name: ")
            born_date = input("Enter psychologist's date of birth (YYYY-MM-DD): ")
            email = input("Enter psychologist's email: ")
            phone = input("Enter psychologist's phone number: ")
            special_fields = input("Enter psychologist's special fields (comma-separated): ")
            hiring_date = input("Enter psychologist's hiring date (YYYY-MM-DD): ")
            writer.writerow({'psychos_id': psycho_id, 'first_name': first_name, 'second_name': second_name, 'born_date': born_date, 'email': email, 'phone': phone, 'special_fields': special_fields, 'hiring_date': hiring_date})
            a = input("Do you want to add another psychologist? (y/n): ")
    print("")
            
def read_psychos():
    try:
        f = open('psychos.csv', 'r')
        with f:
            reader = csv.DictReader(f)
            header = reader.fieldnames
            print(header)
            for row in reader:
                print(row['psychos_id'],row['first_name'],row['second_name'],row['born_date'],row['email'],row['phone'],row['special_fields'],row['hiring_date'])
    except FileNotFoundError:
        print("The file 'teachers.csv' does not exist yet. Add teachers first.")
    print("")

def find_psychos():
    if not os.path.exists('psychos.csv'):
        print("Error: The file is not found.")
        return
    
    with open('psychos.csv', 'r', newline='') as f:
        reader = csv.DictReader(f)
        find_teacher = input("Enter the ID of the psycho: ")
        found = False

        for row in reader:
            if find_teacher == row['psychos_id']:
                headers = reader.fieldnames
                print(headers)
                print(row['psychos_id'],row['first_name'],row['second_name'],row['born_date'],row['email'],row['phone'],row['special_fields'],row['hiring_date'])
                found = True
                break

        if not found:
            print("Teacher not found.")

    print()
    
while True:
    print("MENU")
    print("====================")
    print("  1. Students")
    print("  2. Teachers")
    print("  3. Psychologists")
    print("  4. Exit")

    option = int (input("select an option: "))
    print("")

    if option == 1:
        while True:
            print("STUDENTS")
            print("====================")
            print("  1. Add Student")
            print("  2. Read Students")
            print("  3. Find Students")
            print("  4. Exit")

            sub_option = int (input("select an option: "))

            if sub_option == 1:
                add_students()
            elif sub_option == 2:
                read_students()
            elif sub_option == 3:
                find_students()
            elif sub_option == 4:
                break
            else:
                print("Invalid option!")

    if option == 2:
        while True:
            print("TEACHERS")
            print("====================")
            print("  1. Add Teacher")
            print("  2. Read Teachers")
            print("  3. Find Teacher")
            print("  4. Exit")

            sub_option = int (input("select an option: "))

            if sub_option == 1:
                add_teachers()
            elif sub_option == 2:
                read_teachers()
            elif sub_option == 3:
                find_teachers()
            elif sub_option == 4:
                break
            else:
                print("Invalid option!")

    if option == 3:
        while True:
            print("PSYCHOLOGIST")
            print("=========================")
            print("  1. Add Psychologist")
            print("  2. Read Psychologists")
            print("  3. Find Psychologist")
            print("  3. Exit")

            sub_option = int (input("select an option: "))

            if sub_option == 1:
                add_Psychos()
            elif sub_option == 2:
                read_Psychos()
            elif sub_option == 3:
                find_psychos()
            elif sub_option == 4:
                break
            else:
                print("Invalid option!")

    if option == 4:
        print("Goodbye!")
        break
    else:
        print("Invalid option!")
        print("\n")