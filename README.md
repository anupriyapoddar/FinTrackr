🚀 FinTrackr — Company Finance Dashboard Backend
💡 Overview

FinTrackr is a secure, role-based backend system designed to manage and analyze company-level financial data.

It enables organizations to:

📊 Track income and expenses
📈 Generate real-time financial insights
🔐 Enforce role-based access control (RBAC)
🧾 Maintain centralized financial records
🌐 Live Demo & API Docs
🔗 Live API: https://fintrackr-wuyf.onrender.com
📄 Swagger UI: https://fintrackr-wuyf.onrender.com/swagger-ui/index.html
🎯 Problem Statement

Organizations often face:

❌ Scattered financial records
❌ Lack of centralized tracking
❌ No real-time insights
👉 Solution

FinTrackr solves this by:

Centralizing financial data → Processing → Generating actionable insights

🧠 System Type
Centralized Company Finance Backend
❗ Not a personal expense tracker
❗ Transactions are organization-level (not user-specific)

👥 Role-Based Access Control (RBAC)
Role	               Access
ADMIN	               Full access (Create, Update, Delete, View)
ANALYST	             Dashboard + insights + filtering
VIEWER	             Dashboard (read-only)

🔐 Authentication & Security
1. User Registration
2. Admin Secret Validation
3. OTP-based Verification
4. Password Hashing (BCrypt)
5. JWT-based Authentication
6. Role-based Authorization (@PreAuthorize)
   
🔄 Authentication Flow
Register → OTP Generated → Verify → Login → JWT Token → Access APIs

🧱 Architecture Overview
Client → JWT Authentication → Spring Security (RBAC) → Controller → Service → Repository → MongoDB Atlas

🔥 Core Features
🟢 Transaction Management
Create, update, delete financial records (Admin only)

📊 Dashboard APIs
Total Income
Total Expense
Net Balance
Category Breakdown
Trends (Profit/Loss)
Recent Activity

🔍 Filtering
Filter transactions by type and category

⚙️ Tech Stack
Backend
Java
Spring Boot
Database
MongoDB Atlas
Security
Spring Security
JWT
BCrypt
DevOps
Docker (Multi-stage build)
Render (Cloud deployment)
Tools
Postman
IntelliJ

🚀 Deployment
Containerized using Docker
Deployed on Render
Connected to MongoDB Atlas

📘 Detailed Documentation
👉 System Design & Architecture

🏁 Conclusion
FinTrackr demonstrates:

✅ Clean layered architecture
✅ Secure authentication & authorization
✅ Real-time financial analytics
✅ Scalable backend design

👩‍💻 Author
Anupriya Poddar
