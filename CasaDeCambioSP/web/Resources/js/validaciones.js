/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validarLogin(){
    let usuario = document.form.usuario.value;
    let password = document.form.password.value;
    
    if(usuario==null || usuario==""){
        alert("El nombre de usuario es requerido");
        return false;
    }
    if(password== null || password==""){
        alert("La contraseña es requerida");
        return false;
    }
    
}

function validarRegistro(){
    let usuario = document.form.usuario.value;
    let password = document.form.password.value;
    let valiarPassword = document.form.validarPassword.value;
    let email = document.form.email.value;
    console.log("Hola");
    if(email==null || email==""){
        alert("El email es requerido");
        return false;
    }
    if(usuario==null || usuario==""){
        alert("El nombre de usuario es requerido");
        return false;
    }
    if(password== null || password==""){
        alert("La contraseña es requerida");
        return false;
    }
    if(valiarPassword== null || valiarPassword==""){
        alert("La contraseña es requerida");
        return false;
    }
    if(valiarPassword !== password){
        alert("La contraseña no coinciden");
        return false;
    }  
}

