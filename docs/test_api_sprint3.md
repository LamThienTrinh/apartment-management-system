API TEST REPORT - SPRINT 3
Project: Apartment Management System
Author: Vu Thuy Duong
Date: 19/12/2025

========================================

1. INTRODUCTION

This document describes the API testing activities for Sprint 3.
The purpose is to verify the correctness of backend APIs.

========================================

2. TEST ENVIRONMENT

Operating System: Windows 10
Backend: Spring Boot
Database: MySQL
Testing Tool: Postman

========================================

3. AUTHENTICATION API

Test Case 1:
Login with correct account
Endpoint: POST /api/auth/login
Expected: Status 200
Result: PASS

Test Case 2:
Login with wrong password
Endpoint: POST /api/auth/login
Expected: Status 401
Result: PASS

========================================

4. INVOICE API

Test Case 3:
Get all invoices
Endpoint: GET /api/invoices
Expected: Status 200
Result: PASS

Test Case 4:
Get invoice by ID
Endpoint: GET /api/invoices/1
Expected: Status 200
Result: PASS

Test Case 5:
Create new invoice
Endpoint: POST /api/invoices
Expected: Status 201
Result: PASS

Test Case 6:
Update invoice
Endpoint: PUT /api/invoices/1
Expected: Status 200
Result: PASS

Test Case 7:
Delete invoice
Endpoint: DELETE /api/invoices/1
Expected: Status 204
Result: PASS

========================================

5. PAYMENT API

Test Case 8:
Update payment status
Endpoint: PUT /api/payments/1
Expected: Status 200
Result: PASS

Test Case 9:
Invalid payment ID
Endpoint: PUT /api/payments/999
Expected: Status 404
Result: PASS

========================================

6. FEEDBACK API

Test Case 10:
Create feedback
Endpoint: POST /api/feedback
Expected: Status 201
Result: PASS

Test Case 11:
Get feedback list
Endpoint: GET /api/feedback
Expected: Status 200
Result: PASS

Test Case 12:
Reply feedback
Endpoint: POST /api/feedback/1/reply
Expected: Status 200
Result: PASS

========================================

7. PDF INVOICE API

Test Case 13:
Generate invoice PDF
Endpoint: GET /api/invoices/1/pdf
Expected: Status 200
Result: PASS

Test Case 14:
Invalid invoice PDF
Endpoint: GET /api/invoices/999/pdf
Expected: Status 404
Result: PASS

========================================

8. SECURITY TESTING

Test Case 15:
Access API without token
Endpoint: GET /api/invoices
Expected: Status 401
Result: PASS

========================================

9. PERFORMANCE TESTING

Average response time: 200ms
Maximum response time: 450ms
No system crash occurred.

========================================

10. SUMMARY

All APIs in Sprint 3 were tested successfully.
No critical bugs were found.

========================================

11. CONCLUSION

Sprint 3 testing is completed.
The system is stable.

========================================

12. END OF DOCUMENT
