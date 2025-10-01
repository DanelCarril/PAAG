class Sale:
    
    def __init__(self):
        self.saleid = "1"
        self.productname = "spoon"
        self.productprice = "5.99"
        self.buyername = "Markel"
        self.saledate = "07/04/2025"
    
    def setSaleId(self):
       self.saleid = input("Enter the sale id: ")
       
    def setProductName(self):
        self.productname = input("Enter the product name: ")
    
    def setProductPrice(self):
        self.productprice = input("Enter the price of the product: ")
    
    def setBuyerName(self):
        self.buyername = input("Enter the buyer's name: ")
    
    def setSaleDate(self):
        self.saledate = input("Enter the date of the sale: ")
    
       
    def getSaleId(self):
        print(self.saleid)
    
    def getProductName(self):
        print(self.productname)
    
    def getProductPrice(self):
        print(self.productprice)
    
    def getBuyerName(self):
        print(self.buyername)
    
    def getSaleDate(self):
        print(self.saledate)
        
    def setAll(self):
        self.setSaleId()
        self.setProductName()
        self.setProductPrice()
        self.setBuyerName()
        self.setSaleDate()
    
    def printSale(self):
        print(self.saleid, self.productname, self.productprice, self.buyername, self.saledate)