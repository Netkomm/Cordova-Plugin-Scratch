# Cordova-Plugin-Scratch (Android)
![](plugin.gif)


## Installation

```sh
 cordova plugin add https://github.com/hitmacreed/scratchplugin.git 
 ionic cordova plugin add https://github.com/hitmacreed/scratchplugin.git 
 https://github.com/hitmacreed/scratchplugin.git
```

This requires cordova Platform Android 8.0+

## Info

This Plugin acepts images from drawable folder and Url.
In Android 9.0+ only accetps https Urls
`Scratched Card Image can accetp drawable or Url`
 
## Usage

 Declare in your component
```sh
 declare var ScratchPlugin: any;
```
 Sintax
```sh
    ScratchPlugin.draw('My Toast Message', 'Scratch Card Image', 'Scratched Card Image', 'My Title Card', 'My Title Color Hex', 'My Background', function(mkay) {
      console.log(mkay);
      }, function(err) {
      console.log(err);
    });
```

 Example of usage with drawable
```sh
   ScratchPlugin.draw('You Won!', '@drawable/scratch_card', '@drawable/winner', 'Scratch to Win', '#ffffe6', '@drawable/background', function(mkay) {
      console.log(mkay);
      }, function(err) {
      console.log(err);
    });
```

 Example of usage with Url
```sh
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
