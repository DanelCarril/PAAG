import pickle
import users_methods
import sales_methods
import products_methods

from users import User
from sales import Sale
from products import Product

choose = 1

while choose != 0:
    print("========================")
    print("         MENU")
    print("  0. Exit")
    print("  1. Users")
    print("  2. Products")
    print("  3. Sales")
    print("------------------------")
    choose = int(input("Choose: "))
    
    if choose == 1:
        userChoose = 1
        while userChoose != 0:
            print()
            print("========================")
            print("         USERS")
            print("  0. Return")
            print("  1. Add")
            print("  2. See")
            print("  3. Find")
            print("------------------------")
            userChoose = int(input("Choose: "))
            
            if userChoose == 0:
                break
            elif userChoose == 1:
                ans = 1
                while ans == 1:
                    print()
                    user = User()
                    user.setAll()
                    users_methods.save_user(user, 'users_data.pkl')
                    ans = int(input("Do you want to add a new user? (0/1) "))
            elif userChoose == 2:
                print()
                users_methods.show_users('users_data.pkl')
                print
            elif userChoose == 3:
                print()
                users_methods.find_user('users_data.pkl')
            else:
                if userChoose != 0:
                    print("Invalid choice")
    elif choose == 2:
        print()
        productChoose = 1
        while productChoose != 0:
            print()
            print("========================")
            print("        PRODUCTS")
            print("  0. Return")
            print("  1. Add")
            print("  2. See")
            print("  3. Find")
            print("------------------------")
            productChoose = int(input("Choose: "))
            
            if productChoose == 0:
                break
            elif productChoose == 1:
                ans = 1
                while ans == 1:
                    print()
                    product = Product()
                    product.setAll()
                    products_methods.save_product(product, 'product_data.pkl')
                    ans = int(input("Do you want to add a new product? (0/1) "))
            elif productChoose == 2:
                print()
                products_methods.show_product('product_data.pkl')
                print
            elif productChoose == 3:
                print()
                products_methods.find_product('product_data.pkl')
            else:
                if userChoose != 0:
                    print("Invalid choice")
    elif choose == 3:
        print()
        saleChoose = 1
        while saleChoose != 0:
            print()
            print("========================")
            print("         SALES")
            print("  0. Return")
            print("  1. Add")
            print("  2. See")
            print("  3. Find")
            print("------------------------")
            saleChoose = int(input("Choose: "))
            
            if saleChoose == 0:
                break
            elif saleChoose == 1:
                ans = 1
                while ans == 1:
                    print()
                    sale = Sale()
                    sale.setAll()
                    sales_methods.save_sale(sale, 'sales_data.pkl')
                    ans = int(input("Do you want to add a new product? (0/1) "))
            elif saleChoose == 2:
                print()
                sales_methods.show_sale('sales_data.pkl')
            elif saleChoose == 3:
                print()
                sales_methods.find_sale('sales_data.pkl')
            else:
                if userChoose != 0:
                    print("Invalid choice")
    else:
        if choose != 0:
            print("Invalid choice!")
            print()
print("THANK YOU FOR USING THE PROGRAM!")