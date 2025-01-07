# COMP2000-Assessment-2
Assessment 2
 # Admin Android App

## Overview
This project is an Android application developed as part of COMP2000 Software Engineering 2 coursework. The app is designed for administrators to manage employee data efficiently using a user-friendly mobile interface. The project demonstrates key principles of Human-Computer Interaction (HCI), usability, and robust API integration. It supports critical HR functionalities, ensuring role-specific access and security.

---

## Features
- **Login System:** Secure role-based login for administrators.
- **Employee Management:**
  - Add, edit, and delete employee records.
  - Automatic 5% salary increment for employees completing one year.
- **Leave Requests:**
  - View, approve, or decline employee leave requests.
  - Notifications for leave updates.
- **Notifications:** Real-time push notifications powered by Firebase Cloud Messaging.
- **Settings:** Manage account preferences, including turning off notifications.
- **Responsive Design:** Optimized for various screen sizes and devices.

---

## Tech Stack
- **Programming Language:** Java
- **IDE:** Android Studio
- **API Communication:** Retrofit
- **UI Framework:** Material Design
- **Notifications:** Firebase Cloud Messaging (FCM)
- **Version Control:** Git and GitHub

---

## Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/admin-android-app.git
   ```
2. Open the project in Android Studio.
3. Sync Gradle and resolve dependencies.
4. Add your `google-services.json` file for Firebase integration.
5. Run the app on an emulator or physical device.

---

## API Integration
The app communicates with a RESTful API to manage employee data. Ensure the API server is running and update the base URL in the Retrofit instance:
```java
Retrofit retrofit = new Retrofit.Builder()
    .baseUrl("https://api.example.com/")
    .addConverterFactory(GsonConverterFactory.create())
    .build();
```

### Endpoints Used:
- `POST /employees` - Add a new employee.
- `GET /employees` - Fetch all employees.
- `PUT /employees/{id}` - Edit employee details.
- `DELETE /employees/{id}` - Delete an employee.
- `GET /leave-requests` - Fetch leave requests.
- `PUT /leave-requests/{id}` - Approve or decline leave requests.

---

## Usability Evaluation
- **Methodology:**
  - Conducted formative usability testing with two participants.
  - Evaluated the interface for navigation, accessibility, and task efficiency.
- **Feedback Incorporated:**
  - Improved navigation paths.
  - Streamlined leave request processes.
  - Enhanced visual hierarchy and accessibility.

---

## Legal, Social, and Ethical Considerations
- **Data Privacy:** Implements secure API communication using HTTPS.
- **User Roles:** Enforces role-based navigation for data access control.
- **Ethics:** Designed to comply with GDPR standards for data handling and user notifications.

---

## Future Enhancements
- Add biometric login for enhanced security.
- Integrate advanced analytics for employee performance tracking.
- Expand language support for global usability.

---
