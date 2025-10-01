from users import User
import pickle

def save_user(user, f):
    with open(f, 'ab') as outp:
        pickle.dump(user, outp, pickle.HIGHEST_PROTOCOL)
        print("User saved.")
    
def show_users(f):
    try:
        inp = open (f, 'rb')
        usersList = []
        count = 1
        while count == 1:
            try:
                usersList.append(pickle.load(inp))
            except EOFError:
                count = 0
        if usersList:
            for user in usersList:
                user.printUser()
        else:
            print("The file is empty.")
    except FileNotFoundError:
        print("Error: The file wasn't found.")

def find_user(f):
    search_user = input("Enter the id of the user: ")
    try:
        inp = open(f, 'rb')
        found = False
        count = 1
        while count == 1:
            try:
                user = pickle.load(inp)
                if user.id == search_user:
                    print("Found user:")
                    user.printUser()
                    found = True
            except EOFError:
                count = 0
        if not found:
            print("Error: User not found.")
    except FileNotFoundError:
        print("Error: File not found.")