<h1 align="center">Android Engineering Intern Assignment(FamPay)</h1>

<p align="center">
<img src="https://user-images.githubusercontent.com/54114888/124321900-16460200-db9c-11eb-96da-2c0c35254343.png" width ="300" >
</p>

##  ⭐ Description:

- A standalone container, that displays a list of `Contextual Cards`
    - A `Contextual Card` is used to refer to a view that is rendered using json from an API
    - These views are dynamic and their properties like images, color, texts, buttons (CTAs) etc. can be changed from backend at anytime.
- This container works completely independently of everything else, such that, we can add this to container to any fragment/activity and it will work. (Plug-and-Play component)
- The app renders contextual cards in a list based on the API response that you get from this [API](https://run.mocky.io/v3/04a04703-5557-4c84-a127-8c55335bb3b4)
- The design specifications for the different design types can be referenced from design specified [here.](https://www.figma.com/file/AvK2BRGwMTv4kQab5ymJ0K/AAL3-Android-assignment-Design-Specs) 
- The design linked is only for reference for different types of design types of cards. Actual response from API will render different results.

## 🚀 Functional Features:

- Most of the deeplinks (card, CTAs, Formatted Text entities) are handled.
    - In the API, almost every component has its own url/deeplink that is used to trigger action on click.
- On long press of Big Display Card (HC3), it slides to the right and display action buttons as per the design
    - On tapping "remind later" action on a card, it should be removed from the display. This card is shown on the next app start.
- Implemented swipe down to refresh feature
- Handled loading and error states
- Functions and Classes that enabled reusablity

## 😥 Could not implement:
- On tapping "dismiss now" action, it should be removed from the display. This card should never be visible again.

## 🖥️ Link for APK in the Repository:
[Download the Apk Here.](https://github.com/adrishyantee/Fampay/blob/main/AppDemo/App.apk)

## 📽 Sample Demo:
[The Working Prototype](https://github.com/adrishyantee/Fampay/blob/main/AppDemo/App.mp4)


https://user-images.githubusercontent.com/73780844/180600487-bb287bf4-0a7e-416b-9268-73d65ec559e2.mp4


## 🏗 Built With:
- Android Studio.
- Kotlin.
- XML.
- Glide (loading the images)
- Retrofit (For fetching API Response)
- Coroutines (To handle ansynchronous tasks)
- RecyclerView
- CardView

## ↙️ API Used:
https://run.mocky.io/v3/04a04703-5557-4c84-a127-8c55335bb3b4

## 😓 Difficulties Faced:
- Due to limited amount to time could implement the SharedPrefernces feature to save the list of items once dismiss button is tapped

## 🪐 Steps to Build locally:
- Clone with `git clone https://github.com/adrishyantee/Fampay`.
- Open Android Studio IDE and open the file
- Let the Gradle Sync happen auotmatically and the app is built.
- Run on Android Emulator or Physical Device connected with USB.

## Developed With 💖 By:
<h2 align="center">Adrishyantee Maiti</h2>
