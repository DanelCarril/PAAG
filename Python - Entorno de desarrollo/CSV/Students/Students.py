import csv
import os

def students_add():
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
                

def students_read():
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

def menu():
    while True:
        print("\n1- Add a new student")
        print("2- See the students table")
        print("3- Exit")
        value = input("Enter your decision: ")

        if value == '1':
            students_add()
        elif value == '2':
            students_read()
        elif value == '3':
            print("Exiting the program...")
            break
        else:
            print("Please enter a valid number from the menu.")

menu()
