var deleteBtn = function (email) {
  var url = ctx + "/management/user";

  $.ajax({
    type: 'DELETE',
    url: url,
    contentType: 'application/json',
    data: JSON.stringify({email: email}),
    success: function (data) {
      console.log('Redirecting...');
      window.location.href = ctx + "/management/users";
    },
    error: function (xhr, status, error) {
      $('#msg').html('<span style=\'color:red;\'>' + error + '</span>')
    }
  });
};