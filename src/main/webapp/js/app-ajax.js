  object.onsubmit = function(){$.ajax({
                                     type: "PUT",
                                     url: "${pageContext.request.contextPath}/user/login",
                                     data: $('#myform').serialize(),
                                     success: function(data, textStatus, jqXHR) {
                                       alert('everything was OK');
                                     }
                                   })};