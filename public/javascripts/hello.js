if (window.console) {
  console.log("Welcome to your Play application's JavaScript!");
}

$(document).ready(function(){
         $('#btn').on("click",function(){
         jsRoutes.controllers.HomeController.signUp().ajax({
                      success: function(data){
                        $('#body').html(data);
                      },
                      error: function(){
                      $('#body').html("ERROR");
                      alert("Sign Up Click Action Failed")
                    }
          })
      })

      $('#btn1').on("click",function(){
                jsRoutes.controllers.HomeController.signIn().ajax({
                            success: function(data){
                              $('#body').html(data);
                            },
                            error: function(){
                            $('#body').html("ERROR");
                            alert("Sign In Click Action Failed")
                          }
                })
            })
});
