# LoanProjectionApp
This  REST API is used to get the fees and installments for a given loan. The application is developed using java/ Spring boot and data stored in MSSQL server Database 

# Prerequisites
Apache Tomcat 9
MSSQL Instance installed 
Java8

# Technologies 
The application has been developed using Java /Spring Boot 

# Installation
To run the application successfully please follow the below steps
Clone/ Extract the application files from the repository
Execute the database script shared on your server or local machine 
Open and build the application in your preferred IDE, Netbean used during development 
change the database credentials and URL from the *application,properties* file
Run and build the application then copy the *loanprojection.war* from the target folder
copy the war file to the webapps folder in the installation directory for Tomcat
Once the application has started successfully, test using the below requests

# Tests

# Fee projections 
http://127.0.0.1:8080/loanprojection/fee-projections?amount=1000&duration=1&startDate=2023-06-01

# Results 
```json
[
    {
        "id": 45,
        "type": "Interest",
        "amount": 10.00,
        "dueDate": "2023-06-01"
    },
    {
        "id": 46,
        "type": "Service Fee",
        "amount": 5.000,
        "dueDate": "2023-06-01"
    }
]
```

# Installment Projection 

http://127.0.0.1:8080/loanprojection/installment-projections?amount=3000&duration=3&startDate=2023-06-01

# Results

```json
[
    {
        "loanApplication": null,
        "dueDate": "2023-06-01",
        "installmentAmount": 1045.00
    },
    {
        "loanApplication": null,
        "dueDate": "2023-06-08",
        "installmentAmount": 1045.00
    },
    {
        "loanApplication": null,
        "dueDate": "2023-06-15",
        "installmentAmount": 1045.000
    }
]
```



