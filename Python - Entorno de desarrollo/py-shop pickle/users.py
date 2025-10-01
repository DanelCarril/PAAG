class User:
    
    def __init__(self):
        self.id = "1"
        self.username = "danelk"
        self.name = "Danel"
        self.surname = "Carril"
        self.email = "carril.danel@uni.eus"
        self.password = "danel123"
        self.role = "admin"
    
    def setId(self):
       self.id = input("Enter the value of id: ")
       
    def setUsername(self):
        self.username = input("Username: ")
    
    def setName(self):
        self.name = input("Name: ")
    
    def setSurname(self):
        self.surname = input("Surname: ")
    
    def setEmail(self):
        self.email = input("Email: ")
    
    def setPassword(self):
        self.password = input("Password: ")
    
    def setRole(self):
        self.role = input("Role (admin/member): ")
    
    def getId(self):
       print(self.id)
       
    def getUsername(self):
        print(self.username)
    
    def getName(self):
        print(self.name)
    
    def getSurname(self):
        print(self.surname)
    
    def getEmail(self):
        print(self.email)
    
    def getPassword(self):
        print(self.password)
    
    def getRole(self):
        print(self.role)
        
    def setAll(self):
        self.setId()
        self.setUsername()
        self.setName()
        self.setSurname()
        self.setEmail()
        self.setPassword()
        self.setRole()
    
    def printUser(self):
        print(self.id, self.username, self.name, self.surname, self.email, self.password, self.role)