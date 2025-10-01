import csv
import os

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

while True:
    print("Psychologists")
    print("============================")
    print("1. Add Psychologist")
    print("2. Read Psychologists")
    print("3. Exit")

    sub_option = int (input("select an option: "))

    if sub_option == 1:
        add_psychos()
    elif sub_option == 2:
        read_psychos()
    elif sub_option == 3:
        break
    else:
        print("Invalid option!")
