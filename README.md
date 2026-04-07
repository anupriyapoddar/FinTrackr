# 🚀 FinTrackr — Company Finance Dashboard Backend

## 💡 Overview

FinTrackr is a secure, scalable backend system designed to manage and analyze **company-level financial data**.

It enables organizations to:

- 📊 Track income and expenses  
- 📈 Generate real-time financial insights  
- 🔐 Enforce role-based access control (RBAC)  
- 🧾 Maintain centralized financial records  

---

## 🌐 Live Demo & API Docs

- 🔗 **Live API**  
  https://fintrackr-wuyf.onrender.com  

- 📄 **Swagger UI**  
  https://fintrackr-wuyf.onrender.com/swagger-ui/index.html

👉 Use Swagger UI to:

- ❌ Scattered financial records  
- ❌ Lack of centralized tracking  
- ❌ No real-time insights  

---

## 🎯 Problem Statement

Organizations often struggle with:

- Authenticate user  
- Create transactions  
- View analytics  

### 👉 Solution
Centralizing financial data → Processing → Generating actionable insights


---

## 🧠 System Type

**Centralized Company Finance Backend**

> ❗ Not a personal expense tracker  
> ❗ Transactions are organization-level (not user-specific)

---

## 👥 Role-Based Access Control (RBAC)

| Role     | Access |
|----------|--------|
| **ADMIN**   | Full access (Create, Update, Delete, View) |
| **ANALYST** | Dashboard + insights + filtering |
| **VIEWER**  | Read-only dashboard |

---

## 🔐 Authentication & Security

### Features

- User Registration  
- Admin Secret Validation  
- OTP-based Verification  
- Password Hashing (**BCrypt**)  
- JWT-based Authentication  
- Role-based Authorization (`@PreAuthorize`)  

### 🔄 Authentication Flow
Register → OTP → Verify → Login → JWT Token → Access APIs

---

## 🧱 Architecture Overview

Client -> JWT -> Authentication -> Spring Security (RBAC) -> Controller -> Service -> Repository -> MongoDB Atlas

---

## 🔥 Core Features

### 🟢 Transaction Management
- Create, update, delete financial records (**Admin only**)

### 📊 Dashboard APIs
- Total Income  
- Total Expense  
- Net Balance  
- Category Breakdown  
- Profit/Loss Trends  
- Recent Activity  

### 🔍 Filtering
- Filter by:
  - Type  
  - Category  
  - Date  

---

## ⚙️ Tech Stack

### Backend
- Java  
- Spring Boot  

### Database
- MongoDB Atlas  

### Security
- Spring Security  
- JWT  
- BCrypt  

### DevOps
- Docker (Multi-stage build)  
- Render (Cloud deployment)  

### Tools
- Postman  
- IntelliJ IDEA  

---

## 🚀 Deployment

- 🐳 Containerized using Docker  
- ☁️ Deployed on Render  
- 🔗 Connected to MongoDB Atlas  

---

## 📘 Documentation

Detailed system design and architecture available in the `/docs` folder.

---

## 🏁 Conclusion

FinTrackr demonstrates:

- ✅ Clean layered architecture  
- ✅ Secure authentication & authorization  
- ✅ Real-time financial analytics  
- ✅ Scalable backend design  

---

## 👩‍💻 Author

**Anupriya Poddar**

---

## ⭐ Support

If you found this project helpful, consider giving it a ⭐ on GitHub!
