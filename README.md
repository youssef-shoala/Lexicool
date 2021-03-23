Original App Design Project - README Template
===

# Lexicool

## Table of Contents
1. [Overview](#Overview)
2. [Product Spec](#Product-Spec)
3. [Wireframes](#Wireframes)
4. [Schema](#Schema)

## Overview
### Description
Lexicool is an application designed to help you learn new words! Our app is simple to use and rewards you for learning by offering you coins, themes, and more! Download the app now!

### App Evaluation

- **Category:** Education
- **Mobile:** This app will be useful for people short on time who want a convenient way to expand their vocabulary on the go, for example on the bus, standing in line, or while waiting for your coffee to brew. The app will use the Oxford Dictionary API, Back4App to store profile information, push notifications for daily reminders, and audio voice recognition for searching words. 
- **Story:** Learn new words with Lexicool! An app to help you expand your vocab. This app is suited to anyone with the motivation and will to learn new things, with the aim of the app to make the learning experience as smooth as possible.
- **Market:** The size of the market avaibale is everyone who speaks english, so quite large. Addiotionally, the future possibility of expanding the list of languages offered will only open up the market size furhter. The app is available for anyone who wants to learn, but would require heavy marketing to become popular and really lift off. 
- **Habit:** A streak system will be put in place to motivate the user to log on every day and learn atleast one new word. Push notifications will be sent to remind the user on a daily basis. A reward system could be implemented to give further motivation to form the habit.
- **Scope:** Although the scope is quite wide and there are many features that we hope to add, we believe that it is quite doable within the time given by the course. A stripped down version would still be interesting, however, it would take away from the habit forming ideology of the app. 

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* Ability to login or create a new profile
* Gives the user a word and its definition to learn, when the user feels they have learned the word, they can click a button to get a new random word
* Track previously learned words
* Track user's daily streak
* Send push notifications for reminders
* Search for a word and get it's definition
    * Search using microphone aswell
* Shows a random word and its definition when you click a button

**Optional Nice-to-have Stories**

* Different languages 
* Reward system with different themes
    * Light theme, Dark theme
* Friend System to see other's progress
* Short question to make sure a user has learned the word correctly (given 4 definitions choose the correct one)

### 2. Screen Archetypes

* Login/Sign-up
   * When the user first opens the app, prompt them to create a new account, or login if they already have one.
* Learn Random Word
    * Displays a random word and its definition.
    * Has a button to generate a new word and indicate that the user has learned the first word
* Search Word
    * Search bar to search the definition of a word.
* Profile
    * Displays list of previously random words.
    * Shows your daily streak number
    * (Optional) Shows points and redeemable rewards
    * Button to logout

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Learn Random Word
* Search Word
* Profile

**Flow Navigation** (Screen to Screen)

* Login/Signup Screen
   * Will lead to the Random Word page upon successful login
* Main Activity
   * Has three tabs noted previously

## Wireframes
[Add picture of your hand sketched wireframes in this section]
<img src="https://github.com/yousss811/Lexicool/raw/main/wireframe.jpg" width=600>

## Schema 
[This section will be completed in Unit 9]
### Models
[Add table of models]
### Networking
- [Add list of network requests by screen ]
- [Create basic snippets for each Parse network request]
- [OPTIONAL: List endpoints if using existing API such as Yelp]
