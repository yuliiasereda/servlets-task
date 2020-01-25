
$("#update-form").closest('form').on('submit', function (event) {
  event.preventDefault();
  var $form = $(this);
  var url = ctx + "/management/user";
  var email =  document.getElementById("update-email-input").value;
  var oldEmail =  document.getElementById("old-email-input").value;
  var name =  document.getElementById("update-name-input").value;
  var password =  document.getElementById("update-password-input").value;

  $.ajax({
    type: 'PUT',
    url: url,
    contentType: 'application/json',
    data: JSON.stringify({email: email, name: name, password: password, oldEmail: oldEmail}),
    success: function (data) {
      console.log('Redirecting...');
      window.location.href = ctx + "/management/users";
    },
    error: function (xhr, status, error) {
      $('#msg').html('<span style=\'color:red;\'>' + error + '</span>')
    }
  });
});