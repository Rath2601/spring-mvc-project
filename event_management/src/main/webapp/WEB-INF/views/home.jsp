<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Welcome to EventMan</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/event-home.css">
</head>
<body>
    <header>
        <h1>Welcome to EventMan</h1>
        <nav class="user-auth">
            <!-- No registration links here, only home and event-related navigation -->
            <a href="<%= request.getContextPath() %>/events.jsp" class="view-events">View Events</a>
        </nav>
    </header>

    <main>
        <section class="intro">
            <h2>Discover and Manage Events Effortlessly</h2>
            <p>Find exciting events, track your schedule, and manage event registrations all in one place.</p>
        </section>

        <section class="upcoming-events">
            <h2>Upcoming Events</h2>
            <article>
                <h3>Music Concert: Rock the Night</h3>
                <p>Join us for an unforgettable night of live music with top bands.</p>
                <a href="event1.jsp">Read More</a>
            </article>
            <article>
                <h3>Technology Conference 2024</h3>
                <p>Stay ahead with the latest tech trends and innovations in this year's biggest tech event.</p>
                <a href="event2.jsp">Read More</a>
            </article>
        </section>
    </main>

    <footer>
        <p>&copy; 2024 EventMan. All rights reserved.</p>
    </footer>
</body>
</html>
