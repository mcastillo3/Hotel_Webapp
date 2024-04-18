Using README.md for project notes.
Created a new Resource bundle with an English and a French message.
Created a new 'locale' package with a ReadResource class that gets the messages and returns it as a String.
Created a new DisplayMessageController rest controller that creates a mapping to send the message to the front-end.
The rest controller also creates 2 executors threads.
Added a welcomeMessage variable to app.component.ts, a method to get the message from the back-end, and subscribed it to OnInit.
Edited the app.component.html to display the welcome message on the top page, lines 8-10.
Edited the app.component.html to prices in Canadian dollar and Euro, lines 82-84.
Created a new TimeController rest controller that maps a path to the front-end to get pre-loaded times in different time zones.
Added a presentationTime variable to app.component.ts, a method to get the times from the back-end, and subscribed it to OnInit.
Edited the app.component.html to display a message and the presentation times in different time zones, lines 28-35.
