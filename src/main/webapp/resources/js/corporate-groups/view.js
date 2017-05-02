$(document).ready(function(){
  $(".delete-user").click(function(e){
      var dbid = $(this).attr('dbid');
      var token = $("meta[name='_csrf']").attr("content");
      var header = $("meta[name='_csrf_header']").attr("content");
      console.log(dbid)
      e.preventDefault();
        $.ajax({type: "POST",
            url: "/users/delete",
            data: { userId: dbid},
            beforeSend: function(xhr) {
                xhr.setRequestHeader(header, token);
            },
            success:function(result){
              window.location = window.location;
            },
           error:function(result)
           {
            alert('Cannot delete user.');
           }
       });
  });
});