# YouTube Raffle 🎉

**YouTube Raffle** is a simple Spring Boot web application that allows you to run a raffle among YouTube video commenters.

The application randomly selects **up to 3 winners** from the list of commenters for a given video.

---

## 🚀 Features

- Fetches a list of commenters from a YouTube video URL
- Randomly selects winners (up to 3)
- Minimalistic and modern UI with **Thymeleaf**
- Safe API key management using environment variables

---

## 🛠 Technologies

- Java 21
- Spring Boot 3.5
- Maven
- Thymeleaf
- Google YouTube Data API v3
- Lombok

---

## ⚙️ Installation & Usage

Follow these steps to try it locally:

1. **Clone the repository**

2. **Set your YouTube API Key as an environment variable**

         Linux/macOS:
export YOUTUBE_API_KEY=**`YOUR_YOUTUBE_API_KEY`**

         Windows (PowerShell):
setx YOUTUBE_API_KEY **`YOUR_YOUTUBE_API_KEY`**

   **Or via IntelliJ:**

- a. Go to Run → Edit Configurations → Environment variables and add:
- b. YOUTUBE_API_KEY=**`YOUR_YOUTUBE_API_KEY`**
- c. Run the application 

3. **Open the app in your browser**
        
      http://localhost:8080/youtube

4. **Enter a YouTube video URL and click the button to draw winners**
