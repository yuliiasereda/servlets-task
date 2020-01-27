
$("#form").closest('form').on('submit', function (event) {
  event.preventDefault();
  var $form = $(this);
  var url = "${pageContext.request.contextPath}/user/login";
  var email = $form.find('input[name="your_email"]').val();
  var password = $form.find('input[name="your_pass"]').val();

  $.ajax({
    type: 'PUT',
    url: url,
    contentType: 'application/json',
    data: JSON.stringify({email: email, password: password}),
    success: function (data) {
      window.location.href = "${pageContext.request.contextPath}"
          + data.homeUrl;
    },
    error: function (xhr, status, error) {
      $('#msg').html('<span style=\'color:red;\'>' + error + '</span>')
    }
  });
});