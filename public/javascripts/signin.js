$(document).ready(function(){

 $('#signin').on("click",function(){

                console.log($('#uname').val())
                console.log("Get Access: clicked")
                jsRoutes.controllers.SignInController.getAccess($('#uname').val()).ajax({
                            success: function(data){
                              $('#body').html(data);

                            },
                            error: function(){
                            $('#body').html("ERROR");
                            alert("Sign In Failed")
                          }
                });
            });
});