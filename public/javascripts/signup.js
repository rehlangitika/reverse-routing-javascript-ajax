$(document).ready(function(){

 $('#signUp').on("click",function(){
            var name = $('#fname').val()
            var gender = $('#gender').val()
            var email = $('#emailid').val()
            var username = $('#uname').val()
            var password = $('#password').val()
            var confirmPassword = $("#confirmpassword").val()
                console.log(name+ " "+gender+" "+email+" "+username+" "+password+" "+confirmPassword)
                console.log("Create User: clicked")
                jsRoutes.controllers.SignUpController.createUser(name,gender,email,
                username,password,confirmPassword).ajax({
                success: function(data){
                console.log("Entered Success of Create User")
                $('#body').html(data);
                },
                error:function(){
                $('#body').html("ERROR");
                alert("Create User Failed")
                 }
                 });
            });
$('#logout').on("click",function(){

                console.log("LogOut:clicked")
                jsRoutes.controllers.HomeController.index().ajax({
                            success: function(data){
                              $('#body').html(data);

                            },
                            error: function(){
                            $('#body').html("ERROR");
                            alert("LogOut Failed")
                          }
                });
            });
});
