// Get the modal
var modal = document.getElementById("updateModal");
var updateEmailInput = document.getElementById("update-email-input");
var oldEmailInput = document.getElementById("old-email-input");
var updateNameInput = document.getElementById("update-name-input");
var updatePasswordInput = document.getElementById("update-password-input");

// Get the button that opens the modal
var btn = document.getElementById("updateButton");

// Get the <span> element that closes the modal
var span = document.getElementsByClassName("close")[0];

// When the user clicks on the button, open the modal
var updateBtn = function (email, name, password) {
  modal.style.display = "block";
  updateEmailInput.value = email;
  oldEmailInput.value = email;
  updateNameInput.value = name;
  updatePasswordInput.value = password;
}

// When the user clicks on <span> (x), close the modal
span.onclick = function () {
  modal.style.display = "none";
}

// When the user clicks anywhere outside of the modal, close it
window.onclick = function (event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}