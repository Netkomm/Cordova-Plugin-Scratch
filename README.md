# Cordova-Plugin-Scratch (Android)
![](plugin.gif)


## Installation

```sh
 cordova plugin add https://github.com/hitmacreed/Cordova-Plugin-Scratch.git 
```

```sh
 ionic cordova plugin add https://github.com/hitmacreed/Cordova-Plugin-Scratch.git
```

This requires cordova Platform Android 8.0+

## Info

This Plugin accepts images from drawable folder and Url.

In Android 9.0+ only accepts https Urls

`"ONLY => Scratched Card Image" can accept drawable or Url`
 
## Usage

Declare in your component
 
```javascript
 declare var ScratchPlugin: any;
```

Syntax

```javascript
    ScratchPlugin.draw('My Toast Message', 'Scratch Card Image', 'Scratched Card Image', 'My Title Card', 'My Title Color Hex', 'My Background', function(mkay) {
      console.log(mkay);
      }, function(err) {
      console.log(err);
    });
```

Example of usage with drawable

```javascript
   ScratchPlugin.draw('You Won!', '@drawable/scratch_card', '@drawable/winner', 'Scratch to Win', '#ffffe6', '@drawable/background', function(mkay) {
      console.log(mkay);
      }, function(err) {
      console.log(err);
    });
```

Example of usage with Url

```javascript
   ScratchPlugin.draw('You Won!', '@drawable/scratch_card', 'https://i.imgur.com/DvpvklR.png', 'Scratch to Win', '#ffffe6', '@drawable/background', function(mkay) {
      console.log(mkay);
      }, function(err) {
      console.log(err);
    });
```

##### Libraries used to make this plugin

```sh
https://square.github.io/picasso/
https://github.com/goibibo/ScratchCardView
```
