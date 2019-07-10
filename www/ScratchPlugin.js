var exec = require('cordova/exec');
   
function plugin() {
}
   
plugin.prototype.draw = function(toastMessage, scratchCard, scratchedCard, scratchTitle, scratchTitleColor, backgroundContainer, successCallback, errorCallback) {
    var options = {};
    
    options.toastMessage = toastMessage;
    options.scratchCard = scratchCard;
    options.scratchedCard = scratchedCard;
    options.scratchTitle = scratchTitle;
    options.scratchTitleColor = scratchTitleColor;
    options.backgroundContainer = backgroundContainer;

    exec(successCallback, errorCallback, "ScratchPlugin", "draw", [options]);
}
   
module.exports = new plugin();