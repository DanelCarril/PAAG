from products import Product
import pickle

def save_product(product, f):
    with open(f, 'ab') as outp:
        pickle.dump(product, outp, pickle.HIGHEST_PROTOCOL)
        print("Product saved.")
    
def show_product(f):
    try:
        inp = open (f, 'rb')
        productList = []
        count = 1
        while count == 1:
            try:
                productList.append(pickle.load(inp))
            except EOFError:
                count = 0
        if productList:
            for product in productList:
                product.printProduct()
        else:
            print("The file is empty.")
    except FileNotFoundError:
        print("Error: The file wasn't found.")

def find_product(f):
    search_product = input("Enter the id of the product: ")
    try:
        inp = open(f, 'rb')
        found = False
        count = 1
        while count == 1:
            try:
                product = pickle.load(inp)
                if product.product_id == search_product:
                    print("Found product:")
                    product.printProduct()
                    found = True
            except EOFError:
                count = 0
        if not found:
            print("Error: Product not found.")
    except FileNotFoundError:
        print("Error: File not found.")