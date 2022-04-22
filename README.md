Employee Reimbursement System

Summary:
This is an API and a Web Application that supports an internal expense reimbursement system. 
This system manages the process of reimbursing employees for expenses incurred while on company time. 
All registered employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. 
Finance managers can log in and view all reimbursement requests and past history for all employees in the company. 
Finance managers are authorized to approve and deny requests for expense reimbursement.

Features:

- An new employee or new finance manager can request registration with the system
- An admin user can approve or deny new registration requests
- A registered employee can authenticate with the system by providing valid credentials
- An authenticated employee can view and manage their pending reimbursement requests
- An authenticated employee can view their reimbursement request history (sortable and filterable)
- An authenticated employee can submit a new reimbursement request
- An authenticated finance manager can view a list of all pending reimbursement requests
- An authenticated finance manager can view a history of requests that they have approved/denied
- An authenticated finance manager can approve/deny reimbursement requests
- An admin user can deactivate user accounts, making them unable to log into the system
- An admin user can reset a registered user's password

Technology Stack:

Persistence Tier
- PostGreSQL

API Tier
- Java 8
- Gradle
- JDBC
- Java EE Servlets
- JUnit

Client Tier
- HTML
- CSS
- JS
- Fetch API

Roles:

Brett Evans: Active Developer, 
Jazib Nasim: Active Developer

Links:
-Backend
https://github.com/220214-Java-React/nasim_evans_p1_backend

-frontend
https://github.com/220214-Java-React/nasim_evans_p1_frontend
