

   // establezco objetoOdontologo vacio
   let objetoOdontologo = {
    nombre : "",
    apellido : "",
    matricula : ""
}

let estadoErroresOK = {
    nombre : false,
    apellido : false,
    matricula : false
}
// CAPTURAR NODOS
const form = document.getElementById("formularioOdontologo");
const inputNombre = document.querySelector('#nombre');
const inputApellido = document.querySelector('#apellido');
const inputMatricula = document.querySelector('#matricula');
const botonSubmit = document.querySelector("#btnReg")


const cajaErrorApellido = document.querySelector("#apellidoErrores");
const cajaErrorNombre = document.querySelector("#nombreErrores");
const cajaErrores = document.querySelector("#cajaErrores")

function mostrarErrores(){
estadoErroresOK.nombre ? cajaErrorNombre.classList.add("visibility") : cajaErrorNombre.classList.remove("visibility");
estadoErroresOK.apellido ? cajaErrorApellido.classList.add("visibility") : cajaErrorApellido.classList.remove("visibility");
estadoErroresOK.matricula ? document.querySelector("#matriculaErrores").classList.add("visibility") : document.querySelector("#matriculaErrores").classList.remove("visibility");
}

form.addEventListener('input', function(){
//actualizo el estado de pantalla con los datos
    objetoOdontologo.nombre = inputNombre.value;
    objetoOdontologo.apellido = inputApellido.value;
    objetoOdontologo.matricula = inputMatricula.value;
    console.log(objetoOdontologo)
//  actualizar el estado de error segun el estado del usuario

estadoErroresOK.nombre = validarNombre(objetoOdontologo.nombre);
if(!estadoErroresOK.nombre){
    cajaErrorNombre.textContent = "El nombre de tener almenos 4 caracteres"
}else{
    cajaErrorNombre.textContent = "";
}


estadoErroresOK.apellido = validarApellido(objetoOdontologo.apellido);
if(!estadoErroresOK.apellido){
    cajaErrorApellido.textContent = "El apellido de tener almenos 4 caracteres"
}else{
    cajaErrorApellido.textContent = "";
}


estadoErroresOK.matricula = validarMatricula(objetoOdontologo.matricula);
if(!estadoErroresOK.matricula){
    document.querySelector("#matriculaErrores").textContent = "La matricula tiene hasta 7 caracteres"
}else{
    document.querySelector("#matriculaErrores").textContent = "";
}
//muestro los errores
mostrarErrores();

})

//funcion para validar campos

function validarNombre(nombre){
    let resultado = false;

    if(nombre.length >3 && !nombre.includes('/', '@','.')){
        resultado = true;

    }
    return resultado;
}

function validarApellido(apellido){
    let resultado = false;

    if(apellido.length >3 && !apellido.includes('/', '@','.')){
        resultado = true;
    }
    return resultado;
}


function validarMatricula(matricula){
    let resultado = false;

    if(matricula.length < 7 && !matricula.includes('/', '@','.')){
        resultado = true;
    }
    return resultado;
}

const apiUrl = "http://localhost:8080/odontologos/registrar";
// let datosAEnviar = {
//     nombre: objetoOdontologo.nombre,
//     apellido: objetoOdontologo.apellido,
//     matricula: objetoOdontologo.matricula
// };
const user = "sa";
const password = "sa";
const credenciales = btoa(`${user}:${password}`);

//escuchar el submit del formulario
botonSubmit.addEventListener('click', function(e){
    e.preventDefault();
    // realizar acciones al enviar el formulario

if(estadoErroresOK.nombre && estadoErroresOK.apellido && estadoErroresOK.matricula){

    fetch(apiUrl, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Basic ${credenciales}`
        },
        body: JSON.stringify(objetoOdontologo)
        
    })
        .then(response => 
            
        M.toast({html: 'Odontologo Registrado', classes: 'custom-toast-class'})
           
        )
    
            
    navegarPaginaExito()
    }
});




function navegarPaginaExito(){
localStorage.setItem('user',JSON.stringify(objetoOdontologo))
}
