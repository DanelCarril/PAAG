from sales import Sale
import pickle

def save_sale(user, f):
    with open(f, 'ab') as outp:
        pickle.dump(user, outp, pickle.HIGHEST_PROTOCOL)
        print("Sale saved.")
    
def show_sale(f):
    try:
        inp = open (f, 'rb')
        salesList = []
        count = 1
        while count == 1:
            try:
                salesList.append(pickle.load(inp))
            except EOFError:
                count = 0
        if salesList:
            for user in salesList:
                user.printSale()
        else:
            print("The file is empty.")
    except FileNotFoundError:
        print("Error: The file wasn't found.")

def find_sale(f):
    search_user = input("Enter the id of the sale: ")
    try:
        inp = open(f, 'rb')
        found = False
        count = 1
        while count == 1:
            try:
                sale = pickle.load(inp)
                if sale.saleid == search_user:
                    print("Found user:")
                    sale.printSale()
                    found = True
            except EOFError:
                count = 0
        if not found:
            print("Error: Sale not found.")
    except FileNotFoundError:
        print("Error: File not found.")