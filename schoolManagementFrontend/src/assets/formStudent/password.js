const show_password = document.querySelector('#show_password');
const first = document.querySelector('#register_form_user_password_first');
const second = document.querySelector('#register_form_user_password_second');
show_password.style.cursor = "pointer";

show_password.addEventListener('click', function(e){
    first.type = "text";
    second.type = "text";
    if (first.type == "text" && second.type == "text") {
        show_password.addEventListener('click', function(e){
            first.type = "password";
            second.type = "password"
            if (first.type == "password" && first.type == "password") {
                show_password.addEventListener('click', function(e){
                    first.type = "text";
                    second.type = "text";
                    if (first.type == "text" && second.type == "text") {
                        show_password.addEventListener('click', function(e){
                            first.type = "password";
                            second.type = "password";
                            if (first.type == "password" && second.type == "password") {
                                show_password.addEventListener('click', function(e){
                                    first.type = "text";
                                    second.type = "text";
                                    if (first.type = "text" && second.type == "text") {
                                        show_password.addEventListener('click', function(e){
                                            first.type = "password";
                                            second.type = "password";
                                            if (first.type = "password" && second.type == "password") {
                                                show_password.addEventListener('click', function(e){
                                                    first.type = "text";
                                                    second.type = "text";
                                                    if (first.type == "text" && second.type == "text") {
                                                        show_password.addEventListener('click', function(e){
                                                            first.type = "password";
                                                            second.type = "password";
                                                        })
                                                    }
                                                })
                                            }
                                        })
                                    }
                                })
                            }
                        })
                    }
                })
            }
        })
    }
      
        
})