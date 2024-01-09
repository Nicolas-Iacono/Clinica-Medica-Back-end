let buscarPaciente = document.querySelector('#idPaciente');
console.log(buscarPaciente);

const campoErrorPacienteBuscar = document.querySelector(".campoDeErrorBusquedaPac");
console.log(campoErrorPacienteBuscar);

const campoBusquedaDesplegable = document.querySelector(".resultadoDeBusqueda");
console.log(campoBusquedaDesplegable);

let cuerpoTablaPaciente = document.querySelector("#cuerpoTablaPac");
console.log(cuerpoTablaPaciente)

let busquedaPorApellido1 = document.querySelector("#apellidoInput");
console.log(busquedaPorApellido1)
const errorResultado = document.querySelector("#errorResultado");

const resultadoDeBusquedaOdo = document.querySelector("#resultados")
let formOdo = document.querySelector("#busOdo")
let formPac = document.querySelector("#busPac");

let objetoDeBusquedaOdo = {
    apellido : ""
}

const erroresDeBusquedaOdo = {
    apellido : false
}

// generarError

function mostrarErrorDeBusqueda(){
    erroresDeBusquedaOdo.apellido ? resultadoDeBusquedaOdo.classList.add("visibility"): resultadoDeBusquedaOdo.classList.remove("visibility");
}


formOdo.addEventListener('input', function(){
    console.log(objetoDeBusquedaOdo)

    objetoDeBusquedaOdo.apellido = busquedaPorApellido1.value

    console.log(objetoDeBusquedaOdo)

    erroresDeBusquedaOdo.apellido = validarBusquedaPorApellido(objetoDeBusquedaOdo.apellido)
        if(!erroresDeBusquedaOdo.apellido){
                errorResultado.textContent = "Apellido Inexistente";
        }else{
            errorResultado.textContent = "Apellido Encontrado";
        }

        mostrarErrorDeBusqueda();
})

function validarBusquedaPorApellido(apellido){
    let resultado = false;
    fetch("/odontologos/listar")
    .then(function(response){
        return response.json();
    })
    .then(function(data){
        console.log(data)
        for(var i=0; i<data.length; i++){
           if(apellido === data[i].apellido){
            resultado = true
            break;
            }       
        }
        return resultado;
    });
}



function buscarOdontologo(objeto){

}
