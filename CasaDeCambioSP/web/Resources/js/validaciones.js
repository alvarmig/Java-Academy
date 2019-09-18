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
    }else if(password== null || password==""){
        alert("La contraseña es requerida");
        return false;
    }
    
}

