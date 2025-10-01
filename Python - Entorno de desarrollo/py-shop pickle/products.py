class Product:
    
    def __init__(self):
        self.product_id = "1"
        self.user_id = "1"  
        self.name = "TV"
        self.category = "Object"
        self.description = "A barely used TV"
        self.price = 100.0
        self.status = "available"
        self.created_at = "20/03/2025" 

    def setProductId(self):
        self.product_id = input("Enter product ID: ")

    def setUserId(self):
        self.user_id = input("Enter user ID: ")

    def setName(self):
        self.name = input("Enter product name: ")

    def setCategory(self):
        self.category = input("Enter category: ")

    def setDescription(self):
        self.description = input("Enter description: ")

    def setPrice(self):
        self.price = float(input("Enter price: "))

    def setStatus(self):
        self.status = input("Enter status (available/sold): ")

    def setCreatedAt(self):
        self.created_at = input("Enter created date (dd/mm/yyyy): ")

    def setAll(self):
        self.setProductId()
        self.setUserId()
        self.setName()
        self.setCategory()
        self.setDescription()
        self.setPrice()
        self.setStatus()
        self.setCreatedAt()

    def printProduct(self):
        print(f"Product ID: {self.product_id}, User ID: {self.user_id}, Name: {self.name}, Category: {self.category}, Description: {self.description}, Price: {self.price}, Status: {self.status}, Created At: {self.created_at}")
