const firebase = require("firebase");
// Required for side-effects
require("firebase/firestore");

firebase.initializeApp( {
    apiKey: "AIzaSyBSD5klh8mJjXyMF8SAP4fumx3m2oCefm8",
    authDomain: "test-9f697.firebaseapp.com",
    databaseURL: "https://test-9f697.firebaseio.com",
    projectId: "test-9f697",
    storageBucket: "test-9f697.appspot.com",
    messagingSenderId: "463182210480"
  });
// Initialize Cloud Firestore through Firebase
var db = firebase.firestore();
export default db;
