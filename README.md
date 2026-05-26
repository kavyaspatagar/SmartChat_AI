# SmartChat_AI 🤖

SmartChat_AI is an AI-powered chatbot web application built using Spring Boot, Java, HTML, CSS, and JavaScript.  
It integrates with the Groq API to provide fast and intelligent AI-generated responses in real time.

---

# ✨ Features

✅ Real-time AI Chat  
✅ Clean & Responsive UI  
✅ Spring Boot REST API  
✅ Groq AI Integration  
✅ Typing Animation  
✅ Error Handling  
✅ Cross-Origin Support  

---

# 🛠️ Tech Stack

## Frontend
- HTML5
- CSS3
- JavaScript

## Backend
- Java
- Spring Boot
- REST API
- Maven

## AI Model
- Groq API
- Llama 3.3 70B Versatile

---

# 📁 Project Structure

```bash

```

---

# 🚀 Getting Started

## 1️⃣ Clone the Repository

```bash
git clone https://github.com/kavyaspatagar/SmartChat_AI.git
```

---

## 2️⃣ Open Project

Open the project using:

- IntelliJ IDEA

---

## 3️⃣ Configure API Key

Add your Groq API key as an Environment Variable:

```env
GROQ_API_KEY=your_api_key_here
```

In `application.properties`:

```properties
groq.api.key=${GROQ_API_KEY}
```

---

## 4️⃣ Run the Application

```bash
mvn spring-boot:run
```

OR run the main Spring Boot application directly from IntelliJ.

---

# 🌐 API Endpoint

## POST `/api/chat`

### Request

```json
{
  "message": "Hello AI"
}
```

### Response

```json
{
  "reply": "Hello! How can I help you today?"
}
```

---

# 💡 Future Enhancements

- 🔥 Chat History
- 🎤 Voice Assistant
- 🌙 Dark Mode
- 🧠 AI Memory
- 👤 User Authentication
- 💾 Database Integration
- ⚡ Streaming Responses

---

# 🔒 Security

⚠️ Never upload API keys to GitHub.

Use:
- Environment Variables
- `.gitignore`
- Secure configuration management

---

# 📱 Responsive Design

SmartChat_AI works on:
- Desktop

---

# 👨‍💻 Author

### Kavya Spatagar

GitHub:  
https://github.com/kavyaspatagar

---

# ⭐ Support

If you like this project, give it a ⭐ on GitHub.

---

# 📜 License

This project is developed for learning purposes.
