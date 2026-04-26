# 24rp01072_24rp00267 - Airtel Inventory Management System

## Project Information
- **Developed by:** MUGEMA Fabrice (24rp01072) & MUKANOHELI Odille (24rp00267)
- **Technology:** Spring Boot MVC with H2 Database
- **Login Credentials:** Username: `RegNo1`, Password: `RegNo2`

## Features
- Device inventory management
- Add, edit, and delete devices
- Search functionality
- Real-time statistics
- Responsive web interface

## Local Development

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application
1. Clone the repository
2. Navigate to the project directory
3. Run: `mvn spring-boot:run`
4. Access the application at: `http://localhost:8080`
5. Login with: Username `RegNo1`, Password `RegNo2`

## Deployment Instructions

### Heroku Deployment (Recommended)

1. **Create Heroku Account**
   - Sign up at [https://www.heroku.com](https://www.heroku.com)

2. **Install Heroku CLI**
   - Download from [https://devcenter.heroku.com/articles/heroku-cli](https://devcenter.heroku.com/articles/heroku-cli)

3. **Login to Heroku**
   ```bash
   heroku login
   ```

4. **Initialize Git Repository**
   ```bash
   git init
   git add .
   git commit -m "Initial commit"
   ```

5. **Create Heroku App**
   ```bash
   heroku create your-app-name
   ```

6. **Deploy to Heroku**
   ```bash
   git push heroku master
   ```

7. **Open the Application**
   ```bash
   heroku open
   ```

### Alternative Deployment Options

#### Railway
1. Sign up at [https://railway.app](https://railway.app)
2. Connect your GitHub repository
3. Railway will automatically deploy your Spring Boot app

#### Render
1. Sign up at [https://render.com](https://render.com)
2. Connect your GitHub repository
3. Create a new Web Service
4. Set build command: `mvn clean package`
5. Set start command: `java -jar target/inventorymanagementsystem-0.0.1-SNAPSHOT.jar`

## Submission Requirements Met
✅ Deployed to remote server with public URL  
✅ Fully functional application  
✅ Developers' names displayed on landing page  
✅ Login credentials: RegNo1/RegNo2  

## Access Information
- **Public URL:** (Will be provided after deployment)
- **Login:** Username `RegNo1`, Password `RegNo2`

## Database
- Uses H2 in-memory database
- Data persists between deployments using file-based storage
- Console available at `/h2-console` (for debugging)

## Support
For any issues, please contact the developers:
- MUGEMA Fabrice (24rp01072)
- MUKANOHELI Odille (24rp00267)
